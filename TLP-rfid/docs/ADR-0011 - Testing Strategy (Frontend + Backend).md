ADR-0011: Testing Strategy (Frontend + Backend)

Status: Accepted
Date: 2026-06-12

📌 Context

The TLP (Triminds Logistics Platform) project has evolved into a distributed architecture composed of:

Frontend built with React + TypeScript (Vite)
Modular Spring Boot backend (RFID, Analytics, Prediction, Security)
API Gateway with JWT authentication
Architecture prepared for multi-tenant and microservices deployment

With this evolution, it becomes necessary to define a unified testing strategy to ensure:

platform stability
integration reliability
JWT security consistency
frontend-backend contract alignment
SaaS scalability readiness
🎯 Decision

Adopt a testing strategy based on complementary layers, separating responsibilities between frontend and backend.

🧪 1. FRONTEND TESTING STRATEGY
📦 Adopted stack:
Vitest
React Testing Library
jsdom
📁 Structure:
src/tests/
 ├── auth/
 ├── dashboard/
 ├── rfid/
 ├── mocks/
 ├── setup.ts
🎯 Scope:

✔ UI rendering tests
✔ User interaction tests
✔ Basic flow validation (login, navigation)
✔ API call mocking

❌ Not included in frontend:
database logic
real JWT validation
backend business logic testing
⚙️ 2. BACKEND TESTING STRATEGY
📦 Adopted stack:
JUnit 5
Spring Boot Test
MockMvc
📁 Structure:
src/test/java/com/triminds/
 ├── rfid/
 ├── analytics/
 ├── security/
 ├── shipment/
🎯 Scope:

✔ REST controller testing
✔ Real endpoint validation
✔ HTTP status verification
✔ API contract validation

❌ Initially not included:
performance tests
load testing
distributed system tests (Kafka/WebSocket)
TestContainers (future phase)
🔐 3. FRONTEND + BACKEND INTEGRATION

Integration is validated through:

✔ API contract consistency
frontend consumes /api/*
backend exposes standardized endpoints
gateway handles JWT authentication
✔ validated flow:
Login (Frontend)
   ↓
Auth API (Backend)
   ↓
JWT Token
   ↓
Axios Interceptor (Frontend)
   ↓
Gateway Validation
   ↓
Backend Services
🧠 4. ADOPTED PRINCIPLES
4.1 Separation of responsibilities
Frontend → UI + behavior
Backend → business logic + data
4.2 Tests as integration guarantees

Testing is not only about code, but about:

real endpoints
authentication flows
data consistency
4.3 Progressive evolution

The strategy evolves incrementally:

Phase 1 (current)

✔ basic controller + UI tests

Phase 2

✔ service + repository tests

Phase 3

✔ TestContainers + real database

Phase 4

✔ E2E testing (Playwright + real backend)

Phase 5

✔ load testing + event-driven systems (RFID streaming)

🚀 5. CONSEQUENCES
Positive:

✔ increased platform reliability
✔ early detection of integration issues
✔ strong foundation for SaaS scalability
✔ readiness for multi-tenant architecture

Trade-offs:

⚠ initial increase in complexity
⚠ need to maintain mocks
⚠ learning curve for integration testing

📌 6. DECISION

The testing strategy will be implemented in two parallel layers:

Frontend: Vitest + React Testing Library
Backend: JUnit + Spring Boot Test + MockMvc

Both follow the same philosophy:
👉 validate real platform behavior, not only isolated units.

🧭 7. STATUS

✔ Approved for immediate implementation
✔ Foundation for future evolution (E2E + real-time systems)