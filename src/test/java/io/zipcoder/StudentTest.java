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

    @Test
    public void getNumberOfExamsTakenTest1(){
        Double[] scores = {100d, 90.4, 89.99, 93.457, 93.454};
        Student s = new Student("Maria Theresa", "Hapsburg", scores);
        Integer expected = 5;

        Integer actual = s.getNumberOfExamsTaken();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNumberOfExamsTakenTest2(){
        Double[] scores = {};
        Student s = new Student("Maria Theresa", "Hapsburg", scores);
        Integer expected = 0;

        Integer actual = s.getNumberOfExamsTaken();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNumberOfExamsTakenTest3(){
        Student s = new Student("Maria Theresa", "Hapsburg", null);
        Integer expected = 0;

        Integer actual = s.getNumberOfExamsTaken();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addExamScoreTest1(){
        Student s = new Student("Maria Theresa", "Hapsburg", null);
        Integer expected = 1;

        s.addExamScore(100d);
        Integer actual = s.getNumberOfExamsTaken();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addExamScoreTest2(){
        Student s = new Student("Maria Theresa", "Hapsburg", null);
        String expected = "Exam 1 -> 100\n";

        s.addExamScore(100d);
        String actual = s.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addExamScoreTest3(){
        Double[] scores = {100d, 90d, 93d};
        Student s = new Student("Maria Theresa", "Hapsburg", scores);
        String expected = "Exam 1 -> 100\nExam 2 -> 90\nExam 3 -> 93\nExam 4 -> 89.5\n";

        s.addExamScore(89.5);
        String actual = s.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = InvalidExamNumberException.class)
    public void setExamScoreTest1() throws InvalidExamNumberException{
        Double[] scores = {100d, 90d, 93d};
        Student s = new Student("Maria Theresa", "Hapsburg", scores);
        s.setExamScore(4, 99d);
    }

    @Test(expected = InvalidExamNumberException.class)
    public void setExamScoreTest2() throws InvalidExamNumberException{
        Double[] scores = {100d, 90d, 93d};
        Student s = new Student("Maria Theresa", "Hapsburg", scores);
        s.setExamScore(0, 99d);
    }

    @Test
    public void setExamScoreTest3() throws InvalidExamNumberException{
        Double[] scores = {100d, 90d, 93d};
        Student s = new Student("Maria Theresa", "Hapsburg", scores);
        String expected = "Exam 1 -> 100\nExam 2 -> 99.9\nExam 3 -> 93\n";

        s.setExamScore(2, 99.9);
        String actual = s.getExamScores();

        Assert.assertEquals(expected, actual);
    }

}