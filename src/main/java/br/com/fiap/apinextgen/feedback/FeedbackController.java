package br.com.fiap.apinextgen.feedback;

import br.com.fiap.apinextgen.ApiNextgenApplication;
import jakarta.validation.Valid;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.util.List;


@Controller
public class FeedbackController {

    private final FeedbackService feedbackService;
    private final RabbitTemplate rabbitTemplate;

    public FeedbackController(FeedbackService feedbackService, RabbitTemplate rabbitTemplate) {
        this.feedbackService = feedbackService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping
    public String index(Model model) {
        var feedbacks = get();
        model.addAttribute("feedbacks", feedbacks);
        return "index";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "form";
    }

    @GetMapping("/feedbacks")
    public List<Feedback> get() {
        return feedbackService.getAllFeedbacks();
    }

    @GetMapping("/feedbacks/{id}")
    public Feedback getById(@PathVariable Long id) {
        return feedbackService.getById(id);
    }

    @PostMapping(value = "/feedbacks")
    @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody @Valid Feedback f, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) return "form";

        feedbackService.createFeedback(f);
        redirect.addFlashAttribute("message", "Feedback cadastrado com sucesso");
        rabbitTemplate.convertAndSend(ApiNextgenApplication.FEEDBACK_QUEUE, "Novo feedback feito: " + f.getFeedbackDate());
        return "redirect:/";
    }

    @PutMapping("/feedbacks/{id}")
    public Feedback update(@RequestBody Feedback f, @PathVariable Long id) {
        return feedbackService.updateFeedback(f, id);
    }

    @DeleteMapping("/feedbacks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
    }

}
