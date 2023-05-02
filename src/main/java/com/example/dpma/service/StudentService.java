package com.example.dpma.service;

import com.example.dpma.model.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    public void saveProfile(Student student);
}
