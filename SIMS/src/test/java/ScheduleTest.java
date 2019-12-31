import com.lwb.dao.LabClassScheduleDao;
import com.lwb.dao.LabCourseDao;
import com.lwb.dao.MsBoardDao;
import com.lwb.dao.TimeTableDao;
import com.lwb.pojo.LabClassSchedule;
import com.lwb.pojo.LabCourse;
import com.lwb.pojo.TimeTable;
import com.lwb.service.ScheduleService;
import com.lwb.service.impl.ScheduleServiceImpl;
import com.lwb.util.ClassUtil;
import javafx.scene.media.VideoTrack;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.taglibs.standard.tag.common.sql.DataSourceUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ScheduleTest {
    private InputStream in;
    private SqlSession sqlSession;
    private LabClassScheduleDao lcsd;
    private TimeTableDao tabledao;
    private LabCourseDao labcoursedao;

    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        lcsd = sqlSession.getMapper(LabClassScheduleDao.class);
        tabledao = sqlSession.getMapper(TimeTableDao.class);
        labcoursedao = sqlSession.getMapper(LabCourseDao.class);
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
    public void testFindById(){
        LabClassSchedule labschedule = lcsd.findScheduleByLcnum("5003005X");
        TimeTable timetable = tabledao.findTableById(1);
        System.out.println(labschedule);
        System.out.println(timetable);



        Class<?> clazz = null;



        if(labschedule.getMonday() != 0){
            String str1 = ClassUtil.decimalToBinary(labschedule.getMonday());
            System.out.println("转换后的字符串:"+str1);
            for(int i = str1.length()-1,k=1 ; i >=0 ; i--,k++){
                if(str1.charAt(i) == '1'){  //该课程被安排在这一节
                    try {
                        clazz = Class.forName("com.lwb.pojo.TimeTable");
                        Method method = clazz.getMethod("getMonday" + k);
                        Method method1 = clazz.getMethod("setMonday" + k,String.class);
                        Object obj = method.invoke(timetable);
                        if(obj == null){
                            method1.invoke(timetable,labschedule.getLcname());
                            System.out.println("更新后的课表:");
                            System.out.println(timetable);

                        }else {
                            System.out.println("这节课已经被安排过啦" + ":i=" + i + " k=" + k);
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }  catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                }
            }

        }if(labschedule.getTuesday() != 0){

        }if(labschedule.getWednesday() != 0){

        }if(labschedule.getThursday() != 0){

        }if(labschedule.getFriday() != 0){

        }

    }



    @Test
    public void testdoScheduleToTimetable(){
        LabClassSchedule labschedule = lcsd.findScheduleByLcnum("5003005X");
        System.out.println(labschedule);
        TimeTable timeTable = tabledao.findTableById(1);
        ScheduleService scheduleService = new ScheduleServiceImpl();
        System.out.println("更新前:");
        System.out.println(timeTable);
        scheduleService.doScheduleToTimetable(labschedule);


    }



    @Test
    public void testLabCourse(){
        LabCourse labCourse = labcoursedao.findLabCourseByCnum("5003005");
        System.out.println(labCourse);

    }






}
