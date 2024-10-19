package br.com.fiap.apinextgen.feedback;

import br.com.fiap.apinextgen.ApiNextgenApplication;
import jakarta.validation.Valid;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    private final FeedbackService feedbackService;
    private final RabbitTemplate rabbitTemplate;

    public FeedbackController(FeedbackService feedbackService, RabbitTemplate rabbitTemplate) {
        this.feedbackService = feedbackService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping
    public List<Feedback> getAll() {
        return feedbackService.getAllFeedbacks();
    }

    @GetMapping("{id}")
    public Feedback getById(@PathVariable Long id) {
        return feedbackService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Feedback post(@RequestBody @Valid Feedback f) {
        rabbitTemplate.convertAndSend(ApiNextgenApplication.FEEDBACK_QUEUE, "Novo feedback feito: " + f.getFeedbackDate());
        return feedbackService.createFeedback(f);
    }

    @PutMapping("{id}")
    public Feedback update(@RequestBody Feedback f, @PathVariable Long id) {
        return feedbackService.updateFeedback(f, id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
    }

}
