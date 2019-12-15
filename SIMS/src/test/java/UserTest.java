import com.lwb.dao.StudentDao;
import com.lwb.dao.TeacherDao;
import com.lwb.dao.UsersDao;
import com.lwb.pojo.Student;
import com.lwb.pojo.Teacher;
import com.lwb.pojo.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class UserTest {

    private InputStream in;
    private SqlSession sqlSession;
    private TeacherDao teadao;
    private StudentDao studao;
    private UsersDao usersdao;

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
        studao = sqlSession.getMapper(StudentDao.class);
        usersdao = sqlSession.getMapper(UsersDao.class);
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
     * 测试用户登录
     */
    @Test
    public void testLogin(){
        Users u = usersdao.findUser("10010611","666666");
        System.out.println(u);
        Users student = studao.findWithCourseById(u.getUid());
        Users teacher = teadao.findTeaNoWitnCourseById(u.getUid());
        if(student != null){
            System.out.println("学生:" + ((Student) student).getSname() + "登录");
            System.out.println(student);
        }if(teacher != null){
        System.out.println("教师:"+ ((Teacher) teacher).getTname() + "登录");
            System.out.println(teacher);
        }

        }

    @Test
    public void testChangePwd(){
        int index = usersdao.changePwd("10010611","666666");
        if(index > 0){
            System.out.println("密码修改成功");
        }else{
            System.out.println("密码修改失败");
        }
    }
}
