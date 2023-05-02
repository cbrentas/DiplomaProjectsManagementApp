package com.example.dpma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfessorController {

    @RequestMapping("/professor/dashboard")
    public String getProfessorHome(){
        return "professor/dashboard";
    }
}