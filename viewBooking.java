public class viewBooking {
    // booking info
    private int ref_id;
    private int passenger_id;
    private int flight_id;
    private String checkin_date;
    private String seat_no;
    private String seat_class;
    private double total_cost;
    private String food_order;
    private int total_checkin_bags;

    // passenger info
    private String passport_number;
    private String last_name;
    private String first_name;
    private String birthdate;
    private int contact_no;
    private String email_address;
    private String vip_status;

    public viewBooking(int ref_id, int passenger_id, int flight_id, String checkin_date, String seat_no,
                       String seat_class, double total_cost, String food_order, int total_checkin_bags,
                       String passport_number, String last_name, String first_name,
                       String birthdate, int contact_no, String email_address, String vip_status) {
        this.ref_id = ref_id;
        this.passenger_id = passenger_id;
        this.flight_id = flight_id;
        this.checkin_date = checkin_date;
        this.seat_no = seat_no;
        this.seat_class = seat_class;
        this.total_cost = total_cost;
        this.food_order = food_order;
        this.total_checkin_bags = total_checkin_bags;

        this.last_name = last_name;
        this.first_name = first_name;
        this.birthdate = birthdate;
        this.contact_no = contact_no;
        this.email_address = email_address;
        this.vip_status = vip_status;
    }

    public int getID() {
        return this.ref_id;
    }

    public int getPassenger_id() {
        return passenger_id;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public String getCheckin_date() {
        return checkin_date;
    }

    public String getSeat_no() {
        return seat_no;
    }

    public String getSeat_class() {
        return seat_class;
    }

    public double getTotal_cost() {
        return total_cost;
    }

    public String getFood_order() {
        return food_order;
    }

    public int getTotal_checkin_bags() {
        return total_checkin_bags;
    }

    public String getPassport_number() {
        return passport_number;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public int getContact_no() {
        return contact_no;
    }

    public String getEmail_address() {
        return email_address;
    }

    public String getVip_status() {
        return vip_status;
    }
}
