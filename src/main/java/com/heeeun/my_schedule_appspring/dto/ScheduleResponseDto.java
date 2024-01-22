package com.heeeun.my_schedule_appspring.dto;

import com.heeeun.my_schedule_appspring.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String content;
    private String manager;
    private LocalDateTime createdAt;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.manager = schedule.getManager();
        this.createdAt = schedule.getCreatedAt();
    }
}
