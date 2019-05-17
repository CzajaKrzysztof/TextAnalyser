package pl.codecool.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private View view;

    @BeforeEach
    public void setUpStreams() {
        view = new View();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testPrintString() {
        view.print("test String");
        assertEquals("test String", outContent.toString(), "Test View.print(String string) method.");
    }

    @Test
    public void testPrintIntNumber() {
        view.print(1);
        assertEquals("1\n", outContent.toString(), "Test View.print(int number) method.");
    }

    @Test
    public void testPrintDoubleNumber() {
        view.print(1.1);
        assertEquals("1.1\n", outContent.toString(), "Test View.print(double number) method.");
    }

    @Test
    public void testPrintPopulatedCollection() {
        ArrayList<String> listOfString = new ArrayList<>();
        listOfString.add("a");
        listOfString.add("b");
        listOfString.add("c");

        view.print(listOfString);
        assertEquals("[a, b, c]\n", outContent.toString(), "Test View.print" +
                "(Collection<String> collection) method with populated collection.");
    }

    @Test
    public void testPrintEmptyCollection() {
        ArrayList<String> listOfString = new ArrayList<>();

        view.print(listOfString);
        assertEquals("[]\n", outContent.toString(), "Test View.print" +
                "(Collection<String> collection) method with empty collection.");
    }

    @Test
    public void testPrintPopulatedMap() {
        Map<String, Integer> testMap = new LinkedHashMap<>();
        testMap.put("one", 1);
        testMap.put("two", 2);
        testMap.put("three", 3);

        view.print(testMap);
        assertEquals("Key:  one | Value:    1\nKey:  two | Value:    2\nKey: three | Value:    3\n",
                outContent.toString(), "Test View.print" +
                "(Map<String, Integer> map) method with populated map.");
    }

    @Test
    public void testPrintEmptyMap() {
        Map<String, Integer> testMap = new LinkedHashMap<>();

        view.print(testMap);
        assertEquals("",
                outContent.toString(), "Test View.print" +
                        "(Map<String, Integer> map) method with empty map.");
    }
}