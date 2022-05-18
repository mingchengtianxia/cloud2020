package concert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={ConcertConfig.class})
public class ConcertTest {

    @Autowired
    private Audience audience;

    @Autowired
    private Performance performance;

    @Test
    public void test(){
        audience.test();
    }

    @Test
    public void testP(){
        performance.perform();
    }

    public static void test12(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Performance testDao = applicationContext.getBean("performanceImpl", PerformanceImpl.class);
        testDao.perform();
    }
}
