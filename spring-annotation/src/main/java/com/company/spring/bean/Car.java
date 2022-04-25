package com.company.spring.bean;

/**
 * @Author wlb10
 * @PackageName SpringAnnotationDrivenDevelopment
 * @Package com.company.spring.bean
 * @Date 2022/4/25 9:57
 * @Version 1.0
 */
public class Car {
    public Car() {
        System.out.println("car constructor...");
    }

    public void init() {
        System.out.println("car ... init...");
    }

    public void destroy() {
        System.out.println("car ... destroy...");
    }
}
