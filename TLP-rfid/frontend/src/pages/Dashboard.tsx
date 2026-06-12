import { useDashboard } from "../hooks/useDashboard";

export default function Dashboard() {
  const data = useDashboard();

  return (
    <div>
      <h1>Dashboard Real</h1>
      <pre>{JSON.stringify(data, null, 2)}</pre>
    </div>
  );
}