package pl.codecool.statisticalanalysis;

import java.util.*;

public class StatisticalAnalysis {
    private Iterator<String> iterator;
    private TreeMap<String, Integer> dictionary;

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
        int count = 0;
        for (int i = 0; i < strings.length; i++) {
            String key = strings[i];
            if(dictionary.getOrDefault(key, -1) != -1) {
                count += dictionary.get(key);
            }
        }

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

    public TreeSet<String> occurMoreThen(int times) {
        TreeSet<String> occurens = new TreeSet<>();

        for(String key: dictionary.keySet()) {
            if(dictionary.get(key) > times) {
                occurens.add(key);
            }
        }

        return occurens;
    }

    public TreeMap<String, Integer> getDictionary() {
        return dictionary;
    }
}
