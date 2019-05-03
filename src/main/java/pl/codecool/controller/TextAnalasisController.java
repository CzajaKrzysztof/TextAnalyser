package pl.codecool.controller;

import pl.codecool.statisticalanalysis.StatisticalAnalysis;
import pl.codecool.textloader.FileContent;
import pl.codecool.view.View;

import java.io.IOException;

public class TextAnalasisController {
    View view;
    String[] args;

    public TextAnalasisController(String[] args) {
        view = new View();
        this.args = args;
    }

    public void runner() {
        if (args.length == 0) {
            view.print("You need to pass file name ass argument.\n");
        } else {
            for (String filename : args) {
                FileContent fileContent = null;
                try {
                    fileContent = new FileContent(filename);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                showFileStatistics(filename, fileContent);
            }
        }
    }

    private void showFileStatistics(String filename, FileContent fileContent) {
        StatisticalAnalysis charStats = new StatisticalAnalysis(fileContent.charIterator());
        StatisticalAnalysis wordStats = new StatisticalAnalysis(fileContent.wordIterator());

        view.print(String.format("==%s==\n", filename));
        view.print("Char count: ");
        view.print(charStats.size());
        view.print("Word count: ");
        view.print(wordStats.size());
        view.print("Dict size: ");
        view.print(wordStats.dictionarySize());
        view.print("Most used words (>1%): ");
        view.print(wordStats.occurMoreThen(wordStats.size() / 100));
        view.print("'love' count: ");
        view.print(wordStats.countOf("love"));
        view.print("'hate' count: ");
        view.print(wordStats.countOf("hate"));
        view.print("'music' count: ");
        view.print(wordStats.countOf("music"));
        view.print("vowels %: ");
        view.print(((charStats.countOf("a", "e", "i", "o", "u") * 100) / charStats.size()));
        view.print("'a':'e' count ratio : ");
        view.print(((double) charStats.countOf("a") / (double) charStats.countOf("e")));
        showLettersPercentage(view, charStats);
    }

    private void showLettersPercentage(View view, StatisticalAnalysis charStats) {
        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for(char chr: letters) {
            double letterPercentage = ((double) charStats.countOf(chr + "") * (double) 100) / (double) charStats.size();
            view.print(String.format("[ %s -> %.2f ] ", (chr + "").toUpperCase(), letterPercentage));
        }
        view.print("\n");
    }
}
