import org.junit.Assert;
import org.junit.Test;
import sample.Project;
import sample.Task;

import java.util.Date;

public class TestTask {
    @Test
    public void projectTest(){
       Task task = new Task("Task1", 1, new Date(), new Date(), 1);
        Assert.assertEquals("Task1", task.getName());
    }
}
