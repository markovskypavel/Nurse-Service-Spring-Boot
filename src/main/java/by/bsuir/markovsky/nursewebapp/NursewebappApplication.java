package by.bsuir.markovsky.nursewebapp;

import by.bsuir.markovsky.nursewebapp.configuration.WebSecurityConfig;
import by.bsuir.markovsky.nursewebapp.constant.ConfigConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(ConfigConstant.BASE_PACKAGE)
public class NursewebappApplication {
    public static void main(String[] args) {
        SpringApplication.run(new Class[]{NursewebappApplication.class, WebSecurityConfig.class}, args);
    }
}
