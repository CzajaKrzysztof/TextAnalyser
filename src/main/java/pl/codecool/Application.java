package pl.codecool;

import pl.codecool.controller.TextAnalasisController;
import pl.codecool.view.View;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        TextAnalasisController controller = new TextAnalasisController(args, view);
        controller.run();
    }
}