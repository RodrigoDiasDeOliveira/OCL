import { useEffect, useState } from "react";
import { getRfidEvents } from "../services/rfidService";

export function useRfid() {
  const [events, setEvents] = useState([]);

  useEffect(() => {
    getRfidEvents().then(setEvents);
  }, []);

  return events;
}