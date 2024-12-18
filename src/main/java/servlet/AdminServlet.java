package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Train;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.TrainDAO;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Admin Portal</title></head><body>");
        out.println("<h1>Welcome, Admin!</h1>");
        out.println("<form action='AdminServlet' method='post'>");
        out.println("<label for='train'>Train Name:</label>");
        out.println("<input type='text' id='train' name='train'><br>");
        out.println("<label for='fare'>Fare:</label>");
        out.println("<input type='number' id='fare' name='fare'><br>");
        out.println("<input type='submit' value='Add Train'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String trainName = request.getParameter("train");
        String fare = request.getParameter("fare");

        try {
            TrainDAO.addTrain(new Train(trainName, Integer.parseInt(fare)));
        } catch (NumberFormatException e) {
            System.err.println("Invalid fare: " + fare);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error adding train to the database.");
            e.printStackTrace();
        }

        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Admin Portal</title></head><body>");
        out.println("<h1>Train Added Successfully!</h1>");
        out.println("<p>Train: " + trainName + " | Fare: " + fare + "</p>");
        out.println("<a href='AdminServlet'>Back to Admin Portal</a>");
        out.println("</body></html>");
    }
}
