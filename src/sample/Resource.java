package sample;

public class Resource {
    int empID;
    int cost;
    public Resource(int empID, int cost)
    {
        this.empID = empID;
        this.cost = cost;
    }
    int getEmpID()
    {
        return  this.empID;
    }
}
