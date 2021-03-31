package com.yc.junit;

import com.yc.MyCalculatorTest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @program: maven_1
 * @description:
 * @author: King
 * @create: 2021-03-31 19:49
 */
public class MyJunitRunner {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class c = Class.forName("com.yc.MyCalculatorTest");
        //TODO 升级 按照 maven 约定的要求扫描 test/java 下的单元测试

        //1 获取类中所有方法
        Method[] ms = c.getDeclaredMethods();


//        Field[] fs = c.getDeclaredFields();
//        System.out.println(Arrays.toString(fs));
        //2 循环这些方法 判断那些加了注解
        List<Method> testMethod = new ArrayList<Method>();
        Method beforeMethod = null;
        Method afterMethod = null;
        Method beforeClassMethod = null;
        Method afterClassMethod = null;

        for (Method m : ms) {
            //System.out.println(m);
            if (m.isAnnotationPresent(MyTest.class)) {   //3.方法上有指定注解
                testMethod.add(m);
            }
            if (m.isAnnotationPresent(MyAfter.class)) {   //3.方法上有指定注解
                afterMethod = m;
            }
            if (m.isAnnotationPresent(MyAfterClass.class)) {   //3.方法上有指定注解
                afterClassMethod = m;
            }
            if (m.isAnnotationPresent(MyBefore.class)) {   //3.方法上有指定注解
                beforeMethod = m;
            }
            if (m.isAnnotationPresent(MyBeforeClass.class)) {   //3.方法上有指定注解
                beforeClassMethod = m;
            }
        }
        System.out.println(testMethod);


        //

        if (testMethod == null || testMethod.size() <= 0) {
            throw new RuntimeException("没有要测试的方法");
        }

        Object o = c.newInstance();
        beforeClassMethod.invoke(o,null);
        for (Method m:testMethod){
            if (beforeMethod != null){
                beforeMethod.invoke(o,null);
            }
            m.invoke(o,null);
            if (afterMethod != null){
                afterMethod.invoke(o,null);
            }
        }
        afterClassMethod.invoke(o,null);

    }


    //


}
