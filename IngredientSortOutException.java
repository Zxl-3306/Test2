package com.company;

import java.util.ArrayList;

/*
果汁或啤酒售完
*/
public class IngredientSortOutException extends RuntimeException{
    public IngredientSortOutException() {
    }

    public IngredientSortOutException(String message) {
        super(message);
    }
}
