package cn.yb14.test;

import cn.yb14.dao.IUserDao;
import cn.yb14.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AnnotationCRUDTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private IUserDao userDao;
    private InputStream is;

    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        is.close();
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("yb");
        user.setAddress("西安");
        user.setSex("男");
        userDao.saveUser(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(43);
        user.setUsername("mybatis annotation update");
        user.setAddress("北京市海淀区");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }


    @Test
    public void testDelete() {
        userDao.deleteUser(46);
    }

    @Test
    public void testFindOne() {
        User user = userDao.findById(49);
        System.out.println(user);
    }


    @Test
    public void testFindByName() {
        //List<User> users = userDao.findUserByName("%mybatis%");
        List<User> users = userDao.findUserByName("mybatis");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() {
        int total = userDao.findTotalUser();
        System.out.println(total);
    }

}
