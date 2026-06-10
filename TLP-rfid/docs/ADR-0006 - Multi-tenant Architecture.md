# ADR-0006: Multi-Tenant Architecture

## Status
Accepted

## Context
The platform is designed as a SaaS solution for multiple logistics companies.

## Decision
Each Company is treated as an isolated tenant using:

- Company entity
- JWT-based tenant identification
- ThreadLocal TenantContext in gateway layer

## Consequences
### Positive
- SaaS-ready architecture
- Data isolation between clients
- Scalable onboarding of new companies

### Negative
- Requires strict enforcement of tenant boundaries