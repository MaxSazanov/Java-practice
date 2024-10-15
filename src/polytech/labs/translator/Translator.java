package polytech.labs.translator;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Translator {
    Dict dictionary;
    private static final Logger logger = Logger.getLogger(Solution.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("src/theory/logs/log1.log", true);
            fileHandler.setLevel(Level.INFO);
            fileHandler.setFormatter(new SimpleFormatter());

            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void translate(Path path) {
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNext()) {
                String line = scanner.next("[!.,?:]");
                String[] words = line.split("\\s");
                String phrase;
                String translation;
                String relevantTranslation;
                for (int i = 0; i < words.length; i++) {
                    phrase = words[i];

                    for (int j = i; j < words.length; j++) {
                        if (i != j) {
                            phrase += words[j];
                        }
                        translation = dictionary.getTranslation(phrase);
                        if (translation != null) {
                            relevantTranslation = translation;
                            i = j;
                        }
                    }
                }
            }
        }
        catch (IOException e) {
            logger.log(Level.SEVERE, "invalid file to translate");
        }
    }
}
