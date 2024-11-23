public class RevenueReport {
    private int numFlights;
    private double totalRevenue;

    public RevenueReport(int numFlights, double totalRevenue) {
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
