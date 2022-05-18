package com.atguigu.springcloud.alibaba.reflection;

public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c0 = Class.forName("com.atguigu.springcloud.alibaba.reflection.User");
        System.out.println(c0);

        ClassLoader classLoader = c0.getClassLoader();
        System.out.println(classLoader);

        Person student = new Student();
        System.out.println(student.name);

        //方式一：通过对象获得
        Class c1 = student.getClass();
        System.out.println(c1.hashCode());

        //方式二：通过Class.forName获得
        Class c2 = Class.forName("com.atguigu.springcloud.alibaba.reflection.Student");
        System.out.println(c2.hashCode());

        //方式三：通过类名.class获得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        System.out.println(c1.getSuperclass());
    }
}

class Person{
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

}

class Student extends Person{
    public Student(){
        this.name = "学生";
    }
}

class Teacher extends Person{
    public Teacher(){
        this.name = "老师";
    }
}
