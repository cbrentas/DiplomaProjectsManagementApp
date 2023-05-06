package com.example.dpma.service;

import com.example.dpma.dao.StudentDAO;
import com.example.dpma.dao.SubjectDAO;
import com.example.dpma.model.Student;
import com.example.dpma.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private SubjectDAO subjectDAO;

    @Override
    public void saveProfile(Student student) {

        studentDAO.save(student);
    }

    @Override
    public Student findStudentByUserId(int userId) {
        return studentDAO.findByUserId(userId);
    }

    @Override
    public List<Subject> listStudentSubjects() {
        return subjectDAO.findAll();
    }
}


