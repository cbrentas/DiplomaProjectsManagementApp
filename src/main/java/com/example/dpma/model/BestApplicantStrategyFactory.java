package com.example.dpma.model;

public class BestApplicantStrategyFactory {

    public BestApplicantStrategyFactory(){}

    public BestApplicantStrategy createStrategy(String string) {
        if (string.equals("RandomApplicantStrategy")) {
            BestApplicantStrategy strategy = new RandomApplicantStrategy();
            return strategy;

        } else if (string.equals("BestAvgGradeStrategy")) {
            BestApplicantStrategy strategy = new BestAvgGradeStrategy();
            return strategy;

        } else if (string.equals("FewestCoursesStrategy")) {
            BestApplicantStrategy strategy = new FewestCoursesStrategy();
            return strategy;

        } else if (string.equals("BestApplicantStrategyThreshold")) {
            BestApplicantStrategy strategy = new BestApplicantStrategyThreshold();
            return strategy;

        }
        return null;

    }


}
