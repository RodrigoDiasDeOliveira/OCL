import { render, screen } from "@testing-library/react";
import RfidEvents from "../../pages/RfidEvents";

describe("RFID Events", () => {
  test("renders RFID title", () => {
    render(<RfidEvents />);

    expect(screen.getByText("RFID Events")).toBeInTheDocument();
  });
});