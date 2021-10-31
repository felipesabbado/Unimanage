package com.iade.unimanage.models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Unit {
    private static int nextId = 1;
    private int id;
    private String name;
    private int credits;
    @JsonIgnoreProperties ({"units"})
    private ArrayList<Enrolment> enrolments;

    public Unit(String name, int credits) {
        this.id = nextId;
        this.name = name;
        this.credits = credits;
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
}
