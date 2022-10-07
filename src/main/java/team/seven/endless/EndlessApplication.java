package team.seven.endless;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class EndlessApplication {

    public static void main(String[] args) {
        SpringApplication.run(EndlessApplication.class, args);
    }

}
