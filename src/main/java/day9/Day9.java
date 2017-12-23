package day9;

import util.Input;

import java.util.ArrayList;
import java.util.List;

public class Day9 {

	public static void main(String[] args) {
		String input = Input.firstLine("day9");
		String escapesRemoved = input.replaceAll("!.", "");

		Group firstGroup = new Group(1, escapesRemoved);
		System.out.println("Score:   " + firstGroup.totalScore());
		System.out.println("Garbage: " + firstGroup.totalGarbage());
	}

	interface Item {
		int totalScore();
		int totalGarbage();
	}

	static class Garbage implements Item {
		int length;

		Garbage(String content) {
			length = content.length() - 2;
		}

		@Override
		public int totalScore() {
			return 0;
		}

		@Override
		public int totalGarbage() {
			return length;
		}
	}

	static class Group implements Item {
		private final int score;
		List<Item> items;

		Group(int score, String content) {
			this.score = score;
			if (content.charAt(0) != '{' || content.charAt(content.length() - 1) != '}') {
				throw new IllegalArgumentException("Groups must start  with { and end with }, was: " + content);
			}
			items = new ArrayList<>();
			String remainder = content.substring(1, content.length() - 1);
			while (!remainder.isEmpty()) {
				Pair<Item, String> p = scan(score + 1, remainder);
				items.add(p.a);
				remainder = p.b;
			}
		}

		@Override
		public int totalScore() {
			return score + items.stream().mapToInt(Item::totalScore).sum();
		}

		@Override
		public int totalGarbage() {
			return items.stream().mapToInt(Item::totalGarbage).sum();
		}
	}

	/**
	 * Scans the content string and returns the first item found, plus the remainder of the content string
	 */
	static Pair<Item, String> scan(int baseScore, String content) {
		char firstChar = content.charAt(0);
		if (firstChar == '<') {
			return scanGarbage(content);
		} else if (firstChar == '{') {
			return scanGroup(baseScore, content);
		} else {
			throw new IllegalArgumentException("Content should only start with < or {, was '" + firstChar + "'");
		}
	}

	private static Pair<Item, String> scanGroup(int baseScore, String content) {
		int nestLevel = 0;
		for (int i = 1; i < content.length(); i++) {
			if (content.charAt(i) == '<') {
				// Skip garbage when looking for end of group
				i = content.substring(i).indexOf('>') + i;
			} else if (content.charAt(i) == '{') {
				// Keep track of nested groups
				nestLevel++;
			} else if (content.charAt(i) == '}') {
				// Decrease nesting level if nested, or end group if not nested
				if (nestLevel == 0) {
					if (i == content.length() - 1) {
						return new Pair<>(new Group(baseScore, content), "");
					} else {
						return new Pair<>(new Group(baseScore, content.substring(0, i + 1)), content.substring(i + 2));
					}
				} else {
					nestLevel--;
				}
			}
		}
		throw new IllegalArgumentException("Group brackets did not match");
	}

	private static Pair<Item, String> scanGarbage(String content) {
		int i = content.indexOf('>');
		if (i == content.length() - 1) {
			return new Pair<>(new Garbage(content), "");
		} else {
			return new Pair<>(new Garbage(content.substring(0, i + 1)), content.substring(i + 2));
		}
	}

	static class Pair<A, B> {
		A a;
		B b;

		Pair(A a, B b) {
			this.a = a;
			this.b = b;
		}
	}
}
