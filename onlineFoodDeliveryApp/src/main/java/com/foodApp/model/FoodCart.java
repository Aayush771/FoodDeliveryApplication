package com.foodApp.model;

import java.util.List;


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
public class FoodCart {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer cartId;
	@OneToMany(mappedBy = "foodCart",cascade = CascadeType.ALL)
	private List<Item> items;


}