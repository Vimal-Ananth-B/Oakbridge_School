package com.jap.marksevaluation.commander;

import com.jap.marksevaluation.OakBridgeSchool;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class OakBridgeSchoolTest
{
    int [] math;
    int [] science;
    int [] english;
    int noOfSubjects;
    String[] studentNames;
    int [] rollNos;
    OakBridgeSchool oakBridgeSchool;
    @Before
    public void setUp(){
        oakBridgeSchool = new OakBridgeSchool();
        math  = new int[]{88, 89, 100, 70, 60, 80, 35, 3, 25, 56};
        science = new int[]{80, 83, 99, 67, 56, 84, 38, 9, 32, 65};
        english = new int[]{90, 98, 100, 65, 54, 82, 40, 13, 45, 67};
        noOfSubjects = 3;
        studentNames = new String[]{"Michelle", "Kate", "Ann", "Tina", "Tom", "Sam", "Ria", "Pam", "Leena", "Leo"};
        rollNos = new int[]{102, 109, 101, 103, 104, 108, 110, 105, 106, 107};
    }
    @After
    public void tearDown(){
        math  = null;
        science = null;
        english = null;
        noOfSubjects = 0;
        studentNames = null;
        rollNos = null;
        oakBridgeSchool = null;
    }

    @Test
    public  void givenMarksCalculateTotalAndReturnAnArraySuccess(){
        int[] expectedTotal = {258, 270, 299, 202, 170, 246, 113, 25, 102, 188};
        assertArrayEquals(expectedTotal,oakBridgeSchool.calculateTotalMarks(math,science,english));

    }
    @Test
    public  void givenMarksCalculateTotalAndReturnAnArrayFailure(){
        assertEquals(0,oakBridgeSchool.calculateTotalMarks(new int[0],science,english).length);
        assertEquals( 0,oakBridgeSchool.calculateTotalMarks(math,science,new int[0]).length);
        assertEquals( 0,oakBridgeSchool.calculateTotalMarks(math,new int[0],english).length);
        assertEquals( 0,oakBridgeSchool.calculateTotalMarks(new int[0],new int[0],new int[0]).length);
    }

    @Test
    public  void givenTotalMarksArrayAndNumberOfSubjectsCalculateAverageReturnAnArraySuccess(){
        int[] totalArray = {258, 270, 299, 202, 170, 246, 113, 25, 102, 188};
        int[] expectedAverage = {86, 90, 99, 67, 56, 82, 37, 8, 34, 62};
        assertArrayEquals(expectedAverage,oakBridgeSchool.calculateTotalAverageMarksForEachStudent(totalArray,noOfSubjects));
    }
    @Test
    public void givenTotalMarksInArraysSortInAscendingOrder(){
        int[] totalMarks = {258, 270, 299, 202, 170, 246, 113, 25, 102, 188};
        int[] expectedSortedTotalMarksOfClass = {25,102,113,170,188,202,246,258,270,299};
        assertArrayEquals(expectedSortedTotalMarksOfClass,oakBridgeSchool.sortByTotalMarks(totalMarks));
    }
    @Test public void givenEmptyArrayReturnEmptyArray(){
        int[] totalMarks = {};
        assertEquals( 0,oakBridgeSchool.sortByTotalMarks(totalMarks).length);
    }
    @Test
    public void givenMathMarkFindGrade(){
        assertEquals('A',oakBridgeSchool.findGradeInMath(99));
        assertEquals('B',oakBridgeSchool.findGradeInMath(81));
        assertEquals('C',oakBridgeSchool.findGradeInMath(73));
        assertEquals('D',oakBridgeSchool.findGradeInMath(64));
        assertEquals('F',oakBridgeSchool.findGradeInMath(54));
        assertEquals('F',oakBridgeSchool.findGradeInMath(44));
        assertEquals('F',oakBridgeSchool.findGradeInMath(13));
    }
    @Test
    public void givenScienceMarkFindGrade(){
        assertEquals('A',oakBridgeSchool.findGradeInScience(90));
        assertEquals('B',oakBridgeSchool.findGradeInScience(80));
        assertEquals('C',oakBridgeSchool.findGradeInScience(70));
        assertEquals('D',oakBridgeSchool.findGradeInScience(60));
        assertEquals('F',oakBridgeSchool.findGradeInScience(50));
        assertEquals('F',oakBridgeSchool.findGradeInScience(40));
        assertEquals('F',oakBridgeSchool.findGradeInScience(20));
    }
    @Test
    public void givenEnglishMarkFindGrade(){
        assertEquals('A',oakBridgeSchool.findGradeInEnglish(100));
        assertEquals('B',oakBridgeSchool.findGradeInEnglish(88));
        assertEquals('C',oakBridgeSchool.findGradeInEnglish(77));
        assertEquals('D',oakBridgeSchool.findGradeInEnglish(64));
        assertEquals('F',oakBridgeSchool.findGradeInEnglish(51));
        assertEquals('F',oakBridgeSchool.findGradeInEnglish(48));
        assertEquals('F',oakBridgeSchool.findGradeInEnglish(34));
    }


    @Test
    public  void givenTotalMarksArrayAndNumberOfSubjectsCalculateAverageReturnAnArrayFailure(){
        int[] totalArray = {258, 270, 299, 202, 170, 246, 113, 25, 102, 188};
        assertEquals(0,oakBridgeSchool.calculateTotalAverageMarksForEachStudent(totalArray,0).length);
        assertEquals( 0,oakBridgeSchool.calculateTotalAverageMarksForEachStudent(new int[0],3).length);
        assertEquals( 0,oakBridgeSchool.calculateTotalAverageMarksForEachStudent(new int[0],0).length);
    }

    @Test
    public  void givenMathMarksArrayOfClassReturnAverageSuccess(){
        double expectedMathAverage = 60.6;
        assertEquals(expectedMathAverage,oakBridgeSchool.calculateAverageMathMarks(math,10),0);
    }

    @Test
    public  void givenScienceMarksArrayOfClassReturnAverageSuccess(){
        double expectedScienceAverage = 61.3;
        assertEquals(expectedScienceAverage,oakBridgeSchool.calculateAverageScienceMarks(science,10),0);
    }

    @Test
    public  void givenEnglishMarksArrayOfClassReturnAverageSuccess(){
        double expectedEnglishAverage = 65.4;
        assertEquals(expectedEnglishAverage,oakBridgeSchool.calculateAverageEnglishMarks(english,10),0);
    }


    @Test
    public void givenNameArrayReturnTrueIfNamesAreRepeatedOrFalse(){
        assertFalse(oakBridgeSchool.checkIfNamesAreRepeated(studentNames));
        assertTrue(oakBridgeSchool.checkIfNamesAreRepeated(new String[]{"John","John","Anne","Pam"}));
        assertTrue(oakBridgeSchool.checkIfNamesAreRepeated(new String[]{"John","Gary","Anne","John"}));
        assertTrue(oakBridgeSchool.checkIfNamesAreRepeated(new String[]{"John","John","John","Pam"}));
        assertFalse(oakBridgeSchool.checkIfNamesAreRepeated(new String[]{"Mathew","John","Anne","Pam"}));
        assertFalse(oakBridgeSchool.checkIfNamesAreRepeated(new String[]{"John"}));
    }

    @Test
    public void testGenerateResultMessage() {
        int[] totalScores = oakBridgeSchool.calculateTotalMarks(math,science,english);
        StringBuilder[] resultMessages = oakBridgeSchool.generateResultMessage(studentNames, totalScores);
        assertNotNull(resultMessages);
        assertEquals(studentNames.length, resultMessages.length);
        assertEquals("Hi Michelle you have secured 258", resultMessages[0].toString());
    }


}
