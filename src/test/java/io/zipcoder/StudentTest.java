package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void constructorTestFirstName(){
        Double[] scores = {};
        Student s = new Student("Maria Theresa","Hapsburg",scores);
        String expected = "Maria Theresa";

        String actual = s.getFirstName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorTestLastName(){
        Double[] scores = {};
        Student s = new Student("Maria Theresa","Hapsburg",scores);
        String expected = "Hapsburg";

        String actual = s.getLastName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorTestNullScores(){
        Student s = new Student("Maria Theresa", "Hapsburg", null);

        Assert.assertEquals(2,1+1);
    }

    @Test
    public void getExamScoresTest1(){
        Double[] scores = {100d, 90d, 93d};
        Student s = new Student("Maria Theresa", "Hapsburg", scores);
        String expected = "Exam 1 -> 100\nExam 2 -> 90\nExam 3 -> 93\n";

        String actual = s.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExamScoresTest2(){
        Double[] scores = {100d, 90.4, 89.99, 93.457, 93.454};
        Student s = new Student("Maria Theresa", "Hapsburg", scores);
        String expected = "Exam 1 -> 100\nExam 2 -> 90.4\nExam 3 -> 89.99\nExam 4 -> 93.46\nExam 5 -> 93.45\n";

        String actual = s.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExamScoreTest3(){
        Double[] scores = {};
        Student s = new Student("Maria Theresa", "Hapsburg", scores);
        String expected = "";

        String actual = s.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExamScoreTest4(){
        Double[] scores = null;
        Student s = new Student("Maria Theresa", "Hapsburg", scores);
        String expected = "";

        String actual = s.getExamScores();

        Assert.assertEquals(expected, actual);
    }

}