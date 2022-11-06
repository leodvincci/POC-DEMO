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
        classEntity.setDepartment("College");
        assertEquals("College",classEntity.getDepartment());
    }

    @Test
    void getClassName() {
        assertEquals("Intro To Coding",classEntity.getClassName());
    }

    @Test
    void setClassName() {
        classEntity.setClassName("Intro to Programming");
        assertEquals("Intro to Programming",classEntity.getClassName());
    }

    @Test
    void getClassDescription() {
        assertEquals("A Good Class",classEntity.getClassDescription());
    }

    @Test
    void setClassDescription() {
        classEntity.setClassDescription("A very good class");
        assertEquals("A very good class",classEntity.getClassDescription());
    }

    @Test
    void getClassNumber() {
        assertEquals(101,classEntity.getClassNumber());
    }

    @Test
    void setClassNumber() {
        classEntity.setClassNumber(202);
        assertEquals(202, classEntity.getClassNumber());
    }

    @Test
    void getCumGPA() {
        assertEquals(4.0, classEntity.getCumGPA());
    }

    @Test
    void setCumGPA() {
        classEntity.setCumGPA(5.0);
        assertEquals(5.0, classEntity.getCumGPA());

    }

    @Test
    void getCumDif() {
        assertEquals(5, classEntity.getCumDif());

    }

    @Test
    void setCumDif() {
        classEntity.setCumDif(45);
        assertEquals(45, classEntity.getCumDif());

    }

    @Test
    void getLikes() {
        assertEquals(10, classEntity.getLikes());

    }

    @Test
    void setLikes() {
        classEntity.setLikes(200);
        assertEquals(200, classEntity.getLikes());
    }

    @Test
    void getDislikes() {
        assertEquals(2, classEntity.getDislikes());
    }

    @Test
    void setDislikes() {
        classEntity.setDislikes(42);
        assertEquals(42, classEntity.getDislikes());
    }

    @Test
    void getId() {
        assertEquals(42, classEntity.getId());
    }

    @Test
    void setId() {
        classEntity.setId(24L);
        assertEquals(24, classEntity.getId());

    }

}