package com.csc363.group2.poc_demo.UserReview;

import com.csc363.group2.poc_demo.ClassEntity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReviewRepo extends JpaRepository <UserReviewEntity,Long> {

    List<UserReviewEntity> getUserReviewEntitiesByUserReviewDepartmentAndUserReviewCourseNumber(String department, int courseNumber);

}
