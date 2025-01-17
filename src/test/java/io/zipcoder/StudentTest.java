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
        String expected = "Exam Scores:\n    Exam 1 -> 100\n    Exam 2 -> 90\n    Exam 3 -> 93\n";

        String actual = s.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExamScoresTest2(){
        Double[] scores = {100d, 90.4, 89.99, 93.457, 93.454};
        Student s = new Student("Maria Theresa", "Hapsburg", scores);
        String expected = "Exam Scores:\n    Exam 1 -> 100\n    Exam 2 -> 90.4\n    Exam 3 -> 89.99\n    Exam 4 -> 93.46\n    Exam 5 -> 93.45\n";

        String actual = s.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExamScoreTest3(){
        Double[] scores = {};
        Student s = new Student("Maria Theresa", "Hapsburg", scores);
        String expected = "Exam Scores:\n";

        String actual = s.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExamScoreTest4(){
        Double[] scores = null;
        Student s = new Student("Maria Theresa", "Hapsburg", scores);
        String expected = "Exam Scores:\n";

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
        String expected = "Exam Scores:\n    Exam 1 -> 100\n";

        s.addExamScore(100d);
        String actual = s.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addExamScoreTest3(){
        Double[] scores = {100d, 90d, 93d};
        Student s = new Student("Maria Theresa", "Hapsburg", scores);
        String expected = "Exam Scores:\n    Exam 1 -> 100\n    Exam 2 -> 90\n    Exam 3 -> 93\n    Exam 4 -> 89.5\n";

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
        String expected = "Exam Scores:\n    Exam 1 -> 100\n    Exam 2 -> 99.9\n    Exam 3 -> 93\n";

        s.setExamScore(2, 99.9);
        String actual = s.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScoreTest1(){
        Student s = new Student("Maria Theresa", "Hapsburg", null);
        Double expected = 0d;

        Double actual = s.getAverageExamScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScoreTest2(){
        Double[] scores = {100d, 90d, 93d};
        Student s = new Student("Maria Theresa", "Hapsburg", scores);
        Double expected = 94.3333333333;

        Double actual = s.getAverageExamScore();

        Assert.assertEquals(expected, actual, 0.000000001);
    }

    @Test
    public void getAverageExamScore3(){
        Double[] scores = {100d, 90.4, 89.99, 93.457, 93.454};
        Student s = new Student("Maria Theresa", "Hapsburg", scores);
        Double expected = 93.4602;

        Double actual = s.getAverageExamScore();

        Assert.assertEquals(expected, actual, 0.00000001);
    }

    @Test
    public void toStringTest1(){
        Double[] scores = {100.0, 150.0, 250.0, 0.0};
        Student s = new Student("Leon","Hunter", scores);
        String expected = "Student Name: Leon Hunter\n> Average Score: 125\n> Exam Scores:\n    Exam 1 -> 100\n    Exam 2 -> 150\n    Exam 3 -> 250\n    Exam 4 -> 0\n";

        String actual = s.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareToTest1(){
        Double[] scores1 = {100.0, 150.0, 250.0, 0.0};
        Student s1 = new Student("Leon","Hunter", scores1);

        Double[] scores2 = {100d, 90.4, 89.99, 93.457, 93.454};
        Student s2 = new Student("Maria Theresa", "Hapsburg", scores2);

        int actual = s2.compareTo(s1);

        Assert.assertTrue( actual < 0);
    }

    @Test
    public void compareToTest2(){
        Double[] scores1 = {100.0, 150.0, 250.0, 0.0};
        Student s1 = new Student("Leon","Hunter", scores1);

        //Double[] scores2 = {100d, 90.4, 89.99, 93.457, 93.454};
        Student s2 = new Student("Maria Theresa", "Hapsburg", scores1);

        int actual = s1.compareTo(s2);


        Assert.assertTrue( actual > 0);
    }

    @Test
    public void compareToTest3(){
        Double[] scores1 = {100.0, 150.0, 250.0, 0.0};
        Student s1 = new Student("Leon","Hunter", scores1);

        //Double[] scores2 = {100d, 90.4, 89.99, 93.457, 93.454};
        Student s2 = new Student("Leon", "Hunter", scores1);

        int actual = s2.compareTo(s1);

        Assert.assertTrue( actual == 0);
    }

}