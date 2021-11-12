package com.iade.unimanage.models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Unit {
    private static int nextId = 1;
    private int id;
    private String name;
    private int credits;
    @JsonIgnoreProperties ({"unit"})
    private ArrayList<Enrolment> enrolments;
    @JsonIgnoreProperties ({"unit"})
    private Teacher teacher;

    public Unit(String name, int credits, Teacher teacher) {
        this.id = nextId;
        this.name = name;
        this.credits = credits;
        this.teacher = teacher;
        teacher.getUnits().add(this);
        enrolments = new ArrayList<Enrolment>();
        nextId++;
    }

    public int getNextId() {return nextId; }

    public int getId() { return id; }

    public String getName() { return name; }

    public int getCredits() { return credits; }

    public ArrayList<Enrolment> getEnrolments() {
        return enrolments;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
