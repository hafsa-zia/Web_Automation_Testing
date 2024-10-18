package util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {
    private Connection connection;

    public DatabaseUtil() {
        // Initialize your database connection
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify_test", "username", "password"); // Update with your DB credentials
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> searchSongs(String songName) {
        List<String> songs = new ArrayList<>();
        String query = "SELECT song_name FROM songs WHERE song_name LIKE ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + songName + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                songs.add(resultSet.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songs;
    }
}
