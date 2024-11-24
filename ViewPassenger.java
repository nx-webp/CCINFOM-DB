import java.util.ArrayList;

public class ViewPassenger {
    // passenger info
    private int passenger_id;
    private String passport_number;
    private String last_name;
    private String first_name;
    private String birthdate;
    private Long contact_no;
    private String email_address;
    private String vip_status;

    // list of bookings
    private ArrayList<Booking> bookings;

    public ViewPassenger(int passenger_id, String passport_number, String last_name, String first_name,
                         String birthdate, Long contact_no, String email_address, String vip_status,
                         ArrayList<Booking> bookings) {
        this.passenger_id = passenger_id;
        this.passport_number = passport_number;
        this.last_name = last_name;
        this.first_name = first_name;
        this.birthdate = birthdate;
        this.contact_no = contact_no;
        this.email_address = email_address;
        this.vip_status = vip_status;

        this.bookings = new ArrayList<>(bookings);
    }

    public int getID(){
        return this.passenger_id;
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

    public Long getContact_no() {
        return contact_no;
    }

    public String getEmail_address() {
        return email_address;
    }

    public String getVip_status() {
        return vip_status;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }
}
