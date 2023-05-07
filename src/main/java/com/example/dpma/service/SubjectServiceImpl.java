package com.example.dpma.service;


import com.example.dpma.dao.SubjectDAO;
import com.example.dpma.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectDAO subjectDAO;

    @Override
    public void saveSubject(Subject subject){
        subjectDAO.save(subject);

    }

    @Override
    public Subject findById(Integer subjectId) {

        return subjectDAO.findById(subjectId).get();

    }
}
