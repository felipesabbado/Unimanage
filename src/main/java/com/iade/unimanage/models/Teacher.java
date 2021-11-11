package com.iade.unimanage.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Teacher extends Person {
    private static int nextNumber = 1;
    private int mecNumber;
    private ArrayList<Unit> units;

    public Teacher(String name, LocalDate birthDate, char gender) {
        super(name, birthDate, gender);
        this.mecNumber = nextNumber;
        nextNumber++;
        units = new ArrayList<>();
    }
    
    @Override
    public String getReference() {
        return "T"+mecNumber;
    }

    @Override
    public String getName() {
        return "Professor " + name;
    }

    public int getMecNumber() {
        return mecNumber;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void setMecNumber(int mecNumber) {
        this.mecNumber = mecNumber;
    }

    public void setUnits(ArrayList<Unit> units) {
        this.units = units;
    }
}
