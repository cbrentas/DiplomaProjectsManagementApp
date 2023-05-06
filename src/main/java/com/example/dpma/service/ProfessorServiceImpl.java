package com.example.dpma.service;

import com.example.dpma.dao.ProfessorDAO;
import com.example.dpma.dao.SubjectDAO;
import com.example.dpma.model.Professor;
import com.example.dpma.model.Student;
import com.example.dpma.model.Subject;
import com.example.dpma.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    ProfessorDAO professorDAO;




    @Override
    public void saveProfile(Professor professor) {
        professorDAO.save(professor);

    }

    @Override
    public Professor findProfessorByUserId(int userId) {

        return professorDAO.findByUserId(userId);
    }

    @Override
    public void saveSubject(Professor professor,Subject subject){

        professor.addSubject(subject);



    }

    @Override
    public List<Subject> listProfessorSubjects(Professor professor) {

        return professor.getSubjects();
    }


}
