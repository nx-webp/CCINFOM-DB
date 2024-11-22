/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group3db;

/**
 *
 * @author Admin
 */
public class Booking {
    private int ref_id;
    
    public Booking(int ref_id) {
        this.ref_id = ref_id;
    }
    
    public int getID() {
        return this.ref_id;
    }
    
    public void setID(int ref_id) {
        this.ref_id = ref_id;
    }
}
