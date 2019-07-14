package cn.yb.test;

import cn.yb.dao.IUserDao;
import cn.yb.domain.User;
import cn.yb.mybatis.io.Resources;
import cn.yb.mybatis.sqlsession.SqlSession;
import cn.yb.mybatis.sqlsession.SqlSessionFactory;
import cn.yb.mybatis.sqlsession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 测试自定义mybatis框架
 */
public class Mybatis_design {

    @Test
    public void test1() throws Exception {
        //1.读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        //构建者模式，将对象细节隐藏，使用者直接调用方法即可拿到对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //3.使用工厂创建SqlSession对象
        //工厂模式，解耦
        SqlSession sqlSession = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        //代理模式，不修改源码的情况需下对已有方法增强
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
        //6.释放资源
        sqlSession.close();
        is.close();
    }
}
