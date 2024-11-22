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
    private String last_name;
    private String first_name;
    private String birthdate;
    private int contact_no;
    private String email_address;
    private String vip_status;

    // constructor
    public Passenger(int passenger_id) {
        this.passenger_id = passenger_id;
    }

    // getters
    public int getID(){
        return this.passenger_id;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
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

    // setters
    public void setID(int passenger_id){
        this.passenger_id = passenger_id;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setContact_no(int contact_no) {
        this.contact_no = contact_no;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public void setVip_status(String vip_status) {
        this.vip_status = vip_status;
    }

}
