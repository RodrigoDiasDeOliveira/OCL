import api from "./api";

export const getRfidEvents = async () => {
  const response = await api.get("/rfid/events");
  return response.data;
};