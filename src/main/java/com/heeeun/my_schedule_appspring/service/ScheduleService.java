package com.heeeun.my_schedule_appspring.service;

import com.heeeun.my_schedule_appspring.dto.ScheduleRequestDto;
import com.heeeun.my_schedule_appspring.dto.ScheduleResponseDto;
import com.heeeun.my_schedule_appspring.entity.Schedule;
import com.heeeun.my_schedule_appspring.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
        return scheduleRepository.findAllByOrderByCreatedAtDesc().stream().map(ScheduleResponseDto :: new).toList();
    }

    public ScheduleResponseDto getSelectSchedule(Long id) {
            Schedule schedule = findSchedule(id);
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);
        return scheduleResponseDto;
    }

    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto) {
        Schedule schedule = findSchedule(id);
        confirmPassword(requestDto, schedule);

            schedule.update(requestDto);
            return new ScheduleResponseDto(schedule);
    }

    @Transactional
    public String deleteSchedule(Long id, ScheduleRequestDto requestDto) {
        Schedule schedule = findSchedule(id);
        confirmPassword(requestDto, schedule);

            scheduleRepository.delete(schedule);
            return "삭제되었습니다.";
    }

    public Schedule findSchedule(Long id){
        return scheduleRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "선택한 일정이 존재하지 않습니다."));
    }

    public void confirmPassword (ScheduleRequestDto requestDto, Schedule schedule){
        if(schedule.getPassword().equals(requestDto.getPassword())){
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"비밀번호가 일치하지 않습니다.");
        }
    }
}
