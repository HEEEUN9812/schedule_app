package com.heeeun.my_schedule_appspring.controller;


import com.heeeun.my_schedule_appspring.dto.ScheduleRequestDto;
import com.heeeun.my_schedule_appspring.dto.ScheduleResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ScheduleController {
    // 일정 등록
    @PostMapping("/schdl")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto){
        return scheduleService.createSchedule(requestDto);
    }
    // 전체 일정 조회
    // 선택 일정 조회
    // 선택 일정 수정
    // 선택 일정 삭제

}
