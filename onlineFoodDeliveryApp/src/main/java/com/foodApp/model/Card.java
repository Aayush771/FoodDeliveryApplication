package com.foodApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer  cardId;
    private Long cardNumber;
    private String cardServiceProvider;
    private Double cardAmount;
    private LocalDate expDate = LocalDate.now().plusYears(5);
    private LocalDate issueDate = LocalDate.now();
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
}
