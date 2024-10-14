package com.xzz.mapper;

import com.xzz.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //根据id查询一个账户
    User findUserById( int id);

    //查询所有账户
    List<User> findAllUser();

    //增加user
    void addUser(User user);

    //删除user
    void delUser(int id);

    //更改user
    void updateUser(User user);
    //根据名字和性别查询
    /*
    mybatis对Mapper接口入参的处理:
    1.单个参数不做处理,sql语句填充占位符的key可以任意指定
    例如:id = #{任意指定}
    2.多个参数
    mybatis会将多个参数封装到-个map中,此时填充占位符的key是arg0,arg1....或者param1,param2.....
    例如:username=#{arg0}/username={param1} and email=#{arg1}/email#{param2}
    我么还可以通过在Mapper接口的方法的入参前面添加@Param注解来指定填充占位符的key
    例如:入参前面添加@Param("username"),那么填充占位符的key是:#{username}
    3.pojo
    如果传入的多个参数封装成pojo对象,那么可以直接传入pojo对象,此时的填充占位符的key是pojo的属性名
    例如:username= #{username}
     */
    User findUserByNameAndSex(@Param("username") String username, @Param("sex") String sex);
}
