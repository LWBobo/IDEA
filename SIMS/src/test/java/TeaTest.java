import com.lwb.dao.TeacherDao;
import com.lwb.pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.util.List;


public class TeaTest {
    private InputStream in;
    private SqlSession sqlSession;
    private TeacherDao teadao;

    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        teadao = sqlSession.getMapper(TeacherDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy()throws Exception{
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }


    /**
     * 获取所有教师信息,不带有所教授课程
     */
    @Test
    public void testfindAllStu(){

        List<Teacher> teachers = teadao.findAll();
        for(Teacher t :teachers){
            System.out.println(t);
        }

    }

    /**
     * 获取所有教师信息,带有所教授的课程
     */
    @Test
    public void testselAllCoursByTeaId(){
        List<Teacher> teachers = teadao.findAllTeaWitnCourse();
        for(Teacher t :teachers){
            System.out.println(t);
            System.out.println(t.getCourses());
        }
    }


    /**
     * 根据课程编号获取带有课程信息的教师信息
     */
    @Test
    public void testfindTeaWitnCourseById(){
        Teacher teachers = teadao.findTeaWitnCourseById("10010611");
        System.out.println(teachers);
        System.out.println(teachers.getCourses());
    }

    /**
     * 根据教师编号获取不带有课程信息的教师信息
     */
    @Test
    public void testfindTeaNoWitnCourseById(){
        Teacher teachers = teadao.findTeaNoWitnCourseById("10010611");
        System.out.println(teachers);
        System.out.println(teachers.getCourses());
    }
    @Test
    public void testfindTeaByCnum(){
        Teacher teachers = teadao.findTeaNoWitnCourseById("10010611");
        System.out.println(teachers);
        System.out.println(teachers.getCourses());
    }





}
