package com.csc363.group2.poc_demo.ClassRepo;

import com.csc363.group2.poc_demo.ClassEntity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity,Long> {
}
