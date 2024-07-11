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
        LogUtil.log("Registering the bean based on the returned string is done after all @Configuration classes have been loaded, and one of the scenarios is handling @Condition",
                "DeferredImportSelector", "selectImports");
        return new String[0];
    }
}
