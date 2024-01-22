package com.heeeun.my_schedule_appspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MyScheduleAppSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyScheduleAppSpringApplication.class, args);
    }

}
