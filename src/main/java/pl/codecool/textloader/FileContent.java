package pl.codecool.textloader;

import pl.codecool.textiterator.IterableText;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class FileContent implements IterableText {
    public String fileContent;

    public FileContent(String filename) throws IOException {
        fileContent = getFileContent(filename);
    }

    private String getFileContent(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        try(BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            String nextLine;
            while((nextLine = fileReader.readLine()) != null) {
                stringBuilder.append(nextLine);
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString().toLowerCase().replaceAll("[^a-z ]", "");
    }

    @Override
    public Iterator<String> charIterator() {
        return null;
    }

    @Override
    public Iterator<String> wordIterator() {
        return null;
    }
}
