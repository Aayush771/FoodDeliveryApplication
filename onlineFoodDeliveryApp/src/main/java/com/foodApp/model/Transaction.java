package com.foodApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId;
	
	private LocalDateTime transactionDate;
	
	private double amount;
	
	private String description;
	
	private Integer walletId;

	public Transaction(LocalDateTime transactionDate, double amount,
                       String description) {
		super();
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.description = description;
	}

}
