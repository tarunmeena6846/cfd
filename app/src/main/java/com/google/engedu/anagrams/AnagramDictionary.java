
package com.google.engedu.anagrams;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();
    private ArrayList<String> wordList;
    private HashSet<String> wordset;
    private HashMap<String, ArrayList<String>> lettersToWord = new HashMap<>();

    public AnagramDictionary(Reader reader) throws IOException {
        BufferedReader in = new BufferedReader(reader);
        wordList = new ArrayList<>();
        wordset = new HashSet<>();
        String line;

        Log.e("Dictionary", sortLetters("dcba"));


        while ((line = in.readLine()) != null) {
            String word = line.trim();
            wordList.add(word);
            wordset.add(word);
            String sortedWord = sortLetters(word);
            if (lettersToWord.containsKey(sortedWord)) {
                ArrayList<String> listword = lettersToWord.get(sortedWord);
                listword.add(word);
                lettersToWord.put(sortedWord, listword);
            } else {
                ArrayList<String> listword = new ArrayList<>();
                listword.add(word);
                lettersToWord.put(sortedWord, listword);
            }
        }
    }

    private String sortLetters(String word) {
        char[] letters = word.toCharArray();
        Arrays.sort(letters);
//        Log.e("Dictionary, letters", letters.toString());
        return new String(letters);
    }

    public boolean isGoodWord(String word, String base) {
        return true;
    }


    public ArrayList<String> getAnagrams(String targetWord) {
       String sortedTargetWord= sortLetters(targetWord);
        ArrayList<String> result = new ArrayList<String>();

        for(String word :wordList)
        {
            if(sortLetters(word).equals(sortedTargetWord) && !Objects.equals(word, targetWord)) {
                Log.e("Game", word);
                result.add(word);
            }
        }
        return result;

    }

    public List<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<String>();
        return result;
    }

    public String pickGoodStarterWord() {

        // Too much complexity
//        while (true) {
//            String word = wordList.get((int) (Math.random() * wordList.size()));
//            ArrayList<String> anagrams = getAnagrams(word);
//            if (anagrams.size() >= 6) {
//                return word;
//            }
//        }

//        return "skate";

        ArrayList<String> good_words = new ArrayList<>();
        good_words.add("arrest");
        good_words.add("ratest");
        good_words.add("carets");
        good_words.add("drapes");
        good_words.add("palest");
        good_words.add("lapse");
        good_words.add("leaps");
        good_words.add("least");
        good_words.add("merits");
        good_words.add("slate");
        good_words.add("staple");
        good_words.add("mister");
        good_words.add("plates");
        good_words.add("steal");
        good_words.add("pares");
        good_words.add("traces");
        good_words.add("spear");
        good_words.add("reaps");
        good_words.add("spare");
        good_words.add("reacts");
        good_words.add("least");
        good_words.add("apers");
        good_words.add("alerts");

        return good_words.get((int) (Math.random() * good_words.size()));
    }
}
