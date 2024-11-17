import java.sql.*;
import java.util.ArrayList;

public class Model {
    private Connection connection; // refers to the connection to the SQL database
    //not sure if need pa mga to
    private ArrayList<Flight> flights;
    private ArrayList<Booking> bookings;
    private ArrayList<Passenger> passengers;
    private ArrayList<Employee> employees;

    public Model() {
        this.flights = new ArrayList<>();
        this.bookings = new ArrayList<>();
        this.passengers = new ArrayList<>();
        this.employees = new ArrayList<>();
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

}