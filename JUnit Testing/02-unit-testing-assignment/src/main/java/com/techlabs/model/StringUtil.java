package com.techlabs.model;

public class StringUtil {
    public String truncateAInFirstTwoPlaces(String string){
        string = string.toUpperCase();
        if(string.isEmpty()){
            return "";
        }

        if(string.length()<=2){
            string=string.replace("A","");
            return string;
        }

        String firstTwo = string.substring(0,2);
        String theRestString = string.substring(2);
        firstTwo = firstTwo.replace("A","");

        return firstTwo + theRestString;
    }

    public boolean firstAndLastTwoCharactersAreEqual(String string){
        string = string.toUpperCase();

        if(string.length() < 2){
            return false;
        }

        String firstTwo = string.substring(0,2);
        String lastTwo = string.substring(string.length()-2);

        return firstTwo.equals(lastTwo);
    }
}
