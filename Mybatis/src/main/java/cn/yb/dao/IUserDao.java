package cn.yb.dao;

import cn.yb.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有
     *
     * @return
     */
    //@Select("select * from user")注解配置方式
    List<User> findAll();
}
