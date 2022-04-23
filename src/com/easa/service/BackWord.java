package com.easa.service;

import com.easa.utils.Tools;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import static com.easa.constants.Values.*;

/**
 * @author KHALIL DAOULAT
 */
public class BackWord {

    /**
     * After getting a text of words, this function remove all the special characters from the text
     * And do a loup to check if exist a back word
     * @param filePath
     * @return word and back word
     * @throws IOException
     */
    public String detectBackWords(String filePath) throws IOException {
        String result = EMPTY;
        String content = Optional.ofNullable(filePath).isPresent() ?
                ReadFile.readFile(filePath, StandardCharsets.UTF_8)
                : EMPTY;

        if(Tools.notEmptyOrOneWord(content)) {
            content = content.replaceAll(SPECIAL_CHAR,EMPTY);
            String[] text = content.split(SPACE);
            Map<String,Object> map = new HashMap<>();
            for(int i = 0 ; i < text.length ; i++){
                map.put(WORD, text[i]);
                map.put(BACKWORD, Tools.getBackWord(text[i]));
                map.put(TEXT, text);
                map.put(WORD_INDEX, i);
                if(!checkIfBackWordExist(map).isEmpty()){
                    result += checkIfBackWordExist(map) + "\n";
                }
            }
        }
        return result;
    }

    /**
     * The purpose of this function is to check
     * the current word with a text of words and return if exist a back word for it
     * @param map of object
     * @return word and back word
     */
    private String checkIfBackWordExist(Map<String,Object> map) {
        String result = EMPTY;
        String backWord = (String) map.get(BACKWORD);
        String word = (String) map.get(WORD);
        String[] text = (String[]) map.get(TEXT);
        int wordIndex = (int) map.get(WORD_INDEX);
        if (Optional.ofNullable(backWord).isPresent() && Optional.ofNullable(text).isPresent()) {
            for (int i = wordIndex + 1; i < text.length; i++) {
                if (backWord.equals(text[i])){
                    result = word + KAMAS + SPACE + text[i];
                }
            }
        }
        return result;
    }

}
