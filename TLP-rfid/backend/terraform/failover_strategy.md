# High Availability & Disaster Recovery Strategy (Multi-Cloud)

This project is intentionally designed with an **active-passive multi-cloud architecture** to guarantee business continuity even in extreme scenarios where an entire cloud provider becomes unavailable.

| Layer           | Provider          | Role                        | Reason for choice                                                                 |
|-----------------|-------------------|-----------------------------|------------------------------------------------------------------------------------|
| **Primary**     | Oracle Cloud (OCI)| Production database         | • Oracle Autonomous Database (Always Free tier) <br> • Lowest latency <br> • Native integration with Oracle IoT/RFID services <br> • Automatic backups & patching |
| **Secondary / DR** | Microsoft Azure | Cold/Warm backup database   | • Completely independent vendor <br> • Protection against regional or total OCI outage <br> • Azure SQL Basic tier (near-zero cost when idle) |

### Failover Procedure (manual – under 10 minutes)
1. Detect prolonged unavailability of the Oracle Autonomous Database  
2. Switch the active datasource in `application.properties` (or environment variables) to the Azure SQL connection string  
3. Redeploy the Spring Boot application / restart Kubernetes pods  
4. System resumes operation using the replicated data on Azure

### Strategic Goals Achieved
- No vendor lock-in with Oracle  
- Service continuity even in catastrophic provider-level failures  
- Almost zero additional cost (OCI Free Tier + Azure Basic idle)  
- Demonstrates enterprise-grade cloud-native architecture

### Future Enhancements (optional)
- Automated replication with Oracle GoldenGate or Debezium  
- Automatic failover using Azure Traffic Manager + health checks  
- End-to-end encryption (in-transit and at-rest) on both clouds

With this strategy, the **OCL** system is ready not only for daily operation but also for “the day everything goes down”.

Feel free to place this file at `/terraform/failover_strategy.md` or directly in the repository root.  
It instantly turns what could look like “two random databases” into a strong architectural selling point.