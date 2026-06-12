import { render, screen, fireEvent } from "@testing-library/react";
import Login from "../../pages/Login";
import { BrowserRouter } from "react-router-dom";

describe("Login Page", () => {
  test("renders login form", () => {
    render(
      <BrowserRouter>
        <Login />
      </BrowserRouter>
    );

    expect(screen.getByText("Entrar na Plataforma")).toBeInTheDocument();
  });

  test("fills form fields", () => {
    render(
      <BrowserRouter>
        <Login />
      </BrowserRouter>
    );

    fireEvent.change(screen.getByPlaceholderText("seu@email.com"), {
      target: { value: "test@test.com" },
    });

    fireEvent.change(screen.getByPlaceholderText("••••••••"), {
      target: { value: "123456" },
    });

    expect(screen.getByDisplayValue("test@test.com")).toBeInTheDocument();
  });
});