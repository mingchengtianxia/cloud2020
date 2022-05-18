package com.atguigu.springcloud.alibaba.annotation;

import java.lang.annotation.*;

public class AnnotationTest {

    @MyAnnotation(name="xmg")
    private static  void test1(){

    }

    public static void main(String[] args) {
        test1();
    }

}


@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    //注解的参数：  参数类型+参数名();
    String name() default "";
    int age() default 0;
    int id() default -1; //如果默认值为-1，表示不存在

    String[] schools() default {"西北","清华"};
}



@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotation1{
    //注解的参数：  参数类型+参数名();
    String name() default "";
}

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    String value() default "";
}