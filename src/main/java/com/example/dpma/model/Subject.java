package com.example.dpma.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private int subject_id;

    @Column(name = "subject_name")
    private String subject_name;

    @ManyToOne
    @JoinColumn(name = "supervisor", referencedColumnName = "professor_id")
    private Professor professor;

    @Column(name = "objective")
    private String objective;

    @Column(name = "semester")
    private int semester;

    @OneToMany(mappedBy = "subject")
    private List<Application> applications;
    //

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public List<Application> getApplication() {
        return applications;
    }

    public void setApplication(List<Application> application) {
        this.applications = application;
    }

    public void addApplication(Application application){
        applications.add(application);
    }
}
