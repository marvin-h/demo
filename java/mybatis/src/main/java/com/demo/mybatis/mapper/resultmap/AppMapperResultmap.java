package com.demo.mybatis.mapper.resultmap;

import com.demo.mybatis.mapper.ExtUserEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class AppMapperResultmap {
    public static void main(String[] args) {
        String config = "META-INF/mybatis-mapper-resultmap-cfg.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(config);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = null;
            try {
                sqlSession = sqlSessionFactory.openSession();
                ExtUserEntity userEntity = sqlSession.selectOne("com.demo.mybatis.mapper.resultmap.UserMapper.selectExtUser", 1);
                System.out.println(userEntity.getExtName());
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
