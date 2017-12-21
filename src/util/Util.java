package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Util {
    public static String firstLine(String filename, Class<?> adjacentClass) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(adjacentClass.getResourceAsStream(filename)))) {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read input", e);
        }
    }

    public static List<String> allLines(String fileName, Class<?> adjacentClass) {
        try {
            return Files.readAllLines(Paths.get(adjacentClass.getResource("input").toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Failed to read input", e);
        }
    }
}
