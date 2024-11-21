public class Flight {
	
    private int flightID;
    private String gateNumber;
    private String destination;
    private String origin;
    private String departureTime;
    private String arrivalTime;
    private int pilotID;
    private int copilotID;
    private int leadAttendantID;
    private int flightAttendantID;


    // Constructor

    public Flight(int flightID, String gateNumber, String destination, String origin, String departureTime,
                  String arrivalTime, int pilotID, int copilotID, int leadAttendantID, int flightAttendantID) {
        this.flightID = flightID;
        this.gateNumber = gateNumber;
        this.destination = destination;
        this.origin = origin;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.pilotID = pilotID;
        this.copilotID = copilotID;
        this.leadAttendantID = leadAttendantID;
        this.flightAttendantID = flightAttendantID;
    }


    // GETTERS //

    public int getFlightID() {
        return flightID;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public String getDestination() {
        return destination;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public int getPilotID() {
        return pilotID;
    }

    public int getCoPilotID() {
        return copilotID;
    }

    public int getLeadAttendantID() {
        return leadAttendantID;
    }

    public int getFlightAttendantID() {
        return flightAttendantID;
    }

    // SETTERS //

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setPilotID(int pilotID) {
        this.pilotID = pilotID;
    }

    public void setCoPilotID(int coPilotID) {
        this.copilotID = coPilotID;
    }

    public void setLeadAttendantID(int leadAttendantID) {
        this.leadAttendantID = leadAttendantID;
    }

    public void setFlightAttendantID(int flightAttendantID) {
        this.flightAttendantID = flightAttendantID;
    }
}