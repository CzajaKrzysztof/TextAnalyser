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
        assertTrue(charStatistics.getDictionary().size() > 0);
    }

    @Test
    void testIfDictionaryIsPopulatedByWOrdIterator() {
        assertTrue(wordStatistics.getDictionary().size() > 0);
    }

    @Test
    void testCharCount() {
        assertEquals(1031, charStatistics.size());
    }

    @Test
    void testWordCount() {
        assertEquals(268, wordStatistics.size());
    }

    @Test
    void testWordsDictionarySize() {
        assertEquals(141, wordStatistics.dictionarySize());
    }

    @Test
    void testCountOfForSingleWord() {
        assertEquals(1, wordStatistics.countOf("love"));
    }

    @Test
    void testCountOfForMultipleWords() {
        assertEquals(4, wordStatistics.countOf("love", "music"));
    }

    @Test
    void testOccureMoreThenOnePercent() {
        String[] expectedWords = {"a","and","as","been","but","figure","had","i","in","is","it","me","music","no","not",
                "of","old","the","to","was","where"};
        assertArrayEquals(expectedWords, wordStatistics.occurMoreThen(wordStatistics.size() / 100).toArray());
    }
}