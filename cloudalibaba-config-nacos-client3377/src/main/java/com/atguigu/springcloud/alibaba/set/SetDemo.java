package com.atguigu.springcloud.alibaba.set;

import java.util.*;

public class SetDemo {


    public static void main(String[] args) {
//        TreeSet<Student> treeSet = new TreeSet<>();
//        treeSet.add(new Student(1));
//        treeSet.add(new Student(1));
//        System.out.println(treeSet.size());
//
//        HashSet<Student> hashSet = new HashSet<>();
//        hashSet.add(new Student(1));
//        hashSet.add(new Student(1));
//        System.out.println(hashSet.size());
//
//        TreeSet<Teacher> treeSet2 = new TreeSet<>();
//        treeSet2.add(new Teacher(1));
//        treeSet2.add(new Teacher(1));
//        System.out.println(treeSet2.size());

//        String line3 = "8613719716 ";
//        int int1=java.lang.Integer.parseInt(line3);

//        System.out.println(Integer.parseInt("abc"));

        System.out.println(Student.a);


    }

    public void testList(){
        Plate<? extends People> teacher = new Plate<Teacher>(new Teacher(1));
        List<? super Student> students = new ArrayList<>();
//        teacher.set(new Teacher1(1));
    }
}



class Teacher1 extends Teacher{

    public Teacher1(int id) {
        super(id);
    }
}

class Student implements Comparable{
    private int id;
    public Student(int id){
        this.id = id;
    }

    static{
        System.out.println("ab");
    }
    static int a = 10;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Student){
            Student student = (Student) o;
            if(student.getId() == this.getId()){
                return 0;
            }else{
                return student.getId() > this.getId()?1:-1;
            }
        }
        return 0;
    }
}

class People{

}

class Teacher extends People{
    private int id;
    public Teacher(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher student = (Teacher) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int compareTo(Object o) {
        if(o instanceof Teacher){
            Teacher student = (Teacher) o;
            if(student.getId() == this.getId()){
                return 0;
            }else{
                return student.getId() > this.getId()?1:-1;
            }
        }
        return 0;
    }
}
