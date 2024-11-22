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

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Model model = new Model(connection);
            View view = new View(model);
        } catch(SQLException e) {
            System.out.println("Error in opening the database! Make sure username and password is correct.");
        }


    }
}
