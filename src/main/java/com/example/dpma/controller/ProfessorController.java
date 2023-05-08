package com.example.dpma.controller;

import com.example.dpma.model.*;
import com.example.dpma.service.ProfessorService;
import com.example.dpma.service.SubjectService;
import com.example.dpma.service.ThesisService;
import com.example.dpma.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProfessorController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ProfessorService professorService;

    @Autowired
    SubjectService subjectService;

    @Autowired
    ThesisService thesisService;


    @RequestMapping("/professor/dashboard")
    public String getProfessorHome(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.err.println(currentPrincipalName);
        model.addAttribute("username", currentPrincipalName);
        model.addAttribute("role", "PROFESSOR");

        return "professor/dashboard";
    }


    @RequestMapping("/professor/editProfessorInfo")
    public String updateStudent(Model model, HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String currentPrincipalName = auth.getName();
        User user = userService.loadUserByName(currentPrincipalName);
        Professor professor = professorService.findProfessorByUserId(user.getId());
        model.addAttribute("professor", professor);
        return "professor/editInfo";
    }

    @RequestMapping("/professor/save")
    public String studentSave(@ModelAttribute("professor") Professor professor, Model model) {
        professorService.saveProfile(professor);
        return "professor/dashboard";
    }


    @RequestMapping("/professor/showSubjectForm")
    public String showSubjectForm(Model model) {

        Subject subject = new Subject();

        model.addAttribute("subject", subject);
        return "/professor/subjectForm";

    }


    //Add information for completed
    @RequestMapping("/professor/addSubject")
    public String addSubject(@ModelAttribute("subject") Subject subject, Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = auth.getName();
        User user = userService.loadUserByName(currentPrincipalName);
        Professor professor = professorService.findProfessorByUserId(user.getId());
        subject.setProfessor(professor);
        subjectService.saveSubject(subject);
        professorService.saveSubject(professor, subject);
        model.addAttribute("successMessage", "Subject registered successfully!");


        return "/professor/dashboard";

    }

    @RequestMapping("/professor/subjectsList")
    public String listProfessorSubjects(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = auth.getName();
        User user = userService.loadUserByName(currentPrincipalName);
        Professor professor = professorService.findProfessorByUserId(user.getId());
        model.addAttribute("subjects", professorService.listProfessorSubjects(professor));

        return "professor/subjectsList";
    }

    @RequestMapping("/professor/viewApplications")
    public String listApplication(@RequestParam("subject_id") Integer subjectId, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = auth.getName();
        User user = userService.loadUserByName(currentPrincipalName);
        Professor professor = professorService.findProfessorByUserId(user.getId());
        model.addAttribute("applications", professorService.listApplications(subjectId, professor));

        return "/professor/applicationsList";

    }

    @RequestMapping("/professor/deleteSubject")
    public String deleteSubject(@RequestParam("subject_id") Integer subjectId, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = auth.getName();
        User user = userService.loadUserByName(currentPrincipalName);
        Professor professor = professorService.findProfessorByUserId(user.getId());
        subjectService.deleteById(subjectId);
        professorService.deleteSubject(professor, subjectId);
        model.addAttribute("subjects", professorService.listProfessorSubjects(professor));
        return "/professor/subjectsList";
    }

    @RequestMapping("professor/assignSubject")
    public String assignSubject (@RequestParam("subject_id") Integer subjectId, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = auth.getName();
        User user = userService.loadUserByName(currentPrincipalName);
        Professor professor = professorService.findProfessorByUserId(user.getId());
        professorService.assignSubject(professor, subjectId);

        return "professor/subjectsList";

    }




    }



