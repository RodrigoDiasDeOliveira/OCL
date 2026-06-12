import { createContext, useContext, useState } from "react";
import { login as loginService } from "../services/authService";

const AuthContext = createContext<any>(null);

export function AuthProvider({ children }: any) {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  const login = async (email: string, password: string) => {
    const token = await loginService(email, password);

    if (token) {
      localStorage.setItem("token", token);
      setIsAuthenticated(true);
      return true;
    }

    return false;
  };

  return (
    <AuthContext.Provider value={{ isAuthenticated, login }}>
      {children}
    </AuthContext.Provider>
  );
}

export const useAuth = () => useContext(AuthContext);