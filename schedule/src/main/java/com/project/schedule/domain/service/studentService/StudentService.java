package com.project.schedule.domain.service.studentService;

import com.project.schedule.domain.model.StudentModel;
import com.project.schedule.persistence.repository.StudentRepo.DefaultStudentRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements DefaultStudentService{

    DefaultStudentRepo studentRepo;

    public StudentService(DefaultStudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<StudentModel> getAllStudents() {
        return new ArrayList<>(studentRepo.getAllStudents());
    }

    @Override
    public StudentModel findById(long id) {
        return studentRepo.findById(id);
    }

    @Override
    public StudentModel findByEmail(String email) {
        return studentRepo.findByEmail(email);
    }

    @Override
    public void addStudent(StudentModel student) {
        studentRepo.addStudent(student);
    }

    @Override
    public void deleteStudentById(long id){
        studentRepo.deleteStudentById(id);
    }
}
