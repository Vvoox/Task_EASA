package com.easa;

import com.easa.constants.Values;
import com.easa.service.BackWord;
import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        BackWord detectBackWord = new BackWord();
        String Result = detectBackWord.detectBackWords(Values.PATH);
        System.out.println(Result);
    }
}
