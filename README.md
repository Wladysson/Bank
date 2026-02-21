# Plataforma Financeira - Microservices Architecture

![License](https://img.shields.io/badge/license-MIT-green)
![Java](https://img.shields.io/badge/Java-17%2B-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Kafka](https://img.shields.io/badge/Message%20Broker-Kafka-black)
![Kubernetes](https://img.shields.io/badge/Orchestrator-EKS-blue)
![Infrastructure](https://img.shields.io/badge/Infra-Terraform-7B42BC)

Esta plataforma é uma solução robusta de serviços financeiros baseada em microsserviços. O sistema foi projetado para alta disponibilidade, consistência eventual via padrão **SAGA** e imutabilidade de dados para conformidade regulatória.

A arquitetura é baseada em Java com Quarkus, adotando princípios de Cloud Native e execução em Kubernetes (Amazon EKS). A comunicação entre serviços ocorre majoritariamente por meio de eventos publicados no Apache Kafka, permitindo processamento assíncrono e desacoplamento entre os domínios.

A consistência entre transações distribuídas é garantida através do padrão SAGA, adotando orquestração de fluxos financeiros complexos. Cada etapa de uma transação gera eventos imutáveis que são persistidos para auditoria e rastreabilidade, garantindo aderência a requisitos regulatórios comuns ao setor financeiro.

A solução também adota o conceito de Event-Driven Architecture (EDA), onde o estado do sistema é derivado do fluxo contínuo de eventos, permitindo reconstrução histórica, auditoria completa e análise comportamental.

Domínios Implementados

O ecossistema é dividido em múltiplos microsserviços especializados, cada um responsável por um domínio específico:

Gestão de contas

Processamento de transações (PIX, TED, DOC)

Cartões

Ledger contábil

Tesouraria

Reconciliação

Auditoria

Risco e scoring

Canais digitais

Notificações

Identidade e segurança (IAM e KYC)

Orquestração de processos financeiros

Integração com sistemas externos

Processamento em lote

Backoffice operacional

Essa divisão segue princípios de Domain-Driven Design (DDD), garantindo isolamento de responsabilidades e independência evolutiva entre os serviços.

Fase 1 – Fundação do Ambiente e Módulo de Contas

A primeira etapa do projeto concentra-se na construção das bases estruturais:

Provisionamento de infraestrutura com Terraform

Criação de VPC, sub-redes privadas, EKS e RDS

Configuração de Vault para gerenciamento seguro de segredos

Pipeline de CI/CD com GitHub Actions

Estratégia GitOps utilizando ArgoCD

Stack de observabilidade com Prometheus, Grafana e Alertmanager

Após a estabilização da infraestrutura, é implementado o módulo de contas, responsável por:

Abertura e encerramento de contas

Atualização de dados cadastrais

Consulta de saldo

Persistência transacional em PostgreSQL (RDS)

Nesta fase, o foco está na modelagem adequada do domínio e na integridade transacional local, estabelecendo as bases para a futura integração orientada a eventos.

Fase 2 – Módulo de Transações

O módulo de transações representa o núcleo do sistema financeiro distribuído. Ele é responsável pelo processamento de:

PIX

TED

DOC

O fluxo segue um modelo orientado a eventos:

Um evento de solicitação de transação é publicado no Kafka.

O orquestrador SAGA coordena as etapas.

Cada serviço executa sua responsabilidade e publica eventos de sucesso ou falha.

Em caso de erro, eventos compensatórios são acionados.

Um dos objetivos centrais dessa fase é garantir processamento “exactly once”, evitando duplicidade financeira — requisito crítico em sistemas bancários. Para isso, são aplicadas técnicas como:

Idempotência em consumidores

Controle de offsets

Chaves de correlação

Persistência de estado da transação

Essa etapa introduz consistência eventual controlada e fortalece o modelo distribuído.

Módulos de Cartões e Reconciliação

Com o núcleo transacional estabilizado, são adicionados:

Cartões

Responsável por:

Autorização de compras

Controle de limite

Geração de faturas

Integração com fluxo de liquidação

O processamento ocorre tanto em tempo real quanto em rotinas batch.

Reconciliação

Realiza:

Conferência entre registros internos e sistemas externos

Validação de liquidações

Identificação de divergências

Geração de relatórios operacionais

A reconciliação combina processamento em tempo real com rotinas noturnas de agregação.

Ledger Contábil e Fechamento

O sistema implementa um ledger contábil inspirado em princípios de dupla entrada. Cada evento financeiro gera lançamentos contábeis que:

Nunca são apagados

Nunca são sobrescritos

Apenas recebem novos registros de compensação

Durante o fechamento contábil noturno, o sistema executa:

Agregações

Consolidações

Cálculo de posições

Atualização de saldos derivados

Esse modelo garante rastreabilidade total e aderência a exigências regulatórias.

Auditoria Imutável

Todos os eventos publicados no sistema são armazenados de forma permanente, criando uma trilha de auditoria completa.

Características:

Registro imutável

Correlação entre serviços

Rastreamento de ponta a ponta

Capacidade de reconstrução histórica

Essa abordagem atende requisitos de compliance e possibilita análise forense de incidentes.

Infraestrutura como Código

Toda a infraestrutura é provisionada com Terraform, incluindo:

VPC segmentada

Clusters EKS

RDS PostgreSQL

Configuração de segurança

Políticas de acesso

Integração com Vault

O uso de Infrastructure as Code garante:

Reprodutibilidade

Versionamento

Padronização de ambientes

Redução de erros manuais

CI/CD e GitOps

O pipeline automatizado inclui:

Build e testes automatizados

Análise estática de código

Construção de imagens Docker

Push para registry

Deploy automatizado via ArgoCD

A estratégia GitOps permite que o estado do cluster seja sempre derivado do repositório Git, garantindo rastreabilidade e rollback controlado.

Observabilidade

A stack de monitoramento inclui:

Prometheus para coleta de métricas

Grafana para dashboards

Alertmanager para gestão de alertas

São definidos indicadores de:

SLI (Service Level Indicators)

SLO (Service Level Objectives)

Taxa de erro

Latência

Throughput

Uso de recursos

Também são realizados testes de resiliência com falhas controladas no Kubernetes para validar comportamento sob estresse.

Testes de Resiliência

Na fase final, o sistema passa por:

Simulação de falhas em pods

Interrupção de serviços

Testes de perda de conectividade

Sobrecarga de eventos

O objetivo é validar:

Capacidade de auto-recuperação

Robustez da arquitetura orientada a eventos

Eficiência do padrão SAGA

Estabilidade sob pressão

Processamento em Lote

Além do processamento em tempo real, o sistema executa rotinas batch para:

Fechamento contábil

Consolidação de dados

Geração de relatórios

Cálculos agregados

Essas rotinas são agendadas e executadas com controle de consistência e idempotência.

Segurança e Identidade

O módulo de IAM e KYC garante:

Autenticação

Autorização

Validação de identidade

Controle de acesso entre serviços

Armazenamento seguro de credenciais via Vault

A comunicação entre serviços é protegida, e políticas de menor privilégio são aplicadas.

Conclusão

Este Lab de Microsserviços Financeiros representa a construção de um ambiente bancário distribuído moderno, combinando:

Arquitetura orientada a eventos

Consistência distribuída com SAGA

Infraestrutura como código

GitOps

Observabilidade avançada

Auditoria imutável

Processamento híbrido (tempo real e batch)

O projeto demonstra a aplicação prática de conceitos avançados de engenharia de software, arquitetura distribuída e computação em nuvem, simulando desafios reais enfrentados por instituições financeiras modernas.

Mais do que um conjunto de serviços, trata-se de um ecossistema coeso, resiliente e preparado para operar em ambientes críticos, com foco em confiabilidade, rastreabilidade e escalabilidade.

