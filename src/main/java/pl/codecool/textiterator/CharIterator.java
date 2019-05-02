package pl.codecool.textiterator;

import java.util.Iterator;

public class CharIterator implements Iterator<String> {
    String[] fileContentList;
    int index;

    public CharIterator(String fileContent) {
        fileContentList = splitContentToList(fileContent);
        index = 0;
    }

    private String[] splitContentToList(String fileContent) {
        return fileContent.replaceAll(" +", "").split("");
    }

    @Override
    public boolean hasNext() {
        return index < fileContentList.length;
    }

    @Override
    public String next() {
        return fileContentList[index++];
    }
}
