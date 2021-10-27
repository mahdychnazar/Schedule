package com.project.schedule.domain.service.studentService;

import com.project.schedule.domain.model.StudentModel;

import java.util.List;

public interface DefaultStudentService {

    List<StudentModel> getAllStudents();

    StudentModel findById(long id);

    StudentModel findByEmail(String email);

    void addStudent(StudentModel student);

    void deleteStudentById(long id);
}
