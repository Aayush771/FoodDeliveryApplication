package com.foodApp.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResturantNotFoundException extends RuntimeException {

	public ResturantNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
