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

    public Model() {
        this.currentView = "Home";
	this.flights = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.bookings = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }
    
    /* public static void flightBooking (Statement statement, Connection con) throws SQLException {
    	
    	//declare variables
    	int member_id, flight_id, checkin_bags;
    	float total_cost;
    	String checkin_date, seat_number, seat_class, food_order;
    	PreparedStatement stmt = null;
    	
    	Scanner scanner = new Scanner(System.in);
    	int choice;
    	
    	System.out.println("\nOptions:");
        System.out.println("1. Book a New Flight");
        System.out.println("2. Update Flight Booking");
        System.out.println("3: Cancel Flight Booking");
        System.out.println("0. Return to Previous Menu");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        
        do {
        	
        	switch (choice) {
        		case 2: { //update booking
        			int booking_id;
        			
        			System.out.println("Enter Booking ID: ");
        	    	member_id = scanner.nextInt();
        	    	scanner.nextLine();
        			
        	    	// FILL IN !!
        			String updateBooking = "UPDATE bookings SET ___ WHERE booking_id = ?";
        			
        			stmt = con.prepareStatement(updateBooking);
        			break;
        		}
        	}
        	
        } while (choice != 0);
        
        scanner.close();
    }*/
    
    //passenger functions
    
    
    
    //employee functions
    
    public boolean createEmployee(String last_name, String first_name, String job_title, String hire_date, float salary, String department) throws SQLException {
    	String insertEmployee = "INSERT INTO employees (last_name, first_name, job_title, salary, hire_date, department) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = connection.prepareStatement(insertEmployee);
		
	stmt.setString(1, last_name);
        stmt.setString(2, first_name);
        stmt.setString(3, job_title);
        stmt.setString(4, hire_date);
        stmt.setDouble(5, salary);
        stmt.setString(6, department);
        
        stmt.executeUpdate();

	Employee newEmployee = new Employee(employees.get(employees.size() - 1).getID() + 1);
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
    
    //flight functions
    
    public boolean createFlight(int gate_number, String destination, String origin, String departure, String arrival, int pilot_id, int copilot_id, int lead_attendant_id, int flight_attendant_id, double price) throws SQLException {
	String query = "insert into flights (gate_number, destination, origin, departure, arrival, pilot_id, copilot_id, lead_attendant, flight_attendant) values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
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
        
        Flight newFlight = new Flight(flights.get(flights.size() - 1).getFlight_id() + 1, price);
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
        
        stmt.setInt(1, flightID);
        stmt.setInt(2, gate_number);
        stmt.executeUpdate();
        return true;
    }
	
    //booking functions
    
    public boolean createBooking (int member_id, int flight_id,
    		String checkin_date, String seat_number, String seat_class,
    		Float total_cost, String food_order, int checkin_bags) throws SQLException {
    	String query = "INSERT INTO bookings (member_id, flight_id, checkin_date, seat_number, class, total_cost, food_order, checkin_bags) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
    	 PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setInt(1, member_id);
        stmt.setInt(2, flight_id);
        stmt.setString(3, checkin_date);
        stmt.setString(4, seat_number);
        stmt.setString(5, seat_class);
        stmt.setDouble(6, total_cost);
        stmt.setString(7, food_order);
        stmt.setInt(8, checkin_bags);
        
        stmt.executeUpdate();
        
        Booking newBooking = new Booking(bookings.get(bookings.size() - 1).getID() + 1);
        bookings.add(newBooking);
        
        return true;
    }

    public boolean deleteBooking(int booking_id, int member_id) throws SQLException {
	String cancelBooking = "DELETE FROM bookings WHERE booking_id = ? AND member_id = ?";
	     
	PreparedStatement stmt = connection.prepareStatement(cancelBooking);
	     
	stmt.setInt(1, booking_id);
	stmt.setInt(2, member_id);
	     
	stmt.executeUpdate();
	return true;
    }

    public boolean viewBooking(int booking_ID) throws SQLException {
        // define the query needed to get the flight to delete, '?' is a placeholder
        String query = "select b.ref_id as booking_no, flight_id, p.passenger_id, last_name, first_name, passport_number, birthdate, contact_no, email_address, vip_status from bookings b join passengers p on b.passenger_id = p.passenger_id where booking_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);

	stmt.setInt(1, booking_ID);
        stmt.executeUpdate();
        return true;
    }

    public boolean viewBooking() throws SQLException {
        // define the query needed to get the flight to delete, '?' is a placeholder
        String query = "select b.ref_id as booking_no, flight_id, p.passenger_id, last_name, first_name, passport_number, birthdate, contact_no, email_address, vip_status from bookings b join passengers p on b.passenger_id = p.passenger_id";
        
        PreparedStatement stmt = connection.prepareStatement(query);

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
