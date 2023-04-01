package com.foodApp.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoItemFoundInFoodcart extends RuntimeException {
       public NoItemFoundInFoodcart(String message) {
    	   super(message);
       }
}
