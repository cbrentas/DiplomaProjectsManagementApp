package com.example.dpma.controller;

import com.example.dpma.model.Student;
import com.example.dpma.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/student/dashboard")
    public String getStudentHome(){
//    	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		 String currentPrincipalName = authentication.getName();
//		 System.err.println(currentPrincipalName);

        return "student/dashboard";
    }


    @RequestMapping("/student/save")
    public String saveProfile(@ModelAttribute("student") Student student, Model model){
        studentService.saveProfile(student);
        model.addAttribute("successMessage", "User registered successfully!");
        return "/student/dashboard";


    }
}