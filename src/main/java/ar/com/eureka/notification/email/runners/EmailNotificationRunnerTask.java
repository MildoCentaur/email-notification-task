package ar.com.eureka.notification.email.runners;

import ar.com.eureka.notification.email.EurekaMailSender;
import ar.com.eureka.notification.email.context.MailContext;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

public class EmailNotificationRunnerTask implements CommandLineRunner {

  private String templateName;
  private String to;

  @Autowired
  private EurekaMailSender sender;

  @Value("#{${mailcode.properties}}")
  private Map<String, String> valuesMap;


  @Override
  public void run(String... parameters) throws Exception {
    if (parameters != null && parameters.length>0){
      to = parameters[0];
      templateName = parameters[1];
      System.out.println("to: "+ to + " template:" + templateName);
    }

    MailContext context = parseMailContext(parameters);
    Map<String, Object> templateModel = new HashMap<>();
    templateModel.put("recipientName", "Alejandro RecipientName");
    templateModel.put("text", "Test");
    templateModel.put("senderName", "SenderName");

    sender.sendMessageUsingThymeleafTemplate("alejandro.mildiner@gmail.com","Thymelef template",templateModel);

  }

  private MailContext parseMailContext(String[] parameters) {
    return null;
  }
}
