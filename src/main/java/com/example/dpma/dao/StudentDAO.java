package com.example.dpma.dao;

import com.example.dpma.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<Student, Integer> {




}
