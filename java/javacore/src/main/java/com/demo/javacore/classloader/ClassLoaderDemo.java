package com.demo.javacore.classloader;


import java.net.URL;

public class ClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoaderDemo demo = new ClassLoaderDemo();
        demo.classLoaderPath();
    }

    private void classLoaderPath() {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for(int i = 0; i < urls.length; ++i) {
            System.out.println(urls[i].toExternalForm());
        }
        System.out.println();
        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
