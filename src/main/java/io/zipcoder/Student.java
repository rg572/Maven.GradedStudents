package io.zipcoder;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        examScores = new ArrayList<>();
        if(testScores != null) {
            examScores.addAll(Arrays.asList(testScores));
        }
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getExamScores(){
        StringBuilder sbuild = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.##");
        for(int i = 0; i < examScores.size(); i++){
            sbuild.append(String.format("Exam %d -> %s\n",i+1,df.format(examScores.get(i))));
        }
        return sbuild.toString();
    }

    public Integer getNumberOfExamsTaken(){
        return examScores.size();
    }
}
