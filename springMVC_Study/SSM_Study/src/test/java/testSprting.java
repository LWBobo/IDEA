import com.lwb.dao.AccountDao;
import com.lwb.domain.Account;
import com.lwb.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.print.PrinterGraphics;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class testSprting {


    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        AccountService accountService = (AccountService) ac.getBean("accountService");

        Account acc = new Account();
        accountService.findAll();
        accountService.saveAccount(acc);
    }

    @Test
    public void testMybatis() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlsessionfactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建sqlsession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao ad = session.getMapper(AccountDao.class);

        List<Account> accounts = ad.findAll();
        System.out.println(accounts);


    }
    @Test
    public void testMybatissave() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlsessionfactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建sqlsession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao ad = session.getMapper(AccountDao.class);

        Account account = new Account();
        account.setName("王五");
        account.setMoney(1314.3);
        int a = ad.saveAccount(account);
        session.commit();
        System.out.println(a);


    }
}
