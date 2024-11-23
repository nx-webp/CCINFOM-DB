public class PassengerReport {
    private String last_name;
    private String first_name;
    private String email_address;
    private String vip_status;
    private int totalBookings;

    public PassengerReport(String last_name, String first_name, String email_address, String vip_status, int totalBookings) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.email_address = email_address;
        this.vip_status = vip_status;
        this.totalBookings = totalBookings;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getVip_status() {
        return vip_status;
    }

    public String getEmail_address() {
        return email_address;
    }

    public int getTotalBookings() {
        return totalBookings;
    }

    public String getFirst_name() {
        return first_name;
    }
}
