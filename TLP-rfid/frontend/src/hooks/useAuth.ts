import { useState } from "react";
import { login } from "../services/authService";

export function useAuth() {
  const [loading, setLoading] = useState(false);

  const signIn = async (email: string, password: string) => {
    setLoading(true);
    await login(email, password);
    setLoading(false);
  };

  return { signIn, loading };
}