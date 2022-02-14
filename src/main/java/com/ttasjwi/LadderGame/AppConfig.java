package com.ttasjwi.LadderGame;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean (destroyMethod = "close")
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
