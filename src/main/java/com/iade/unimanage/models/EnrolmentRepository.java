package com.iade.unimanage.models;

public class EnrolmentRepository {

    public static void populate() {
        StudentRepository.getStudent(1).enroll(new Enrolment(StudentRepository.getStudent(1), UnitRepository.getUnit(2), 12.5));
    }
}
