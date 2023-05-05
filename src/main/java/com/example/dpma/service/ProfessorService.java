package com.example.dpma.service;

import com.example.dpma.model.Professor;
import com.example.dpma.model.Student;
import com.example.dpma.model.Subject;
import org.springframework.stereotype.Service;

@Service
public interface ProfessorService {

    public void saveProfile(Professor professor);

    public Professor findProfessorByUserId(int userId);

    public void saveSubject(String username, Subject subject);
}
