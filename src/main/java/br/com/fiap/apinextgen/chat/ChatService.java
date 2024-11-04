package br.com.fiap.apinextgen.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    final ChatClient chatClient;

    public ChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
                .defaultSystem("""
                        Você é uma pessoa que gera feedbacks.
                        Você só pode responder assuntos que são relacionados a feedbacks.
                        """)
                .build();

    }

    public String sendToAi(String message) {
        return chatClient
                .prompt()
                .user(message)
                .call()
                .content();
    }
}
