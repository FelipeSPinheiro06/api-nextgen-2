package br.com.fiap.apinextgen.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate registrationDate;

    private boolean isSatisfied;

    private String gender;

    private boolean aged;

    private BigDecimal timeOfService;

    private LocalDate exitForecast;
}
