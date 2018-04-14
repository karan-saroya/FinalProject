package sample;

import java.util.Date;

public class Task {
    String name;
    int taskID;
    Date startDate, endDate;
    public Task(String name, int taskID, Date startDate, Date endDate)
    {
        this.name = name;
        this.taskID = taskID;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    String getName()
    {
        return this.name;
    }

    @Override
    public String toString() {
        return name + ", ID = " + taskID;
    }
}
