package by.bsuir.markovsky.nursewebapp;

import by.bsuir.markovsky.nursewebapp.configuration.WebSecurityConfig;
import by.bsuir.markovsky.nursewebapp.constant.ConfigConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@ComponentScan(ConfigConstant.BASE_PACKAGE)
public class NursewebappApplication {

    @Value("${time.timezone.utc}")
    private String timezone;

    //It needs to correct date (server has -1 hour)
    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone(timezone));
    }

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{NursewebappApplication.class, WebSecurityConfig.class}, args);
    }

}
