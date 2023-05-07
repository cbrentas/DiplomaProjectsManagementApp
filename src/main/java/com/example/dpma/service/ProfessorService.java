package com.example.dpma.service;

import com.example.dpma.model.Application;
import com.example.dpma.model.Professor;
import com.example.dpma.model.Student;
import com.example.dpma.model.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessorService {

    public void saveProfile(Professor professor);

    public Professor findProfessorByUserId(int userId);

    public void saveSubject(Professor professor, Subject subject);

    public List<Subject> listProfessorSubjects(Professor professor);

    public List<Application> listApplications(Integer subjectId, Professor professor);
}
