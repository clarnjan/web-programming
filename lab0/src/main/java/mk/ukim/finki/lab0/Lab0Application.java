package mk.ukim.finki.lab0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Lab0Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab0Application.class, args);
    }

}
