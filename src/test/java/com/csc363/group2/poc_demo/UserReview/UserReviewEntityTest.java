package com.csc363.group2.poc_demo.UserReview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserReviewEntityTest {

    UserReviewEntity userReview = new UserReviewEntity(
            "leodpenrose@gmail.com",
            "CSC",
            101,
            4.0,
            5,
            true,
            false,
            "Loved it!"
    );

    @Test
    void getUserReviewCourseNumber() {
        assertEquals(101, userReview.getUserReviewCourseNumber());
    }

    @Test
    void setUserReviewCourseNumber() {
        userReview.setUserReviewCourseNumber(500);
        assertEquals(500, userReview.getUserReviewCourseNumber());
    }

    @Test
    void getUserReviewEmail() {
        assertEquals("leodpenrose@gmail.com", userReview.getUserReviewEmail());
    }

    @Test
    void setUserReviewEmail() {
        userReview.setUserReviewEmail("leodpenrose@hotmail.com");
        assertEquals("leodpenrose@hotmail.com", userReview.getUserReviewEmail());
    }

    @Test
    void getUserReviewDepartment() {
        assertEquals("CSC", userReview.getUserReviewDepartment());

    }

    @Test
    void setUserReviewDepartment() {
        userReview.setUserReviewDepartment("SE");
        assertEquals("SE", userReview.getUserReviewDepartment());
    }

    @Test
    void getUserReviewGPA() {
        assertEquals(4.0, userReview.getUserReviewGPA());

    }

    @Test
    void setUserReviewGPA() {
        userReview.setUserReviewGPA(5.0);
        assertEquals(5.0, userReview.getUserReviewGPA());

    }

    @Test
    void getUserReviewDifficulty() {
        assertEquals(5, userReview.getUserReviewDifficulty());
    }

    @Test
    void setUserReviewDifficulty() {
        userReview.setUserReviewDifficulty(10);
        assertEquals(10, userReview.getUserReviewDifficulty());
    }

    @Test
    void getUserReviewLike() {
        assertEquals(true, userReview.getUserReviewLike());
    }

    @Test
    void setUserReviewLike() {
        userReview.setUserReviewLike(false);
        assertEquals(false, userReview.getUserReviewLike());

    }

    @Test
    void getUserReviewDislike() {
        assertEquals(false, userReview.getUserReviewDislike());
    }

    @Test
    void setUserReviewDislike() {
        userReview.setUserReviewDislike(true);
        assertEquals(true, userReview.getUserReviewDislike());

    }

    @Test
    void getUserReviewId() {
        assertEquals(null, userReview.getUserReviewID());
    }



    @Test
    void getUserReviewFeedback() {
        assertEquals("Loved it!", userReview.getUserReviewFeedback());
    }

    @Test
    void setUserReviewFeedback() {
        userReview.setUserReviewFeedback("I Loved It!!");
        assertEquals("I Loved It!!", userReview.getUserReviewFeedback());
    }

}