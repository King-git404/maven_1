package com;

import java.util.Date;

/**
 * @program: maven_1
 * @description:
 * @author: King
 * @create: 2021-04-01 21:05
 */
public class Test2 {
    public int add(int x, int y) {
        System.out.println("2021年3月31日18时51分56秒");
        return x + y;
    }

    public int sub(int x, int y) {
        Date date = new Date();
        System.out.println(date.getDay());
        return x - y;
    }
}
