package com.company.spring.condition;

import com.company.spring.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author wlb10
 * @PackageName SpringAnnotationDrivenDevelopment
 * @Package com.company.spring.condition
 * @Date 2022/4/25 9:13
 * @Version 1.0
 */
public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        /**
         * annotationMetadata:当前类的注解信息
         * beanDefinitionRegistry：beanDefinitionRegistry注册类
         *      把所有需要添加到容器的bean：调用
         *      BeanDefinitionRegistry.registerBeanDefinition手动注册
         */
        boolean red = beanDefinitionRegistry.containsBeanDefinition("com.company.spring.bean.Red");
        boolean bule = beanDefinitionRegistry.containsBeanDefinition("com.company.spring.bean.Bule");
        if(red && bule){
            //指定bean的定义信息（bean类型，beanscope等）
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个bean
            beanDefinitionRegistry.registerBeanDefinition("rainBow",rootBeanDefinition);
        }
    }
}
