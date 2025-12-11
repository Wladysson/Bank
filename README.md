



# BANK

## Enterprise Banking Platform

> Distributed banking platform designed with a cloud-native, microservices-based architecture, focused on scalability, resilience, security, observability and continuous delivery.

---

## Overview

**Bank** is an enterprise-oriented banking platform composed of independently deployable services organized around business domains and platform capabilities.

The platform is designed to support distributed financial operations while maintaining clear domain boundaries, service autonomy and operational resilience.

Its architecture combines modern application development practices with cloud-native infrastructure, event-driven communication, observability and automated delivery pipelines.

The project is being developed as a modular banking ecosystem, where each service is responsible for a specific business capability and can evolve independently while communicating with the rest of the platform through well-defined interfaces and events.

### Architectural Principles

- Domain-oriented service decomposition.
- Independent service deployment.
- Asynchronous event-driven communication.
- Distributed transaction coordination.
- Resilience and fault isolation.
- Secure service-to-service communication.
- Centralized observability.
- Infrastructure as Code.
- Automated CI/CD.
- Cloud-native deployment.
- Continuous evolution of business capabilities.

---

# Platform Architecture

The Bank platform follows a distributed architecture based on independent services and shared infrastructure capabilities.

At the application layer, services are organized according to their business responsibilities.

At the infrastructure layer, the platform relies on Kubernetes, AWS, Terraform, service networking, messaging infrastructure, persistence and observability components.

The architecture is designed to allow individual services to scale, evolve and be deployed independently while maintaining controlled communication between domains.

### High-Level Architecture

> **Architecture diagram will be added here.**

![Bank Platform Architecture](docs/images/architecture-placeholder.png)

The architecture diagrams used by the project are maintained as editable Draw.io files and rendered images for documentation purposes.

---

# Platform Capabilities

The platform is organized into several groups representing different business and technical capabilities.

## Core Banking

Core banking services provide the fundamental capabilities required for account management, transaction processing, treasury operations, access control and operational governance.

| Service | Responsibility |
|---|---|
| **contas** | Account management and account lifecycle operations. |
| **transacoes** | Transaction processing and transaction control. |
| **tesouraria** | Liquidity management, financial position and treasury operations. |
| **canais** | Integration with customer and service channels. |
| **auditoria** | Audit trail, operational traceability and accountability. |
| **admin** | Platform administration and operational management. |
| **iam** | Identity, authentication and authorization. |

---

# Financial Services

Financial services provide capabilities related to payments, reconciliation, accounting, risk, scoring and operational limits.

| Service | Responsibility |
|---|---|
| **payments** | Payment processing and payment lifecycle management. |
| **reconciliation** | Reconciliation of financial events and movements. |
| **risk** | Risk analysis and risk management capabilities. |
| **ledger** | Transactional accounting and financial ledger management. |
| **quota** | Operational limits, quotas and authorization thresholds. |
| **scoring** | Customer and risk profile evaluation and classification. |

---

# Customer & Operations

These services support customer experience, internal operations, external integrations and distributed business workflows.

| Service | Responsibility |
|---|---|
| **notification** | Notifications and communication with customers and systems. |
| **reporting** | Reports, analytical views and operational information. |
| **integration** | Integration with external systems and partners. |
| **consent** | Consent management and permission control. |
| **kic** | Customer information validation and knowledge processes. |
| **orchestration** | Coordination of distributed workflows and multi-service processes. |
| **customer-profile** | Customer profile and related information management. |
| **backoffice** | Internal operations and administrative support. |

---

# Platform Services

Platform services provide shared capabilities required to operate and evolve the banking ecosystem.

| Service | Responsibility |
|---|---|
| **data-platform** | Data processing, analytics and information integration capabilities. |
| **config** | Centralized configuration management. |
| **batch** | Scheduled processing and batch operations. |

---

# Service Ecosystem

The platform is composed of independently deployable services.

Each service owns a specific responsibility and contributes to a larger distributed banking ecosystem.

The service-oriented approach enables:

- Independent development.
- Independent deployment.
- Independent scaling.
- Domain isolation.
- Fault isolation.
- Controlled dependencies.
- Evolution of individual capabilities.
- Clear ownership boundaries.

Detailed documentation for each service will be available through the project's service documentation.

---

# Engineering Showcase

The following section presents selected execution, implementation and validation results from the platform.

The images below represent different stages of development and testing and are intended to provide visual evidence of the platform operating successfully.

> The screenshots are intentionally presented as implementation evidence rather than being tied to a specific documentation category.

---

## Implementation Evidence

### Platform Execution

![Platform Execution](docs/images/showcase-01.png)

---

### Service Execution

![Service Execution](docs/images/showcase-02.png)

---

### API and Integration Validation

![API Validation](docs/images/showcase-03.png)

---

### Automated Tests

![Automated Tests](docs/images/showcase-04.png)

---

### Distributed Communication

![Distributed Communication](docs/images/showcase-05.png)

---

### Infrastructure Execution

![Infrastructure](docs/images/showcase-06.png)

---

### Observability

![Observability](docs/images/showcase-07.png)

---

### CI/CD Pipeline

![CI/CD Pipeline](docs/images/showcase-08.png)

---

> Additional implementation evidence and service-specific validation results will be progressively added as the platform evolves.

---

# Technology Stack

## Application

| Technology | Purpose |
|---|---|
| **Java** | Primary application language. |
| **Quarkus** | Cloud-native Java framework for backend services. |

## Data & Messaging

| Technology | Purpose |
|---|---|
| **PostgreSQL** | Relational persistence. |
| **Apache Kafka** | Event streaming and asynchronous communication. |

## Cloud & Infrastructure

| Technology | Purpose |
|---|---|
| **AWS** | Cloud infrastructure and managed services. |
| **Kubernetes** | Container orchestration and service deployment. |
| **Terraform** | Infrastructure as Code. |

## Observability

| Technology | Purpose |
|---|---|
| **Prometheus** | Metrics collection and monitoring. |
| **Grafana** | Metrics visualization and operational dashboards. |

## DevOps & Delivery

| Technology | Purpose |
|---|---|
| **GitHub Actions** | Continuous integration and automation pipelines. |
| **ArgoCD** | GitOps-based continuous delivery. |
| **JFrog Artifactory** | Artifact management and distribution. |

## Service Networking

| Technology | Purpose |
|---|---|
| **Istio** | Service mesh, traffic management and service-to-service governance. |

---

# Event-Driven Architecture

Kafka is used as the messaging backbone for asynchronous communication between services.

Event-driven communication helps reduce direct coupling between domains and enables services to react to business events independently.

The architecture can support patterns such as:

```text
Service A
    │
    │ Event
    ▼
 Apache Kafka
    │
    ├──────────────► Service B
    │
    ├──────────────► Service C
    │
    └──────────────► Service D