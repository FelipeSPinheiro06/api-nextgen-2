package br.com.fiap.apinextgen.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;

@Controller
public class ChatController {

    @Autowired
    ChatService chatService;

    @PostMapping("/enviar")
    public String sendToAi(@RequestBody Map<String, String> payload, Model model) {
        String message = payload.get("message");
        String response = chatService.sendToAi(message);
        model.addAttribute("response", response);
        return "form";
    }

}
