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
        sbuild.append("Exam Scores:\n");
        for(int i = 0; i < examScores.size(); i++){
            sbuild.append(String.format("    Exam %d -> %s\n",i+1,df.format(examScores.get(i))));
        }
        return sbuild.toString();
    }

    public Integer getNumberOfExamsTaken(){
        return examScores.size();
    }

    public void addExamScore(double examScore){
        examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore) throws InvalidExamNumberException{
        if(examNumber < 1 || examNumber > examScores.size()){
            throw new InvalidExamNumberException();
        }
        examScores.set(examNumber - 1, newScore);
    }

    public Double getAverageExamScore(){
        if(examScores.size() == 0){
            return Double.NaN;
        }

        Double sum = 0d;
        for(Double score : examScores){
            sum += score;
        }
        return sum/examScores.size();
    }

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("Student Name: %s %s\n> Average Score: %s\n> %s", firstName, lastName,
                df.format(getAverageExamScore()), getExamScores());
    }
}
