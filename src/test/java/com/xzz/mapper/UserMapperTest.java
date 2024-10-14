package com.xzz.mapper;

import com.xzz.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserMapperTest {
    private UserMapper mapper = null;
    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream in = Resources.getResourceAsStream("mybatis-Config.xml");
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(in);
        SqlSession session = factory.openSession(true);
        mapper = session.getMapper(UserMapper.class);
    }

    @Test
    public void findUSer() {
        User user = mapper.findUserById(2);
        System.out.println(user);
    }

    @Test
    public void findAllUser() {
        List<User> list = mapper.findAllUser();
        Iterator<User> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    @Test
    public void addUserTest() throws ParseException {
        String birthdayStr = "2011-12-12";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = sdf.parse(birthdayStr);
        User user = new User(null, "Jerry", birthday, "男", "北京");
        mapper.addUser(user);

    }

    @Test
    public void delUserTest() {
        mapper.delUser(7);
    }
    //更改user
    @Test
    public void updateUserTest() throws ParseException {
        String birthdayStr = "2008-08-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = sdf.parse(birthdayStr);
        User user = new User(7, "Jerry", birthday, "女", "北京");
        mapper.updateUser(user);
    }

    @Test
    public void findUserByNameAndSexTest() {
        User user = mapper.findUserByNameAndSex("张三","1");
        System.out.println(user);
    }
    //测试
}