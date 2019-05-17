package pl.codecool;

import pl.codecool.controller.TextAnalysisController;
import pl.codecool.view.View;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        TextAnalysisController controller = new TextAnalysisController(args, view);
        controller.run();
    }
}