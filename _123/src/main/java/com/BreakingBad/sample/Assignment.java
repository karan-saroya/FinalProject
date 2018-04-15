package sample;

public class Assignment {
    String task;
    String resource;
    int proj_id;
    double progress = 0;

    public Assignment(String task, String resource, int proj_id)
    {
        this.task = task;
        this.resource = resource;
        this.proj_id = proj_id;
    }
    String getResource()
    {
        return  this.resource;
    }
    String getTask()
    {
        return  this.getTask();
    }
    int getID(){return this.proj_id;};
    void setProgress(double progress)
    {
        this.progress = progress;
    }
    double getProgress()
    {
        return  this.progress;
    }
}
