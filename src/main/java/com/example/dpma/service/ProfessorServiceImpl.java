package com.example.dpma.service;

import com.example.dpma.dao.ProfessorDAO;
import com.example.dpma.dao.StudentDAO;
import com.example.dpma.dao.SubjectDAO;
import com.example.dpma.dao.ThesisDAO;
import com.example.dpma.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    ProfessorDAO professorDAO;

    @Autowired
    SubjectService subjectService;

    @Autowired
    SubjectDAO subjectDAO;

    @Autowired
    ThesisDAO thesisDAO;

    @Autowired
    StudentDAO studentDAO;


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
            if(mySubjects.get(i).getId() == subjectId ){
                mySubjects.remove(i);
            }
        }



    }

    @Override
    public void assignSubject(Professor professor, Integer subjectId,String strategy){
        Subject subject = subjectDAO.findById(subjectId).get();
        List<Application> applications = subject.getApplications();
        Student bestStudent = subject.findBestApplicant(strategy, applications);
        Thesis thesis = new Thesis();
        thesis.setProfessor(professor);
        thesis.setSubject(subject);
        thesis.setStudent(bestStudent);
        thesisDAO.save(thesis);
        professor.addThesis(thesis);

    }

    @Override
    public void assignSubjectToParticular(Professor professor, Integer subjectId, Integer studentId){
        Thesis thesis = new Thesis();
        thesis.setProfessor(professor);
        thesis.setSubject(subjectDAO.findById(subjectId).get());
        thesis.setStudent(studentDAO.findById(studentId).get());
        thesisDAO.save(thesis);
        professor.addThesis(thesis);
    }




}