package com.project.schedule.persistence.repository.TimeSlotRepo;

import com.project.schedule.persistence.repository.entity.TimeForCourseEntity;
import com.project.schedule.persistence.repository.entity.WeekDays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeSlotRepo extends JpaRepository<TimeForCourseEntity, Long> {

    List<TimeForCourseEntity> findAllByDays(WeekDays days);
}
