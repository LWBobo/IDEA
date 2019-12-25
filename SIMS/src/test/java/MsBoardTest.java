import com.lwb.dao.CourseDao;
import com.lwb.dao.MsBoardDao;
import com.lwb.pojo.MsBoard;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MsBoardTest {

    private InputStream in;
    private SqlSession sqlSession;
    private MsBoardDao msboarddao;

    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        msboarddao = sqlSession.getMapper(MsBoardDao.class);
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
    public void testadd(){
        MsBoard msboard = new MsBoard();
        msboard.setUid("201716040225");
        msboard.setUname("郭睿哲");
        msboard.setMstitle("出差申请");
        msboard.setMskeyword("出差");
        msboard.setMscontents("出差一周");
        int index = msboarddao.addMessage(msboard);
        if(index == 1){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }


    @Test
    public void tesedel(){
        int index = msboarddao.delMsessage(1);
        if(index == 1){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    @Test
    public void testupdate(){
        MsBoard msboard = new MsBoard();
        msboard.setMsid(3);
        msboard.setMstitle("通知");
        msboard.setMskeyword("紧急通知");
        msboard.setMscontents("明天不上班");
        int index = msboarddao.updatemessage(msboard);
        if(index == 1){
            System.out.println("更新成功");
        }else{
            System.out.println("更新失败");
        }
    }


    @Test
    public void testShowAll(){
        List<MsBoard> msboards = msboarddao.showAllMessage();
        for(MsBoard m :msboards){
            System.out.println(m);
        }
    }

@Test
    public void testFindByUid(){
        List<MsBoard> msboards = msboarddao.findByUid("201716040224");
        for(MsBoard m :msboards){
            System.out.println(m);
        }
    }


}
