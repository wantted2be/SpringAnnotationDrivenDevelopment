package com.company.spring.config;

import com.company.spring.bean.Person;
import com.company.spring.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.filter.AspectJTypeFilter;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.stereotype.Controller;

/**
 * @Author wlb10
 * @PackageName SpringAnnotationDrivenDevelopment
 * @Package com.company.spring.config
 * @Date 2022/4/24 13:25
 * @Version 1.0
 */
//配置类==配置文件

/**
 * value 包的扫描位置
 * excludeFilters：排除扫描的组件
 * includeFilters：扫描的组件，使用时需要把useDefaultFilters设置为false（默认为true）
 * FilterType：1.FilterType.ANNOTATION按照注解
 *           ：2.FilterType.ASSIGNABLE_TYPE按照类型
 *           ：3.FilterType.ASPECTJ使用ASPECTJ表达式
 *           ：3.FilterType.ASPECTJ使用ASPECTJ表达式
 */
@Configuration
@ComponentScan(value = {"com.company.spring"},
        //excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})},
        includeFilters = {
                //@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
                //@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
                //@ComponentScan.Filter(type = FilterType.ASPECTJ,classes = {AspectJTypeFilter.class})
                //@ComponentScan.Filter(type = FilterType.REGEX,classes = {RegexPatternTypeFilter.class})
                @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
        }, useDefaultFilters = false)
public class MainConfig {
    @Bean(value = {"person"})  //给容器中注册一个bean,bean的id默认是方法名，value属性可以更改id值，类型为返回值的类型
    public Person person(){
        return new Person("李四",20);
    }
}
