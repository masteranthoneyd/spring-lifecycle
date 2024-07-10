package com.yangbingdong.spring.explore.lifecycle.autoconfigure;

import com.yangbingdong.spring.explore.lifecycle.LogUtil;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author bingdong.yang@salesforce-china.com
 */
public class CustomDeferredImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        LogUtil.log("根据返回的字符串注册bean, 执行时机是在所有 @Configuration 类加载完之后, 其中一个场景是处理 @Condition",
                "DeferredImportSelector", "selectImports");
        return new String[0];
    }
}
