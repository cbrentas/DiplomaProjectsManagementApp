package com.example.dpma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping("/student/dashboard")
    public String getStudentHome(){
//    	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		 String currentPrincipalName = authentication.getName();
//		 System.err.println(currentPrincipalName);

        return "student/dashboard";
    }
}