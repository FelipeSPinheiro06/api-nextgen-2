package br.com.fiap.apinextgen.message;

import br.com.fiap.apinextgen.ApiNextgenApplication;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener(queues = ApiNextgenApplication.FEEDBACK_QUEUE)
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }

}
