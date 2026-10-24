package com;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class TestComparable {
    public static void main(String[] args){
        List<Student> list=new ArrayList<>();
        list.add(new Student("张三", 102, 88.5, 175.2));
        list.add(new Student("李四", 101, 92.0, 168.5));
        list.add(new Student("王五", 103, 76.3, 180.1));
        System.out.println("====默认排序(id升序,Comparable)====");
        Collections.sort(list);
        for(Student s:list){
            System.out.println(s);
        }
        System.out.println("\n====成绩降序(ScoreDescComparator)====");
        Collections.sort(list,new ScoreDescComparator());
        for(Student s:list){
            System.out.println(s);
        }
        System.out.println("\n====身高升序(HeightAscComparator)====");
        Collections.sort(list,new HeightAscComparator());
        for(Student s:list){
            System.out.println(s);
        }
    }
}
