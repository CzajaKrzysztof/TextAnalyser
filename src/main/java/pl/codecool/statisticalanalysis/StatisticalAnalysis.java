package pl.codecool.statisticalanalysis;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class StatisticalAnalysis {
    Iterator<String> iterator;
    TreeMap<String, Integer> dictionary;

    public StatisticalAnalysis(Iterator<String> iterator) {
        this.iterator = iterator;
        dictionary = createDictionary();
    }

    private TreeMap<String, Integer> createDictionary() {
        TreeMap<String, Integer> tempDict = new TreeMap<>();

        while(iterator.hasNext()) {
            String key = iterator.next();
            tempDict.put(key, tempDict.getOrDefault(key, 0) + 1);
        }

        return tempDict;
    }

    public int countOf(String... strings) {
        int count =0;

        return count;
    }

    public int dictionarySize() {
        return dictionary.size();
    }

    public int size() {
        int sumOfEntries = 0;
        for(String key: dictionary.keySet()) {
            sumOfEntries += dictionary.get(key);
        }

        return sumOfEntries;
    }

    public Set<String> occurMoreThen(int) {

    }
}
