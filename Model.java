import java.sql.*;
import java.util.ArrayList;

public class Model {
    private Connection connection; // refers to the connection to the SQL database
    private String currentView;
    private ArrayList<Flight> flights;
    private ArrayList<Employee> employees;
    private ArrayList<Passenger> passengers;
    private ArrayList<Booking> bookings;
    private ArrayList<FlightOccupancyReport> foReports;
    private ArrayList<EmployeeStatisticsReport> esReports;
    private ArrayList<RevenueReport> revReports;
    private ArrayList<PassengerReport> passReports;
    private ArrayList<ViewBooking> viewBookings;
    private ArrayList<ViewFlight> viewFlights;
    private ArrayList<ViewPassenger> viewPassengers;

    public Model(Connection connection) {
        this.connection = connection;

        this.flights = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.bookings = new ArrayList<>();
        this.passengers = new ArrayList<>();
        this.foReports = new ArrayList<>();
        this.revReports = new ArrayList<>();
        this.passReports = new ArrayList<>();

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
                        rs.getLong("contact_no"),
                        rs.getString("email_address"),
                        rs.getString("vip_status"));
                //data read (by row) is assigned to an arraylist
                passengers.add(passHolder);
            }
            rs.close();
        } catch(SQLException e) {
            System.out.println("Error! Something happened to the database.");
            System.out.println(e.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Error! Unable to close the statement.");
                System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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
                        rs.getString("seat_class"),
                        rs.getDouble("total_cost"),
                        rs.getString("food_order"),
                        rs.getInt("total_checkin_bags"));

                bookings.add(bookHolder);
            }
            rs.close();
        } catch(SQLException e) {
            System.out.println("Error! Something happened to the database.");
            System.out.println(e.getMessage());
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

    public boolean updateContactNo (int passenger_id, Long contact_number) throws SQLException{
        String query = "UPDATE passengers SET contact_no = ? WHERE passenger_id = ?";

        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setLong(1, contact_number);
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
    public boolean updateELastName (int employee_id, String last_name) throws SQLException{
        String query = "UPDATE employees SET last_name = ? WHERE employee_id = ?";

        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setString(1, last_name);
        stmt.setInt(2, employee_id);
        stmt.executeUpdate();

        for(int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getID() == employee_id)
                employees.get(i).setLast_name(last_name);
        }

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
    public boolean updateGateNumber(int flightID, int gate_number) throws SQLException{
        String query = "UPDATE flights SET gate_number = ? WHERE flight_id = ?";

        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setInt(1, gate_number);
        stmt.setInt(2, flightID);
        stmt.executeUpdate();
        return true;
    }

    public boolean updateDesination (int flightID, String destination) throws SQLException{
        String query = "UPDATE flights SET destination = ? WHERE flight_id = ?";

        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setString(1, destination);
        stmt.setInt(2, flightID);
        stmt.executeUpdate();
        return true;
    }

    public boolean updateOrigin (int flightID, String origin) throws SQLException{
        String query = "UPDATE flights SET origin = ? WHERE flight_id = ?";

        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setString(1, origin);
        stmt.setInt(2, flightID);
        stmt.executeUpdate();
        return true;
    }

    public boolean updateDeparture (int flightID, String departure) throws SQLException{
        String query = "UPDATE flights SET departure = ? WHERE flight_id = ?";

        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setString(1, departure);
        stmt.setInt(2, flightID);
        stmt.executeUpdate();
        return true;
    }

    public boolean updateArrival (int flightID, String arrival) throws SQLException{
        String query = "UPDATE flights SET arrival = ? WHERE flight_id = ?";

        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setString(1, arrival);
        stmt.setInt(2, flightID);
        stmt.executeUpdate();
        return true;
    }

    public boolean updatePilot (int flightID, int pilot_id) throws SQLException{
        String query = "UPDATE flights SET pilot_id = ? WHERE flight_id = ?";

        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setInt(1, pilot_id);
        stmt.setInt(2, flightID);
        stmt.executeUpdate();
        return true;
    }

    public boolean updateCoPilot (int flightID, int copilot_id) throws SQLException{
        String query = "UPDATE flights SET copilot_id = ? WHERE flight_id = ?";

        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setInt(1, copilot_id);
        stmt.setInt(2, flightID);
        stmt.executeUpdate();
        return true;
    }

    public boolean updateLeadAttendant (int flightID, int lead_attendant) throws SQLException{
        String query = "UPDATE flights SET lead_attendant = ? WHERE flight_id = ?";

        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setInt(1, lead_attendant);
        stmt.setInt(2, flightID);
        stmt.executeUpdate();
        return true;
    }

    public boolean updateFlightAttendant (int flightID, int flight_attendant) throws SQLException{
        String query = "UPDATE flights SET flight_attendant = ? WHERE flight_id = ?";

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

    public boolean updateSeat (int ref_id, String seat_number) throws SQLException{
        String query = "UPDATE bookings SET seat_no = ? WHERE ref_id = ?";

        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setString(1, seat_number);
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

    //FIND FUNCTIONS

    public boolean findEmployee(int employee_id){
        for(int i = 0; i < employees.size(); i++){
            if(employee_id == employees.get(i).getID())
                return true;
        }
        return false;
    }

    public boolean findPassenger(int passenger_id){
        for(int i = 0; i < passengers.size(); i++){
            if(passenger_id == passengers.get(i).getID())
                return true;
        }
        return false;
    }

    public boolean findFlight(int flight_id){
        for(int i = 0; i < flights.size(); i++){
            if(flight_id == flights.get(i).getFlight_id())
                return true;
        }
        return false;
    }

    public boolean findBooking(int ref_id){
        for(int i = 0; i < bookings.size(); i++){
            if(ref_id == bookings.get(i).getID())
                return true;
        }
        return false;
    }

    public double getTotalPrice(int flight_id, String seat_number){
        for(int i = 0; i < flights.size(); i++){
            if(flights.get(i).getFlight_id() == flight_id)
                return flights.get(i).getSeatPrice(seat_number);
        }
        return 3000;
    }

}
