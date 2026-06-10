# ADR-0001: Monorepo Architecture

## Status
Accepted

## Context
The TLP (Triminds Logistics Intelligence Platform) consists of multiple domains such as RFID tracking, prediction engines, analytics, integration services, and security components. Early-stage development requires fast iteration and shared domain models.

## Decision
We adopt a monorepo structure under a single Spring Boot application, organized by business domains:

- rfid
- prediction
- analytics
- integration
- security
- gateway
- shipment
- warehouse

## Consequences
### Positive
- Simplified development and deployment
- Shared domain models across modules
- Easier debugging and refactoring

### Negative
- Future scaling may require migration to microservices
- Larger build times as the system grows