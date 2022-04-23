package com.easa.utils;

import java.util.Optional;

import static com.easa.constants.Values.SPACE;

public class Tools {

    // Check if has one word
    public static boolean contentHasOneWord(String text){
        return  text.split(SPACE).length == 1;
    }

    // reverse the word
    public static String getBackWord(String word){
        String backWord ="";
        if(Optional.ofNullable(word).isPresent()){
            for(int i = word.length()-1 ; i>=0  ; i--){
                backWord += word.charAt(i);
            }
        }
        return backWord;
    }

    //Check if not empty or containing one word
    public static boolean notEmptyOrOneWord(String text){
        if(Optional.ofNullable(text).isPresent()){
            return !text.isEmpty() && !contentHasOneWord(text);
        }
        return false;
    }
}
