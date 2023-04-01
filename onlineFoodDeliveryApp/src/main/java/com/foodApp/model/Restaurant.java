package com.foodApp.model;

import java.util.ArrayList;
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
public class Restaurant {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer restaurantId;
	private String restaurantName;
	private String managerName;
	private String contactNo;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	@JsonIgnore
	@OneToMany(mappedBy ="restaurant",cascade = CascadeType.ALL)
	private List<Item> item = new ArrayList<>();
}