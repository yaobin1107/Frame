package cn.yb04.mybatis.sqlsession.defaults;

import cn.yb04.mybatis.cfg.Configuration;
import cn.yb04.mybatis.sqlsession.SqlSession;
import cn.yb04.mybatis.sqlsession.SqlSessionFactory;


/**
 * SqlSessionFactory接口的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
