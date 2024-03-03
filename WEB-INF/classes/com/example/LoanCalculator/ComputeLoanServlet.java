import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

// Make sure to import your Loan class here

public class ComputeLoanServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Extract parameters from the request
        double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
        double annualInterestRate = Double.parseDouble(request.getParameter("annualInterestRate"));
        int numberOfYears = Integer.parseInt(request.getParameter("numberOfYears"));
        
        // Create a Loan object and compute payments
        Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);
        double monthlyPayment = loan.getMonthlyPayment();
        double totalPayment = loan.getTotalPayment();
        
        // Generate the HTML response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Loan Calculation Result</title></head><body>");
        out.println("<p>Loan Amount: " + loanAmount + "</p>");
        out.println("<p>Annual Interest Rate: " + annualInterestRate + "%</p>");
        out.println("<p>Number of Years: " + numberOfYears + "</p>");
        out.println("<p>Monthly Payment: " + String.format("%.2f", monthlyPayment) + "</p>");
        out.println("<p>Total Payment: " + String.format("%.2f", totalPayment) + "</p>");
        out.println("</body></html>");
    }
}
