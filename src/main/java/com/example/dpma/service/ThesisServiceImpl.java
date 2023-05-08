package com.example.dpma.service;

import com.example.dpma.dao.ThesisDAO;
import com.example.dpma.model.Thesis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThesisServiceImpl implements ThesisService{

    @Autowired
    ThesisDAO thesisDAO;


    @Override
    public void saveThesis(Thesis thesis) {
        thesisDAO.save(thesis);
    }
}
