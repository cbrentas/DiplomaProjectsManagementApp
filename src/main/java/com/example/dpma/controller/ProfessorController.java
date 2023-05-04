package com.example.dpma.controller;

import com.example.dpma.model.Professor;
import com.example.dpma.model.Student;
import com.example.dpma.model.User;
import com.example.dpma.service.ProfessorService;
import com.example.dpma.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfessorController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ProfessorService professorService;

    @RequestMapping("/professor/dashboard")
    public String getProfessorHome() {
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
}