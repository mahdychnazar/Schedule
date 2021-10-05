package com.project.schedule.persistence.repository.StudentRepo;

import com.project.schedule.persistence.repository.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);
}
