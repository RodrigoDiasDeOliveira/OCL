import { render, screen } from "@testing-library/react";
import Dashboard from "../../pages/Dashboard";

describe("Dashboard", () => {
  test("renders dashboard title", () => {
    render(<Dashboard />);

    expect(screen.getByText("Dashboard")).toBeInTheDocument();
  });
});