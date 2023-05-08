package com.example.dpma.dao;

import com.example.dpma.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationDAO extends JpaRepository<Application,Integer> {

    public Optional<Application> findApplicationByStudentIdAndSubjectId(Integer student_id, Integer subject_id);

}
