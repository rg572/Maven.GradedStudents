package io.zipcoder;

import java.util.*;

public class Classroom {

    private Student[] students;
    private Integer maxNumberOfStudents;

    public Classroom(Integer maxNumberOfStudents){
        this.maxNumberOfStudents = maxNumberOfStudents;
        students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students){
       if(students.length > 30) {
           this.students = students.clone();
           maxNumberOfStudents = students.length;
           orderStudents();
       }
       else{
           maxNumberOfStudents = 30;
           this.students = Arrays.copyOf(students, maxNumberOfStudents);
           orderStudents();
       }
    }

    public Classroom(){
        maxNumberOfStudents = 30;
        students = new Student[maxNumberOfStudents];
    }

    public Student[] getStudents(){
        return students;
    }

    public Double getAverageExamScore(){
        Double sum = 0d;
        Integer examNumber = 0;

        for(Student s : students){
            if(s != null){
                sum += s.getAverageExamScore() * s.getNumberOfExamsTaken();
                examNumber += s.getNumberOfExamsTaken();
            }
        }
        if(examNumber == 0){
            return 0d;
        }
        else{
            return sum/examNumber;
        }
    }

    public Boolean addStudent(Student student){
        Boolean addedStudent = false;
        for(int i = 0; i < students.length; i++){
            if(students[i] == null){
                students[i] = student;
                addedStudent = true;
                break;
            }
        }
        return addedStudent;
    }

    public void orderStudents(){
        PriorityQueue<Integer> nullPositions =  new PriorityQueue<Integer>();
        for(int i = 0; i < students.length; i++){
            if(students[i] == null){
                nullPositions.add(i);
            }
            else if(nullPositions.size() > 0){
                int firstNull = nullPositions.poll();
                students[firstNull] = students[i];
                students[i] = null;
                nullPositions.add(i);
            }
        }

    }

    public void remove(String firstName, String lastName){
        for(int i = 0; i < students.length; i++){
            if(students[i] != null){
                if(firstName.equals(students[i].getFirstName()) && lastName.equals(students[i].getLastName())){
                    students[i] = null;
                }
            }
        }
        orderStudents();
    }

    public Student[] getStudentsByScore(){
        ArrayList<Student> smartWay = new ArrayList<>();
        for(Student s : students){
            if(s != null){
                smartWay.add(s);
            }
        }
        if(smartWay.size() == 0){
            return new Student[0];
        }
        else {
            Collections.sort(smartWay);
            return smartWay.toArray(new Student[smartWay.size()]);
        }
    }


    public Map<Student, String> getGradeBook(){

        TreeMap<Student, String> gradeBook = new TreeMap<>(new StudentNameComp());
        Student[] sortedStudents = getStudentsByScore();
        double aCutoff = sortedStudents.length * 0.9;
        double bCutoff = sortedStudents.length * 0.7;
        double cCutoff = sortedStudents.length * 0.5;
        double dCutoff = sortedStudents.length * 0.1;

        for(int i = 0; i < sortedStudents.length; i++){
            if(i >= Math.ceil(aCutoff)){
                gradeBook.put(sortedStudents[i], "A");
            } else if (i >= Math.ceil(bCutoff)){
                gradeBook.put(sortedStudents[i], "B");
            } else if (i >= Math.ceil(cCutoff)){
                gradeBook.put(sortedStudents[i], "C");
            } else if (i >= Math.ceil(dCutoff)){
                gradeBook.put(sortedStudents[i], "D");
            } else {
                gradeBook.put(sortedStudents[i], "F");
            }
        }
        return gradeBook;

    }
}
