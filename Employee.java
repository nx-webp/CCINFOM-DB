/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group3db;

/**
 *
 * @author Admin
 */
public class Employee {
    private int employee_id;
    
    public Employee(int employee_id) {
        this.employee_id = employee_id;
    }
    
    public int getID() {
        return this.employee_id;
    }
    
    public void setID(int employee_id) {
        this.employee_id = employee_id;
    }
}
