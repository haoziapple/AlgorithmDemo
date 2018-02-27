package com.haozi.demo.algorithm.audition;

/**
 * Created by ASUS on 2017/12/23.
 */
public class Child extends Father {
    private Father father;

    static {
        System.out.println("child's static code block");
    }

    public Child(){
        System.out.println("child's no arg constructor");
    }

    public Child(String name)
    {
        System.out.println("child's string constructor");
        this.father = new Father(name);
    }

    public static void main(String[] args) {
        Child child = new Child("mike");
        System.out.println("===================");
        child = new Child();
    }
}
