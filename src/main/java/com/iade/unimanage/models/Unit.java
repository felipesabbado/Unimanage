package com.iade.unimanage.models;

import java.util.ArrayList;

public class Unit {
    private static int nextId = 1;
    private int id;
    private String name;
    private int credits;
    private ArrayList<Student> students;

    public Unit(String name, int credits) {
        this.id = nextId;
        this.name = name;
        this.credits = credits;
        students = new ArrayList<Student>();
        nextId++;
    }

    public int getNextId() {return nextId; }

    public int getId() { return id; }

    public String getName() { return name; }

    public int getCredits() { return credits; }

    public ArrayList<Student> getStudents() {
        return students;
    }
}