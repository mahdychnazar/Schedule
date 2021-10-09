package com.project.schedule.persistence.repository.CourseRepo;

import com.project.schedule.persistence.repository.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

    Optional<Course> findByTitle(String title);

    Optional<Course> findByLector(String name);
}
