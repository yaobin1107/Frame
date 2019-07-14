package cn.yb.dao;

import cn.yb.domain.Student;
import cn.yb.mybatis.annotation.Select;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IStudentDao {
    /**
     * 查询所有
     *
     * @return
     */
    @Select("select * from user")
    //注解配置方式
    List<Student> findAll();
}
