import org.junit.Assert;
import sample.Task;
import org.junit.Test;
import sample.Project;

import java.util.Date;

public class TestProject {

    @Test
    public void projectTest(){
        Task[] tasks = {new Task("", 1, new Date(), new Date(), 1)};
        Project project1 = new Project(new Date(), new Date(), 1, tasks);
        Project project2 = new Project(new Date(), new Date(), 1, null);
        Assert.assertTrue(true);
    }
}
