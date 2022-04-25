package com.company.spring.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author wlb10
 * @PackageName SpringAnnotationDrivenDevelopment
 * @Package com.company.spring.condition
 * @Date 2022/4/24 19:54
 * @Version 1.0
 */
public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //3.获取当前环境信息
        Environment conditionContextEnvironment = conditionContext.getEnvironment();

        String property = conditionContextEnvironment.getProperty("os.name");
        if(property.contains("Windows")){
            return true;
        }
        return false;
    }
}
