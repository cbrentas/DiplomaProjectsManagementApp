package com.example.dpma.model;

import java.util.List;

public abstract class TemplateStrategyAlgorithm implements BestApplicantStrategy{

    public TemplateStrategyAlgorithm(){

    }

    @Override
    public Student findBestApplicant(List<Application> applications){
        return null;
    }
    public abstract int compareApplications(Application fapplication, Application sapplication);

}
