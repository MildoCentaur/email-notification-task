package ar.com.eureka.notification.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class EmailNotificationTaskApplication {

  public static void main(String[] args) {
    SpringApplication.run(EmailNotificationTaskApplication.class, args);
  }

  @Bean
  public EmailNotificationTask emailNotificationTask(){
    return new EmailNotificationTask();
  }

  public class EmailNotificationTask implements CommandLineRunner{

    private String templateName;
    private String to;

    @Value("${test}")
    String test;

    @Override
    public void run(String... parameters) throws Exception {
      if (parameters != null && parameters.length>0){
        to = parameters[0];
        templateName = parameters[1];
        System.out.println("to: "+ to + " template:" + templateName);
      }

      System.out.println("Test: " + test);
    }
  }

}
