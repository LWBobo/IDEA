package com.lwb.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class Test {

    @org.junit.Test
    public void test(){
        //读取国际化资源数据
        //使用ResourceBundle读取数据
        //baseName=包名+文件名
        //默认读取是中文
        //ResourceBundle rb = ResourceBundle.getBundle("resources.message");

        //指定读取某个国家国际化数据
      //  ResourceBundle rb = ResourceBundle.getBundle("message", Locale.US);
        ResourceBundle rb = ResourceBundle.getBundle("message");

        System.out.println(rb.getString("login.username"));
        System.out.println(rb.getString("login.password"));
        System.out.println(rb.getString("login.submit"));
    }
}
