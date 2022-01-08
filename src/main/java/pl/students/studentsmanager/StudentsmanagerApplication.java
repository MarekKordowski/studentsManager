package pl.students.studentsmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class StudentsmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsmanagerApplication.class, args);
	}

}
