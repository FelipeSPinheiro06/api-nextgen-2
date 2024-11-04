package br.com.fiap.apinextgen.feedback;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "feedbacks")
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String feeling;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "feedback_date")
    private LocalDate feedbackDate;
    private String company;


    public Feedback(String feeling, String description, LocalDate feedbackDate) {
    }
}
