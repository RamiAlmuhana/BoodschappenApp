import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnector {

    private Connection connection;
    private final String url;
    private final String user;
    private final String password;

    public DatabaseConnector() {
        //zorg ervoor dat de database boodschappen_db bestaat, hier moet je ook zelf met SQL je tables maken en dus je
        //database ontwerp!
        this.url = "jdbc:postgresql://localhost:5432/boodschappen_db";
        this.user = "postgres";
        this.password = "postgres";
        this.createDatabaseConnection();
    }

    private void createDatabaseConnection(){
        try {
            connection = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertData(String naam, String category, int hoeveelheid, double prijs) {
        try {
            String insertQuery = "INSERT INTO boodschap_item (naam, categorie, hoeveelheid, prijs) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Set values for the INSERT statement
            preparedStatement.setString(1, naam);
            preparedStatement.setString(2, category);
            preparedStatement.setInt(3, hoeveelheid);
            preparedStatement.setDouble(4, prijs);

            // Execute the INSERT statement
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Insert successful. Rows affected: " + rowsAffected);
            } else {
                System.out.println("Insert failed.");
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectData() {
        try {
            // Prepare the SELECT statement
            String selectQuery = "SELECT * FROM boodschap_item";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
//                System.out.println(resultSet.getInt("item_id"));
//                System.out.println(resultSet.getString("naam"));
//                System.out.println(resultSet.getString("categorie"));
//                System.out.println(resultSet.getInt("hoeveelheid"));
//                System.out.println(resultSet.getDouble("prijs"));
                System.out.println(resultSet.getString("naam") + " - " + resultSet.getString("categorie") + " - " + resultSet.getInt("hoeveelheid") + " - " + resultSet.getInt("prijs"));
            }

            // Close the result set and prepared statement
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            // Close the connection
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
