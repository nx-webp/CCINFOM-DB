import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Model {
    private Connection connection; // refers to the connection to the SQL database
    private String currentView;

    public Model() {
        this.currentView = "Home";
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
        			String updateBooking = "UPDATE bookings SET XXX WHERE booking_id = ?";
        			
        			stmt = con.prepareStatement(updateBooking);
        			break;
        		}
        	}
        	
        } while (choice != 0);
        
        scanner.close();
    }*/
    
    public boolean newBooking (int member_id, int flight_id,
    		String checkin_date, String seat_number, String seat_class,
    		Float total_cost, String food_order, int checkin_bags) throws SQLException {
    	String newBooking = "INSERT INTO bookings (member_id, flight_id, checkin_date, seat_number, class, total_cost, food_order, checkin_bags) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
    	 PreparedStatement stmt = connection.prepareStatement(newBooking);
        
        stmt.setInt(1, member_id);
        stmt.setInt(2, flight_id);
        stmt.setString(3, checkin_date);
        stmt.setString(4, seat_number);
        stmt.setString(5, seat_class);
        stmt.setDouble(6, total_cost);
        stmt.setString(7, food_order);
        stmt.setInt(8, checkin_bags);
        
        stmt.executeUpdate();
        return true;
    }

	 public boolean cancelBooking(int booking_id, int member_id) throws SQLException {
		 String cancelBooking = "DELETE FROM bookings WHERE booking_id = ? AND member_id = ?";
	     
	     PreparedStatement stmt = connection.prepareStatement(cancelBooking);
	     
	     stmt.setInt(1, booking_id);
	     stmt.setInt(2, member_id);
	     
	     stmt.executeUpdate();
	     return true;
	 }

    public boolean deleteFlight(String flightID) throws SQLException {
        // define the query needed to get the flight to delete, '?' is a placeholder
        String query = "DELETE * FROM flights WHERE flightID = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);
        
        stmt.setString(1, flightID);
        stmt.executeUpdate();
        return true;
    }

    public boolean viewBooking(String bookingID) throws SQLException {
        // define the query needed to get the flight to delete, '?' is a placeholder
        String query = "select b.ref_id as booking_no, flight_id, p.passenger_id, last_name, first_name, passport_number, birthdate, contact_no, email_address, vip_status from bookings b join passengers p on b.passenger_id = p.passenger_id where booking_id = ?";
        
        PreparedStatement stmt = connection.prepareStatement(query);

	stmt.setString(1, booking_ID);
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
