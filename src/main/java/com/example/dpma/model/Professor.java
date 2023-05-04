package com.example.dpma.model;

import jakarta.persistence.*;

@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id")
    private int professor_id;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "specialty")
    private String specialty;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Professor(int professor_id, String full_name, String specialty, User user) {
        this.professor_id = professor_id;
        this.full_name = full_name;
        this.specialty = specialty;
        this.user = user;
    }

    public Professor() {
    }


    public int getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Professor{" +
                "professor_id=" + professor_id +
                ", full_name='" + full_name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", user=" + user +
                '}';
    }
}
