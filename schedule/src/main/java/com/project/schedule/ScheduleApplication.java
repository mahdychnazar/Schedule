package com.project.schedule;


import com.project.customstarter.service.StarterService;
import com.project.schedule.domain.model.CourseModel;
import com.project.schedule.domain.model.StudentModel;
import com.project.schedule.domain.service.courseService.DefaultCourseService;
import com.project.schedule.domain.service.studentService.DefaultStudentService;
import com.project.schedule.persistence.repository.UserRepo.DefaultUserRepo;
import com.project.schedule.persistence.repository.entity.Role;
import com.project.schedule.persistence.repository.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;



@SpringBootApplication
public class ScheduleApplication implements CommandLineRunner {
	private static final Logger logger = LogManager.getLogger(ScheduleApplication.class);
	private static final Marker ADMIN_USER = MarkerManager.getMarker("ADMIN");
	private static final Marker GENERAL_USER = MarkerManager.getMarker("GENERAL");;

	@Autowired
	DefaultStudentService studentService;

	DefaultCourseService courseService;

	StarterService starterService;

	DefaultUserRepo userRepo;

	PasswordEncoder passwordEncoder;

	public ScheduleApplication(DefaultStudentService studentService, DefaultCourseService courseService, StarterService starterService, DefaultUserRepo userRepo, PasswordEncoder passwordEncoder) {
		this.studentService = studentService;
		this.courseService = courseService;
		this.starterService = starterService;
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
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
		logger.debug(studentService.getAllStudents());
		logger.debug(courseService.getAllCourses());
	}

	private void crudOperations() {
		logger.trace(GENERAL_USER,"***********************Test student service***********************");
		StudentModel student = new StudentModel(1L,"Yevhen","yevhen",12, "2002-06-21T12:02", Collections.emptySet());
		userRepo.addUser(new User(1L, student.getName(),passwordEncoder.encode("p"), true, Collections.singleton(Role.ADMIN)));
		studentService.addStudent(student);
		logger.trace( ADMIN_USER,studentService.findByEmail("yevhen"));
		logger.trace(GENERAL_USER,"***********************Success***********************");
		logger.trace(GENERAL_USER,"***********************Test course service***********************");
		CourseModel course = new CourseModel(1L,"Math","Topology","Kozerenko", Collections.emptyList());
		CourseModel course2 = new CourseModel(2L,"Math","Graph theory","Kozerenko", Collections.emptyList());
		courseService.addCourse(course);
		courseService.addCourse(course2);
		logger.trace( ADMIN_USER,courseService.findById(1L));
		logger.trace( ADMIN_USER,courseService.findById(2L));
		logger.trace( ADMIN_USER,courseService.findByAuthor("Kozerenko"));
		starterService.starterFunc();
		logger.info(GENERAL_USER,"***********************Success***********************");
	}

}
