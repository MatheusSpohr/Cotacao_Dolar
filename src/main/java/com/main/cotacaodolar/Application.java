package com.main.cotacaodolar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class Application implements CommandLineRunner {

    @Autowired
    private DollarService dollarService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        // Executa a tarefa inicial
        dollarService.requestDollarRate();
    }

    // Agendando a tarefa para rodar a cada 30 minutos
    @Scheduled(fixedRate = 30 * 60 * 1000)
    public void scheduleTask() {
        dollarService.requestDollarRate();
	}
}
