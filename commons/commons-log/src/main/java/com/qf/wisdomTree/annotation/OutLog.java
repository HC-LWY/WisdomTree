package com.qf.wisdomTree.annotation;


import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OutLog {

    String user() default "";

    String resources();

    String operation();

    String remarks() default "";

    String Operation_Add="添加";

    String Operation_Put="修改";

    String Operation_Del="删除";

}
