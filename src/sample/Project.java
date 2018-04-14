package sample;

import java.util.Date;

public class Project {
    public static int num_projects=1;
    Date startDate;
    Date endDate;
    int projID;
    Task[] tasks;
    public Project(Date startDate, Date endDate, int projectID, Task[] tasks)
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.projID = projectID;
        this.tasks = tasks;
        num_projects++;
    }
    //Overloaded constructor to support optional list of tasks parameter
    Project(Date startDate, Date endDate,int projectID)
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.projID = projectID;
        this.tasks = null;
        num_projects++;
    }
}
