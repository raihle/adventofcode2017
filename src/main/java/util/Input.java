package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Input {
    public static String firstLine(String fileName) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(Input.class.getResourceAsStream("/input/" + fileName)))) {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read input", e);
        }
    }

    public static List<String> allLines(String fileName) {
        try {
            return Files.readAllLines(Paths.get(Input.class.getResource("/input/" + fileName).toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Failed to read input", e);
        }
    }
}
