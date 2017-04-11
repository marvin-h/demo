package com.demo.mybatis.intro;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class AppIntro {
    public static void main(String[] args) {
        String config = "META-INF/mybatis-intro-cfg.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(config);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = null;
            try {
                sqlSession = sqlSessionFactory.openSession();
                UserEntity userEntity = sqlSession.selectOne("com.demo.mybatis.intro.UserMapper.selectUser", 1);
                System.out.println(userEntity.getName());
            }
            finally {
                if(sqlSession != null) {
                    sqlSession.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
