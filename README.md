# Plataforma Financeira Core - Microservices Architecture

![License](https://img.shields.io/badge/license-MIT-green)
![Java](https://img.shields.io/badge/Java-17%2B-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Kafka](https://img.shields.io/badge/Message%20Broker-Kafka-black)
![Kubernetes](https://img.shields.io/badge/Orchestrator-EKS-blue)
![Infrastructure](https://img.shields.io/badge/Infra-Terraform-7B42BC)

Esta plataforma é uma solução robusta de serviços financeiros baseada em microsserviços. O sistema foi projetado para alta disponibilidade, consistência eventual via padrão **SAGA** e imutabilidade de dados para conformidade regulatória.

## 🏗️ Arquitetura e Tecnologias

A solução utiliza uma abordagem **Event-Driven** e **Cloud Native**, garantindo que cada transação seja rastreável, auditável e resiliente a falhas.

### Core Stack
* **Backend:** Java 17+, Spring Boot 3, Hibernate/JPA.
* **Mensageria:** Apache Kafka (Processamento *Exactly-once*).
* **Banco de Dados:** PostgreSQL (Persistência relacional) e Redis (Caching/Locks).
* **Infraestrutura (IaC):** Terraform, AWS (VPC, EKS, RDS, Vault).
* **DevOps & Observabilidade:** GitHub Actions (CI), ArgoCD (GitOps), Prometheus, Grafana e Alertmanager.

---

## 🛠️ Ecossistema de Microsserviços

A plataforma é dividida em módulos especializados para garantir escalabilidade independente:

| Módulo | Responsabilidade | Status |
| :--- | :--- | :--- |
| **Account Service** | Gestão de contas, CRUD completo e saldos integrados. | ✅ Estável |
| **Transaction Engine** | Processamento de PIX, TED e DOC via eventos Kafka. | ✅ Estável |
| **Cards & Conciliation** | Ciclo de vida de cartões e rotinas de reconciliação diária. | 🏗️ Em dev |
| **Ledger (Contábil)** | Registro imutável de lançamentos e fechamento noturno. | 🏗️ Em dev |
| **IAM & KYC** | Identidade, Segurança, Vault e Onboarding (KYC). | ⏳ Planejado |
| **Audit Service** | Trilha de auditoria permanente (Event Sourcing). | ⏳ Planejado |

---

## 🚀 Roadmap de Implementação

1.  **Fase 1 (Fundação):** Setup de Infra (VPC/EKS/RDS) + Módulo de Contas + Integração Transacional PostgreSQL.
2.  **Fase 2 (Movimentação):** Engine de Transações + Mensageria Kafka + Implementação do padrão SAGA.
3.  **Fase 3 (Cartões e Reconciliação):** Processamento em lote (Batch), fluxos RT e liquidação financeira.
4.  **Fase 4 (Resiliência e Compliance):** Auditoria imutável, Testes de Caos (Chaos Engineering) no K8s e Dashboards de SLO/SLI.

---

## 🔧 Configuração do Ambiente

### Pré-requisitos
* Docker e Docker Compose
* JDK 17
* Terraform (para provisionamento AWS)
* Kubectl e Helm

