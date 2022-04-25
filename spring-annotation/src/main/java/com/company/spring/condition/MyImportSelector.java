package com.company.spring.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author wlb10
 * @PackageName SpringAnnotationDrivenDevelopment
 * @Package com.company.spring.condition
 * @Date 2022/4/24 20:41
 * @Version 1.0
 */
//自定义逻辑，返回需要导入的组件
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        /**
         * 方法不要返回null值。
         * @parameter:AnnotationMetadata，当前标注@Import注解的类的所有注解信息
         * @return:返回值就是要导入容器的组件全类名
         */
        return new String[]{"com.company.spring.bean.Bule","com.company.spring.bean.Yellow"};
    }
}
