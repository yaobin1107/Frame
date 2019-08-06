package cn.yb14.test;


import cn.yb14.dao.IUserDao;
import cn.yb14.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisAnnoTest {
    @Test
    public void test() throws IOException {
        //1.获取字节输入流
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.通过SqlSessionFactoryBuilder构建session工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //3.通过工厂获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //4.通过SqlSession的getMapper方法获取Dao的代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        //5.调用方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6.释放资源
        sqlSession.close();
        is.close();
    }
}
