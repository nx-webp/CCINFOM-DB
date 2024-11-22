import java.sql.*;
import java.util.ArrayList;

public class Model {
    private Connection connection; // refers to the connection to the SQL database
    private String currentView;

    public Model() {
        this.currentView = "Home";
    }

    public boolean deleteFlight(String flightID) throws SQLException {
        // define the query needed to get the flight to delete, '?' is a placeholder
        String query = "DELETE * FROM flights WHERE flightID = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, flightID);
        stmt.executeUpdate();
        return true;
    }


    public boolean setCurrentView(String currentView) {
        if (currentView.equals("Home") || currentView.equals("Admin Menu") ||
                currentView.equals("Passenger Menu") || currentView.equals("Exit Program")) {
            this.currentView = currentView;
            return true; // view changed
        }
        return false; // do not change view
    }

    public String getCurrentView() {
        return currentView;
    }

}
