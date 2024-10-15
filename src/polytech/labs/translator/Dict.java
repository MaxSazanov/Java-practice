package polytech.labs.translator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Optional;
import java.util.logging.*;

public class Dict {
    private final HashMap<String, String> dictionary;
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

    public Dict() {
        dictionary = new HashMap<>();
    }

    public Dict(HashMap<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public static Optional<Dict> readDict(Path path) {
        HashMap<String, String> dictionary = new HashMap<>();
        /*
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach((line) -> {
                String[] entry = line.split("\\|");
                if (entry.length == 2) {
                    dictionary.put(entry[0], entry[1]);
                }
                else {
                    logger.log(Level.WARNING, "incorrect entry: " + line);
                }
            });
        }
        */
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                String[] entry = line.split("\\|");
                if (entry.length == 2) {
                    dictionary.put(entry[0], entry[1]);
                }
                else {
                    logger.log(Level.WARNING, "incorrect entry: " + line);
                }
            }
        }
        catch (IOException e) {
            logger.log(Level.SEVERE, "invalid file");
        }

        if (dictionary.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(new Dict(dictionary));
    }

    public String getTranslation(String word) {
        return dictionary.get(word);
    }
}