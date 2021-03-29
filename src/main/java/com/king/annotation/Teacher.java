package com.king.annotation;

/**
 * @program: maven_1
 * @description:
 * @author: King
 * @create: 2021-03-29 20:35
 */
@MyHelloWorld(name = "a",age = 100,ins = {""})
public class Teacher {
    @MyHelloWorld(name = "c",ins = {""})
    private String name;

    @MyHelloWorld(name = "aa",ins = {""})
    public String getName() {
        return name;
    }



    public static void main(String[] args) {

    }
}
