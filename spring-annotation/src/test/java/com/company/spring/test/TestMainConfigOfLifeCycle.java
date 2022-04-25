package com.company.spring.test;

import com.company.spring.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author wlb10
 * @PackageName SpringAnnotationDrivenDevelopment
 * @Package com.company.spring.test
 * @Date 2022/4/25 10:00
 * @Version 1.0
 */
public class TestMainConfigOfLifeCycle {
    @Test
    public void testInitAndDestory(){
        //1.创建IOC
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");
        // 关闭容器
        applicationContext.close();
    }
}
