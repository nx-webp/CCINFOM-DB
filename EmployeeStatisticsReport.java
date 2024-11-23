public class EmployeeStatisticsReport {
    private int employee_id;
    private int numTasks;
    private double totalRevenue;

    public EmployeeStatisticsReport(int employee_id, int numTasks, double totalRevenue) {
        this.employee_id = employee_id;
        this.numTasks = numTasks;
        this.totalRevenue = totalRevenue;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public int getNumTasks() {
        return numTasks;
    }
}
