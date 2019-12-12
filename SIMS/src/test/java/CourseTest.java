import com.lwb.dao.CourseDao;
import com.lwb.pojo.Course;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.util.List;


public class CourseTest {
    private InputStream in;
    private SqlSession sqlSession;
    private CourseDao coursedao;

    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        coursedao = sqlSession.getMapper(CourseDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy()throws Exception{
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testfindAllStu(){

        List<Course> courses = coursedao.findAll();
        for(Course c :courses){
            System.out.println(c);
        }

    }



    @Test
    public void testselAllCoursByStuId(){
        List<Course> courses = coursedao.selAllCoursByStuId("201716040224");
        for(Course c :courses){
            System.out.println(c);
        }
    }

}
