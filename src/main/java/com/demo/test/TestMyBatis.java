package com.demo.test;

import com.demo.domain.User;
import com.demo.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    @Test
    public void run() throws Exception{
        //加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //构建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建session
        SqlSession session = factory.openSession();
        //获取代理对象
        UserMapper mapper = session.getMapper(UserMapper.class);
        //调用方法
        List<User> list = mapper.findAll();
        for(User u:list){
            System.out.println(u.toString());
        }
        //关闭资源
        session.close();
        inputStream.close();
    }
}
