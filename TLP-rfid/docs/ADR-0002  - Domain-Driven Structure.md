# ADR-0002: Domain-Driven Structure

## Status
Accepted

## Context
The system needs to reflect logistics business logic rather than technical layers. RFID events, shipments, warehouses, and predictions are core business domains.

## Decision
We adopt a Domain-Driven Design (DDD)-inspired modular structure where each package represents a business domain.

## Consequences
### Positive
- Better alignment with business logic
- Easier evolution into microservices
- Improved maintainability

### Negative
- Requires discipline in avoiding cross-domain coupling