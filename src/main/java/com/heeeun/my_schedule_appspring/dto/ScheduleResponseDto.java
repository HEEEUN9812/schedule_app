package com.heeeun.my_schedule_appspring.dto;

import com.heeeun.my_schedule_appspring.entity.Schedule;

import java.util.Date;

public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String content;
    private String manager;
    private Date date;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.manager = schedule.getManager();
        this.date = schedule.getDate();
    }
}
