package com.csc363.group2.poc_demo.Repos;

import com.csc363.group2.poc_demo.ClassEntity.ClassEntity;
import com.csc363.group2.poc_demo.UserReview.UserReviewEntity;
import com.csc363.group2.poc_demo.appuser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Long> {

    AppUser getAppUserByEmail(String userEmail);



}
