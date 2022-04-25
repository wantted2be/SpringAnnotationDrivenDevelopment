package com.company.spring.test;

import com.company.spring.bean.Person;
import com.company.spring.config.MainConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author wlb10
 * @PackageName SpringAnnotationDrivenDevelopment
 * @Package com.company.spring.test
 * @Date 2022/4/24 13:13
 * @Version 1.0
 */
public class TestMainConfig {
    @Test
    public void testSpringXml(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }
    @Test
    public void testSpringConfigClass(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);

        String[] namesType = applicationContext.getBeanNamesForType(Person.class);
        for(String name : namesType){
            System.out.println(name);
        }
    }
    @Test
    public void testIOC(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] bean = applicationContext.getBeanDefinitionNames();
        for(String name : bean){
            System.out.println(name);
        }
    }
}
