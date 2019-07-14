package cn.yb.mybatis.sqlsession;

/**
 * 自定义mybatis中和数据库交互的核心类
 *
 */
public interface SqlSessionFactory {
    SqlSession openSession();
}
