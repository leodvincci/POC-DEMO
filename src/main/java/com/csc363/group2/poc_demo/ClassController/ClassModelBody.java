package com.csc363.group2.poc_demo.ClassController;

import com.csc363.group2.poc_demo.appuser.AppUserRole;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ClassModelBody {

    String className;
    String classDescription;
    String department;
    int classNumber;
    double cumGPA;
    double cumDif;
    int likes;
    int dislikes;
}
