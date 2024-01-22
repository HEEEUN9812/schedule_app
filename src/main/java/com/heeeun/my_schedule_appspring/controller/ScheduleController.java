package com.heeeun.my_schedule_appspring.controller;


import com.heeeun.my_schedule_appspring.dto.ScheduleRequestDto;
import com.heeeun.my_schedule_appspring.dto.ScheduleResponseDto;
import com.heeeun.my_schedule_appspring.entity.Schedule;
import com.heeeun.my_schedule_appspring.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // 일정 등록
    @PostMapping("/schdl")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto){
        return scheduleService.createSchedule(requestDto);
    }

    // 전체 일정 조회
    @GetMapping("/schdl")
    public List<ScheduleResponseDto> getSchedule(){
        return scheduleService.getSchedule();
    }

    // 선택 일정 조회
    @GetMapping("/schdl/{id}")
    public Schedule getSelectSchedule(@PathVariable Long id){
        return scheduleService.getSelectSchedule(id);
    }

    // 선택 일정 수정
    @PutMapping("/schdl/{id}")
    public Long update(@PathVariable Long id, @PathVariable String password, @RequestBody ScheduleRequestDto requestDto){
        return scheduleService.updateSchedule(id, password, requestDto);
    }


    // 선택 일정 삭제

}
