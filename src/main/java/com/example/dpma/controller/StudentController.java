package com.example.dpma.controller;

import com.example.dpma.dao.StudentDAO;
import com.example.dpma.dao.UserDAO;
import com.example.dpma.model.Student;
import com.example.dpma.model.Subject;
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
    UserServiceImpl userService;

    @RequestMapping("/student/dashboard")
    public String getStudentHome(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.err.println(currentPrincipalName);
        model.addAttribute("username", currentPrincipalName);
        model.addAttribute("role", "STUDENT");

        return "student/dashboard";
    }

    @RequestMapping("/student/editStudentInfo")
    public String updateStudent(Model model, HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String currentPrincipalName = auth.getName();
        User user = userService.loadUserByName(currentPrincipalName);
        Student student = studentService.findStudentByUserId(user.getId());
        model.addAttribute("student", student);
        return "student/editInfo";
    }


    @RequestMapping("/student/save")
    public String studentSave(@ModelAttribute("student") Student student, Model model) {
        studentService.saveProfile(student);
        return "student/dashboard";
    }

    @RequestMapping("/student/showAllSubjects")
    public String studentShowAllSubjects(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String currentPrincipalName = auth.getName();
        User user = userService.loadUserByName(currentPrincipalName);
        Student student = studentService.findStudentByUserId(user.getId());
        model.addAttribute("subjects", studentService.listStudentSubjects());


        return "/student/subjectsList";
    }


    @RequestMapping("/student/ApplicationCreate")
    public String applyToSubject(@RequestParam("subject_id") Integer subjectId, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = auth.getName();
        User user = userService.loadUserByName(currentPrincipalName);
        Student student = studentService.findStudentByUserId(user.getId());
        studentService.applyToSubject(student, subjectId);


        return "/student/dashboard";
    }
}