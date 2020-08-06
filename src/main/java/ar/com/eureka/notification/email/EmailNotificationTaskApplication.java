package ar.com.eureka.notification.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;

@SpringBootApplication
@EnableTask
public class EmailNotificationTaskApplication {

  public static void main(String[] args) {
    SpringApplication.run(EmailNotificationTaskApplication.class, args);
  }

}
