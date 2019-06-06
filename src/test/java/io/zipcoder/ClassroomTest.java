package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ClassroomTest {

    @Test
    public void constructorIntegerTest(){
        Classroom c = new Classroom(10);
        Student[] expected = new Student[10];

        Student[] actual = c.getStudents();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorStudentArrayTest1(){
        Student[] expected = new Student[30];
        Classroom c = new Classroom(new Student[7]);

        Student[] actual = c.getStudents();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorStudentArrayTest2(){
        Student[] expected = new Student[35];
        Classroom c = new Classroom(expected);

        Student[] actual = c.getStudents();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorDefaultTest(){
        Student[] expected = new Student[30];
        Classroom c = new Classroom(expected);

        Student[] actual = c.getStudents();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getAverageExamScoreTest(){
        Double[] s1Scores = {100d, 150d};
        Double[] s2Scores = {225d, 25d};
        Student s1 = new Student("Student", "One", s1Scores);
        Student s2 = new Student("Student", "Two", s2Scores);

        Student[] students = {s1, s2};
        Classroom classroom = new Classroom(students);
        Double expected = 125d;

        Double actual = classroom.getAverageExamScore();

        Assert.assertEquals(expected, actual);

    }

//    @Test
//    public void addStudentTest1(){
//        Integer maxNumberOfStudents = 1;
//        Classroom classroom = new Classroom(maxNumberOfStudents);
//        Double[] examScores = {100d, 150d, 250d, 0d};
//        Student student = new Student("Leon", "Hunter", examScores);
//
//        Student[] preEnrollment = classroom.getStudents();
//        classroom.addStudent(student);
//        Student[] postEnrollment = classroom.getStudents();
//
//        // Then
//        String preEnrollmentAsString = Arrays.toString(preEnrollment);
//        String postEnrollmentAsString = Arrays.toString(postEnrollment);
//
//        System.out.println("===========================");
//        System.out.println(preEnrollmentAsString);
//        System.out.println("===========================");
//        System.out.println(postEnrollmentAsString);
//    }

    @Test
    public void addStudentTest2(){
        Integer maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = {100d, 150d, 250d, 0d};
        Student student = new Student("Leon", "Hunter", examScores);
        String expected = "Student Name: Leon Hunter\n> Average Score: 125\n> Exam Scores:\n    Exam 1 -> 100\n" +
                "    Exam 2 -> 150\n    Exam 3 -> 250\n    Exam 4 -> 0\n";


        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        String actual = postEnrollment[0].toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addStudentTest3(){
        Integer maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = {100d, 150d, 250d, 0d};
        Student student = new Student("Leon", "Hunter", examScores);
        classroom.addStudent(student);

        Student stu = new Student("Beef", "Stew", null);

        Assert.assertFalse(classroom.addStudent(stu));
    }

    @Test
    public void addStudentTest4(){
        Integer maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = {100d, 150d, 250d, 0d};
        Student student = new Student("Leon", "Hunter", examScores);

        Assert.assertTrue(classroom.addStudent(student));

    }


    @Test
    public void orderStudentsTest0(){
        Double[] examScores = {100d, 150d, 250d, 0d};
        Student student = new Student("Leon", "Hunter", examScores);
        Student stu = new Student("Beef", "Stew", null);
        Student[] expected = {null, student, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, stu, null, null, null, null};
        Classroom classroom = new Classroom(expected);
        //Student[] expected = {student, stu, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};

        //classroom.orderStudents();
        Student[] actual = classroom.getStudents();

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void orderStudentsTest1(){
        Double[] examScores = {100d, 150d, 250d, 0d};
        Student student = new Student("Leon", "Hunter", examScores);
        Student stu = new Student("Beef", "Stew", null);
        Student[] students = {null, student, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, stu, null, null, null, null};
        Classroom classroom = new Classroom(students);
        Student[] expected = {student, stu, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};

        classroom.orderStudents();
        Student[] actual = classroom.getStudents();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTest1(){
        Double[] examScores = {100d, 150d, 250d, 0d};
        Student student = new Student("Leon", "Hunter", examScores);
        Student stu = new Student("Beef", "Stew", null);
        Student[] students = {student, stu, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};
        Classroom classroom = new Classroom(students);
        Student[] expected = {stu, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};

        classroom.remove("Leon", "Hunter");
        Student[] actual = classroom.getStudents();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getStudentsByScoreTest1(){

        Double[] scores1 = {100.0, 150.0, 250.0, 0.0};
        Student s1 = new Student("Leon","Hunter", scores1);

        Double[] scores2 = {100d, 90.4, 89.99, 93.457, 93.454};
        Student s2 = new Student("Maria Theresa", "Hapsburg", scores2);

        Double[] scores3 = {30d};
        Student s3 = new Student("Beef", "Stew", scores3);

        Student[] students = {s1, s2, s3};
        Classroom classroom = new Classroom(students);

        Student[] expected = {s3,s2,s1};
        Student[] actual = classroom.getStudentsByScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getStudentsByScoreTest2(){

        Double[] scores1 = {100.0, 150.0, 250.0, 0.0};
        Student s1 = new Student("Leon","Hunter", scores1);

        Double[] scores2 = {100d, 90.4, 89.99, 93.457, 93.454};
        Student s2 = new Student("Maria Theresa", "Hapsburg", scores1);

        Double[] scores3 = {30d};
        Student s3 = new Student("Beef", "Stew", scores1);

        Student[] students = {s1, s2, s3};
        Classroom classroom = new Classroom(students);

        Student[] expected = {s2,s1,s3};
        Student[] actual = classroom.getStudentsByScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getStudentsByScoreTest3(){

        Double[] scores1 = {100.0, 150.0, 250.0, 0.0};
        Student s1 = new Student("Leon","Hapsburg", scores1);

        Double[] scores2 = {100d, 90.4, 89.99, 93.457, 93.454};
        Student s2 = new Student("Maria Theresa", "Hapsburg", scores1);

        Double[] scores3 = {30d};
        Student s3 = new Student("Beef", "Hapsburg", scores1);

        Student[] students = {s1, s2, s3};
        Classroom classroom = new Classroom(students);

        Student[] expected = {s3,s1,s2};
        Student[] actual = classroom.getStudentsByScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getGradeBookTest1(){
        Double[] scores1 = {100.0, 150.0, 250.0, 0.0};  // 125
        Student s1 = new Student("Leon","Hunter", scores1);

        Double[] scores2 = {100d, 90.4, 89.99, 93.457, 93.454}; // 93.4602
        Student s2 = new Student("Maria Theresa", "Hapsburg", scores2);

        Double[] scores3 = {30d}; // 30
        Student s3 = new Student("Beef", "Stew", scores3);

        Double[] scores4 = {150.0, 150.0, 300.0, 100.0};  // 175
        Student s4 = new Student("Otto", "Bismarck", scores4);

        Double[] scores5 = {20d, 60d, 57d};  // 69
        Student s5 = new Student("Autobahn", "Bismark", scores5);

        Double[] scores6 = {100d, 50d, 88d, 79d}; // 79.25
        Student s6 = new Student("Manlius", "Aquillius", scores6);

        Double[] scores7 = {55d}; // 55
        Student s7 = new Student("Didius", "Julianus", scores7);

        Double[] scores8 = {145.5}; // 145.5
        Student s8 = new Student("Marcus", "Aurelius", scores8);

        Double[] scores9 = {501.0}; // 501
        Student s9 = new Student("Darth", "Vader", scores9);

        Double[] scores10 = {4d}; //4
        Student s10 = new Student("Wilhelm", "Hohenzollern", scores10);

        Student[] students = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10};
        Classroom classroom = new Classroom(students);

        Map<Student, String> gradeBook = classroom.getGradeBook();

        for(Map.Entry<Student, String> entry: gradeBook.entrySet()){
            System.out.printf("%s, %s: %s\n", entry.getKey().getLastName(), entry.getKey().getFirstName(), entry.getValue());
        }
    }
}


