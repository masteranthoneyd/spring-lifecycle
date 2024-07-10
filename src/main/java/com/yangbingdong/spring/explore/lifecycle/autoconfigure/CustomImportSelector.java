package com.yangbingdong.spring.explore.lifecycle.autoconfigure;

import com.yangbingdong.spring.explore.lifecycle.LogUtil;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author bingdong.yang@salesforce-china.com
 */
public class CustomImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        LogUtil.log("根据返回的字符串注册bean",
                "ImportSelector", "selectImports");
        return new String[0];
    }
}
