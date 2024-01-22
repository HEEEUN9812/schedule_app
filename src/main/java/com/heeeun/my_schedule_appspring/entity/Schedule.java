package com.heeeun.my_schedule_appspring.entity;

import com.heeeun.my_schedule_appspring.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "scheduler")
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "manager", nullable = false)
    private String manager;
    @Column(name = "password", nullable = false)
    private String password;

    public Schedule(ScheduleRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.manager = requestDto.getManager();
        this.password = requestDto.getPassword();
    }
}



