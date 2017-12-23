package day12;

import util.Input;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day12 {
	private static final Pattern LINE_PATTERN = Pattern.compile("(^\\w+) <-> (.+)$");
	private static Map<String, Set<String>> adjacent = new HashMap<>();
	private static Map<String, Set<String>> reachable = new HashMap<>();

	public static void main(String[] args) {
		List<String> input = Input.allLines("day12");

		for (String line : input) {
			Matcher lineMatcher = LINE_PATTERN.matcher(line);
			lineMatcher.find();
			String name = lineMatcher.group(1);
			String[] listedConnections = lineMatcher.group(2).split(", ");
			adjacent.put(name, new HashSet<>(Arrays.asList(listedConnections)));
		}

		Set<String> reachableFrom0 = getReachableNodes("0");
		System.out.println(reachableFrom0.size());
	}

	private static void calculateReachableNodes(String name) {
		Set<String> reached = new HashSet<>();
		LinkedList<String> queue = new LinkedList<>(adjacent.get(name));
		// Make sure that the current node is part of the reachability group,
		// in case the node has no connections
		queue.add(0, name);
		while (!queue.isEmpty()) {
			String reachedNode = queue.removeFirst();
			if (reached.add(reachedNode)) {
				if (reachable.containsKey(reachedNode)) {
					// If the just reached node has already been explored, copy that set.
					// There's no need to queue the nodes since they have already been explored
					reached.addAll(reachable.get(reachedNode));
				} else {
					// Otherwise just queue all adjacent nodes for exploration
					queue.addAll(adjacent.get(reachedNode));
				}
			}
		}
		// Any node found this way is part of the same reachability group
		for (String node : reached) {
			reachable.put(node, reached);
		}
	}

	private static Set<String> getReachableNodes(String name) {
		if (!reachable.containsKey(name)) {
			calculateReachableNodes(name);
		}
		return reachable.get(name);
	}
}
