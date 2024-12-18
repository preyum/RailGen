package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.BookingDAO;

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String passengerName = request.getParameter("name");
        String trainName = request.getParameter("train");
        
        try {
			BookingDAO.addBooking(new Booking(passengerName, trainName));
		} catch (SQLException e) {
			System.out.println("Error in booking.."+ e.getMessage());
		}

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Booking Confirmation</title></head><body>");
        out.println("<h1>Thank you, " + passengerName + "!</h1>");
        out.println("<p>You have successfully booked the train: " + trainName + "</p>");
        out.println("<a href='pages/index.jsp'>Back to Home</a>");
        out.println("</body></html>");
    }
}
