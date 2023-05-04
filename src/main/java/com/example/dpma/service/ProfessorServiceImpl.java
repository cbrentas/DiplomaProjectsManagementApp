package com.example.dpma.service;

import com.example.dpma.dao.ProfessorDAO;
import com.example.dpma.model.Professor;
import com.example.dpma.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
}
