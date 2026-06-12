import { useEffect, useState } from "react";
import { getDashboard } from "../services/dashboardService";

export function useDashboard() {
  const [data, setData] = useState(null);

  useEffect(() => {
    getDashboard().then(setData);
  }, []);

  return data;
}