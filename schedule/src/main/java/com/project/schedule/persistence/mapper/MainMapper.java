package com.project.schedule.persistence.mapper;

import com.project.schedule.domain.model.CourseModel;
import com.project.schedule.domain.model.StudentModel;
import com.project.schedule.persistence.repository.CourseRepo.DefaultCourseRepo;
import com.project.schedule.persistence.repository.StudentRepo.DefaultStudentRepo;
import com.project.schedule.persistence.repository.entity.Course;
import com.project.schedule.persistence.repository.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class MainMapper {

    static DefaultCourseRepo courseRepo;
    static DefaultStudentRepo studentRepo;

    public MainMapper(DefaultStudentRepo studentRepo, DefaultCourseRepo courseRepo){
        MainMapper.studentRepo = studentRepo;
        MainMapper.courseRepo = courseRepo;
    }

    public static StudentModel studentToStudentModel(Student student){
            StudentModel studentModel = new StudentModel();
            studentModel.setId(student.getId());
            studentModel.setName(student.getName());
            studentModel.setAge(student.getAge());
            studentModel.setEmail(student.getEmail());
            studentModel.setBirthDate(student.getBirthDate());
            studentModel.setCourseModels(coursesToLongSet(student.getCourses()));
            return studentModel;
    }

    private static Set<Long> coursesToLongSet(Set<Course> courses) {
        Set<Long> courseModels  = new HashSet<>();
        for (Course course : courses){
            courseModels.add(course.getId());
        }
        return courseModels;
    }

    public static Student studentModelToStudent(StudentModel studentModel){
        Student student = new Student();
        student.setId(studentModel.getId());
        student.setName(studentModel.getName());
        student.setAge(studentModel.getAge());
        student.setEmail(studentModel.getEmail());
        student.setBirthDate(studentModel.getBirthDate());
        student.setCourses(longModelToCourses(studentModel.getCourseModels()));
        return student;
    }

    private static Set<Course> longModelToCourses(Set<Long> courseModels) {
        Set<Course> courses  = new HashSet<>();
        for (Long id : courseModels){
            courses.add(courseRepo.findById(id));
        }
        return courses;
    }

    public static Set<Student> studentsModelToStudents(Set<StudentModel> studentModels) {
        Set<Student> students = new HashSet<>();
        for (StudentModel studentModel : studentModels){
            students.add(studentModelToStudent(studentModel));
        }
        return students;
    }

    public static Set<StudentModel> studentsToStudentsModel(Set<Student> students) {
        Set<StudentModel> studentModels = new HashSet<>();
        for (Student student : students){
            studentModels.add(studentToStudentModel(student));
        }
        return studentModels;
    }

    public static Set<Course> coursesModelToCourses(Set<CourseModel> courseModels) {
        Set<Course> courses = new HashSet<>();
        for (CourseModel courseModel : courseModels){
            courses.add(courseModelToCourse(courseModel));
        }
        return courses;
    }

    public static List<CourseModel> coursesToCoursesModel(List<Course> courses) {
        List<CourseModel> coursesModel = new ArrayList<>();
        for (Course course : courses){
            coursesModel.add(courseToCourseModel(course));
        }
        return coursesModel;
    }

    public static CourseModel courseToCourseModel(Course course) {
        CourseModel courseModel = new CourseModel();
        courseModel.setId(course.getId());
        courseModel.setTitle(course.getTitle());
        courseModel.setLector(course.getLector());
        courseModel.setDescription(course.getDescription());
        courseModel.setStudentModelSet(studentsToLongModel(course.getStudentSet()));
        return courseModel;
    }

    private static List<Long> studentsToLongModel(List<Student> studentSet) {
        List<Long> studentModels  = new ArrayList<>();
        for (Student student : studentSet){
            studentModels.add(student.getId());
        }
        return studentModels;
    }

    public static Course courseModelToCourse(CourseModel courseModel) {
        Course course = new Course();
        course.setId(courseModel.getId());
        course.setTitle(courseModel.getTitle());
        course.setLector(courseModel.getLector());
        course.setDescription(courseModel.getDescription());
        course.setStudentSet(LongToStudents(courseModel.getStudentModelSet()));
        return course;
    }

    private static List<Student> LongToStudents(List<Long> studentModelSet) {
        List<Student> students  = new ArrayList<>();
        for (Long id : studentModelSet){
            students.add(studentModelToStudent(studentRepo.findById(id)));
        }
        return students;
    }
}
