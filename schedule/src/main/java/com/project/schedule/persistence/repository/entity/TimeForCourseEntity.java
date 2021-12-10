package com.project.schedule.persistence.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "timeslots")
public class TimeForCourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    WeekDays days;
    Time time;

    @ManyToMany(mappedBy = "timeForCourses", fetch = FetchType.EAGER)
    private Set<Course> course = new HashSet<>();

    public TimeForCourseEntity() {
    }

    public TimeForCourseEntity(WeekDays days, Time time, Set<Course> course) {
        this.days = days;
        this.time = time;
        this.course = course;
    }
}
