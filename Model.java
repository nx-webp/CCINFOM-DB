import java.sql.*;
import java.util.ArrayList;

public class Model {
    private Connection connection; // refers to the connection to the SQL database
    private String currentView;

    //not sure if need pa mga to
//    private ArrayList<Flight> flights;
//    private ArrayList<Booking> bookings;
//    private ArrayList<Passenger> passengers;
//    private ArrayList<Employee> employees;

    public Model() {
        this.currentView = "Home";
    }

    /*
    public boolean deleteFlight(String flightID) throws SQLException {
        // define the query needed to get the flight to delete, '?' is a placeholder
        String query = "DELETE * FROM flights WHERE flightID = ?";
        try {
            PreparedStatement statement = connection.prepareSt
        }
    }
    */


    public boolean setCurrentView(String currentView) {
        if (currentView.equals("Home") || currentView.equals("View Records") ||
                currentView.equals("Manage Records") || currentView.equals("Generate Reports") ||
                currentView.equals("Book Flight")) {
            this.currentView = currentView;
            return true; // view changed
        }
        return false; // do not change view
    }

    public String getCurrentView() {
        return currentView;
    }

}