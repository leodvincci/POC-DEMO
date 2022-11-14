package com.csc363.group2.poc_demo.ClassRepo;

import com.csc363.group2.poc_demo.ClassEntity.ClassEntity;
import com.csc363.group2.poc_demo.appuser.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity,Long> {



    ClassEntity findByDepartmentAndClassNumber(String department, int classNumber);

    List<ClassEntity> findAllByUsers(AppUser user);

    @Transactional
    @Modifying
    @Query(value = "delete from student_course_map where course_id= course_id and appuser_id= appuser_id ",nativeQuery = true)
    void deleteByClassNumberAndUserId(int course_id, Long appuser_id);



}
