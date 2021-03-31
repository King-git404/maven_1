package com.king.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: maven_1
 * @description:
 * @author: King
 * @create: 2021-03-29 21:09
 */
@Target(value = {ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface DBConnection {
    /**
     * name=onlineclasses
     * pwd=Aa123456
     * url=jdbc:mysql://kingmysql.mysql.rds.aliyuncs.com:3306/onlineclasses
     * driver=com.mysql.cj.jdbc.Driver
     */
    //链接数据库参数
    public String url();

    public String driverClass();

    public String name() default "root";

    public String pwd() default "Aa123456";



}
