import com.lwb.dao.StudentDao;
import com.lwb.pojo.Student;
import com.lwb.pojo.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class StuTest {
    private InputStream in;
    private SqlSession sqlSession;
    private StudentDao studao;

    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        studao = sqlSession.getMapper(StudentDao.class);
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

        List<Student> students = studao.findAll();
        for(Student s :students){
            System.out.println(s);
        }

    }

    /**
     * 获取所有学生信息,包括选课信息
     */
    @Test
    public void testfindAllWithCourse(){
        List<Student> students = studao.findAllWithCourseAndTea();
        for(Student s :students){
            System.out.println(s);
            System.out.println(s.getCourses());
        }
    }

    @Test
    public void testfindWithCourseById(){
       Student stu = studao.findWithCourseById("201716040223");
        System.out.println(stu);
        System.out.println(stu.getCourses());

    }


    @Test
    public void testUpdate(){
        int index = studao.ChStuInfo("201716040223","韩旭","男","13253376824","天津市大港区",new Date());
        System.out.println(index);

    }

    @Test
    public void testfindWithCourseAndGradeById(){
        Student student = studao.findWithCourseAndGradeById("201716040224");
        System.out.println(student);
        System.out.println(student.getCourses());
        System.out.println(student.getCourses().get(2).getCgrade());
    }



    @Test
    public void testupdate() throws ParseException {
        Student student = new Student();
        student.setSnum("201716040224");
        student.setSsex("男");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1998-02-11");
        student.setSbirthday(date);
        int index = studao.updateStuInfo(student);
        System.out.println(index);
    }


}
