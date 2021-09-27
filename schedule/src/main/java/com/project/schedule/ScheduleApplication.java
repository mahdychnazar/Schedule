package com.project.schedule;

import com.project.schedule.domain.model.Course;
import com.project.schedule.domain.model.Student;
import com.project.schedule.domain.service.studentService.DefaultCourseService;
import com.project.schedule.domain.service.studentService.DefaultStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class ScheduleApplication implements CommandLineRunner {

	@Autowired
	DefaultStudentService studentService;

	DefaultCourseService courseService;

	public ScheduleApplication(DefaultCourseService courseService) {
		this.courseService = courseService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ScheduleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("***********************Test student service***********************");
		Student student = new Student(1L,"Yevhen","yevhen",12, LocalDateTime.parse("2002-06-21T12:02"));
		studentService.addStudent(student);
		System.out.println(studentService.findByEmail("yevhen"));
		System.out.println("***********************Success***********************");
		System.out.println("***********************Test course service***********************");
		Course course = new Course(1L,"Math","Topology","Kozerenko");
		Course course2 = new Course(2L,"Math","Graph theory","Kozerenko");
		courseService.addCourse(course);
		courseService.addCourse(course2);
		System.out.println(courseService.findById(1L));
		System.out.println(courseService.findById(2));
		System.out.println("***********************Success***********************");
	}
}
