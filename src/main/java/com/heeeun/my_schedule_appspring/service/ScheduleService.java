package com.heeeun.my_schedule_appspring.service;

import com.heeeun.my_schedule_appspring.dto.ScheduleRequestDto;
import com.heeeun.my_schedule_appspring.dto.ScheduleResponseDto;
import com.heeeun.my_schedule_appspring.entity.Schedule;
import com.heeeun.my_schedule_appspring.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public List<ScheduleResponseDto> getSchedule() {
        return scheduleRepository.findAll().stream().map(ScheduleResponseDto :: new).toList();
    }

    public Schedule getSelectSchedule(Long id) {
            Schedule schedule = findSchedule(id);
        return schedule;

//        return scheduleRepository.findAll().stream()
//                .filter(s->s.getId().equals(id))
//                .findFirst()
//                .map(ScheduleResponseDto::new)
//                .orElseThrow(()-> new IllegalArgumentException());
    }

    public Long updateSchedule(Long id, String password, ScheduleRequestDto requestDto) {
        Schedule schedule = findSchedule(id);
        schedule.update(requestDto);
        return id;
    }

    public Schedule findSchedule(Long id){
        return scheduleRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("선택한 일정은 존재하지 않습니다."));
    }

//    public boolean checkPassword(String password){
//        return scheduleRepository.checkPassword(password);
//    }
}
