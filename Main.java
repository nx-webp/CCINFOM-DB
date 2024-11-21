import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
    	
    	try (Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement()) {
    	
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
	                				/* reports to generate
	                				  >> can be in menu form rin naman*/
	                				break;
	                			}
	                			case 0: {
	                				break;
	                			}
	                			default:
	                				System.out.println("Invalid Input.");
	                                break;
	                		}
	            		} while (nMenu != 0);
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
	            		} while (nMenu != 0);
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
    	
    	System.out.println("\nOptions:");
        System.out.println("1. Book a New Flight");
        System.out.println("2. Update Flight Booking");
        System.out.println("3: Cancel Flight Booking")
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
    
    /*private static void insertData(Statement statement) throws SQLException {
        String insertSQL = "INSERT INTO flights (username, email) VALUES ('john', 'john@example.com')";
        statement.executeUpdate(insertSQL);
        System.out.println("Data inserted successfully.");
    }

    private static void updateData(Statement statement) throws SQLException {
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
