package com.project.schedule.domain.service.studentService;

import com.project.schedule.domain.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService implements DefaultStudentService{

    Map<Long,Student> studentMap = new HashMap<>();

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public Student findById(long id) {
        return studentMap.get(id);
    }

    @Override
    public Student findByEmail(String email) {
        return studentMap.values().stream().filter(student -> student.getEmail().equals(email)).findAny().get();
    }

    @Override
    public void addStudent(Student student) {
        studentMap.put(student.getId(),student);
    }
}
