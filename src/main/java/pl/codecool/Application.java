package pl.codecool;

import pl.codecool.statisticalanalysis.StatisticalAnalysis;
import pl.codecool.textloader.FileContent;
import pl.codecool.view.View;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        View view = new View();

        if (args.length == 0) {
            System.out.println("You need to pass file name ass argument.");
        } else {
            for (String filename: args) {
                FileContent fileContent = null;
                try {
                    fileContent = new FileContent(filename);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Iterator<String> charIterator = fileContent.charIterator();
                Iterator<String> wordIterator = fileContent.wordIterator();

                StatisticalAnalysis charStats = new StatisticalAnalysis(charIterator);
                StatisticalAnalysis wordStats = new StatisticalAnalysis(wordIterator);

                view.print(String.format("==%s==\n", filename));
                view.print("Char count: ");
                view.print(charStats.size());
                view.print("Word count: ");
                view.print(wordStats.size());
                view.print("Dict size: ");
                view.print(wordStats.dictionarySize());
                view.print("Most used words (>1%): ");
                view.print(wordStats.occurMoreThen(wordStats.size()/100));
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
        }
    }

    private static void showLettersPercentage(View view, StatisticalAnalysis charStats) {
        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for(char chr: letters) {
            double letterPercentage = ((double) charStats.countOf(chr + "") * (double) 100) / (double) charStats.size();
            view.print(String.format("[ %s -> %.2f ] ", (chr + "").toUpperCase(), letterPercentage));
        }
        view.print("\n");
    }
}