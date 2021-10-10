package com.project.schedule;

import com.project.customstarter.service.StarterService;
import com.project.schedule.domain.model.CourseModel;
import com.project.schedule.domain.model.StudentModel;
import com.project.schedule.domain.service.studentService.DefaultCourseService;
import com.project.schedule.domain.service.studentService.DefaultStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Collections;

@SpringBootApplication
public class ScheduleApplication implements CommandLineRunner {

	@Autowired
	DefaultStudentService studentService;

	DefaultCourseService courseService;

	StarterService starterService;

	public ScheduleApplication(DefaultCourseService courseService, StarterService starterService) {
		this.courseService = courseService;
		this.starterService = starterService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ScheduleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		crudOperations();
		addStudentToCourses();

	}

	private void addStudentToCourses() {
		StudentModel byId = studentService.findById(1L);
		byId.getCourseModels().add(1L);
		byId.getCourseModels().add(2L);
		studentService.addStudent(byId);
		System.out.println(studentService.getAllStudents());
		System.out.println(courseService.getAllCourses());
	}

	private void crudOperations() {
		System.out.println("***********************Test student service***********************");
		StudentModel student = new StudentModel(1L,"Yevhen","yevhen",12, LocalDateTime.parse("2002-06-21T12:02"), Collections.emptySet());
		studentService.addStudent(student);
		System.out.println(studentService.findByEmail("yevhen"));
		System.out.println("***********************Success***********************");
		System.out.println("***********************Test course service***********************");
		CourseModel course = new CourseModel(1L,"Math","Topology","Kozerenko", Collections.emptySet());
		CourseModel course2 = new CourseModel(2L,"Math","Graph theory","Kozerenko", Collections.emptySet());
		courseService.addCourse(course);
		courseService.addCourse(course2);
		System.out.println(courseService.findById(1L));
		System.out.println(courseService.findById(2L));
		System.out.println(courseService.findByAuthor("Kozerenko"));
		starterService.starterFunc();
		System.out.println("***********************Success***********************");
	}

}
