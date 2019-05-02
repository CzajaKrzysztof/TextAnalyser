package pl.codecool.textiterator;

import java.util.Iterator;

public class CharIterator implements Iterator<String> {
    String[] fileContentList;

    public CharIterator(String fileContent) {
        fileContentList = splitContentToList(fileContent);
    }

    private String[] splitContentToList(String fileContent) {
        return fileContent.replaceAll(" +", "").split("");
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public String next() {
        return null;
    }
}
