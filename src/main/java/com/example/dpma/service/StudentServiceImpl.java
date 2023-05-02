package com.example.dpma.service;

import com.example.dpma.dao.StudentDAO;
import com.example.dpma.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public void saveProfile(Student student){
        studentDAO.save(student);
    }

}
