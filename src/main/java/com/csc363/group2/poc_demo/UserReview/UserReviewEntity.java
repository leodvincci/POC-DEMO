package com.csc363.group2.poc_demo.UserReview;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserReviewEntity {

    @SequenceGenerator(
            name = "userReview_sequence",
            sequenceName = "userReview_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userReview_sequence"
    )
    Long userReviewID;

    String userReviewEmail;
    String userReviewDepartment;

    public int getUserReviewCourseNumber() {
        return userReviewCourseNumber;
    }

    public void setUserReviewCourseNumber(int userReviewCourseNumber) {
        this.userReviewCourseNumber = userReviewCourseNumber;
    }

    int userReviewCourseNumber;
    Double userReviewGPA;
    Integer userReviewDifficulty;
    Boolean userReviewLike;
    Boolean userReviewDislike;
    String userReviewFeedback;

    public String getUserReviewEmail() {
        return userReviewEmail;
    }

    public void setUserReviewEmail(String userReviewEmail) {
        this.userReviewEmail = userReviewEmail;
    }

    public String getUserReviewDepartment() {
        return userReviewDepartment;
    }

    public void setUserReviewDepartment(String userReviewCourse) {
        this.userReviewDepartment = userReviewCourse;
    }

    public Double getUserReviewGPA() {
        return userReviewGPA;
    }

    public void setUserReviewGPA(Double userReviewGPA) {
        this.userReviewGPA = userReviewGPA;
    }

    public Integer getUserReviewDifficulty() {
        return userReviewDifficulty;
    }

    public void setUserReviewDifficulty(Integer userReviewDifficulty) {
        this.userReviewDifficulty = userReviewDifficulty;
    }

    public Boolean getUserReviewLike() {
        return userReviewLike;
    }

    public void setUserReviewLike(Boolean userReviewLike) {
        this.userReviewLike = userReviewLike;
    }

    public Boolean getUserReviewDislike() {
        return userReviewDislike;
    }

    public void setUserReviewDislike(Boolean userReviewDislike) {
        this.userReviewDislike = userReviewDislike;
    }

    public String getUserReviewFeedback() {
        return userReviewFeedback;
    }

    public void setUserReviewFeedback(String userReviewFeedback) {
        this.userReviewFeedback = userReviewFeedback;
    }

    @Override
    public String toString() {
        return "UserReviewEntity{" +
                "userReviewEmail='" + userReviewEmail + '\'' +
                ", userReviewCourse='" + userReviewDepartment + '\'' +
                ", userReviewGPA=" + userReviewGPA +
                ", userReviewDifficulty=" + userReviewDifficulty +
                ", userReviewLike=" + userReviewLike +
                ", userReviewDislike=" + userReviewDislike +
                ", userReviewFeedback='" + userReviewFeedback + '\'' +
                '}';
    }

    public UserReviewEntity() {
    }

    public Long getUserReviewID() {
        return userReviewID;
    }

    public void setUserReviewID(Long userReviewID) {
        this.userReviewID = userReviewID;
    }

    public UserReviewEntity(String userReviewEmail, String userReviewDepartment, int userReviewCourseNumber, Double userReviewGPA, Integer userReviewDifficulty, Boolean userReviewLike, Boolean userReviewDislike, String userReviewFeedback) {
        this.userReviewEmail = userReviewEmail;
        this.userReviewDepartment = userReviewDepartment;
        this.userReviewCourseNumber = userReviewCourseNumber;
        this.userReviewGPA = userReviewGPA;
        this.userReviewDifficulty = userReviewDifficulty;
        this.userReviewLike = userReviewLike;
        this.userReviewDislike = userReviewDislike;
        this.userReviewFeedback = userReviewFeedback;
    }
}
