package com.iade.unimanage.models;

import java.time.LocalDate;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Student extends Person {
    private static int nextNumber = 1;
    private int number;
    @JsonIgnoreProperties({"student"})
    private ArrayList<Enrolment> enrolments;

    @Override
    public String getReference() {
        return "S"+number;
    }

    public Student(String name, LocalDate birthDate, char gender){
        super(name, birthDate, gender);
        this.number = nextNumber;
        nextNumber++;
        email = "";
        enrolments = new ArrayList<Enrolment>();
    }

    public static int getNextNumber() { return nextNumber; }
    
    public String getName() { return name; }
    
    public int getNumber() { return number; }
    
    public ArrayList<Enrolment> getEnrolments() { return enrolments;}
    
    public void enroll(Enrolment enrolment) {
        enrolments.add(enrolment);
        enrolment.getUnit().getEnrolments().add(enrolment);
    }
    
    public Enrolment getEnrolmentByUnitId(int unitId){
        for(int i = 0; i < enrolments.size(); i++) {
            if (enrolments.get(i).getUnit().getId() == unitId)
                return enrolments.get(i);
        }
        return null;
    }
}
