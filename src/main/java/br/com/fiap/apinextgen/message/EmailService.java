package br.com.fiap.apinextgen.message;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    JavaMailSender mailSender;

    public void sendEmail(String message) throws MessagingException {
        var email = mailSender.createMimeMessage();
        var config = new MimeMessageHelper(email);

        config.setTo("fsp12371@gmail.com");
        config.setSubject("Feedback realizado com sucesso!");
        config.setText("""
                    <h1>Novo Feedback</h1>
                    <p>%s</p>                
                """.formatted(message), true);

        mailSender.send(email);
    }

}
