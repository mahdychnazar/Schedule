package com.project.schedule;


import com.project.customstarter.service.StarterService;
import com.project.schedule.domain.model.CourseModel;
import com.project.schedule.domain.model.StudentModel;
import com.project.schedule.domain.service.courseService.DefaultCourseService;
import com.project.schedule.domain.service.studentService.DefaultStudentService;
import com.project.schedule.jobs.DBToLoggerJob;
import com.project.schedule.persistence.repository.TimeSlotRepo.TimeSlotRepo;
import com.project.schedule.persistence.repository.UserRepo.DefaultUserRepo;
import com.project.schedule.persistence.repository.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;


@EnableScheduling
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
	@Autowired
	TimeSlotRepo timeSlotRepo;

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

		createTimeSlots();
		crudOperations();
		addStudentToCourses();
		schedulerStart();

	}

	private void createTimeSlots() {
		TimeForCourseEntity time1 = new TimeForCourseEntity(WeekDays.MONDAY,Time.FIRST, Collections.emptySet());
		TimeForCourseEntity time2 = new TimeForCourseEntity(WeekDays.MONDAY,Time.SECOND, Collections.emptySet());
		TimeForCourseEntity time3 = new TimeForCourseEntity(WeekDays.MONDAY,Time.THIRD, Collections.emptySet());
		TimeForCourseEntity time4 = new TimeForCourseEntity(WeekDays.MONDAY,Time.FOURTH, Collections.emptySet());
		TimeForCourseEntity time5 = new TimeForCourseEntity(WeekDays.MONDAY,Time.FIFTH, Collections.emptySet());
		TimeForCourseEntity time6 = new TimeForCourseEntity(WeekDays.MONDAY,Time.SIXTH, Collections.emptySet());
		TimeForCourseEntity time7 = new TimeForCourseEntity(WeekDays.TUESDAY,Time.FIRST, Collections.emptySet());
		TimeForCourseEntity time8 = new TimeForCourseEntity(WeekDays.TUESDAY,Time.SECOND, Collections.emptySet());
		TimeForCourseEntity time9 = new TimeForCourseEntity(WeekDays.TUESDAY,Time.THIRD, Collections.emptySet());
		TimeForCourseEntity time10 = new TimeForCourseEntity(WeekDays.TUESDAY,Time.FOURTH, Collections.emptySet());
		TimeForCourseEntity time11 = new TimeForCourseEntity(WeekDays.TUESDAY,Time.FIFTH, Collections.emptySet());
		TimeForCourseEntity time12 = new TimeForCourseEntity(WeekDays.TUESDAY,Time.SIXTH, Collections.emptySet());
		TimeForCourseEntity time13 = new TimeForCourseEntity(WeekDays.WEDNESDAY,Time.FIRST, Collections.emptySet());
		TimeForCourseEntity time14 = new TimeForCourseEntity(WeekDays.WEDNESDAY,Time.SECOND, Collections.emptySet());
		TimeForCourseEntity time15 = new TimeForCourseEntity(WeekDays.WEDNESDAY,Time.THIRD, Collections.emptySet());
		TimeForCourseEntity time16 = new TimeForCourseEntity(WeekDays.WEDNESDAY,Time.FOURTH, Collections.emptySet());
		TimeForCourseEntity time17 = new TimeForCourseEntity(WeekDays.WEDNESDAY,Time.FIFTH, Collections.emptySet());
		TimeForCourseEntity time18 = new TimeForCourseEntity(WeekDays.WEDNESDAY,Time.SIXTH, Collections.emptySet());
		TimeForCourseEntity time19 = new TimeForCourseEntity(WeekDays.THURSDAY,Time.FIRST, Collections.emptySet());
		TimeForCourseEntity time20 = new TimeForCourseEntity(WeekDays.THURSDAY,Time.SECOND, Collections.emptySet());
		TimeForCourseEntity time21 = new TimeForCourseEntity(WeekDays.THURSDAY,Time.THIRD, Collections.emptySet());
		TimeForCourseEntity time22 = new TimeForCourseEntity(WeekDays.THURSDAY,Time.FOURTH, Collections.emptySet());
		TimeForCourseEntity time23 = new TimeForCourseEntity(WeekDays.THURSDAY,Time.FIFTH, Collections.emptySet());
		TimeForCourseEntity time24 = new TimeForCourseEntity(WeekDays.THURSDAY,Time.SIXTH, Collections.emptySet());
		TimeForCourseEntity time25 = new TimeForCourseEntity(WeekDays.FRIDAY,Time.FIRST, Collections.emptySet());
		TimeForCourseEntity time26 = new TimeForCourseEntity(WeekDays.FRIDAY,Time.SECOND, Collections.emptySet());
		TimeForCourseEntity time27 = new TimeForCourseEntity(WeekDays.FRIDAY,Time.THIRD, Collections.emptySet());
		TimeForCourseEntity time28 = new TimeForCourseEntity(WeekDays.FRIDAY,Time.FOURTH, Collections.emptySet());
		TimeForCourseEntity time29 = new TimeForCourseEntity(WeekDays.FRIDAY,Time.FIFTH, Collections.emptySet());
		TimeForCourseEntity time30 = new TimeForCourseEntity(WeekDays.FRIDAY,Time.SIXTH, Collections.emptySet());
		TimeForCourseEntity time31 = new TimeForCourseEntity(WeekDays.SATURDAY,Time.FIRST, Collections.emptySet());
		TimeForCourseEntity time32 = new TimeForCourseEntity(WeekDays.SATURDAY,Time.SECOND, Collections.emptySet());
		TimeForCourseEntity time33 = new TimeForCourseEntity(WeekDays.SATURDAY,Time.THIRD, Collections.emptySet());
		TimeForCourseEntity time34 = new TimeForCourseEntity(WeekDays.SATURDAY,Time.FOURTH, Collections.emptySet());
		TimeForCourseEntity time35 = new TimeForCourseEntity(WeekDays.SATURDAY,Time.FIFTH, Collections.emptySet());
		TimeForCourseEntity time36 = new TimeForCourseEntity(WeekDays.SATURDAY,Time.SIXTH, Collections.emptySet());
		timeSlotRepo.save(time1);
		timeSlotRepo.save(time2);
		timeSlotRepo.save(time3);
		timeSlotRepo.save(time4);
		timeSlotRepo.save(time5);
		timeSlotRepo.save(time6);
		timeSlotRepo.save(time7);
		timeSlotRepo.save(time8);
		timeSlotRepo.save(time9);
		timeSlotRepo.save(time10);
		timeSlotRepo.save(time11);
		timeSlotRepo.save(time12);
		timeSlotRepo.save(time13);
		timeSlotRepo.save(time14);
		timeSlotRepo.save(time15);
		timeSlotRepo.save(time16);
		timeSlotRepo.save(time17);
		timeSlotRepo.save(time18);
		timeSlotRepo.save(time19);
		timeSlotRepo.save(time20);
		timeSlotRepo.save(time21);
		timeSlotRepo.save(time22);
		timeSlotRepo.save(time23);
		timeSlotRepo.save(time24);
		timeSlotRepo.save(time25);
		timeSlotRepo.save(time26);
		timeSlotRepo.save(time27);
		timeSlotRepo.save(time28);
		timeSlotRepo.save(time29);
		timeSlotRepo.save(time30);
		timeSlotRepo.save(time31);
		timeSlotRepo.save(time32);
		timeSlotRepo.save(time33);
		timeSlotRepo.save(time34);
		timeSlotRepo.save(time35);
		timeSlotRepo.save(time36);

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
		CourseModel course = new CourseModel(1L,"Topology","Topology","Kozerenko", Collections.emptyList());
		course.setTimeForCourses(Collections.singleton(timeSlotRepo.findById(1L).get()));
		CourseModel course2 = new CourseModel(2L,"Graph theory","Graphs","Kozerenko", Collections.emptyList());
		course2.setTimeForCourses(Collections.singleton(timeSlotRepo.findById(1L).get()));

		courseService.addCourse(course);
		courseService.addCourse(course2);
		logger.trace( ADMIN_USER,courseService.findById(1L));
		logger.trace( ADMIN_USER,courseService.findById(2L));
		logger.trace( ADMIN_USER,courseService.findByAuthor("Kozerenko"));
		starterService.starterFunc();
		logger.info(GENERAL_USER,"***********************Success***********************");
	}

	private void schedulerStart() throws SchedulerException {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		JobDetail dbToLoggerJob = JobBuilder.newJob(DBToLoggerJob.class)
				.withIdentity("DBToLoggerJob", "group1")
				.usingJobData("studentService", String.valueOf(studentService.getAllStudents()))
				.usingJobData("courseService", String.valueOf(courseService.getAllCourses()))
				.build();
		Trigger triggerToDB = TriggerBuilder.newTrigger()
				.withIdentity("myTrigger", "group1")
				.startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(40)
						.repeatForever())
				.forJob("DBToLoggerJob", "group1")
				.build();
		JobDetail StudentsInfoJob = JobBuilder.newJob(DBToLoggerJob.class)
				.withIdentity("StudentsInfoJob", "group2")
				.usingJobData("studentsAmountOnTopology", String.valueOf(courseService.findByTitle("Topology").getStudentModelSet().size()))
				.build();
		CronTrigger triggerStudentsTopologyInfo = TriggerBuilder.newTrigger()
				.withIdentity("crontrigger", "group2")
				.withSchedule(CronScheduleBuilder.cronSchedule("0 0 12 * * ?"))
				.forJob("StudentsInfoJob", "group2")
				.build();
		scheduler.scheduleJob(dbToLoggerJob, triggerToDB);
		scheduler.scheduleJob(StudentsInfoJob, triggerStudentsTopologyInfo);
		scheduler.start();
	}

}
