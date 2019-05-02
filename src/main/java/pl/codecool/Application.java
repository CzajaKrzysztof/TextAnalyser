package pl.codecool;

import pl.codecool.textloader.FileContent;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("You need to pass file name ass argument.");
        } else {
            for (String filename: args) {
                try {
                    FileContent fileContent = new FileContent(filename);
                    fileContent.charIterator();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
