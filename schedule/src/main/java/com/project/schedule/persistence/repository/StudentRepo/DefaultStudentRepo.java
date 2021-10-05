package com.project.schedule.persistence.repository.StudentRepo;

import com.project.schedule.domain.model.StudentModel;

import java.util.Set;

public interface DefaultStudentRepo {

    Set<StudentModel> getAllStudents();

    StudentModel findById(long id);

    StudentModel findByEmail(String email);

    void addStudent(StudentModel student);
}
