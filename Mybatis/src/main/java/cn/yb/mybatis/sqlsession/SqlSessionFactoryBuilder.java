package cn.yb.mybatis.sqlsession;

import cn.yb.mybatis.conf.Configuration;
import cn.yb.mybatis.sqlsession.defaults.DefaultSessionFactory;
import cn.yb.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {
    /**
     * 根据字节输入流来构建SqlSessionFactory
     *
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSessionFactory(cfg);
    }
}
