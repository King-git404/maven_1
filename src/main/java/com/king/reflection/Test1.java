package com.king.reflection;

import com.king.Showable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

/**
 * @program: maven_1
 * @description: com.king.Person
 * @author: Kin
 * @create: 2021-03-29 18:41
 */
public class Test1 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("请输入类路径");
            String path = scanner.nextLine();
            System.out.println("待加载的类 " + path);

            Class c = Class.forName(path);
            String name = c.getName();
            System.out.println( name);


            System.out.println("===========getDeclaredFields()");
            Field[] fs = c.getDeclaredFields();
            //getFields()：获得某个类的所有的公共（public）的字段，包括父类中的字段。
            //getDeclaredFields()：获得某个类的所有声明的字段，即包括public、private和 protected，但是不包括父类的申明字段。
            if (fs != null && fs.length > 0) {
                for (Field f : fs) {
                    System.out.println(f.getModifiers() + " " + f.getName());
                    String modifiers  = "";
                    switch (f.getModifiers()){
                        case 1:
                            modifiers = "public";
                            break;
                        case 2:
                            modifiers = "private";
                            break;
                        case 4:
                            modifiers = "protected";
                            break;
                    }
                    System.out.println(modifiers + " "+ f.getName());

                }
            }


            System.out.println("===========getMethods()");
            Method[] ms = c.getMethods();
            //getMethods()获取的是所有public方法，包括：类自身声明的public方法、父类中的public方法、实现的接口方法。
            //getDeclaredMethods()获取的是类中所有方法，也就是源文件中有哪些方法，就会获取到哪些，包括：类自身的方法、重写的父类的方法、实现的接口方法。
            if (ms != null && ms.length > 0) {
                for (Method m : ms) {
                    System.out.println(m.getModifiers() + " " + m.getName());
                }
            }

            System.out.println("===========");
            Constructor[] cs = c.getConstructors();
            if (cs != null && cs.length > 0) {

                for (Constructor cc : cs) {

                    System.out.println(cc.getModifiers() + "  " + cc.getName());
                }
            }


            System.out.println("===========用反射完成实例化操作");
            // 用反射完成实例化操作
            Object o = c.newInstance();
            if (o instanceof Showable) {
                Showable p = (Showable) o;
                p.show();
            }

            System.out.println("===========用反射调用某个方法");
            if (ms != null && ms.length > 0) {
                for (Method m : ms) {
                   if (m.getName().startsWith("sh")){
                       m.invoke(o);
                   }
                }
            }

            Map<String, String> pMap = new HashMap<String, String>();
            pMap.put("name", "蔡徐坤");
            pMap.put("age", 18 + "");

            Object oo = setValues(pMap,c);
            System.out.println(oo.toString());
        }


    }

    /**
     * 反射功能模块 将map保存的属性存到 cls 对应对象中
     *
     * @param map
     * @param cls
     * @return
     */
    public static Object setValues(Map<String, String> map, Class cls) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object o = null;
        o = cls.newInstance();

        Method[] ms = cls.getMethods();
        if (ms != null && ms.length > 0) {
            for (Method m : ms) {
                if (m.getName().startsWith("set")) {
                    String mName = m.getName();
                    String fName = mName.substring(3).toLowerCase();
                    String value = map.get(fName);
                    System.out.println(mName + "~" + fName + "~" + value);
                    if ("Integer".equals(m.getParameterTypes()[0].getTypeName()) || "int".equals(m.getParameterTypes()[0].getTypeName())) {
                        m.invoke(o, Integer.valueOf(value));
                    } else {
                        m.invoke(o, value);
                    }


                }
            }
        }
        return o;
    }
}
