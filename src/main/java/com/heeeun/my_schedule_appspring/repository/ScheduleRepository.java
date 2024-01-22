package com.heeeun.my_schedule_appspring.repository;

import com.heeeun.my_schedule_appspring.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}