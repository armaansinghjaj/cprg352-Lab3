package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculatorServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get requests end up here!
        
        getServletContext().getRequestDispatcher("/WEB-INF/AgeCalculator.jsp").forward (request, response);
        return;
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Post requests here!
        
        int ageCounter;
        
        // Capture the incoming age parameter
        String age = request.getParameter("age");
        
        // Set up the attribute in the request object, to be sent to the JSP
        request.setAttribute("Age", age);
        
        // Perform validations from here
        // if no input
        if(age == null || age.equals("")){
            // Error message
            String message = "You must give your current age";
            
            // set the error message in the request object as an attribute
            request.setAttribute("message", message);
            
            getServletContext().getRequestDispatcher("/WEB-INF/AgeCalculator.jsp").forward(request, response);
            // stop the code call
            return;
        }
        
        // if input is in text or number
        else{
            if(checkNumber(age)){
                ageCounter = Integer.parseInt(age);
                ageCounter++;
                String message = "Your age next birthday will be " + ageCounter + ".";
                
                // set the message with age in the request object as an attribute
                request.setAttribute("message", message);
                
                getServletContext().getRequestDispatcher("/WEB-INF/AgeCalculator.jsp").forward(request, response);
                // stop the code call
                return;
            }
            else{
                String message = "You must enter a number.";
                
                // set the error message in the request object as an attribute
                request.setAttribute("message", message);
                
                getServletContext().getRequestDispatcher("/WEB-INF/AgeCalculator.jsp").forward(request, response);
                // stop the code call
                return;
            }
        }
    }
    
    // Public method to check if the input is in number or String
    public static boolean checkNumber(String ageInput) { 
        try {  
            Integer.parseInt(ageInput);
        } catch(NumberFormatException ne){  
            return false;  
        }
        return true;
    }
}