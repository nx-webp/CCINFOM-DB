import java.util.ArrayList;

public class FlightOccupancyReport {
    private int flight_id;
    private String origin;
    private String destination;
    private int numPassenger;

    public FlightOccupancyReport(int flight_id, String year, String month,
                                 ArrayList<Flight> flights, ArrayList<Booking> bookings) {
        for(Flight flight : flights) {
            if(flight.getFlight_id() == flight_id) {

                origin = flight.getOrigin();
                destination = flight.getDestination();
                numPassenger = 0;

                for(Booking booking : bookings) {
                    if(booking.getFlight_id() == flight_id &&
                            booking.getCheckin_date().startsWith(year + "-" + month)) {
                        numPassenger++;
                    }
                }
            }

            //exit loop when flight is found
            break;
        }
    }

    public int getFlight_id() {
        return flight_id;
    }

    public String getDestination() {
        return destination;
    }

    public String getOrigin() {
        return origin;
    }

    public int getNumPassenger() {
        return numPassenger;
    }
}
