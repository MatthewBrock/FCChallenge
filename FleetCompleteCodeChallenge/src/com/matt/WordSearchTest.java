package com.matt;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordSearchTest {
    private final List<String> testDictionary1 = Arrays.asList("dog", "go", "gem", "ham", "jam", "god", "arc", "car", "apple", "tel");
    private final List<String> testDictionary2 = Arrays.asList("list", "silent", "lines", "it", "is", "god", "arc", "car", "man's");
    private final List<String> testDictionary3 = Arrays.asList("list", "silent", "lines", "it", "leap", "pea", "app", "eeapp");

    @Test
    void testFindWords() {

        List<String> foundWords0 = WordSearch.findWords("aplet", testDictionary1);
        assertEquals(Arrays.asList("tel"), foundWords0);

        List<String> foundWords1 = WordSearch.findWords("listen", testDictionary2);
        assertEquals(Arrays.asList("list", "silent", "lines", "it", "is"), foundWords1);

        List<String> foundWords2 = WordSearch.findWords("items", testDictionary2);
        assertEquals(Arrays.asList("it", "is"), foundWords2);

        List<String> foundWords3 = WordSearch.findWords("car", testDictionary2);
        assertEquals(Arrays.asList("arc", "car"), foundWords3);

        List<String> foundWords4 = WordSearch.findWords("not", testDictionary2);
        assertEquals( Collections.emptyList(), foundWords4);

        List<String> foundWords5 = WordSearch.findWords("", testDictionary2);
        assertEquals(Collections.emptyList(), foundWords5);

        List<String> foundWords6 = WordSearch.findWords("Hoffman's", testDictionary2);
        assertEquals(Collections.singletonList("man's"), foundWords6);

        List<String> foundWords7 = WordSearch.findWords("apple", testDictionary3);
        assertEquals(Arrays.asList("leap", "pea", "app"), foundWords7);

        List<String> foundWords8 = WordSearch.findWords("eeapp", testDictionary3);
        assertEquals(Arrays.asList("pea", "app", "eeapp"), foundWords8);

        List<String> foundWords9 = WordSearch.findWords("applet", testDictionary1);
        assertEquals(Arrays.asList("apple", "tel"), foundWords9);

    }
}