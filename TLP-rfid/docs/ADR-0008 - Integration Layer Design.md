# ADR-0008: Integration Layer Design

## Status
Accepted

## Context
The platform must integrate with external systems such as ERP, WMS, and IoT devices.

## Decision
We isolate all external communication into a dedicated integration module:

- ERPClient
- WMSClient
- IntegrationService
- External DTOs

All external data is normalized into internal domain events.

## Consequences
### Positive
- Clean separation of external systems
- Easier system evolution
- Controlled data ingestion

### Negative
- Additional mapping layer required