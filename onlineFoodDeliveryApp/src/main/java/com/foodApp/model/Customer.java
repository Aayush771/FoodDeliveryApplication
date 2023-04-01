package com.foodApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer customerId;
	private String name;
	private Integer age;
	private String gender;
	private String mobileNo;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private String email;
	private String role;
	@JsonIgnore
	@Embedded
	@ElementCollection
	private List<Address> address;
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private FoodCart foodCart;
	@JsonIgnore
	@OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
	private List<OrderDetails> orderDetails;

}

