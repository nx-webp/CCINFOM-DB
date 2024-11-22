/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
public class Seat {
    private String name;
    private boolean occupied;
    private double price;
    
    public Seat(String name, double price){
        this.name = name;
        occupied = false;
        this.price = price;
    }
    
    public void occupySeat(){
        occupied = true;
    }
    
    public void unoccupySeat(){
        occupied = false;
    }
    
    public String getName(){
        return this.name;
    }
    
    public boolean isOccupied(){
        return occupied;
    }
    
    public double getPrice() {
        return this.price;
    }
}
