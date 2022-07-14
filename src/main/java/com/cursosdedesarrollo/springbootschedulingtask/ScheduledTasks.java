package com.cursosdedesarrollo.springbootschedulingtask;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // Ejecución de una tarea donde se fija el tiempo desde que termina de ejecutar hasta la siguiente vez
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
    // Ejecución de la tarea cada X milisegundos
    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);
    }
    // Se fija un tiempo par comenzar a ejecutar (initialDelay) y luego se fija un intervalo entre lanzamientos
    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void scheduleFixedRateWithInitialDelayTask() {

        long now = System.currentTimeMillis() / 1000;
        System.out.println(
                "Fixed rate task with one second initial delay - " + now);
    }
    // Se definen como las tareas cron https://www.redeszone.net/tutoriales/servidores/cron-crontab-linux-programar-tareas/
    @Scheduled(cron = "0 15 10 15 * ?")
    public void scheduleTaskUsingCronExpression() {

        long now = System.currentTimeMillis() / 1000;
        System.out.println(
                "schedule tasks using cron jobs - " + now);
    }
    // Fijado por fichero de propiedades
    @Scheduled(fixedDelayString = "${fixedDelay.in.milliseconds}")
    public void scheduleTaskUsingFixedDelayString() {

        long now = System.currentTimeMillis() / 5000;
        System.out.println(
                "schedule tasks using fixedDelayString - " + now);
    }
    // Fijado por fichero de propiedades cargado desde SpringSchedulingConfig
    @Scheduled(fixedRateString = "${fixedRate.in.milliseconds}")
    public void scheduleTaskUsingFixedRateString() {

        long now = System.currentTimeMillis() / 5000;
        System.out.println(
                "schedule tasks using fixedRateString - " + now);
    }
    // Fijado por fichero de propiedades
    @Scheduled(cron = "${cron.expression}")
    public void scheduleTaskUsingCron() {

        long now = System.currentTimeMillis() / 5000;
        System.out.println(
                "schedule tasks using Cron - " + now);
    }
}
