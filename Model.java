import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Model {
    private Connection connection; // refers to the connection to the SQL database
    private String currentView;
    private ArrayList<Flight> flights;
    private ArrayList<Employee> employees;
    private ArrayList<Passenger> passengers;
    private ArrayList<Booking> bookings;
    private ArrayList<FlightOccupancyReport> foReports;

    public Model(Connection connection) {
        this.currentView = "Home";
        this.connection = connection;

        this.flights = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.bookings = new ArrayList<>();
        this.passengers = new ArrayList<>();
        this.foReports = new ArrayList<>();
        
        this.fetchData();
        
    }

    public void fetchData() {
        // fetch existing data from the database (store in arraylists above)
        Statement stmt = null;

        // PASSENGERS
        String passengersQuery = "SELECT * FROM passengers";
        try {
            stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(passengersQuery);

            while(rs.next()) {
                //create new passenger
                Passenger passHolder = new Passenger(rs.getInt("passenger_id"),
                                                     rs.getString("passport_number"),
                                                     rs.getString("last_name"),
                                                     rs.getString("first_name"),
                                                     rs.getString("birthdate"),
                                                     rs.getInt("contact_no"),
                                                     rs.getString("email_address"),
                                                     rs.getString("vip_status"));
                //data read (by row) is assigned to an arraylist
                passengers.add(passHolder);
            }
            rs.close();
        } catch(SQLException e) {
            System.out.println("Error! Something happened to the database.");
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Error! Unable to close the statement.");
            }
        }

        // EMPLOYEES
        String employeesQuery = "SELECT * FROM employees";
        try {
            stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(employeesQuery);

            while(rs.next()) {
                // create new employee
                Employee empHolder = new Employee(rs.getInt("employee_id"),
                                                  rs.getString("last_name"),
                                                  rs.getString("first_name"),
                                                  rs.getString("job_title"),
                                                  rs.getString("hire_date"),
                                                  rs.getDouble("salary"),
                                                  rs.getString("department"));

                employees.add(empHolder);
            }
            rs.close();
        } catch(SQLException e) {
            System.out.println("Error! Something happened to the database.");
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Error! Unable to close the statement.");
            }
        }

        // FLIGHTS
        String flightsQuery = "SELECT * FROM flights";
        try {
            stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(flightsQuery);

            while(rs.next()) {
                // create new flight instance

                Flight flightHolder = new Flight(rs.getInt("flight_id"),
                                                 rs.getInt("gate_number"),
                                                 rs.getString("destination"),
                                                 rs.getString("origin"),
                                                 rs.getString("departure"),
                                                 rs.getString("arrival"),
                                                 rs.getInt("pilot_id"),
                                                 rs.getInt("copilot_id"),
                                                 rs.getInt("lead_attendant"),
                                                 rs.getInt("flight_attendant"),
                                                 3000 /* base price? */ );

                flights.add(flightHolder);
            }
            rs.close();
        } catch(SQLException e) {
            System.out.println("Error! Something happened to the database.");
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Error! Unable to close the statement.");
            }
        }

        // BOOKINGS
        String bookingsQuery = "SELECT * FROM bookings";
        try {
            stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(bookingsQuery);

            while(rs.next()) {
                // create new booking object

                Booking bookHolder = new Booking(rs.getInt("ref_id"),
                                                 rs.getInt("passenger_id"),
                                                 rs.getInt("flight_id"),
                                                 rs.getString("checkin_date"),
                                                 rs.getString("seat_no"),
                                                 rs.getString("saet_class"),
                                                 rs.getDouble("total_cost"),
                                                 rs.getString("food_order"),
                                                 rs.getInt("total_checkin_bags"));

                bookings.add(bookHolder);
            }
            rs.close();
        } catch(SQLException e) {
            System.out.println("Error! Something happened to the database.");
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Error! Unable to close the statement.");
            }
        }
    }
    
    
    /*
    ---------------------------------------------------------------------------------------------------
    PASSENGERS
    ---------------------------------------------------------------------------------------------------
    */
    
    public boolean createPassenger(String passport_number, String last_name, String first_name,
                                   String birthdate, int contact_no, String email_address, String vip_status)
            throws SQLException{
        String query = "INSERT INTO passengers (passport_number, last_name, first_name, " +
                "birthdate, contact_no, email_address, vip_status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, passport_number);
        stmt.setString(2, last_name);
        stmt.setString(3, first_name);
        stmt.setString(4, birthdate);
        stmt.setInt(5, contact_no);
        stmt.setString(6, email_address);
        stmt.setString(7, vip_status);
        
        stmt.executeUpdate();
        
        Passenger newPassenger = new Passenger(passengers.get(passengers.size() - 1).getID() + 1, 
                passport_number, last_name, first_name, birthdate, contact_no, email_address, vip_status);
        passengers.add(newPassenger);
        
        return true;
    }
    
    public boolean deletePassenger (int passenger_id) throws SQLException {
        // define the query needed to get the flight to delete, '?' is a placeholder
        String query = "DELETE * FROM passengers WHERE passenger_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setInt(1, passenger_id);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updatePassport (int passenger_id, String passport_number) throws SQLException{
        String query = "UPDATE passengers SET passport_number = ? WHERE passenger_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, passport_number);
        stmt.setInt(2, passenger_id);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updatePLastName (int passenger_id, String last_name) throws SQLException{
        String query = "UPDATE passengers SET last_name = ? WHERE passenger_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, last_name);
        stmt.setInt(2, passenger_id);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updatePFirstName (int passenger_id, String first_name) throws SQLException{
        String query = "UPDATE passengers SET first_name = ? WHERE passenger_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, first_name);
        stmt.setInt(2, passenger_id);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateBirthdate (int passenger_id, String birthdate) throws SQLException{
        String query = "UPDATE passengers SET birthdate = ? WHERE passenger_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, birthdate);
        stmt.setInt(2, passenger_id);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateContactNo (int passenger_id, int contact_number) throws SQLException{
        String query = "UPDATE passengers SET contact_no = ? WHERE passenger_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setInt(1, contact_number);
        stmt.setInt(2, passenger_id);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateEmail (int passenger_id, String email) throws SQLException{
        String query = "UPDATE passengers SET email_address = ? WHERE passenger_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, email);
        stmt.setInt(2, passenger_id);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateStatus (int passenger_id, String vip_status) throws SQLException{
        String query = "UPDATE passengers SET vip_status = ? WHERE passenger_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, vip_status);
        stmt.setInt(2, passenger_id);
        stmt.executeUpdate();
        return true;
    }
    
    /*
    ---------------------------------------------------------------------------------------------------
    EMPLOYEES
    ---------------------------------------------------------------------------------------------------
    */
    
    public boolean createEmployee(String last_name, String first_name, String job_title, String hire_date,
                                  float salary, String department)
            throws SQLException {
    	String insertEmployee = "INSERT INTO employees (last_name, first_name, job_title, salary, hire_date, " +
                                "department) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = connection.prepareStatement(insertEmployee);
		
	    stmt.setString(1, last_name);
        stmt.setString(2, first_name);
        stmt.setString(3, job_title);
        stmt.setString(4, hire_date);
        stmt.setDouble(5, salary);
        stmt.setString(6, department);
        
        stmt.executeUpdate();

	Employee newEmployee = new Employee(employees.get(employees.size() - 1).getID() + 1, last_name,
                                        first_name, job_title, hire_date, salary, department);
        employees.add(newEmployee);
        
        return true;
    }
    
    public boolean deleteEmployee (int employee_id) throws SQLException {
        // define the query needed to get the flight to delete, '?' is a placeholder
        String query = "DELETE * FROM employees WHERE employee_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setInt(1, employee_id);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateELastName (int employee_id, String last_name) throws SQLException{
        String query = "UPDATE employees SET last_name = ? WHERE employee_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, last_name);
        stmt.setInt(2, employee_id);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateEFirstName (int employee_id, String first_name) throws SQLException{
        String query = "UPDATE employees SET first_name = ? WHERE employee_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, first_name);
        stmt.setInt(2, employee_id);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateJobTitle (int employee_id, String job_title) throws SQLException{
        String query = "UPDATE employees SET job_title = ? WHERE employee_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, job_title);
        stmt.setInt(2, employee_id);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateSalary (int employee_id, float salary) throws SQLException{
        String query = "UPDATE employees SET salary = ? WHERE employee_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setDouble(1, salary);
        stmt.setInt(2, employee_id);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateHireDate (int employee_id, String hire_date) throws SQLException{
        String query = "UPDATE employees SET hire_date = ? WHERE employee_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, hire_date);
        stmt.setInt(2, employee_id);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateDepartment (int employee_id, String department) throws SQLException{
        String query = "UPDATE employees SET department = ? WHERE employee_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, department);
        stmt.setInt(2, employee_id);
        stmt.executeUpdate();
        return true;
    }
    
    /*
    ---------------------------------------------------------------------------------------------------
    FLIGHTS
    ---------------------------------------------------------------------------------------------------
    */
    
    public boolean createFlight(int gate_number, String destination, String origin, String departure, String arrival,
                                int pilot_id, int copilot_id, int lead_attendant_id, int flight_attendant_id, double price)
            throws SQLException {
	    String query = "insert into flights (gate_number, destination, origin, departure, arrival, " +
                    "pilot_id, copilot_id, lead_attendant, flight_attendant) values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
	    PreparedStatement stmt = connection.prepareStatement(query);

	    stmt.setInt(1, gate_number);
	    stmt.setString(2, destination);
	    stmt.setString(3, origin);
	    stmt.setString(4, departure);
        stmt.setString(5, arrival);
        stmt.setInt(6, pilot_id);
	    stmt.setInt(7, copilot_id);
	    stmt.setInt(8, lead_attendant_id);
	    stmt.setInt(9, flight_attendant_id);
	    stmt.executeUpdate();
        
        Flight newFlight = new Flight(flights.get(flights.size() - 1).getFlight_id() + 1, gate_number, destination, origin,
                departure, arrival, pilot_id, copilot_id, lead_attendant_id, flight_attendant_id, price);
        flights.add(newFlight);
        
	return true;
    }
    
    public boolean deleteFlight(int flightID) throws SQLException {
        // define the query needed to get the flight to delete, '?' is a placeholder
        String query = "DELETE * FROM flights WHERE flight_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setInt(1, flightID);
        stmt.executeUpdate();
        return true;
    }

    public boolean updateGateNumber(int flightID, int gate_number) throws SQLException{
        String query = "UPDATE flights SET gate_number = ? WHERE flightID = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setInt(1, gate_number);
        stmt.setInt(2, flightID);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateDesination (int flightID, String destination) throws SQLException{
        String query = "UPDATE flights SET destination = ? WHERE employee_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, destination);
        stmt.setInt(2, flightID);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateOrigin (int flightID, String origin) throws SQLException{
        String query = "UPDATE flights SET origin = ? WHERE employee_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, origin);
        stmt.setInt(2, flightID);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateDeparture (int flightID, String departure) throws SQLException{
        String query = "UPDATE flights SET departure = ? WHERE employee_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, departure);
        stmt.setInt(2, flightID);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateArrival (int flightID, String arrival) throws SQLException{
        String query = "UPDATE flights SET arrival = ? WHERE employee_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, arrival);
        stmt.setInt(2, flightID);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updatePilot (int flightID, int pilot_id) throws SQLException{
        String query = "UPDATE flights SET pilot_id = ? WHERE employee_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setInt(1, pilot_id);
        stmt.setInt(2, flightID);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateCoPilot (int flightID, int copilot_id) throws SQLException{
        String query = "UPDATE flights SET copilot_id = ? WHERE employee_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setInt(1, copilot_id);
        stmt.setInt(2, flightID);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateLeadAttendant (int flightID, int lead_attendant) throws SQLException{
        String query = "UPDATE flights SET lead_attendant = ? WHERE employee_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setInt(1, lead_attendant);
        stmt.setInt(2, flightID);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateFlightAttendant (int flightID, int flight_attendant) throws SQLException{
        String query = "UPDATE flights SET flight_attendant = ? WHERE employee_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setInt(1, flight_attendant);
        stmt.setInt(2, flightID);
        stmt.executeUpdate();
        return true;
    }
	
    /*
    ---------------------------------------------------------------------------------------------------
    BOOKINGS
    ---------------------------------------------------------------------------------------------------
    */
    
    public boolean createBooking (int passenger_id, int flight_id, String checkin_date, String seat_number,
                                  String seat_class, Float total_cost, String food_order, int checkin_bags)
            throws SQLException {
    	String query = "INSERT INTO bookings (passenger_id, flight_id, checkin_date, seat_number, " +
                "seat_class, total_cost, food_order, total_checkin_bags) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
    	 PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setInt(1, passenger_id);
        stmt.setInt(2, flight_id);
        stmt.setString(3, checkin_date);
        stmt.setString(4, seat_number);
        stmt.setString(5, seat_class);
        stmt.setDouble(6, total_cost);
        stmt.setString(7, food_order);
        stmt.setInt(8, checkin_bags);
        
        stmt.executeUpdate();
        
        Booking newBooking = new Booking(bookings.get(bookings.size() - 1).getID() + 1, passenger_id, flight_id, checkin_date,
                seat_number, seat_class, total_cost, food_order, checkin_bags);
        bookings.add(newBooking);
        
        return true;
    }

    public boolean deleteBooking(int booking_id, int passenger_id) throws SQLException {
	    String cancelBooking = "DELETE FROM bookings WHERE booking_id = ?";
	     
	    PreparedStatement stmt = connection.prepareStatement(cancelBooking);
	     
	    stmt.setInt(1, booking_id);
	     
	    stmt.executeUpdate();
	    return true;
    }
    
    public boolean updatePassenger (int ref_id, int passenger_id) throws SQLException{
        String query = "UPDATE bookings SET passenger_id = ? WHERE ref_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setInt(1, passenger_id);
        stmt.setInt(2, ref_id);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateFlight (int ref_id, int flight_id) throws SQLException{
        String query = "UPDATE bookings SET pass = ? WHERE ref_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setInt(1, flight_id);
        stmt.setInt(2, ref_id);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateCheckIn (int ref_id, String checkin_date) throws SQLException{
        String query = "UPDATE bookings SET checkin_date = ? WHERE ref_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, checkin_date);
        stmt.setInt(2, ref_id);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateSeat (int ref_id, int seat_number) throws SQLException{
        String query = "UPDATE bookings SET seat_number = ? WHERE ref_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setInt(1, seat_number);
        stmt.setInt(2, ref_id);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateClass (int ref_id, String seat_class) throws SQLException{
        String query = "UPDATE bookings SET seat_class = ? WHERE ref_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, seat_class);
        stmt.setInt(2, ref_id);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateTotalCost (int ref_id, float total_cost) throws SQLException{
        String query = "UPDATE bookings SET total_cost = ? WHERE ref_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setDouble(1, total_cost);
        stmt.setInt(2, ref_id);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateFoodOrder (int ref_id, String food_order) throws SQLException{
        String query = "UPDATE bookings SET food_order = ? WHERE ref_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, food_order);
        stmt.setInt(2, ref_id);
        stmt.executeUpdate();
        return true;
    }
    
    public boolean updateTotalBaggage (int ref_id, int total_checkin_bags) throws SQLException{
        String query = "UPDATE bookings SET total_checkin_bags = ? WHERE ref_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setInt(1, total_checkin_bags);
        stmt.setInt(2, ref_id);
        stmt.executeUpdate();
        return true;
    }
    
    /*
    ---------------------------------------------------------------------------------------------------
    VIEWS
    ---------------------------------------------------------------------------------------------------
    */

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }
	    
    /*
    ---------------------------------------------------------------------------------------------------
    GENERATE REPORTS
    ---------------------------------------------------------------------------------------------------
    */

    public boolean generateFOR (int year, int month) throws SQLException {
        String query = "SELECT f.flight_id, f.origin, f.destination, COUNT(b.checkin_date) AS numbers " +
                        "FROM flights f JOIN bookings b ON f.flight_id = b.flight_id " +
                        "WHERE YEAR(b.checkin_date) = ? AND MONTH(b.checkin_date) = ? " +
                        "GROUP BY f.flight_id, f.origin, f.destination " +
                        "ORDER BY f.flight_id;";

        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setInt(1, year);
        stmt.setInt(2, month);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            FlightOccupancyReport holder = new FlightOccupancyReport(rs.getInt("flight_id"),
                                                                     rs.getString("destination"),
                                                                     rs.getString("origin"),
                                                                     rs.getInt("numbers"));
            foReports.add(holder);
        }
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
