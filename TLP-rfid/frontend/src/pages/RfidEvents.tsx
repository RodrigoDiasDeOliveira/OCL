import { useRfid } from "../hooks/useRfid";

export default function RfidEvents() {
  const events = useRfid();

  return (
    <div>
      <h1>RFID Events</h1>
      <pre>{JSON.stringify(events, null, 2)}</pre>
    </div>
  );
}