package com.heeeun.my_schedule_appspring.service;

import com.heeeun.my_schedule_appspring.dto.ScheduleRequestDto;
import com.heeeun.my_schedule_appspring.dto.ScheduleResponseDto;
import com.heeeun.my_schedule_appspring.entity.Schedule;
import com.heeeun.my_schedule_appspring.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public ScheduleResponseDto getSelectSchedule(Long id) {
            Schedule schedule = findSchedule(id);
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);
        return scheduleResponseDto;

//        return scheduleRepository.findAll().stream()
//                .filter(s->s.getId().equals(id))
//                .findFirst()
//                .map(ScheduleResponseDto::new)
//                .orElseThrow(()-> new IllegalArgumentException());
    }

    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto) { // 비밀번호 메서드 추가 필요
        Schedule schedule = findSchedule(id);
        schedule.update(requestDto);
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);
        return scheduleResponseDto;
    }

    public Long deleteSchedule(Long id) { // 비밀번호 메서드 추가 필요
        Schedule schedule = findSchedule(id);
        scheduleRepository.delete(schedule);
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
