package com.csc363.group2.poc_demo.ClassEntity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassEntityTest {

    ClassEntity classEntity = new ClassEntity(
            42L,
            "Intro To Coding",
            "A Good Class",
            "Computer Science",
            101,
            4.0,
            5,
            10,
            2);

    @Test
    void getDepartment() {
        assertEquals("Computer Science",classEntity.getDepartment());
    }

    @Test
    void setDepartment() {

    }

    @Test
    void getClassName() {
    }

    @Test
    void setClassName() {
    }

    @Test
    void getClassDescription() {
    }

    @Test
    void setClassDescription() {
    }

    @Test
    void getClassNumber() {
    }

    @Test
    void setClassNumber() {
    }

    @Test
    void getCumGPA() {
    }

    @Test
    void setCumGPA() {
    }

    @Test
    void getCumDif() {
    }

    @Test
    void setCumDif() {
    }

    @Test
    void getLikes() {
    }

    @Test
    void setLikes() {
    }

    @Test
    void getDislikes() {
    }

    @Test
    void setDislikes() {
    }
}