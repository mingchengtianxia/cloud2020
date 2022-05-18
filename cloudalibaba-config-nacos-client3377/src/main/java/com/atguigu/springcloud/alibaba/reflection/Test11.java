package com.atguigu.springcloud.alibaba.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

//反射获取泛型
public class Test11 {

    public static void test1(Map<String, User> map, List<User> list){

    }

    public Map<String, User> test2(){
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        //反射获取方法
        Method method = Test11.class.getDeclaredMethod("test1", Map.class, List.class);
        //获取泛型参数类型
        Type[] genericTypes = method.getGenericParameterTypes();
        for (Type genericType : genericTypes) {
            System.out.println(genericType);
            //如果泛型参数类型是参数化类型
            if(genericType instanceof ParameterizedType){
                Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("\tacturalType "+actualTypeArgument);
                }
            }
        }

        method = Test11.class.getDeclaredMethod("test2", null);
        //获取泛型返回类型
        Type genericReturnType = method.getGenericReturnType();
        System.out.println("#return:"+genericReturnType);
        if(genericReturnType instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("\tacturalType "+actualTypeArgument);
            }
        }
    }
}
