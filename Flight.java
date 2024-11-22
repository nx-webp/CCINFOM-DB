/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group3db;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Flight {
    private int flight_id;
    private ArrayList<Seat> seats;
    private int seatAmount = 300;
    private double price;
    
    public Flight(int flight_id, double price) {
        this.flight_id = flight_id;
        this.price = price;
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
}
