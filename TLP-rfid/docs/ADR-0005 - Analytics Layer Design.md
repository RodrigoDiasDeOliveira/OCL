# ADR-0005: Analytics Layer Design

## Status
Accepted

## Context
The platform requires operational insights such as KPIs, bottlenecks, throughput, and prediction accuracy.

## Decision
The analytics layer does not own data. It consumes data from:

- RFID events
- Shipments
- Prediction outputs

Analytics services are purely computational and include:
- KPI calculation
- optimization services
- behavioral analysis
- forecasting aggregation

## Consequences
### Positive
- Clear separation between data and insights
- Scalable analytics computation layer
- Real-time dashboard capability

### Negative
- Requires efficient data access patterns