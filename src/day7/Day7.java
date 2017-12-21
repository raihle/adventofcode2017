package day7;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day7 {
    public static void main(String[] args) throws URISyntaxException, IOException {
        List<String> lines = Files.readAllLines(Paths.get(Day7.class.getResource("input").toURI()));
        Set<String> allNodes = findAllNodes(lines);
        Set<String> allChildNodes = findAllChildNodes(lines);
        System.out.println("Root node: " + allNodes.stream().filter(n -> !allChildNodes.contains(n)).findAny());
    }


    private static Set<String> findAllNodes(List<String> lines) {
        Set<String> nodes = new HashSet<>();
        for (String line : lines) {
            String name = line.split(" ")[0];
            nodes.add(name);
        }
        return nodes;
    }

    private static Set<String> findAllChildNodes(List<String> lines) {
        Set<String> childNodes = new HashSet<>();
        for (String line : lines) {
            int arrowIndex = line.indexOf("->");
            if (arrowIndex >= 0) {
                String[] children = line.substring(arrowIndex + 3).split(", ");
                childNodes.addAll(Arrays.asList(children));
            }
        }
        return childNodes;
    }
}
