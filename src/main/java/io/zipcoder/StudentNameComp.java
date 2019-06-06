package io.zipcoder;

import java.util.Comparator;

public class StudentNameComp implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getLastName().compareTo(o2.getLastName()) == 0){
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
        else {
            return o1.getLastName().compareTo(o2.getLastName());
        }
    }
}
