package com.haozi.demo.algorithm.audition;

/**
 * Created by ASUS on 2017/12/23.
 */
public class Father {

    public Father() {
        System.out.println("father's no arg constructor");
    }

    public Father(String name){
        System.out.println("father's string arg constructor");
    }

    static {
        System.out.println("father's static code block");
    }
}
