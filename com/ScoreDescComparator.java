package com;
import java.util.Comparator;
public class ScoreDescComparator implements Comparator<Student>{
    public int compare(Student s1,Student s2){
        return Double.compare(s2.getScore(), s1.getScore());
    }
}
