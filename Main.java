import java.util.Scanner;
import java.sql.*;

/* NOTES/COMMENTS:

 	>> need to edit/improve menus (exiting/returning to previous pages need a better system)
 	>> menus can have different functions to be more effective ^^
 	>> still need to test functions !!
 	>> double check where input buffer clearance is needed
 	
 	>> will we need input error handling / user verifications (e.g. canceling a flight, booking id
 	   should match with the passenger's member id - when entered and in the records)
   	   for everything or should we assume values entered always meet the necessary parameters?
 	   
 	>> flight booking: any ideas how we/the user can tell if a flight's seat is already booked?
 	>> can we make drop-down lists for ENUM values (e.g. flight class, passenger status, etc.)
 	>> how to compute for total cost of a booking T-T
*/

public class Main {

    public static void main(String[] args) {
    	
    	/* Database connection parameters:
    	 		>> whoever will present during the demo, please input values
    	 		into URL, username and password :> - this will link java to our
    	 		SQL schema which contains our tables ^^ (configure with the JDBC)
    	*/
    	
        String url = "";
        String username = "root";
        String password = "";
    	
    	try (Connection con = DriverManager.getConnection(url, username, password);
                Statement statement = con.createStatement()) {
    	
	    	Scanner scanner = new Scanner(System.in);
	        int choice;
	
	        // Display menu options
	        do {
	            System.out.println("\nOptions:");
	            System.out.println("1. ADMIN MENU");
	            System.out.println("2. PASSENGER MENU");
	            System.out.println("0. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();
	            
	            switch(choice)
	            {
	            	case 1: { // ADMIN TRANSACTIONS
	            		int nMenu;
	            		
	            		do {
	            			System.out.println("\nOptions:");
	                        System.out.println("1. Edit Employee Records");
	                        System.out.println("2. Edit Flight Records");
	                        System.out.println("3. Generate Reports");
	                        System.out.println("0. Previous Menu");
	                        System.out.print("Enter your choice: ");
	                		nMenu = scanner.nextInt();
	                		scanner.nextLine();
	                		
	                		switch (nMenu)
	                		{
	                			case 1: {
	                				// employee records transaction
	                				break;
	                			}
	                			case 2: {
	                				int flightMenu;
	                				
	                				System.out.println("\nOptions:");
	    	                        System.out.println("1. Create New Flight Record");
	    	                        System.out.println("2. Edit Existing Flight Records");
	    	                        System.out.println("3. Delete a Flight Record");
	    	                        System.out.println("0. Previous Menu");
	    	                        System.out.print("Enter your choice: ");
	    	                        flightMenu
	    	                        
	                				break;
	                			}
	                			case 3: {
	                				int reportChoice;
	                				
	                				System.out.println("\nOptions:");
	                				System.out.println("1: Flight Occupancy Report");
	                				System.out.println("2: Revenue Report");
	                				System.out.println("3: Passenger Report");
	                				System.out.println("4: Employee Statistics Report");
	                				System.out.println("0: Return to Previous Menu");
	                				reportChoice = scanner.nextInt();
	                				scanner.nextLine(); //clear input buffer
	                				
	                				do
	                				{
	                					switch (reportChoice)
	                					{
	                						case 1: { //flight occupancy report
	                							//ask user for year and month
	                							int nYear;
	                							System.out.println("Enter year: ");
	                							nYear = scanner.nextInt();
	                							scanner.nextLine();
	                							
	                							int sMonth;
	                							System.out.println("Enter month: (INT) ");
	                							sMonth = scanner.nextInt();
	                							scanner.nextLine();
	                							
	                							String query = "SELECT f.flight_ID, f.origin, f.designation, COUNT(b.booking_ref) FROM flights f JOIN bookings b ON f.flight_id = b.flight_id WHERE year(b.checkin_date) = ? AND month(b.checkin_date) = ?";
	                							
	                							PreparedStatement myStmt = con.prepareStatement(query);
	                							
	                							myStmt.setInt(1, nYear); 
	                							myStmt.setInt(2, sMonth);
	                							
	                							ResultSet rs= myStmt.executeQuery(); 
	               
	                							while (rs.next()) {
	                								int flightId = rs.getInt("flight_id");
	                							    String origin = rs.getString("origin");
	                							    String destination = rs.getString("destination");
	                							    int bookingCount = rs.getInt(4); // Column index 4 for COUNT(b.booking_ref)
	                							    System.out.println("Flight ID: " + flightId + ", Origin: " + origin + 
	                							                       ", Destination: " + destination + ", Bookings: " + bookingCount);
	                							}
	                							break;
	                						}
	                						case 2: {
	                							break;
	                						}
	                						case 3 : {
	                							break;
	                						}
	                						case 4: {
	                							Statement stmt = con.createStatement();
	                							ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
	                							while(rs.next()) {
	                								int employeeID = rs.getInt("employee_ID");
	                								String lastName = rs.getString("last_name");
	                								String firstName = rs.getString("first_name");
	                								System.out.println("ID: " + employeeID + ", Name: " + firstName + " " + lastName);
	                							} break;
	                						}
	                						case 0: {
	                							break;
	                						}
	                						default:
	                							System.out.println("Invalid Input.");
	                					}
	                				} while (reportChoice); //while reportChoice is TRUE
	                				
	                				// syntax error on menu exits, find better solution
	                				break;
	                			}
	                			case 0: {
	                				break;
	                			}
	                			default:
	                				System.out.println("Invalid Input.");
	                                break;
	                		}
	            		} while (nMenu); // while nMenu is TRUE
	            		break;
	            	}
	            	case 2: { // PASSENGER TRANSACTIONS
	            		int nMenu;
	            		
	            		do {
	            			System.out.println("\nOptions:");
	                        System.out.println("1. Flight Booking");
	                        System.out.println("2. Manage your Account");
	                        System.out.println("0. Exit");
	                        System.out.print("Enter your choice: ");
	                		nMenu = scanner.nextInt();
	                		
	                		switch (nMenu)
	                		{
	                			case 1: {
	                				flightBooking(statement, con);
	                				break;
	                			}
	                			case 2: {
	                				// account creation
	                				break;
	                			}
	                			case 0: {
	                				break;
	                			}
	                			default:
	                				System.out.println("Invalid Input.");
	                                break;
	                		}
	            		} while (nMenu);
	            		break;
	            	}
	            	case 0: {
	            		System.out.println("Exiting program..");
	            		break;
	            	}
	            	default: {
	            		System.out.println("Invalid input.");
	            		break;
	            	}
	            }
	        } while (choice != 0);
	        
	        scanner.close();
	        
    	} catch (SQLException e) {
            e.printStackTrace();
        }
        
        Model model = new Model();
        View view = new View();

        Controller controller = new Controller(view, model);
    }
    
    public static void flightBooking (Statement statement, Connection con) throws SQLException {
    	
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
    }
}
