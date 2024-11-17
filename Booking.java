public class Booking {
    private String bookingRef;
    private int memberID;
    private int flightID;
    private String checkInDate;
    private String seatNumber;
    private String seatClass;
    private double totalCost;
    private String foodOrder;
    private int baggageCount;


    // Constructor

    public Booking(String bookingRef, int memberID, int flightID, String checkInDate, String seatNumber,
                   String seatClass, double totalCost, String foodOrder, int baggageCount) {
        this.bookingRef = bookingRef;
        this.memberID = memberID;
        this.flightID = flightID;
        this.checkInDate = checkInDate;
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.totalCost = totalCost;
        this.foodOrder = foodOrder;
        this.baggageCount = baggageCount;
    }


    // GETTERS //

    public String getBookingRef() {
        return bookingRef;
    }

    public int getMemberID() {
        return memberID;
    }

    public int getFlightID() {
        return flightID;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String getFoodOrder() {
        return foodOrder;
    }

    public int getBaggageCount() {
        return baggageCount;
    }


    // SETTERS //


    public void setBookingRef(String bookingRef) {
        this.bookingRef = bookingRef;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setFoodOrder(String foodOrder) {
        this.foodOrder = foodOrder;
    }

    public void setBaggageCount(int baggageCount) {
        this.baggageCount = baggageCount;
    }
}