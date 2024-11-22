/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group3db;

/**
 *
 * @author Admin
 */
public class Passenger {
    private int passenger_id;
    
    public Passenger(int passenger_id) {
        this.passenger_id = passenger_id;
    }
    
    public int getID(){
        return this.passenger_id;
    }
    
    public void setID(int passenger_id){
        this.passenger_id = passenger_id;
    }
}
