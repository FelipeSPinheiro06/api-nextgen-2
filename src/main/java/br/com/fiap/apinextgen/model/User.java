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
    public Long id;

    @NotNull
    @Size(min = 3, max = 64)
    public String name;

    @NotNull
    @PastOrPresent
    public LocalDate registrationDate;

    @NotNull
    public boolean isSatisfied;

    public String gender;

    @NotNull
    public boolean aged;

    @Min(1)
    @NotNull
    public BigDecimal timeOfService;

    @NotNull
    @FutureOrPresent
    public LocalDate exitForecast;
}
