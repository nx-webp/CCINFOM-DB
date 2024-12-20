/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */

public class Passenger {
    private int passenger_id;
    private String passport_number;
    private String last_name;
    private String first_name;
    private String birthdate;
    private long contact_no; 
    private String email_address;
    private String vip_status;

    // constructor
    public Passenger(int passenger_id, String passport_number, String last_name, String first_name,
                     String birthdate, long contact_no, String email_address, String vip_status) {
        this.passenger_id = passenger_id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.birthdate = birthdate;
        this.contact_no = contact_no;
        this.email_address = email_address;
        this.vip_status = vip_status;
    }

    // getters
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

    public long getContact_no() {
        return contact_no;
    }

    public String getEmail_address() {
        return email_address;
    }

    public String getVip_status() {
        return vip_status;
    }

}
