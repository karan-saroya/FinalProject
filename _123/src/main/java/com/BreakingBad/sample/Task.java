package com.BreakingBad.sample;



import java.util.Date;

public class Task {
    String name;
    int taskID;
    Date startDate, endDate;
    int projID;
    public Task(String name, int taskID, Date startDate, Date endDate, int projectID)
    {
        this.name = name;
        this.taskID = taskID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projID =  projectID;
    }
    public String getName()
    {
        return this.name;
    }

    @Override
    public String toString() {
        return name + ", ID = " + taskID;
    }
}
