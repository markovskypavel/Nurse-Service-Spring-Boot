package by.bsuir.markovsky.nursewebapp;

import by.bsuir.markovsky.nursewebapp.configuration.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("by.bsuir.markovsky.nursewebapp")
public class NursewebappApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{NursewebappApplication.class, WebSecurityConfig.class}, args);
    }
}
