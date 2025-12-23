# bank-account

> Serviço de Gestão de Contas Bancárias - Enterprise Banking Platform

[![License](https://img.shields.io/badge/license-proprietary-blue.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://openjdk.org/)
[![Quarkus](https://img.shields.io/badge/Quarkus-3.x-blue.svg)](https://quarkus.io/)
[![Port](https://img.shields.io/badge/Port-8080-green.svg)](http://localhost:8080)
[![CI](https://github.com/your-org/bank-account/actions/workflows/ci.yml/badge.svg)](https://github.com/your-org/bank-account/actions)

---

## 📋 Índice

- [Visão Geral](#-visão-geral)
- [Responsabilidades do Serviço](#-responsabilidades-do-serviço)
- [Sub-domínios e Módulos](#-sub-domínios-e-módulos)
- [Arquitetura](#-arquitetura)
    - [Arquitetura Hexagonal](#arquitetura-hexagonal)
    - [Padrões de Design](#padrões-de-design)
    - [Diagrama de Arquitetura](#diagrama-de-arquitetura)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [API Endpoints](#-api-endpoints)
- [Eventos de Domínio](#-eventos-de-domínio)
- [Getting Started](#-getting-started)
    - [Pré-requisitos](#pré-requisitos)
    - [Configuração Local](#configuração-local)
    - [Variáveis de Ambiente](#variáveis-de-ambiente)
- [Documentação por Módulo](#-documentação-por-módulo)
- [Testes](#-testes)
- [Observabilidade](#-observabilidade)
- [Segurança](#-segurança)
- [Deploy](#-deploy)
- [Contribuição](#-contribuição)
- [Licença](#-licença)

---

## 📖 Visão Geral

O serviço **bank-account** é responsável pela gestão completa do ciclo de vida de contas bancárias dentro da Enterprise Banking Platform.

Este serviço implementa os domínios de gestão de contas PF/PJ, contas poupança, contas investimento, contas multi-titulares (conjuntas), gestão de saldos e reservas (hold), configuração de limites operacionais, motor de extrato, hierarquia empresarial e emissão de documentos core.

A arquitetura segue princípios de Domain-Driven Design (DDD) com separação clara entre domain, application e infrastructure layers, garantindo alta coesão, baixo acoplamento e testabilidade.

### Informações Técnicas

| Atributo | Valor |
|----------|-------|
| **Porta** | `8080` |
| **Framework** | Quarkus 3.x |
| **Linguagem** | Java 17+ |
| **Banco de Dados** | PostgreSQL 15+ |
| **Mensageria** | Apache Kafka 3.5+ |
| **Cache** | Redis 7+ |

---

## 🎯 Responsabilidades do Serviço

### Core Responsibilities

| Responsabilidade | Descrição |
|------------------|-----------|
| **Gestão de Contas** | Abertura, manutenção, encerramento e controle de status de contas PF/PJ, poupança, investimento e conjuntas. |
| **Gestão de Saldos** | Controle de saldo disponível em tempo real com precisão transacional. |
| **Hold/Reservas** | Gestão de reservas de valor para evitar gasto duplo em transações pendentes. |
| **Limites Operacionais** | Configuração de limites por canal (Pix, Saque, TED) ajustáveis por perfil de risco. |
| **Motor de Extrato** | Agregação de histórico de lançamentos para consulta de extratos por período. |
| **Hierarquia Empresarial** | Estrutura de conta-mestre e sub-contas para gestão de departamentos e filiais corporativas. |
| **Cheque Especial** | Controle de limites extras concedidos, taxas de juros e monitoramento de uso. |
| **Emissão de Documentos** | Geração automática de informes de rendimentos, declarações de titularidade e comprovantes. |

---

## 🏛️ Sub-domínios e Módulos

O serviço é organizado em sub-domínios coesos que representam capacidades de negócio específicas:

| Sub-domínio | Responsabilidade | Status |
|-------------|------------------|--------|
| **account** | Gestão de contas (PF/PJ, poupança, investimento, conjuntas) e ciclo de vida. | ✅ Implementado |
| **balance** | Gestão de saldos e controle de disponibilidade em tempo real. | ✅ Implementado |
| **hold** | Reservas de valor (hold) para transações pendentes e prevenção de gasto duplo. | ✅ Implementado |
| **limit** | Configuração e validação de limites operacionais por canal e perfil de risco. | ✅ Implementado |
| **overdraft** | Gestão de cheque especial, limites extras e aplicação de juros. | ✅ Implementado |
| **statement** | Motor de extrato com agregação de lançamentos e geração de relatórios. | ✅ Implementado |
| **corporate** | Hierarquia empresarial com conta-mestre e sub-contas corporativas. | ✅ Implementado |
| **document** | Emissão de documentos core (informes, declarações, comprovantes). | ✅ Implementado |

---

## 🏗️ Arquitetura

### Arquitetura Hexagonal

O serviço segue a arquitetura hexagonal (ports & adapters) com separação clara entre:

- **Domain Layer**: Regras de negócio puras, entidades, value objects, domain services e eventos.
- **Application Layer**: Casos de uso, comandos, queries, DTOs e orquestração de fluxos.
- **Infrastructure Layer**: Persistência (JPA), mensageria (Kafka), cache (Redis), clients externos.
- **Interfaces Layer**: Controladores REST, requests/responses e exception handlers.