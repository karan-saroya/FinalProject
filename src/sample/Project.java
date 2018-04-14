package sample;

import java.util.Date;

public class Project {
    Date startDate;
    Date endDate;
    String modelUsed;
    Task[] tasks;
    public Project(Date startDate, Date endDate, String modelUsed, Task[] tasks)
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.modelUsed = modelUsed;
        this.tasks = tasks;
    }
    //Overloaded constructor to support optional list of tasks parameter
    Project(Date startDate, Date endDate, String modelUsed)
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.modelUsed = modelUsed;
        this.tasks = null;
    }
}
