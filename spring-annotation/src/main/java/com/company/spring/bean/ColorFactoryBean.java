package com.company.spring.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author wlb10
 * @PackageName SpringAnnotationDrivenDevelopment
 * @Package com.company.spring.bean
 * @Date 2022/4/25 9:36
 * @Version 1.0
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    /**
     * 返回一个color对象，这个对象会添加到容器中
     * @return
     * @throws Exception
     */
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    /**
     * 指定返回对象的类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 指定是否是单实例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
