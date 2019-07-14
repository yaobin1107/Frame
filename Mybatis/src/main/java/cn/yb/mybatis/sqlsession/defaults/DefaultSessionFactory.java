package cn.yb.mybatis.sqlsession.defaults;

import cn.yb.mybatis.conf.Configuration;
import cn.yb.mybatis.sqlsession.SqlSession;
import cn.yb.mybatis.sqlsession.SqlSessionFactory;

/**
 * SqlSessionFactory接口的实现类
 */
public class DefaultSessionFactory implements SqlSessionFactory {

    Configuration cfg;

    public DefaultSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的数据库操作对象
     *
     * @return
     */
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
