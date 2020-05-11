import com.lwb.dao.CustomerDao;
import com.lwb.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.util.resources.cldr.nso.CurrencyNames_nso;

import java.util.List;
import java.util.PrimitiveIterator;


@RunWith(SpringJUnit4ClassRunner.class) //声明spring提供的单元测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml")//指定spring容器的配置信息
public class SpringDataJPA_Test {
    @Autowired
    private CustomerDao customerDao;



    @Test
    public void testFindOne(){

        Customer customer = customerDao.findOne(4);
        System.out.println(customer);

    }

    /**
     * save : 保存或者更新
     *      根据传递的对象是否存在主键id，
     *      如果没有id主键属性：保存
     *      存在id主键属性，根据id查询数据，更新数据
     */
    @Test
    public void testSave() {
        Customer customer  = new Customer();
        customer.setCustName("黑马程序员");
        customer.setCustLevel("vip");
        customer.setCustIndustry("it教育");
        customerDao.save(customer);
    }

    @Test
    public void testUpdate() {
        /**
         * 这个会将数据库中的全部属性改变，建议先查询在更新
         */
        Customer customer  = customerDao.findOne(4);
        customer.setCustPhone("13253376824");
        customerDao.save(customer);
    }

    @Test
    public void testFindAll(){

        List<Customer> customers = customerDao.findAll();
       for(Customer c : customers){
           System.out.println(c);
       }

    }

    @Test
    public void testDelOne(){

        this.testFindAll();
        System.out.println("******************");
        customerDao.delete(5);
        System.out.println("****************************");
        this.testFindAll();

    }

}
