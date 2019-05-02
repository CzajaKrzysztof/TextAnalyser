package pl.codecool;

import pl.codecool.textloader.FileContent;

import java.io.IOException;
import java.util.Iterator;

public class Application {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("You need to pass file name ass argument.");
        } else {
            for (String filename: args) {
                try {
                    FileContent fileContent = new FileContent(filename);
                    Iterator<String> charIterator = fileContent.charIterator();
                    Iterator<String> wordIterator = fileContent.wordIterator();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
