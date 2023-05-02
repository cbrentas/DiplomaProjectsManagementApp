package com.example.dpma.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {

    @Id
    @Column(name="student_id")
    private int student_id;





    ///////////////////////
    @Column(name="full_name")
    private String full_name;

    @Column(name="year_of_studies")
    private int year_of_studies;

    @Column(name="curr_average_grade")
    private float curr_average_grade;

    @Column(name="num_of_remaining_courses")
    private int num_of_remaining_courses;

    public int getId() {
        return student_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public int getYear_of_studies() {
        return year_of_studies;
    }

    public float getCurr_average_grade() {
        return curr_average_grade;
    }

    public int getNum_of_remaining_courses() {
        return num_of_remaining_courses;
    }

    //Setters

    public void setId(int id) {
        this.student_id = id;
    }
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setYear_of_studies(int year_of_studies) {
        this.year_of_studies = year_of_studies;
    }

    public void setCurr_average_grade(float curr_average_grade) {
        this.curr_average_grade = curr_average_grade;
    }

    public void setNum_of_remaining_courses(int num_of_remaining_courses) {
        this.num_of_remaining_courses = num_of_remaining_courses;
    }
    public String yespls(){
        return "hi";
    }

}
