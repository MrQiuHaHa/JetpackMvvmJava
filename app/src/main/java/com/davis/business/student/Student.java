package com.davis.business.student;

public class Student {
    public int id;
    public String name;
    public int age;
    public int height;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
