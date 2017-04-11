package com.demo.javacore.classloader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class UserDefinedClassLoader extends ClassLoader {
    private String path;

    public UserDefinedClassLoader(String path) {
        if(path == null) {
            throw new IllegalArgumentException();
        }

        this.path = path;
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        InputStream inputStream = null;
        Class<?> clazz = null;
        try {
            inputStream = new FileInputStream(getFullFileName(name));
            byte[] buff = new byte[1024*4];
            int len = inputStream.read(buff);
            clazz = defineClass(name, buff, 0, len);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return clazz;
    }

    private String getFullFileName(String name) {
        return path + name.replace('.', '/') + ".class";
    }

    public static void main(String[] args) {
        UserDefinedClassLoader cl = new UserDefinedClassLoader(UserDefinedClassLoader.class.getClassLoader().getResource("").getPath());
        try {
            Class<?> c = cl.findClass("com.demo.javacore.classloader.UserDefinedClTestClass");
            System.out.println(c.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
