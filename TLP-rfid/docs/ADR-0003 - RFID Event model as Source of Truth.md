# ADR-0003: RFID Event Model as Source of Truth

## Status
Accepted

## Context
RFID data represents real-world physical movement of goods and must serve as the primary data source for analytics and prediction systems.

## Decision
RFID events are treated as the system's source of truth and are persisted through `RfidEventRepository`.

All downstream systems (prediction, analytics, integration) consume RFID events.

## Consequences
### Positive
- Single source of truth for logistics movement
- Reliable audit trail
- Enables real-time analytics and prediction

### Negative
- High dependency on event quality and integrity