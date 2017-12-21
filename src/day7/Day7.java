package day7;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day7 {
	private static final Pattern NODE_PATTERN = Pattern.compile("^(\\w+) \\((\\d+)\\)(?: -> (.*))?$");

	public static void main(String[] args) throws URISyntaxException, IOException {
		List<String> lines = Files.readAllLines(Paths.get(Day7.class.getResource("input").toURI()));
		Map<String, Node> nodeStorage = new HashMap<>();
		List<Node> nodeList = lines.stream().map(l -> parseNode(l, nodeStorage)).collect(Collectors.toList());
		nodeList.forEach(n -> nodeStorage.put(n.name, n));
		Node root = findRoot(nodeStorage);

		System.out.println("Root: " + root.name);
		Node lastUnbalancedRoot = root;
		Node unbalancedRoot = root.getRootOfUnbalancedSubtree();
		while (unbalancedRoot != lastUnbalancedRoot) {
			lastUnbalancedRoot = unbalancedRoot;
			unbalancedRoot = lastUnbalancedRoot.getRootOfUnbalancedSubtree();
		}
		System.out.println("Unbalanced subtrees: total weight (individual weight)");
		for (Node child : unbalancedRoot.children()) {
			System.out.println(child.name + ": " + child.totalWeight() + " (" + child.weight + ")");
		}
	}

	private static Node parseNode(String line, Map<String, Node> nodeStorage) {
		Matcher m = NODE_PATTERN.matcher(line);
		m.find();
		String name = m.group(1);
		int weight = Integer.parseInt(m.group(2));
		String children = m.group(3);
		if (children == null) {
			return new Node(name, weight, new String[0], nodeStorage);
		} else {
			return new Node(name, weight, children.split(", "), nodeStorage);
		}
	}

	private static class Node {
		private final String name;
		private final int weight;
		private final String[] children;
		private Map<String, Node> nodes;
		private Optional<Integer> totalWeight;

		Node(String name, int weight, String[] children, Map<String, Node> nodes) {
			this.name = name;
			this.weight = weight;
			this.children = children;
			this.nodes = nodes;
			this.totalWeight = Optional.empty();
		}

		List<Node> children() {
			return Arrays.stream(children).map(c -> nodes.get(c)).collect(Collectors.toList());
		}

		int totalWeight() {
			if (!this.totalWeight.isPresent()) {
				this.totalWeight = Optional.of(calculateTotalWeight());
			}
			return this.totalWeight.get();
		}

		private int calculateTotalWeight() {
			return Arrays.stream(children).mapToInt(c -> nodes.get(c).totalWeight()).sum() + weight;
		}

		boolean areDescendentsBalanced() {
			if (children.length == 0) {
				return true;
			}
			if (children.length == 1) {
				return children().get(0).areDescendentsBalanced();
			}
			List<Node> children = children();
			int firstWeight = children.get(0).totalWeight();
			for (Node child : children) {
				if (child.totalWeight() != firstWeight) {
					return false;
				}
			}
			return true;
		}

		Node getRootOfUnbalancedSubtree() {
			for (Node c : children()) {
				if (!c.areDescendentsBalanced()) {
					return c;
				}
			}
			// All subtrees are balanced, so the difference is in weight between the direct children
			return this;
		}
	}

	private static Node findRoot(Map<String, Node> nodes) {
		Set<String> nodeNames = new HashSet<>(nodes.keySet());
		for (Node node : nodes.values()) {
			nodeNames.removeAll(Arrays.asList(node.children));
		}
		if (nodeNames.size() != 1) {
			throw new IllegalArgumentException("Input nodes did not contain a single root node, " + nodeNames.size() + " found instead");
		}
		return nodes.get(nodeNames.iterator().next());
	}
}
