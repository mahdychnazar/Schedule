package com.project.schedule.domain.service.studentService;

import com.project.schedule.ScheduleApplication;
import com.project.schedule.domain.model.StudentModel;
import com.project.schedule.persistence.repository.StudentRepo.DefaultStudentRepo;
import org.apache.logging.log4j.*;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements DefaultStudentService{

    private static final Logger logger = LogManager.getLogger(ScheduleApplication.class);
    private static final Marker STUDENT_MARKER = MarkerManager.getMarker("checkStudent");

    DefaultStudentRepo studentRepo;

    public StudentService(DefaultStudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<StudentModel> getAllStudents() {
        return new ArrayList<>(studentRepo.getAllStudents());
    }

    @Override
    @Cacheable("student")
    public StudentModel findById(long id) {
        return studentRepo.findById(id);
    }

    @Override
    @Cacheable("studentEmail")
    public StudentModel findByEmail(String email) {
        return studentRepo.findByEmail(email);
    }

    @Override
    @CachePut(value = "students", key = "#student.id")
    public void addStudent(StudentModel student) {
        ThreadContext.put("student.id", student.getId().toString());
        ThreadContext.put("student.name", student.getName());
        studentRepo.addStudent(student);
        logger.info(STUDENT_MARKER, "Student having id {} and name {} is added", student.getId(), student.getName());
        ThreadContext.clearAll();
    }

    @Override
    @CacheEvict(value = "students", key = "#id")
    public void deleteStudentById(long id){
        studentRepo.deleteStudentById(id);
    }
}
