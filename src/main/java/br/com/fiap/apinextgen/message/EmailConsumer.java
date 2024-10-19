package br.com.fiap.apinextgen.message;

import br.com.fiap.apinextgen.ApiNextgenApplication;
import jakarta.mail.MessagingException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    private final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = ApiNextgenApplication.FEEDBACK_QUEUE)
    public void receiveMessage(String message) throws MessagingException {
        System.out.println("Received <" + message + ">");
        emailService.sendEmail(message);
    }

}
