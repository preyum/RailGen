package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.BookingDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Booking;

@WebServlet("/ViewBookingsServlet")
public class ViewBookingsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>All Bookings</title></head><body>");
        out.println("<h1>All Bookings</h1>");

        try {
            List<Booking> bookings = BookingDAO.getAllBookings();

            if (bookings.isEmpty()) {
                out.println("<p>No bookings found.</p>");
            } else {
                out.println("<table border='1'>");
                out.println("<tr><th>Passenger Name</th><th>Train Name</th><th>Fare</th></tr>");
                for (Booking booking : bookings) {
                    out.println("<tr><td>" + booking.getPassengerName() + "</td><td>" + booking.getTrainName() + "</td><td>" + booking.getFare() + "</td></tr>" + booking.getOrigin() + "</td></tr>" + booking.getDestination());
                }
                out.println("</table>");
            }
        } catch (Exception e) {
            out.println("<p>Error retrieving bookings: " + e.getMessage() + "</p>");
        }

        out.println("<a href='index.html'>Back to Home</a>");
        out.println("</body></html>");
    }
}