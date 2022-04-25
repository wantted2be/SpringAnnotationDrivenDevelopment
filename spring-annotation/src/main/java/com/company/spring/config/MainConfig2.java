package com.company.spring.config;

import com.company.spring.bean.Color;
import com.company.spring.bean.ColorFactoryBean;
import com.company.spring.bean.Person;
import com.company.spring.bean.Red;
import com.company.spring.condition.LinuxCondition;
import com.company.spring.condition.MyImportBeanDefinitionRegister;
import com.company.spring.condition.MyImportSelector;
import com.company.spring.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @Author wlb10
 * @PackageName SpringAnnotationDrivenDevelopment
 * @Package com.company.spring.config
 * @Date 2022/4/24 17:06
 * @Version 1.0
 */
@Configuration
@Import(value = {Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegister.class})
public class MainConfig2 {
    /**
     * @Scope
     * prototype:多实例对象，在IOC启动时候不创建对象，在创建对象的时候创建对象
     * singleton:单实例（默认值），默认在IOC容器启东时，就把对象创建并且放在了IOC
     * request：同一次请求创建一个实例
     * session：同一个session创建一个实例
     * application：
     *
     * 懒加载：@lazy
     *      单实例bean，默认在容器启动的时候创建对象
     *      懒加载，容器启动的时候不会创建对象，第一次使用获取bean的时候创建对象，并初始化
     */
    @Lazy
    @Scope(value = "singleton")  //调整作用域
    @Bean(value = {"person"})  //默认是单实例的
    public Person person(){
        System.out.println("给容器添加person");
        return new Person("王五",20);
    }

    /**
     * @Conditional({Condition}) : 按照一定的条件进行判断，满足条件注册bean如果放在类前面，表示对类中组件统一设置
     * 如果操作系统是linux 给容器注册linus 否则给容器注册bill gates
     */

    @Conditional({WindowsCondition.class})
    @Bean(value = {"bill"})
    public Person person01(){
        return new Person("bill gates",65);
    }

    @Conditional({LinuxCondition.class})
    @Bean(value = {"linus"})
    public Person person02(){
        return new Person("linus",48);
    }

    /**
     * 给容器注册组件的几种方式：
     * 1.包扫描+组件注解（自己写的类）
     * 2.@Bean（导入的第三方包）
     * 3.@Import[快速的给容器中导入组件]
     *      a.@Import(要导入到容器的组件)，容器会自动注册这个组件，id默认是全类名
     *      b.ImportSelector:返回需要导入组件的全类名数组
     *      c.ImportBeanDefinitionRegister
     * 4.使用Spring提供的FactoryBean,给工厂bean使用@Bean注册组件，工厂bean返回的是自己定义的bean，要获取本身+&符号
     */
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
