package com.cursosdedesarrollo.springbootschedulingtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// busca por tareas programadas
@EnableScheduling
public class SpringBootSchedulingTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSchedulingTaskApplication.class, args);
    }

}
