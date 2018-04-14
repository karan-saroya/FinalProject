package sample;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class ProjectPLanner {
    Task[] formulateTasks(Project proj)
    {
        Task[] tasks = {new Task("Requirement Specification", 1, new Date(), new Date()),
                        new Task("Design Specification", 1, new Date(), new Date()),
                        new Task("Implementation", 1, new Date(), new Date()),
                        new Task("Testing", 1, new Date(), new Date())};
        return tasks;
    }

    String[] generateSchedule(Task[] tasks)
    {
        ArrayList<String> sched = new ArrayList<>();
        for(Task task: tasks)
        {
            sched.add(task.getName());
        }
        return sched.toArray(new String[sched.size()]);
    }

    int estimateCost(Assignment assg[], Project[] prev)
    {
        return ((assg.length * 20) / prev.length > 5) ? (assg.length * 20) / prev.length : 5;
    }
}
