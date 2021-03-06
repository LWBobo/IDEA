import com.lwb.dao.CourseDao;
import com.lwb.pojo.Course;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.VoiceStatus;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Test
    public void testselAllCourseWithStu(){
        List<Course> courses = coursedao.selAllCourseWithStu();
        for (Course c :courses){
            System.out.println(c);
            System.out.println(c.getStudents());
        }
    }

    /**
     * 根据课程号获取带有学生信息的课程信息
     */
    @Test
    public void testfindCourseWithStuBycId(){
        Course courses = coursedao.findCourseWithStuBycId("5003001");
        System.out.println(courses);
        System.out.println(courses.getStudents());
    }

    /**
     * 获取所有带有教师信息的课程信息
     */
    @Test
    public void testfindAllCourseWithTea(){
        List<Course> courses = coursedao.findAllCourseWithTea();
       for(Course c :courses){
           System.out.println(c);
           System.out.println(c.getTeacher());
       }
    }


    /**
     * 根据课程号获取带有教师信息的课程信息
     */
    @Test
    public void testfindAllCourseWithTeaByid(){
        Course courses = coursedao.findCourseWithTeaByid("5003003");
        System.out.println(courses);
        System.out.println(courses.getTeacher());
    }

    /**
     * 获取所有带有教师和学生信息的课程信息
     */
    @Test
    public void testfindAllCourseWithTeaAndStu(){
        List<Course> courses = coursedao.findAllCourseWithTeaAndStu();
        for(Course c :courses){
            System.out.println(c);
            System.out.println(c.getTeacher());
            System.out.println(c.getStudents());
        }
    }


    /**
     * 根据课程号获取所有带有教师和学生信息的课程信息
     */
    @Test
    public void testfindAllCourseWithTeaAndStuByCnum(){
        Course courses = coursedao.findAllCourseWithTeaAndStuByCnum("5003003");
            System.out.println(courses);
            System.out.println(courses.getTeacher());
            System.out.println(courses.getStudents());
    }

    /**
     * 根据学生号获取带有教师信息的课程信息
     */
    @Test
    public void testselAllCoursWithTeaByStuId(){
        List<Course> courses = coursedao.selAllCoursWithTeaByStuId("201716040224");
        for(Course c :courses){
            System.out.println(c);
            System.out.println(c.getTeacher());
        }
    }
    /**
     * 根据学生号获取带有教师信息的课程信息
     */
    @Test
    public void testselAllCoursWithTeaAndGradeByStuId(){
        List<Course> courses = coursedao.selAllCoursWithTeaAndGradeByStuId("201716040224");
        for(Course c :courses){
            System.out.println(c);
            System.out.println(c.getCgrade());
            System.out.println(c.getTeacher());
        }
    }


    /**
     * 测试更新函数
     * @throws ParseException
     */
    @Test
    public void testupdate() throws ParseException {
        Course course = new Course();
        course.setCnum("5003001");
        course.setCislabcourse(0);
        int index = coursedao.updateCourseInfo(course);
        System.out.println(index);



    }

    @Test
    public void testFindAllCourseWitnLabCourse(){
        List<Course> courses = coursedao.findAllCourseWithLabCourse();
        for(Course c :courses){
            System.out.println(c);
            if(c.getLabcourse() != null){
                System.out.println(c.getLabcourse());
            }
        }
    }



}
