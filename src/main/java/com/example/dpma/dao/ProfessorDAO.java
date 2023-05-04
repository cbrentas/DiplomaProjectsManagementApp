package com.example.dpma.dao;

import com.example.dpma.model.Professor;
import com.example.dpma.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorDAO extends JpaRepository<Professor, Integer> {

    Professor findByUserId(int userId);


}
