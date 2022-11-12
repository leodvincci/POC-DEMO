package com.csc363.group2.poc_demo.ClassRepo;

import com.csc363.group2.poc_demo.ClassEntity.ClassEntity;
import com.csc363.group2.poc_demo.appuser.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity,Long> {



    ClassEntity findByDepartmentAndClassNumber(String department, int classNumber);

    List<ClassEntity> findAllByUsers(AppUser user);

}
