package sample;

public class Manager {
    int empID;
    String empName;
    int priorityLevel;
    int cost = 0;
    public Manager(int empID, String empName, int priorityLevel, int cost)
    {
        this.empID = empID;
        this.empName = empName;
        this.priorityLevel = priorityLevel;
        this.cost = cost;
    }
}
