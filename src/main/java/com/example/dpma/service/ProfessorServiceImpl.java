package com.example.dpma.service;

import com.example.dpma.dao.ProfessorDAO;
import com.example.dpma.dao.SubjectDAO;
import com.example.dpma.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    ProfessorDAO professorDAO;

    @Autowired
    SubjectService subjectService;


    @Override
    public void saveProfile(Professor professor) {
        professorDAO.save(professor);

    }

    @Override
    public Professor findProfessorByUserId(int userId) {

        return professorDAO.findByUserId(userId);
    }

    @Override
    public void saveSubject(Professor professor, Subject subject) {

        professor.addSubject(subject);


    }

    @Override
    public List<Subject> listProfessorSubjects(Professor professor) {

        return professor.getSubjects();
    }

    @Override
    public List<Application> listApplications(Integer subjectId, Professor professor) {

        return subjectService.findById(subjectId).getApplications();
    }

    @Override
    public void deleteSubject(Professor professor,Integer subjectId) {
        List<Subject> mySubjects = professor.getSubjects();
        for(int i=0; i<mySubjects.size();i++){
            if(mySubjects.get(i).getSubject_id() == subjectId ){
                mySubjects.remove(i);
            }
        }


    }


}
