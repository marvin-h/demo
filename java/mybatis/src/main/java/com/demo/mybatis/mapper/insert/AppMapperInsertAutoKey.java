package com.demo.mybatis.mapper.insert;

import com.demo.mybatis.mapper.UserEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class AppMapperInsertAutoKey {
    public static void main(String[] args) {
        String config = "META-INF/mybatis-mapper-insert-autokey-cfg.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(config);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = null;
            try {
                sqlSession = sqlSessionFactory.openSession();
                UserEntity userEntity = new UserEntity();
                userEntity.setName("dd");
                sqlSession.insert("com.demo.mybatis.mapper.insert.UserMapper.insertUser", userEntity);
                userEntity = sqlSession.selectOne("com.demo.mybatis.mapper.insert.UserMapper.selectUser", 1);
                System.out.println(userEntity.getName());
                userEntity = sqlSession.selectOne("com.demo.mybatis.mapper.insert.UserMapper.selectUser", 2);
                System.out.println(userEntity.getName());
                sqlSession.commit();
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
