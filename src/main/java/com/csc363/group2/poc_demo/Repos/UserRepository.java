package com.csc363.group2.poc_demo.Repos;

import com.csc363.group2.poc_demo.appuser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Long> {
}
