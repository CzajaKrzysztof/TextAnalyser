package pl.codecool.view;

import java.util.Collection;

public class View {
    public void print(String string) {
        System.out.println(string);
    }

    public void print(int number) {
        System.out.println(number);
    }

    public void print(Collection<String> collection) {
        System.out.println(collection.toString());
    }
}
