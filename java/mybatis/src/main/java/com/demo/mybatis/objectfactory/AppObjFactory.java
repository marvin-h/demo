package com.demo.mybatis.objectfactory;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class AppObjFactory {
    public static void main(String[] args) {
        String config = "META-INF/mybatis-objfactory-cfg.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(config);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = null;
            try {
                sqlSession = sqlSessionFactory.openSession();
                UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
                UserEntity userEntity = userMapper.selectUser(1);
                System.out.println(userEntity.getName());
            } finally {
                if (sqlSession != null) {
                    sqlSession.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
