import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

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
	                        System.out.println("1. Create New Employee Record");
	                        System.out.println("2. Create New Flight Record");
	                        System.out.println("3. Generate Reports")
	                        System.out.println("0. Previous Menu");
	                        System.out.print("Enter your choice: ");
	                		nMenu = scanner.nextInt();
	                		
	                		switch (nMenu)
	                		{
	                			case 1: {
	                				// employee records transaction
	                				break;
	                			}
	                			case 2: {
	                				// flight records transaction
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
	                				
	                				do
	                				{
	                					switch (reportChoice)
	                					{
	                						case 1: { //flight occupancy report
	                							//ask user for year and month
	                							int nYear;
	                							System.out.println("Enter year: ");
	                							nYear = scanner.nextInt();
	                							
	                							Statement stmt = con.createStatement();
	                							ResultSet rs = stmt.executeQuery
	                									("SELECT f.flight_ID, f.origin, f.designation, COUNT(b.booking_ref) FROM flights, booking WHERE year(b.checkin_date) =" + nYear);
	                							while(rs.next()) {
	                								int flight_id = rs.getInt("flight_id");
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
	                        System.out.println("1. Book a Flight");
	                        System.out.println("2. Create an Account");
	                        System.out.println("0. Exit");
	                        System.out.print("Enter your choice: ");
	                		nMenu = scanner.nextInt();
	                		
	                		switch (nMenu)
	                		{
	                			case 1: {
	                				flightBooking();
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
	        
    	} catch (SQLException e) {
            e.printStackTrace();
        }
        
        Model model = new Model();
        View view = new View();

        Controller controller = new Controller(view, model);
    }
    
    public static void flightBooking () {
    	
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
        		case 1: {
        			//create booking
        			break;
        		}
        		case 2: {
        			//update booking
        			break;
        		}
        		case 3: {
        			//delete booking
        			break;
        		}
        	}
        	
        } while (choice != 0);
    }
    
    private static void insertData(Statement statement) throws SQLException {
    	
    	//declare and get variable inputs
    	int flight_id, gate_no, pilot_id, copilot_id, lead_attendant_id, flight_attendant_id;
    	String destination, origin, departure_time, arrival_time;
    	
        String insertSQL = String.format("INSERT INTO flights VALUES (%d, %d, %s, %s, %s, %s, %d, %d, %d, %d",
        			flight_id, gate_no, destination, origin, departure_time, arrival_time,
        			pilot_id, copilot_id, lead_attendant_id, flight_attendant_id);
        statement.executeUpdate(insertSQL);
        System.out.println("Data inserted successfully.");
    }

    /*private static void updateData(Statement statement) throws SQLException {
        String updateSQL = "UPDATE flights SET email = 'newemail@example.com' WHERE username = 'john'";
        statement.executeUpdate(updateSQL);
        System.out.println("Data updated successfully.");
    }

    private static void deleteData(Statement statement) throws SQLException {
        String deleteSQL = "DELETE FROM flights WHERE flight_id = ";
        statement.executeUpdate(deleteSQL);
        System.out.println("Data deleted successfully.");
    }*/
}
