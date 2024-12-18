package dao;

import db.DBConnection;
import models.Train;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TrainDAO {
    public static void addTrain(Train train) throws SQLException {
        String query = "INSERT INTO trains (name, fare) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, train.getName());
            stmt.setInt(2, train.getFare());
            stmt.executeUpdate();
        }
    }
}
