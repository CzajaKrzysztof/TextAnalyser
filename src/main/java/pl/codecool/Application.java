package pl.codecool;

import pl.codecool.controller.TextAnalasisController;

public class Application {
    public static void main(String[] args) {
        TextAnalasisController controller = new TextAnalasisController(args);
        controller.runner();
    }
}