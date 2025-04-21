package com.johnsapp.final_project;

import java.io .*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http .*;
import jakarta.servlet.annotation .*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(name = "Calculator", value = "/calculator")
public class HelloServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(HelloServlet.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        getServletContext().getRequestDispatcher("/calculator.jsp").forward(request, response);
        logger.info("getting requested .jsp file");
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
            logger.info("Parsing input strings to float");
            num1 = Float.parseFloat(num1Str);
            num2 = Float.parseFloat(num2Str);
        }
        catch (NumberFormatException e) {
            logger.warn("Input number out of range 'NumberFormatException'");
            errorMessage = "Invalid number format. Please enter valid numbers.";
        }
        float result = 0;


        if (errorMessage == null) {
            try {
                switch (operation) {
                    case "add":
                        logger.info("calling addNumbers from .jsp");
                        result = Calculator.addNumbers(num1, num2);
                        break;
                    case "subtract":
                        logger.info("calling subtractNumbers from .jsp");
                        result = Calculator.subtractNumbers(num1, num2);
                        break;
                    case "multiply":
                        logger.info("calling multiplyNumbers from .jsp");
                        result = Calculator.multiplyNumbers(num1, num2);
                        break;
                    case "divide":
                        logger.info("calling divideNumbers from .jsp");
                        result = Float.parseFloat(Calculator.divideNumbers(num1, num2));
                        break;
                    default:
                        logger.warn("Unknown operation: ");
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
            logger.fatal(errorMessage);
            request.setAttribute("error", errorMessage);
            request.setAttribute("result", null);
        }
        else{
            logger.info("calculation completed");
            request.setAttribute("result", result);
            request.setAttribute("error", null);
        }
        logger.info("recycling the jsp page");
        getServletContext().getRequestDispatcher("/calculator.jsp").forward(request, response);
    }
}