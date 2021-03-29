package com.king;

/**
 * @program: maven_1
 * @description:
 * @author: King
 * @create: 2021-03-29 18:33
 */
public class Person implements Showable{


    public Person(){

    }
    public Person(String name,String age){

    }

    public static void main(String[] args) {

    }


    @Override
    public void show() {
        System.out.println("Hello world");
    }
}
