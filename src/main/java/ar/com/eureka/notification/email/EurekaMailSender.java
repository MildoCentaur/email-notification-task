package ar.com.eureka.notification.email;

import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Component
public class EurekaMailSender {

  @Autowired
  private JavaMailSender emailSender;

  @Autowired
  private SpringTemplateEngine thymeleafTemplateEngine;

  public void sendSimpleMessage(
      String to, String subject, String text) {

    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("noreply@eureka.com");
    message.setTo(to);
    message.setSubject(subject);
    message.setText(text);
    emailSender.send(message);

  }


  public void sendMessageUsingThymeleafTemplate(
      String to, String subject, Map<String, Object> templateModel)
      throws MessagingException {

    Context thymeleafContext = new Context();
    thymeleafContext.setVariables(templateModel);

    String htmlBody = thymeleafTemplateEngine.process("registered-user-template", thymeleafContext);

    sendHtmlMessage(to, subject, htmlBody);
  }

  private void sendHtmlMessage(String to, String subject, String htmlBody) throws MessagingException {

    MimeMessage message = emailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
    helper.setFrom("noreply@eureka.com");
    helper.setTo(to);
    helper.setSubject(subject);
    helper.setText(htmlBody, true);
//        helper.addInline("attachment.png", resourceFile);
    emailSender.send(message);
  }

}
