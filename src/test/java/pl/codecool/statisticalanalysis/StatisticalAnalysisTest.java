package pl.codecool.statisticalanalysis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.codecool.textloader.FileContent;

import java.io.IOException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class StatisticalAnalysisTest {
    private FileContent fileContent;
    private Iterator<String> charIterator;
    private Iterator<String> wordIterator;
    StatisticalAnalysis charStatistics;
    StatisticalAnalysis wordStatistics;

    @BeforeEach
    void loadTextFile() {
        try {
            fileContent = new FileContent("src/main/resources/test.txt");
            wordIterator = fileContent.wordIterator();
            charIterator = fileContent.charIterator();
            charStatistics = new StatisticalAnalysis(charIterator);
            wordStatistics = new StatisticalAnalysis(wordIterator);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testIfDictionaryIsPopulatedByCharIterator() {
        assertTrue(charStatistics.getDictionary().size() > 0, "Test if dictionary is populated by " +
                "character iterator");
    }

    @Test
    void testIfDictionaryIsPopulatedByWOrdIterator() {
        assertTrue(wordStatistics.getDictionary().size() > 0, "Test if dictionary is populated by " +
                "word iterator");
    }

    @Test
    void testCharCount() {
        assertEquals(1031, charStatistics.size(), "Test size method to sum counts of chars in " +
                "dictionary");
    }

    @Test
    void testWordCount() {
        assertEquals(268, wordStatistics.size(), "Test size method to sum counts of words in " +
                "dictionary");
    }

    @Test
    void testWordsDictionarySize() {
        assertEquals(141, wordStatistics.dictionarySize(), "Test dictionarySize method returning " +
                "size of dictionary");
    }

    @Test
    void testCountOfForSingleString() {
        assertEquals(1, wordStatistics.countOf("love"), "Test countOf method returning " +
                "count of specified string from dictionary");
    }

    @Test
    void testCountOfForMultipleStrings() {
        assertEquals(4, wordStatistics.countOf("love", "music"), "Test countOf method " +
                "returning count of multiple specified strings from dictionary");
    }

    @Test
    void testCountOfWIthNoStrings() {
        assertEquals(0, wordStatistics.countOf(), "Test countOf method with no argument provided");
    }

    @Test
    void testCountOfWIthEmptyString() {
        assertEquals(0, wordStatistics.countOf(""), "Test countOf method with empty " +
                "string provided");
    }

    @Test
    void testOccurMoreThenOnePercent() {
        String[] expectedWords = {"a","and","as","been","but","figure","had","i","in","is","it","me","music","no","not",
                "of","old","the","to","was","where"};
        assertArrayEquals(expectedWords, wordStatistics.occurMoreThen(wordStatistics.size() / 100).toArray(),
                "Test method occurMoreThen method returning collection of strings occurring in dictionary " +
                        "more then given %");
    }
}