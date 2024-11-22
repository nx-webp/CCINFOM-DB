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
        		case 1: { //book a new flight
        	    	
        	    	//initialize variables by asking for user input
        	    	System.out.println("Enter Member ID: ");
        	    	member_id = scanner.nextInt();
        	    	scanner.nextLine();
        	    	
        	    	System.out.println("Enter Flight ID: ");
        	    	flight_id = scanner.nextInt();
        	    	scanner.nextLine();
        	    	
        	    	System.out.println("Enter Check-In Date (YYYY-MM-DD): ");
        	    	checkin_date = scanner.nextLine();
        	    	
        	    	System.out.println("Enter Desired Seat Number: ");
        	    	seat_number = scanner.nextLine();
        	    	
        	    	System.out.println("Enter Desired Seat Class: ");
        	    	seat_class = scanner.nextLine();
        	    	
        	    	//total cost
        	    	
        	    	System.out.println("Choose your food order: ");
        	    	food_order = scanner.nextLine();
        	    	
        	    	System.out.println("Number of Bags to Check-In: ");
        	    	checkin_bags = scanner.nextInt();
        	    	scanner.nextLine();
        	    	
        	    	String newBooking = "INSERT INTO bookings (member_id, flight_id, checkin_date, seat_number, class, total_cost, food_order, checkin_bags) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        	        
        	        stmt = con.prepareStatement(newBooking);
        	        
        	        stmt.setInt(1, member_id);
		            stmt.setInt(2, flight_id);
		            stmt.setString(3, checkin_date);
		            stmt.setString(4, seat_number);
		            stmt.setString(5, seat_class);
		            stmt.setDouble(6, total_cost);
		            stmt.setString(7, food_order);
		            stmt.setInt(8, checkin_bags);
        	        
        	        stmt.executeUpdate();
        	        System.out.println("Data inserted successfully.");
        			break;
        		}
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
        		case 3: { //cancel booking
        			int booking_id;
        			
        			System.out.println("Enter Booking ID: ");
        	    	booking_id = scanner.nextInt();
        	    	scanner.nextLine();
        	    	
        	    	System.out.println("Enter Member ID: "); //for verification
        	    	member_id = scanner.nextInt();
        	    	scanner.nextLine();
        			
        			String cancelBooking = "DELETE FROM bookings WHERE booking_id = ? AND member_id = ?";
        			
        			stmt = con.prepareStatement(cancelBooking);
        			
        			stmt.setInt(1, booking_id);
        			stmt.setInt(2, member_id);
        			
        			stmt = con.prepareStatement(cancelBooking);
        			break;
        		}
        	}
        	
        } while (choice != 0);
        
        scanner.close();
    }*/

	 public boolean cancelBooking(int booking_id, int member_id) throws SQLException {
	     // define the query needed to get the flight to delete, '?' is a placeholder
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
