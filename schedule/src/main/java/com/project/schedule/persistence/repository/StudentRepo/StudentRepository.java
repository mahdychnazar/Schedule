package com.project.schedule.persistence.repository.StudentRepo;

import com.project.schedule.domain.model.StudentModel;
import com.project.schedule.persistence.mapper.MainMapper;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class StudentRepository implements DefaultStudentRepo{

    StudentRepo studentRepo;

    public StudentRepository(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    @Override
    public Set<StudentModel> getAllStudents() {
        return MainMapper.studentsToStudentsModel(new HashSet<>(studentRepo.findAll()));
    }

    @Override
    public StudentModel findById(long id) {
        return MainMapper.studentToStudentModel(studentRepo.findById(id).get());
    }

    @Override
    public StudentModel findByEmail(String email) {
        return MainMapper.studentToStudentModel(studentRepo.findByEmail(email).get());
    }

    @Override
    public void addStudent(StudentModel student) {
        studentRepo.save(MainMapper.studentModelToStudent(student));
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepo.deleteById(id);
    }
}
