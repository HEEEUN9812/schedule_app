package com.heeeun.my_schedule_appspring.service;

import com.heeeun.my_schedule_appspring.dto.ScheduleRequestDto;
import com.heeeun.my_schedule_appspring.dto.ScheduleResponseDto;
import com.heeeun.my_schedule_appspring.entity.Schedule;
import com.heeeun.my_schedule_appspring.repository.ScheduleRepository;

public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }


    public ScheduleResponseDto createSchedule (ScheduleRequestDto requestDto){
        Schedule schedule = new Schedule(requestDto);
        Schedule saveSchedule = scheduleRepository.save(schedule);

        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);
        return scheduleResponseDto;
    }
}
