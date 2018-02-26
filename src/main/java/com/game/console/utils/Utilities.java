package com.game.console.utils;

public class Utilities {

	public static int convertLetterToInt(char val)
    {
        int toReturn;
        toReturn = val - 64;
        if(toReturn<1||toReturn>26) {
        	toReturn= -1;
        }
        return toReturn;
    }
}
