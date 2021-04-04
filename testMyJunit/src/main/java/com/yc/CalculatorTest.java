package com.yc;

import com.Calculator;
import com.yc.junit.*;


public class CalculatorTest {
    private Calculator cal;

    @MyBeforeClass
    public static void bc() {
        System.out.println("before.class");
    }

    @MyAfterClass
    public static void ac(){
        System.out.println("after.class");
    }

    @MyBefore
    public void setUp() throws Exception {
        System.out.println("before");
        cal = new Calculator();
    }

    @MyAfter
    public void tearDown() throws Exception {
        System.out.println("after");
    }

    @MyTest
    public void add() {
        System.out.println("add测试");
        System.out.println( Assert.assertEquals(3, cal.add(1, 2)));
    }

    @MyTest
    public void sub() {
        System.out.println("sub测试");
        System.out.println( Assert.assertEquals(cal.sub(2, 1), 1));
    }
}