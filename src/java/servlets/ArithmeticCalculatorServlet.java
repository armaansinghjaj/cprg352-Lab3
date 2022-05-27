package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArithmeticCalculatorServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get requests here!
        
        String message = "---";
        
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Post requests here!
        
        // Capture the incoming numbers
        String firstNumber = request.getParameter("first_number");
        String secondNumber = request.getParameter("second_number");
        String addition = request.getParameter("add");
        String subtract = request.getParameter("sub");
        String multiply = request.getParameter("mul");
        String modulus = request.getParameter("mod");
        
        // Perform validations from here
        // if no input
        if(firstNumber == null || firstNumber.equals("") || secondNumber == null || secondNumber.equals("") || checkNumber(firstNumber) == false || checkNumber(secondNumber) == false){
            // error message
            String message = "Invalid";
            
            // set the error message in the request object as an attribute
            request.setAttribute("message", message);
            
            // Set up the attribute for first and second number in the request object, to be sent to the JSP
            request.setAttribute("firstNumber", firstNumber);
            request.setAttribute("secondNumber", secondNumber);
           
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            // stop the code call
            return;
        }
        
        // if it has valid input, perform calculations
        else{
            long calculation = 0;
            long firstnumber = Long.parseLong(firstNumber);
            long secondnumber = Long.parseLong(secondNumber);
            
            // perform arithmetic operation according to the button pressed in JSP
            if(addition != null){
                calculation = firstnumber + secondnumber;
            }
            else if(subtract != null){
                calculation = firstnumber - secondnumber;
            }
            else if(multiply != null){
                calculation = firstnumber * secondnumber;
            }
            else if(modulus != null){
                calculation = firstnumber % secondnumber;
            }
            
            String message = Long.toString(calculation);
            
            // set the calculation as message in the request object as an attribute
            request.setAttribute("message", message);
            request.setAttribute("firstNumber", firstNumber);
            request.setAttribute("secondNumber", secondNumber);
            
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            // stop the code call
            return;
        }
    }
    
    // Public method to check if the input is in number or String
    public static boolean checkNumber(String numberInput){ 
        try {  
            Long.parseLong(numberInput);
        } catch(NumberFormatException ne){
            return false;  
        }
        return true;
    }
}