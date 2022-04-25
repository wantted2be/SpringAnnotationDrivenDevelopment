package com.company.spring.config;

import com.company.spring.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wlb10
 * @PackageName SpringAnnotationDrivenDevelopment
 * @Package com.company.spring.config
 * @Date 2022/4/25 9:51
 * @Version 1.0
 */
@Configuration
public class MainConfigOfLifeCycle {
    /**
     * bean的生命周期，指的是bean从创建到初始化，经过一系列的流程，最终销毁的过程。
     * 只不过，在Spring中，bean的生命周期是由Spring容器来管理的。
     * 在Spring中，我们可以自己来指定bean的初始化和销毁的方法。
     * 我们指定了bean的初始化和销毁方法之后，当容器在bean进行到当前生命周期的阶段时，会自动调用我们自定义的初始化和销毁方法。
     *      a.指定初始化和销毁方法
     *          <bean class="com.company.spring.bean.Person" id="person" init-method="init" destroy-method="destroy">
     *              <property name="name" value="张三"></property>
     *              <property name="age" value="48"></property>
     *          </bean>
     *      b.@Bean(initMethod="init", destroyMethod="destroy")
     *          bean对象的初始化方法调用的时机：对象创建完成，如果对象中存在一些属性，并且这些属性也都赋好值之后，那么就会调用bean的初始化方法。对于单实例bean来说，在Spring容器创建完成后，Spring容器会自动调用bean的初始化方法；对于多实例bean来说，在每次获取bean对象的时候，调用bean的初始化方法。
     *          bean对象的销毁方法调用的时机：对于单实例bean来说，在容器关闭的时候，会调用bean的销毁方法；对于多实例bean来说，Spring容器不会管理这个bean，也就不会自动调用这个bean的销毁方法了。
     */
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }

}
