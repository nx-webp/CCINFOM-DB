import java.util.ArrayList;

public class ViewFlight {
    // flight details
    private int flight_id;
    private int gate_number;
    private String destination;
    private String origin;
    private String departure;
    private String arrival;
    private int pilot_id;
    private int copilot_id;
    private int lead_attendant;
    private int flight_attendant;

    // list of guests that booked
    private ArrayList<Passenger> guests;

    public ViewFlight(int flight_id, int gate_number, String destination, String origin, String departure,
                      String arrival, int pilot_id, int copilot_id, int lead_attendant, int flight_attendant,
                      ArrayList<Passenger> guests) {
        this.flight_id = flight_id;
        this.gate_number = gate_number;
        this.destination = destination;
        this.origin = origin;
        this.departure = departure;
        this.arrival = arrival;
        this.pilot_id = pilot_id;
        this.copilot_id = copilot_id;
        this.lead_attendant = lead_attendant;
        this.flight_attendant = flight_attendant;

        this.guests = new ArrayList<>(guests);
    }

    public int getFlight_id(){
        return this.flight_id;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getCopilot_id() {
        return copilot_id;
    }

    public int getFlight_attendant() {
        return flight_attendant;
    }

    public int getGate_number() {
        return gate_number;
    }

    public int getLead_attendant() {
        return lead_attendant;
    }

    public int getPilot_id() {
        return pilot_id;
    }

    public String getArrival() {
        return arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public ArrayList<Passenger> getGuests() {
        return guests;
    }

}
