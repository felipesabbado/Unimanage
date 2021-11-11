package com.iade.unimanage.models.repositories;

import java.time.LocalDate;
import java.util.ArrayList;

import com.iade.unimanage.models.Teacher;
import com.iade.unimanage.models.Unit;

public class TeacherRepository {
    private static ArrayList<Teacher> teachers = new ArrayList<>();

    public static void populate() {
        Teacher t;
        t = new Teacher("Antonio de Souza", LocalDate.parse("1958-01-31"), 'M');
        teachers.add(t);
    }

    public static ArrayList<Teacher> getTeachers(){
        return teachers;
    }

    public static Teacher getTeacher(int mecNumber) {
        for (Teacher teacher: teachers)
            if(teacher.getMecNumber() == mecNumber)
                return teacher;
        return null;
    }

    public static ArrayList<Unit> getUnits(int mecNumber) {
        return teachers.get(mecNumber).getUnits();
    }

    public static boolean addUnit(int mecNumber, int unitNumber) {
        return teachers.get(mecNumber).getUnits().add(UnitRepository.getUnit(unitNumber));
    }

    public static boolean addUnit(int mecNumber, Unit unit) {
        return teachers.get(mecNumber).getUnits().add(unit);
    }

    public static boolean removeUnit(int mecNumber, int unitId) {
        if(unitId <= UnitRepository.getUnits().size()) {
            return teachers.get(mecNumber).getUnits().removeIf((u) -> u.getId() == unitId);
        }
        return false;
    }
}
