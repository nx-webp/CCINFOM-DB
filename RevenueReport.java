public class RevenueReport {
    private int month;
    private int numFlights;
    private double totalRevenue;

    public RevenueReport(int month, int numFlights, double totalRevenue) {
        this.month = month;
        this.numFlights = numFlights;
        this.totalRevenue = totalRevenue;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public int getNumFlights() {
        return numFlights;
    }
}
