/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Booking {
    private int ref_id;
    private int passenger_id;
    private int flight_id;
    private String checkin_date;
    private String seat_no;
    private String seat_class;
    private double total_cost;
    private String food_order;
    private int total_checkin_bags;

    // constructor
    public Booking(int ref_id) {
        this.ref_id = ref_id;
    }

    // getters
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

    // setters

    public void setID(int ref_id) {
        this.ref_id = ref_id;
    }

    public void setPassenger_id(int passenger_id) {
        this.passenger_id = passenger_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public void setCheckin_date(String checkin_date) {
        this.checkin_date = checkin_date;
    }

    public void setSeat_no(String seat_no) {
        this.seat_no = seat_no;
    }

    public void setSeat_class(String seat_class) {
        this.seat_class = seat_class;
    }

    public void setTotal_cost(double total_cost) {
        this.total_cost = total_cost;
    }

    public void setFood_order(String food_order) {
        this.food_order = food_order;
    }

    public void setTotal_checkin_bags(int total_checkin_bags) {
        this.total_checkin_bags = total_checkin_bags;
    }
}
