// src/App.tsx
import { Routes, Route, Navigate } from 'react-router-dom'
import MainLayout from './components/layout/MainLayout'
import Dashboard from './pages/Dashboard'
import RfidEvents from './pages/RfidEvents'
import Inventory from './pages/Inventory'
import Shipments from './pages/Shipments'
import Predictions from './pages/Predictions'
import Analytics from './pages/Analytics'

function App() {
  return (
    <Routes>
      <Route path="/" element={<MainLayout />}>
        <Route index element={<Navigate to="/dashboard" replace />} />
        <Route path="dashboard" element={<Dashboard />} />
        <Route path="rfid" element={<RfidEvents />} />
        <Route path="inventory" element={<Inventory />} />
        <Route path="shipments" element={<Shipments />} />
        <Route path="predictions" element={<Predictions />} />
        <Route path="analytics" element={<Analytics />} />
      </Route>
      
      {/* Futuro: Login */}
      {/* <Route path="/login" element={<Login />} /> */}
    </Routes>
  )
}

export default App