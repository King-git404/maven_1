package com.king.reflection;

import com.king.Showable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Scanner;

/**
 * @program: maven_1
 * @description: vcom.king.Person
 * @author: Kin
 * @create: 2021-03-29 18:41
 */
public class Test1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入类路径");
            String path = scanner.nextLine();
            System.out.println("待加载的类 " + path);

            Class c = Class.forName(path);
            String name = c.getName();

            System.out.println(name);

            Field[] fs = c.getDeclaredFields();
            if (fs != null && fs.length >0) {
                for (Field f : fs) {
                    System.out.println(f.getModifiers() + " " + f.getName());
                }
            }

            System.out.println("===========");

            Constructor[] cs = c.getConstructors();
            if (cs != null && cs.length>0){

                for (Constructor cc :
                    cs ) {

                    System.out.println(cc.getModifiers() + "  " + cc.getName());
                }
            }
            // 用反射完成实例化操作
            Object o = c.newInstance();
            if (o instanceof Showable){
               Showable p = (Showable) o;
               p.show();
            }

        }
    }
}
