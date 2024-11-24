public class FlightOccupancyReport {
    private int flight_id;
    private String origin;
    private String destination;
    private int numPassenger;

    public FlightOccupancyReport(int flight_id, String origin, String destination, int numPassenger) {
        this.flight_id = flight_id;
        this.origin = origin;
        this.destination = destination;
        this.numPassenger = numPassenger;
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
