package ar.com.eureka.notification.email.configurations;

import ar.com.eureka.notification.email.runners.EmailNotificationRunnerTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;


@Configuration
public class MailConfiguration {

  @Bean
  public EmailNotificationRunnerTask emailNotificationRunnerTask(){
    return new EmailNotificationRunnerTask();
  }

  @Bean
  public SpringTemplateEngine thymeleafTemplateEngine() {
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.setTemplateResolver(thymeleafTemplateResolver());
    templateEngine.setTemplateEngineMessageSource(emailMessageSource());
    return templateEngine;
  }

  @Bean
  public SpringResourceTemplateResolver thymeleafTemplateResolver() {
    SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
    templateResolver.setPrefix("templates/mails/");
    templateResolver.setSuffix(".html");
    templateResolver.setTemplateMode("HTML");
    templateResolver.setCharacterEncoding("UTF-8");
    return templateResolver;
  }

  @Bean
  public ResourceBundleMessageSource emailMessageSource() {
    final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("/messages");
    return messageSource;
  }

}
