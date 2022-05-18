package com.atguigu.springcloud.alibaba.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test07 {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c1 = Class.forName("com.atguigu.springcloud.alibaba.reflection.User");
        //利用反射实例化对象，必须要有无参构造函数
        User user1 = (User) c1.newInstance();
        System.out.println(user1);

        //通过反射找到带参构造函数，实例化
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User)constructor.newInstance("demo", 1, 12);
        System.out.println(user2);

        //通过反射获取一个方法
        Method method = c1.getDeclaredMethod("setName", String.class);
        //invoke 激活方法， 参数为（对象, 方法的值）
        method.invoke(user1, "test");
        System.out.println(user1.getName());

        //通过反射获取属性，  name为private的
        Field name = c1.getDeclaredField("name");
        //不能直接操作私有属性，设置可访问为true
        name.setAccessible(true);
        name.set(user2, "filedTest");
        System.out.println(user2.getName());
    }
}
