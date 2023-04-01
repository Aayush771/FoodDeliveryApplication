package com.foodApp.model;

import java.time.LocalDateTime;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetails {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer orderId;
	private LocalDateTime datetime;
	private String orderStatus;
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private FoodCart cart;
	private Integer totalAmount;
	private Integer totalItem;
	@ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
}
