import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
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

                System.out.println("Added!");
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

    public boolean createPassenger(String passport_number, String last_name, String first_name,
                                   String birthdate, Long contact_no, String email_address, String vip_status)
            throws SQLException{
        String query = "INSERT INTO passengers (passport_number, last_name, first_name, " +
                "birthdate, contact_no, email_address, vip_status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setString(1, passport_number);
        stmt.setString(2, last_name);
        stmt.setString(3, first_name);
        stmt.setString(4, birthdate);
        stmt.setLong(5, contact_no);
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

        for(int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getID() == employee_id)
                employees.remove(i);
        }

        return true;
    }

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
                                  String seat_class, double total_cost, String food_order, int checkin_bags)
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

    public boolean deleteBooking(int booking_id) throws SQLException {
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

    public boolean updateSeat (int ref_id, String seat_number) throws SQLException{
        String query = "UPDATE bookings SET seat_number = ? WHERE ref_id = ?";

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

    public boolean viewBooking () throws SQLException{
        String query = "SELECT b.ref_id, b.passenger_id, b.flight_id, b.checkin_date, b.seat_no, " +
                "b.seat_class, b.total_cost, b.food_order, b.total_checkin_bags, p.last_name, p.first_name, " +
                "p.email_address, p.vip_status, p.contact_no, p.passport_number " +
                "FROM bookings b JOIN passengers p ON b.passenger_id = p.passenger_id ";

        PreparedStatement stmt = connection.prepareStatement(query);

        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            ViewBooking holder = new ViewBooking(rs.getInt("ref_id"),
                    rs.getInt("passenger_id"),
                    rs.getInt("flight_id"),
                    rs.getString("checkin_date"),
                    rs.getString("seat_no"),
                    rs.getString("seat_class"),
                    rs.getDouble("total_cost"),
                    rs.getString("food_order"),
                    rs.getInt("total_checkin_bags"),
                    rs.getString("passport_number"),
                    rs.getString("last_name"),
                    rs.getString("first_name"),
                    rs.getString("birthdate"),
                    rs.getInt("contact_no"),
                    rs.getString("email_address"),
                    rs.getString("vip_status"));

            viewBookings.add(holder);
        }
        return true;
    }

    public boolean viewFlight () throws SQLException{
        String query = "SELECT * FROM flights";
        String query2 = "SELECT * FROM passengers p " +
                "JOIN bookings b ON p.passenger_id = b.passenger_id " +
                "WHERE b.flight_id = ?";

        PreparedStatement stmt = connection.prepareStatement(query);
        PreparedStatement stmt2 = connection.prepareStatement(query2);

        ResultSet rs = stmt.executeQuery();

        ArrayList<Passenger> arrayHolder = new ArrayList<>();

        while(rs.next()) {
            stmt2.setInt(1, rs.getInt("flight_id"));
            ResultSet rs2 = stmt2.executeQuery();

            while (rs2.next()) {
                Passenger elementHolder = new Passenger(rs.getInt("passenger_id"),
                        rs.getString("passport_number"),
                        rs.getString("last_name"),
                        rs.getString("first_name"),
                        rs.getString("birthdate"),
                        rs.getLong("contact_no"),
                        rs.getString("email_address"),
                        rs.getString("vip_status"));

                arrayHolder.add(elementHolder);
            }

            ViewFlight holder = new ViewFlight(rs.getInt("flight_id"),
                    rs.getInt("gate_number"),
                    rs.getString("destination"),
                    rs.getString("origin"),
                    rs.getString("departure"),
                    rs.getString("arrival"),
                    rs.getInt("pilot_id"),
                    rs.getInt("copilot_id"),
                    rs.getInt("lead_attendant"),
                    rs.getInt("flight_attendant"),
                    arrayHolder);

            viewFlights.add(holder);
        }
        return true;
    }

    public boolean viewPassenger () throws SQLException{
        String query = "SELECT * FROM passengers";
        String query2 = "SELECT * FROM bookings b " +
                "JOIN passengers p ON b.passenger_id = p.passenger_id " +
                "WHERE b.passenger_id = ?";

        PreparedStatement stmt = connection.prepareStatement(query);
        PreparedStatement stmt2 = connection.prepareStatement(query2);

        ResultSet rs = stmt.executeQuery();

        ArrayList<Booking> arrayHolder = new ArrayList<>();

        while(rs.next()) {
            stmt2.setInt(1, rs.getInt("passenger_id"));
            ResultSet rs2 = stmt2.executeQuery();

            while (rs2.next()) {
                Booking elementHolder = new Booking(rs.getInt("ref_id"),
                        rs.getInt("passenger_id"),
                        rs.getInt("flight_id"),
                        rs.getString("checkin_date"),
                        rs.getString("seat_no"),
                        rs.getString("seat_class"),
                        rs.getDouble("total_cost"),
                        rs.getString("food_order"),
                        rs.getInt("total_checkin_bags"));

                arrayHolder.add(elementHolder);
            }

            ViewPassenger holder = new ViewPassenger(rs.getInt("passenger_id"),
                    rs.getString("passport_number"),
                    rs.getString("last_name"),
                    rs.getString("first_name"),
                    rs.getString("birthdate"),
                    rs.getLong("contact_no"),
                    rs.getString("email_address"),
                    rs.getString("vip_status"),
                    arrayHolder);

            viewPassengers.add(holder);
        }
        return true;
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

    public boolean generateESR (int year, int month) throws SQLException {
        String query = "SELECT e.employee_id, COUNT(f.flight_id) AS numTasks, (e.salary * COUNT(f.flight_id)) AS totalRevenue " +
                "FROM employees e LEFT JOIN flights f ON e.employee_id IN (f.pilot_id, f.copilot_id, f.lead_attendant, f.flight_attendant)" +
                "WHERE YEAR(f.departure) = ? AND MONTH(f.departure) = ? " +
                "GROUP BY e.employee_id, e.salary";

        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setInt(1, year);
        stmt.setInt(2, month);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            EmployeeStatisticsReport holder = new EmployeeStatisticsReport(
                    rs.getInt("employee_id"),
                    rs.getInt("numTasks"),
                    rs.getDouble("totalRevenue"));

            esReports.add(holder);
        }
        return true;
    }

    public boolean generateRevR (int year) throws SQLException {
        String query = "SELECT MONTH(f.departure) AS month, COUNT(f.flight_id) AS numbers, SUM(b.total_cost) as revenue " +
                "FROM flights f LEFT JOIN bookings b ON f.flight_id " +
                "WHERE YEAR(f.departure) = ? " +
                "GROUP BY month " +
                "ORDER BY month;";

        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setInt(1, year);

        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            RevenueReport holder = new RevenueReport(rs.getInt("month"),
                    rs.getInt("numbers"),
                    rs.getInt("revenue"));

            revReports.add(holder);
        }
        return true;
    }

    public boolean generatePassR (int year, int month) throws SQLException {
        String query = "SELECT p.last_name, p.first_name, p.email_address, p.vip_status, COUNT(b.ref_id) AS totalBookings " +
                "FROM passengers p LEFT JOIN bookings b ON p.passenger_id = b.passenger_id " +
                "WHERE YEAR(b.checkin_date) = ? AND MONTH(b.checkin_date) = ? " +
                "GROUP BY p.last_name, p.first_name, p.email_address, p.vip_status;";

        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setInt(1, year);
        stmt.setInt(1, month);

        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            PassengerReport holder = new PassengerReport(rs.getString("last_name"),
                    rs.getString("first_name"),
                    rs.getString("email_address"),
                    rs.getString("vip_status"),
                    rs.getInt("totalBookings"));

            passReports.add(holder);
        }
        return true;
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
