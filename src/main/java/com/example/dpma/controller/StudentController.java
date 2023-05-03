package com.example.dpma.controller;

import com.example.dpma.dao.UserDAO;
import com.example.dpma.model.Student;
import com.example.dpma.model.User;
import com.example.dpma.service.StudentService;
import com.example.dpma.service.UserService;
import com.example.dpma.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/student/dashboard")
    public String getStudentHome() {
//    	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		 String currentPrincipalName = authentication.getName();
//		 System.err.println(currentPrincipalName);

        return "student/dashboard";
    }

    @PostMapping("/students/editStudentInfo")
    public String updateStudent(Model model, HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String currentPrincipalName = auth.getName();
        Optional<User> currUser = userDAO.findByUsername(currentPrincipalName);

        model.addAttribute("student");
        return "student/editInfo";
    }


    @RequestMapping("/student/save")
    public String studentSave(@ModelAttribute("student") Student student, Model model) {

        studentService.saveProfile(student);
        return "student/dashboard";
    }
}