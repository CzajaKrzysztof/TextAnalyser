package pl.codecool.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.codecool.view.View;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TextAnalysisControllerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testRunWithNoFileNamesInArgs() {
        View view = new View();
        String[] args = new String[0];
        TextAnalysisController controller = new TextAnalysisController(args, view);
        controller.run();
        assertEquals("You need to pass file name ass argument.\n", outContent.toString(), "Test " +
                "controller`s main methos run() with empty args array.");
    }

}