import { Routes, Route, Navigate } from 'react-router-dom'

import MainLayout from './components/layout/MainLayout'
import Dashboard from './pages/Dashboard'
import RfidEvents from './pages/RfidEvents'
import Inventory from './pages/Inventory'
import Shipments from './pages/Shipments'
import Predictions from './pages/Predictions'
import Analytics from './pages/Analytics'
import Login from './pages/Login'
import Integration from './pages/Integration'

import PrivateRoute from './components/auth/PrivateRoute'

function App() {
  return (
    <Routes>

      {/* PUBLIC ROUTE */}
      <Route path="/login" element={<Login />} />

      {/* PROTECTED LAYOUT */}
      <Route
        path="/"
        element={
          <PrivateRoute>
            <MainLayout />
          </PrivateRoute>
        }
      >
        <Route index element={<Navigate to="/dashboard" replace />} />

        <Route path="dashboard" element={<Dashboard />} />
        <Route path="rfid" element={<RfidEvents />} />
        <Route path="inventory" element={<Inventory />} />
        <Route path="shipments" element={<Shipments />} />
        <Route path="predictions" element={<Predictions />} />
        <Route path="analytics" element={<Analytics />} />
        <Route path="integration" element={<Integration />} />
      </Route>

      {/* fallback */}
      <Route path="*" element={<Navigate to="/login" replace />} />

    </Routes>
  )
}

export default App