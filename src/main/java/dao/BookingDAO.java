package dao;

import db.DBConnection;
import models.Booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookingDAO {
    public static void addBooking(Booking booking) throws SQLException {
        String query = "INSERT INTO bookings (passenger_name, train_name) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, booking.getPassengerName());
            stmt.setString(2, booking.getTrainName());
            stmt.executeUpdate();
        }
    }
}
