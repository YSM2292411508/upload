

import com.yuan.Service.AllService;

import com.yuan.Tool.Data;
import com.yuan.Tool.FileName;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void test1(){
        String config="applicationContext.xml";
        ApplicationContext ctx=new ClassPathXmlApplicationContext(config);
        AllService allService= (AllService) ctx.getBean("select");
        List<Data> data=allService.data();
        System.out.println(data);
    }

    @Test
    public void test2(){
       String time= FileName.GetFileName();
       System.out.println(time);
    }

    @Test
    public void test3() {
        Data data = new Data();
        data.setTupian("生命");
        data.setWenjian("生命");
        data.setJieshao("生命");
        data.setLianjie("生命");
        data.setMingzi("生命");
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        AllService allService = (AllService) ctx.getBean("select");
        int row = allService.insertData(data);
    }
}
