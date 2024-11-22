/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Flight {
    private int flight_id;
    private int gate_number;
    private String destination;
    private String origin;
    private String departure;
    private String arrival;
    private int pilot_id;
    private int copilot_id;
    private int lead_attendant;
    private int flight_attendant;
    private ArrayList<Seat> seats;
    private int seatAmount = 300;
    private double price;
    
    public Flight(int flight_id, double price) {
        this.flight_id = flight_id;
        this.price = price;
        this.seats = new ArrayList<>();
        for(int i = 1; i <= 30; i++){
            Seat newSeat = new Economy("A" + i, price);
            seats.add(newSeat);
        }
        for(int i = 1; i <= 30; i++){
            Seat newSeat = new Economy("B" + i, price);
            seats.add(newSeat);
        }
        for(int i = 1; i <= 30; i++){
            Seat newSeat = new Economy("C" + i, price);
            seats.add(newSeat);
        }
        for(int i = 1; i <= 30; i++){
            Seat newSeat = new Economy("D" + i, price);
            seats.add(newSeat);
        }
        for(int i = 1; i <= 30; i++){
            Seat newSeat = new Economy("E" + i, price);
            seats.add(newSeat);
        }
        for(int i = 1; i <= 30; i++){
            Seat newSeat = new Economy("F" + i, price);
            seats.add(newSeat);
        }
        for(int i = 31; i <= 40; i++){
            Seat newSeat = new Business("A" + i, price);
            seats.add(newSeat);
        }
        for(int i = 31; i <= 40; i++){
            Seat newSeat = new Business("B" + i, price);
            seats.add(newSeat);
        }
        for(int i = 31; i <= 40; i++){
            Seat newSeat = new Business("C" + i, price);
            seats.add(newSeat);
        }
        for(int i = 31; i <= 40; i++){
            Seat newSeat = new Business("D" + i, price);
            seats.add(newSeat);
        }
        for(int i = 31; i <= 40; i++){
            Seat newSeat = new Business("E" + i, price);
            seats.add(newSeat);
        }
        for(int i = 31; i <= 40; i++){
            Seat newSeat = new Business("F" + i, price);
            seats.add(newSeat);
        }
        for(int i = 41; i <= 50; i++){
            Seat newSeat = new First("A" + i, price);
            seats.add(newSeat);
        }
        for(int i = 41; i <= 50; i++){
            Seat newSeat = new First("B" + i, price);
            seats.add(newSeat);
        }
        for(int i = 41; i <= 50; i++){
            Seat newSeat = new First("C" + i, price);
            seats.add(newSeat);
        }
        for(int i = 41; i <= 50; i++){
            Seat newSeat = new First("D" + i, price);
            seats.add(newSeat);
        }
        for(int i = 41; i <= 50; i++){
            Seat newSeat = new First("E" + i, price);
            seats.add(newSeat);
        }
        for(int i = 41; i <= 50; i++){
            Seat newSeat = new First("F" + i, price);
            seats.add(newSeat);
        }
    }
    
    public boolean isSeatOccupied(String seatName) {
        for(int i = 0; i < seatAmount; i++){
            if(seatName.equals(seats.get(i).getName()))
                return seats.get(i).isOccupied();
        }
        return true;
    }
    
    public boolean occupySeat(String seatName) {
        for(int i = 0; i < seatAmount; i++){
            if(seatName.equals(seats.get(i).getName())){
                seats.get(i).occupySeat();
                return true;
            }
        }
        return false;
    }
    
    public boolean unoccupySeat(String seatName) {
        for(int i = 0; i < seatAmount; i++){
            if(seatName.equals(seats.get(i).getName())){
                seats.get(i).unoccupySeat();
                return true;
            }
        }
        return false;
    }
    
    public double getSeatPrice(String seatName) {
        for(int i = 0; i < seatAmount; i++){
            if(seatName.equals(seats.get(i).getName()))
                return seats.get(i).getPrice();
        }
        return -1;
    }
    
    public int getFlight_id(){
        return this.flight_id;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getCopilot_id() {
        return copilot_id;
    }

    public int getFlight_attendant() {
        return flight_attendant;
    }

    public int getGate_number() {
        return gate_number;
    }

    public int getLead_attendant() {
        return lead_attendant;
    }

    public int getPilot_id() {
        return pilot_id;
    }

    public String getArrival() {
        return arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public void setCopilot_id(int copilot_id) {
        this.copilot_id = copilot_id;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setFlight_attendant(int flight_attendant) {
        this.flight_attendant = flight_attendant;
    }

    public void setGate_number(int gate_number) {
        this.gate_number = gate_number;
    }

    public void setLead_attendant(int lead_attendant) {
        this.lead_attendant = lead_attendant;
    }

    public void setPilot_id(int pilot_id) {
        this.pilot_id = pilot_id;
    }

}
