package pl.codecool.view;

import java.util.Collection;
import java.util.Map;

public class View {
    public void print(String string) {
        System.out.print(string);
    }

    public void print(int number) {
        System.out.println(number);
    }

    public void print(double number) {
        System.out.println(number);
    }

    public void print(Collection<String> collection) {
        System.out.println(collection.toString());
    }

    public void print(Map<String, Integer> map) {
        for(String key: map.keySet()) {
            System.out.println(String.format("Key: %4s | Value: %4s", key, map.get(key)));
        }
    }
}
