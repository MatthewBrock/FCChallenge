package com.matt;

import java.io.*;
import java.util.*;

public class WordSearch {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Incorrect Number of Arguments");
            return;
        }
        String input = args[0].toLowerCase();
        String filename = args[1];
        List<String> dictionary = readFile(filename);

        for (String word : findWords(input, dictionary)) {
            System.out.println(word);
        }
    }

    /**
     * @param input      The input string / Master Word
     * @param dictionary List of words in the dictionary
     * @return All of the words from the dictionary that can be made using the Master Word
     */
    public static List<String> findWords(String input, List<String> dictionary) {
        List<String> outputWords = new ArrayList<>();
        int[] masterLetterCount = new int[256];
        char[] masterWordChars = input.toCharArray();
        for (char c : masterWordChars) {
            if (c < 256) {
                masterLetterCount[c] += 1;
            }
        }

        for (String word : dictionary) {
            int[] masterLetterCountCopy = masterLetterCount.clone();
            char[] wordChars = word.toLowerCase().toCharArray();
            for (char c : wordChars) {
                if (c < 256) {
                    masterLetterCountCopy[c] -= 1;
                }
            }
            boolean add = true;
            for (int i : masterLetterCountCopy) {
                if (i < 0) {
                    add = false;
                    break;
                }
            }
            if (add) {
                outputWords.add(word);
            }
        }
        return outputWords;
    }

    private static List<String> readFile(String filename) {
        List<String> lines = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toLowerCase();
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to Read Dictionary");
        }
        return lines;
    }
}