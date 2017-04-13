package com.demo.javacore.generaltype;


public class GeneralType<T> {
    private T member;
    public GeneralType(T member) {
        this.member = member;
    }

    public T getMember() {
        return member;
    }

    public void run() {
        System.out.println(member.getClass().getName());
    }

    public static void main(String[] args) {
        GeneralType<String> generalType = new GeneralType<String>("");
        GeneralType<Integer> generalType1 = new GeneralType<>(1);
        generalType.run();
        generalType1.run();
    }
}
