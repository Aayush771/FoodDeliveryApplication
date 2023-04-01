package com.foodApp.Exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ItemUnavailable  extends RuntimeException{
	public ItemUnavailable(String message) {
 	   super(message);
    }
}