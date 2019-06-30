package com.yanghui.study.config.database;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Inherited
public @interface TargetDataSource {

    String value();
}
