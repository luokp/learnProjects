package com.luokp.springcode.Define_annotation_aspect;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyLog {
    String requestUrl();
}
