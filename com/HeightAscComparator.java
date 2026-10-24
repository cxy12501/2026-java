package com;
import java.util.Comparator;
public class HeightAscComparator implements Comparator<Student>{
    public int compare(Student s1,Student s2){
        return Double.compare(s1.getHeight(), s2.getHeight());
    }
}
