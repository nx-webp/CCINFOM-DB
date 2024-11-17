public class Employee {
    private int employeeID;
    private String lastName;
    private String firstName;
    private String jobTitle;
    private String hireDate;
    private double salary;
    private String department;

    // Constructor
    public Employee(int employeeID, String lastName, String firstName, String jobTitle,
                    String hireDate, double salary, String department) {
        this.employeeID = employeeID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.jobTitle = jobTitle;
        this.hireDate = hireDate;
        this.salary = salary;
        this.department = department; 
    }


    // GETTERS //

    public int getEmployeeID() {
        return employeeID;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getHireDate() {
        return hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    // SETTERS //

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}