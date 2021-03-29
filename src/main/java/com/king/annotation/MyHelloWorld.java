package com.king.annotation;

import java.lang.annotation.*;

/**
 * @program: maven_1
 * @description: 自定义注解
 * @author: King
 * @create: 2021-03-29 20:31
 * Target 表示注解可以加在什么地方
 * Retention 表示这个注解什么时候保留
 */

/**
 * @Target(ElementType.TYPE) //接口、类、枚举
 * @Target(ElementType.FIELD) //字段、枚举的常量
 * @Target(ElementType.METHOD) //方法
 * @Target(ElementType.PARAMETER) //方法参数
 * @Target(ElementType.CONSTRUCTOR) //构造函数
 * @Target(ElementType.LOCAL_VARIABLE) //局部变量
 * @Target(ElementType.ANNOTATION_TYPE) //注解
 * @Target(ElementType.PACKAGE) ///包
 */

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
//@Deprecated // 说明该注解将被包含在javadoc中
/**
 * 1、RetentionPolicy.SOURCE：注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃；
 * 2、RetentionPolicy.CLASS：注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期；
 * 3、RetentionPolicy.RUNTIME：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
 */
@Retention(RetentionPolicy.CLASS)
@Inherited //子类是否可以继承· 父类注解
public @interface MyHelloWorld {

    public String name();

    public int age() default 20;

    public String[] ins();

}
