package com.demo.javacore.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE_USE)
@interface TypeUseAnno {

}

public class TypeUseDemo {
    public static void main(String[] args) {
        @TypeUseAnno String text;
        java.util.@TypeUseAnno Scanner console;
    }
}
