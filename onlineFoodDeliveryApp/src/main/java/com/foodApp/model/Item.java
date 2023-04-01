package com.foodApp.model;



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
public class Item{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer itemId;
	private String itemName;
	private Integer quantity;
	private Double cost;
	@ManyToOne(cascade = CascadeType.ALL)
	private Restaurant restaurant;

	@ManyToOne
	private FoodCart foodCart;
}