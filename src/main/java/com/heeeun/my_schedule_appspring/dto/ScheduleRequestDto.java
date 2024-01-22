package com.heeeun.my_schedule_appspring.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class ScheduleRequestDto {
    private String title;
    private String content;
    private String manager;
    private String password;
}
