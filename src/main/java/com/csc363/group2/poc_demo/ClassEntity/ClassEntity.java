package com.csc363.group2.poc_demo.ClassEntity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class ClassEntity {

    @SequenceGenerator(
            name = "class_sequence",
            sequenceName = "class_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "class_sequence"
    )
    Long id;
    String className;
    String classDescription;
    String department;
    int classNumber;
    double cumGPA;
    double cumDif;
    int likes;
    int dislikes;

    public ClassEntity() {
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassDescription() {
        return classDescription;
    }

    public void setClassDescription(String classDescription) {
        this.classDescription = classDescription;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public double getCumGPA() {
        return cumGPA;
    }

    public void setCumGPA(double cumGPA) {
        this.cumGPA = cumGPA;
    }

    public double getCumDif() {
        return cumDif;
    }

    public void setCumDif(double cumDif) {
        this.cumDif = cumDif;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public ClassEntity(Long id, String className, String classDescription, String department, int classNumber, double cumGPA, double cumDif, int likes, int dislikes) {
        this.id = id;
        this.className = className;
        this.classDescription = classDescription;
        this.classNumber = classNumber;
        this.cumGPA = cumGPA;
        this.cumDif = cumDif;
        this.likes = likes;
        this.dislikes = dislikes;
    }
}
