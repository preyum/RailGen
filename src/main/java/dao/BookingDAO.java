package dao;

import db.DBConnection;
import models.Booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    public static void addBooking(Booking booking) throws SQLException {
        String query = "INSERT INTO bookings (passenger_name, train_name, fare, origin, destination) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, booking.getPassengerName());
            stmt.setString(2, booking.getTrainName());
            stmt.setInt(3, booking.getFare());
            stmt.setString(4, booking.getOrigin());      // Update to origin
            stmt.setString(5, booking.getDestination()); // Update to destination
            stmt.executeUpdate();
        }
    }

    public static List<Booking> getAllBookings() throws Exception {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT passenger_name, train_name, fare, origin, destination FROM bookings"; // Update query

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String passengerName = resultSet.getString("passenger_name");
                String trainName = resultSet.getString("train_name");
                int fare = resultSet.getInt("fare");
                String origin = resultSet.getString("origin");      // Update to origin
                String destination = resultSet.getString("destination"); // Update to destination
                bookings.add(new Booking(passengerName, trainName, fare, origin, destination)); // Update constructor
            }
        }

        return bookings;
    }
}
