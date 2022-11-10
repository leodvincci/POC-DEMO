package com.csc363.group2.poc_demo.ClassController;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassModelBodyTest {

    ClassModelBody classModel = new ClassModelBody(
            "Computer Science I",
            "Learn computer science",
            "CSC",
            101,
            0.0,
            0.0,
            0,
            0
    );

    @Test
    void getClassName() {
        assertEquals("Computer Science I",classModel.getClassName());
    }

    @Test
    void getClassDescription() {
        assertEquals("Learn computer science",classModel.getClassDescription());

    }

    @Test
    void getDepartment() {
        assertEquals("CSC",classModel.getDepartment());

    }

    @Test
    void getClassNumber() {
        assertEquals(101,classModel.getClassNumber());

    }

    @Test
    void getCumGPA() {
        assertEquals(0.0,classModel.getCumGPA());

    }

    @Test
    void getCumDif() {
        assertEquals(0.0,classModel.getCumDif());

    }

    @Test
    void getLikes() {
        assertEquals(0,classModel.getLikes());

    }

    @Test
    void getDislikes() {
        assertEquals(0,classModel.getDislikes());

    }
}