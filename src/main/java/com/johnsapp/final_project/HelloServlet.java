package com.johnsapp.final_project;

import java.io .*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http .*;
import jakarta.servlet.annotation .*;

@WebServlet(name = "Calculator", value = "/calculator")
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        getServletContext().getRequestDispatcher("/calculator.jsp").forward(request, response);
        System.out.println("doGet");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        System.out.println("doPost");
        String operation = request.getParameter("operation");
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");
        String errorMessage = null;
        float num1 = 0;
        float num2 = 0;

        try {
            num1 = Float.parseFloat(num1Str);
            num2 = Float.parseFloat(num2Str);
        }
        catch (NumberFormatException e) {
            errorMessage = "Invalid number format. Please enter valid numbers.";
        }
        float result = 0;


        if (errorMessage == null) {
            try {
                switch (operation) {
                    case "add":
                        result = Calculator.addNumbers(num1, num2);
                        break;
                    case "subtract":
                        result = Calculator.subtractNumbers(num1, num2);
                        break;
                    case "multiply":
                        result = Calculator.multiplyNumbers(num1, num2);
                        break;
                    case "divide":
                        result = Float.parseFloat(Calculator.divideNumbers(num1, num2));
                        break;
                    default:
                        errorMessage = "Invalid operation.";
                }
            } catch (ArithmeticException e) {
                errorMessage = e.getMessage(); // Get the error message from the exception
            }
        }

        request.setAttribute("num1", num1Str);
        request.setAttribute("num2", num2Str);
        request.setAttribute("operation", operation);
        if (errorMessage != null) {
            request.setAttribute("error", errorMessage);
            request.setAttribute("result", null);
        }
        else{
            request.setAttribute("result", result);
            request.setAttribute("error", null);
        }

        getServletContext().getRequestDispatcher("/calculator.jsp").forward(request, response);
    }
}