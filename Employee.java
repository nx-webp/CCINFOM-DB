/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Employee {
    private int employee_id;
    private String last_name;
    private String first_name;
    private String job_title;
    private String hire_date;
    private double salary;
    private String department;

    // constructor
    public Employee(int employee_id) {
        this.employee_id = employee_id;
    }

    // getters
    public int getID() {
        return this.employee_id;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getJob_title() {
        return job_title;
    }

    public String getHire_date() {
        return hire_date;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    // setters
    public void setID(int employee_id) {
        this.employee_id = employee_id;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
