package pl.codecool.controller;

import pl.codecool.statisticalanalysis.StatisticalAnalysis;
import pl.codecool.textloader.FileContent;
import pl.codecool.view.View;

import java.io.IOException;

public class TextAnalysisController {
    View view;
    String[] args;

    public TextAnalysisController(String[] args, View view) {
        this.view = view;
        this.args = args;
    }

    public void run() {
        if (args.length == 0) {
            view.print("You need to pass file name ass argument.\n");
        } else {
            long startTime = System.nanoTime();
            for (String filename : args) {
                FileContent fileContent = loadFileContent(filename);
                showFileStatistics(filename, fileContent);
            }
            view.print(String.format("Benchmark time: %.3f sec", (System.nanoTime() - startTime) / 1000000000.0));
        }
    }

    private FileContent loadFileContent(String filename) {
        FileContent fileContent = null;
        try {
            fileContent = new FileContent(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
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
