package ar.com.eureka.notification.email.configurations;

import ar.com.eureka.notification.email.runners.EmailNotificationRunnerTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;


@Configuration
public class MailConfiguration { //implements WebMvcConfigurer {

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

//  @Bean
//  public LocaleResolver localeResolver() {
//    SessionLocaleResolver slr = new SessionLocaleResolver();
//    slr.setDefaultLocale(Locale.US);
//    slr.setTimeZoneAttributeName("en_AR");
//    return slr;
//  }

//  @Bean
//  public LocaleChangeInterceptor localeChangeInterceptor() {
//    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
//    lci.setParamName("lang");
//    return lci;
//  }

//  @Override
//  public void addInterceptors(InterceptorRegistry registry) {
//    registry.addInterceptor(localeChangeInterceptor());
//  }

  @Bean
  public SpringResourceTemplateResolver thymeleafTemplateResolver() {
    SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
    templateResolver.setPrefix("/WEB-INF/mails/");
    templateResolver.setSuffix(".html");
    templateResolver.setTemplateMode("HTML");
    templateResolver.setCharacterEncoding("UTF-8");
    return templateResolver;
  }

  @Bean
  public ResourceBundleMessageSource emailMessageSource() {
    final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("mailMessages");
    return messageSource;
  }

}
