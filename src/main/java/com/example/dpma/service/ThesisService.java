package com.example.dpma.service;


import com.example.dpma.model.Thesis;
import org.springframework.stereotype.Service;

@Service
public interface ThesisService {
    public void saveThesis(Thesis thesis);

}
