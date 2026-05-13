# core-banking-contas

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/core-banking-contas-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- Hibernate ORM ([guide](https://quarkus.io/guides/hibernate-orm)): Define your persistent model with Hibernate ORM and Jakarta Persistence
- Kafka Streams Processor ([guide](https://docs.quarkiverse.io/quarkus-kafka-streams-processor/dev/index.html)): Easily build resilient Kafka Streams topologies based on the Processor API
- Messaging - Kafka Connector ([guide](https://quarkus.io/guides/kafka-getting-started)): Connect to Kafka with Reactive Messaging
- JDBC Driver - PostgreSQL ([guide](https://quarkus.io/guides/datasource)): Connect to the PostgreSQL database via JDBC
- Micrometer metrics ([guide](https://quarkus.io/guides/micrometer)): Instrument the runtime and your application with dimensional metrics using Micrometer.

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)



### Messaging codestart

Use Quarkus Messaging

[Related Apache Kafka guide section...](https://quarkus.io/guides/kafka-reactive-getting-started)


### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)


# Account Service

Serviço responsável pela gestão de contas bancárias, cobrindo abertura e encerramento de contas, controle de saldo e reservas, limites operacionais, extratos, hierarquia PJ, cheque especial e emissão de documentos core.

## Funcionalidades

- Gestão de contas PF e PJ
- Suporte a conta poupança, investimento e conta conjunta
- Controle de saldo disponível em tempo real
- Gestão de hold para reserva de valores
- Abertura, bloqueio, suspensão e encerramento de contas
- Configuração de limites operacionais por canal
- Geração de extratos por período
- Hierarquia empresarial para contas PJ
- Controle de cheque especial
- Emissão de documentos como informe de rendimentos, declaração de titularidade e comprovantes de conta

## Estrutura do Projeto

```text
com.bank.account
│
├── domain
│   ├── model
│   │   ├── Account.java
│   │   ├── AccountHolder.java
│   │   ├── JointAccountHolder.java
│   │   ├── AccountStatus.java
│   │   ├── AccountType.java
│   │   ├── Balance.java
│   │   ├── HoldBalance.java
│   │   ├── OverdraftLimit.java
│   │   ├── AccountLimit.java
│   │   └── CorporateHierarchy.java
│   │
│   ├── service
│   │   ├── AccountLifecycleService.java
│   │   ├── BalanceManagementService.java
│   │   ├── HoldManagementService.java
│   │   ├── LimitValidationService.java
│   │   ├── OverdraftManagementService.java
│   │   └── CorporateHierarchyService.java
│   │
│   ├── event
│   │   ├── AccountCreatedEvent.java
│   │   ├── AccountClosedEvent.java
│   │   ├── AccountBlockedEvent.java
│   │   ├── BalanceReservedEvent.java
│   │   ├── HoldReleasedEvent.java
│   │   └── OverdraftUsedEvent.java
│   │
│   └── repository
│       ├── AccountRepository.java
│       ├── BalanceRepository.java
│       ├── HoldRepository.java
│       ├── AccountLimitRepository.java
│       └── CorporateHierarchyRepository.java
│
├── application
│   ├── service
│   │   ├── AccountApplicationService.java
│   │   ├── AccountOpeningService.java
│   │   ├── AccountClosureService.java
│   │   ├── BalanceQueryService.java
│   │   ├── StatementService.java
│   │   └── DocumentGenerationService.java
│   │
│   ├── command
│   │   ├── OpenAccountCommand.java
│   │   ├── CloseAccountCommand.java
│   │   ├── BlockAccountCommand.java
│   │   ├── ReserveBalanceCommand.java
│   │   ├── ReleaseHoldCommand.java
│   │   └── ConfigureLimitCommand.java
│   │
│   └── dto
│       ├── AccountRequestDTO.java
│       ├── AccountResponseDTO.java
│       ├── BalanceResponseDTO.java
│       ├── StatementResponseDTO.java
│       └── LimitConfigurationDTO.java
│
├── infrastructure
│   ├── persistence
│   │   ├── entity
│   │   │   ├── AccountEntity.java
│   │   │   ├── BalanceEntity.java
│   │   │   ├── HoldEntity.java
│   │   │   ├── AccountLimitEntity.java
│   │   │   └── CorporateHierarchyEntity.java
│   │   │
│   │   └── repository
│   │       ├── JpaAccountRepository.java
│   │       ├── JpaBalanceRepository.java
│   │       ├── JpaHoldRepository.java
│   │       ├── JpaAccountLimitRepository.java
│   │       └── JpaCorporateHierarchyRepository.java
│   │
│   ├── messaging
│   │   ├── KafkaAccountEventPublisher.java
│   │   └── LedgerEventConsumer.java
│   │
│   ├── document
│   │   ├── StatementGenerator.java
│   │   ├── OwnershipCertificateGenerator.java
│   │   └── IncomeReportGenerator.java
│   │
│   └── audit
│       └── AccountAuditLogger.java
│
└── interfaces
    └── rest
        ├── AccountController.java
        ├── BalanceController.java
        ├── StatementController.java
        └── LimitController.java
```

## Organização em Camadas

- `domain`: regras de negócio, modelos, eventos e contratos de repositório
- `application`: casos de uso, comandos e DTOs
- `infrastructure`: persistência, mensageria, documentos e auditoria
- `interfaces`: exposição dos endpoints REST

## Integrações

- Kafka para publicação de eventos de conta
- Consumo de eventos do Ledger
- API REST para operações de conta, saldo, extrato e limites
