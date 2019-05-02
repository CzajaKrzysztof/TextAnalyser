package pl.codecool.textiterator;

import java.util.Iterator;

public class WordIterator implements Iterator<String> {
    private String[] fileContentList;
    private int index;

    public WordIterator(String fileContent) {
        fileContentList = splitFileContentToList(fileContent);
        index = 0;
    }

    private String[] splitFileContentToList(String fileContent) {
        return fileContent.replaceAll(" +", " ").split(" ");
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
