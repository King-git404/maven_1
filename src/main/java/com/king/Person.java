package com.king;

import java.util.Date;

/**
 * @program: maven_1
 * @description:
 * @author: King
 * @create: 2021-03-29 18:33
 */
public class Person implements Showable{

    private static Date d;
    private String name;
    private int age;

    public String string;
    protected String  protected_;

    public static void main(String[] args) {
        d = new Date();
        System.out.println(d.getYear());
        System.out.println();
    }

    public Person(){
        System.out.println("无参数构造方法");
    }
    @SuppressWarnings(value = {"unchecked"})
    public Person(String name,String age){
        this.name = name;
        System.out.println("有参数构造方法");
    }




    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void show() {
        System.out.println("Hello world");
    }
}
