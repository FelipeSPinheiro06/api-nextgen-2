package br.com.fiap.apinextgen.feedback;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String feeling;
    private LocalDate feedbackDate;
    private String company;

}
