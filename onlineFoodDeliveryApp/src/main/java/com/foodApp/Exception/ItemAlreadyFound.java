package com.foodApp.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ItemAlreadyFound extends RuntimeException{
   public ItemAlreadyFound(String message) {
	   super(message);
   }
}