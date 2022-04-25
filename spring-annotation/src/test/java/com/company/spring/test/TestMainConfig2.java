package com.company.spring.test;

import com.company.spring.bean.Bule;
import com.company.spring.bean.Person;
import com.company.spring.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Map;


/**
 * @Author wlb10
 * @PackageName SpringAnnotationDrivenDevelopment
 * @Package com.company.spring.test
 * @Date 2022/4/24 17:07
 * @Version 1.0
 */
public class TestMainConfig2 {
    @Test
    public void testMainConfig2(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for(String name : definitionNames){
            System.out.println(name);
        }
        Person person1 = applicationContext.getBean(Person.class);
        Person person2 = applicationContext.getBean(Person.class);
        System.out.println(person1 == person2);
    }
    @Test
    public void test0102(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for(String name : beanNamesForType){
            System.out.println(name);
        }
        Map<String,Person> personMap =  applicationContext.getBeansOfType(Person.class);
        System.out.println(personMap);
    }
    @Test
    public void testImport(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name : beanDefinitionNames){
            System.out.println(name);
        }
        Bule bule = applicationContext.getBean(Bule.class);
        System.out.println(bule);
    }
    @Test
    public void testFactoryBean(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for(String name : beanDefinitionNames){
            System.out.println(name);
        }
        Object colorFactoryBean = applicationContext.getBean("colorFactoryBean");
        System.out.println("bean类型"+colorFactoryBean.getClass());
    }
}
