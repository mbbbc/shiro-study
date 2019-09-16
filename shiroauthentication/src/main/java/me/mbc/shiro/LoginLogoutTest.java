package me.mbc.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class LoginLogoutTest {
    private static final String INT_RESOURCE_PATH = "classpath:shiro.ini";

    @Test
    public void test(){

    }

    @Test
    public void testHelloWorld(){
        //1.获取SecurityManager工厂，通过Ini配置文件初始化SecurityManagerFactory
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(INT_RESOURCE_PATH);
        //2.得到SecurityManaget实例，并绑定到Securityutils
        SecurityManager instance = factory.getInstance();
        SecurityUtils.setSecurityManager(instance);
        //3.得到Subject及创建用户名、密码身份验证Token
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        try{
            //4.登录
            subject.login(token);
        }catch (AuthenticationException e){
            //5.身份验证失败

        }
        //断言用户已经登录
        Assert.assertEquals(true, subject.isAuthenticated());
        //6.退出
        subject.logout();
        Assert.assertEquals(false, subject.isAuthenticated());
    }

    @Test
    public void testCustom
            (){

    }
}
