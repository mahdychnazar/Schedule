package com.project.schedule.domain.service.studentService;

import com.project.schedule.domain.model.Student;

import java.util.List;

public interface DefaultStudentService {

    List<Student> getAllStudents();

    Student findById(long id);

    Student findByEmail(String email);

    void addStudent(Student student);
}
