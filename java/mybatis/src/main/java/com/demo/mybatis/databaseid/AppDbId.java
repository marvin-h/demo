package com.demo.mybatis.databaseid;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class AppDbId {
    public static void main(String[] args) {
        String config = "META-INF/mybatis-databaseid-cfg.xml";
        InputStream inputStream = null;
        InputStream inputStream1 = null;
        try {
            inputStream = Resources.getResourceAsStream(config);
            inputStream1 = Resources.getResourceAsStream(config);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"mysql");
            SqlSession sqlSession = null;

            SqlSessionFactory sqlSessionFactory1 = new SqlSessionFactoryBuilder().build(inputStream1,"postgres");
            SqlSession sqlSession1 = null;
            try {
                sqlSession = sqlSessionFactory.openSession();
                UserEntity userEntity = sqlSession.selectOne("com.demo.mybatis.databaseid.UserMapper.selectUser", 1);
                System.out.println(userEntity.getName());

                sqlSession1 = sqlSessionFactory1.openSession();
                UserEntity userEntity1 = sqlSession.selectOne("com.demo.mybatis.databaseid.UserMapper.selectUser", 1);
                System.out.println(userEntity1.getName());
            }
            finally {
                if(sqlSession != null) {
                    sqlSession.close();
                }

                if(sqlSession1 != null) {
                    sqlSession1.close();
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
            if(inputStream1 != null) {
                try {
                    inputStream1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
