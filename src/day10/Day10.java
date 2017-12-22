package day10;

import util.Util;

import java.util.Arrays;

public class Day10 {
	public static void main(String[] args) {
		String input = Util.firstLine("input", Day10.class);
		int[] lengths = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
		KnotHash knotHash = new KnotHash(256);
		knotHash.addAll(lengths);
		System.out.println(knotHash.getHash());
	}

	private static class KnotHash {
		private int[] marks;
		private int currentMark;
		private int skipLength;

		public KnotHash(int size) {
			currentMark = 0;
			skipLength = 0;
			marks = new int[size];
			for (int i = 0; i < size; i++) {
				marks[i] = i;
			}
		}

		public void addAll(int[] lengths) {
			for (int length : lengths) {
				add(length);
			}
		}

		public void add(int length) {
			int[] reversedSubList = new int[length];
			for (int i = 0; i < length; i++) {
				reversedSubList[length - i - 1] = marks[(i + currentMark) % marks.length];
			}
			for (int i = 0; i < length; i++) {
				marks[(i + currentMark) % marks.length] = reversedSubList[i];
			}
			currentMark = (currentMark + length + skipLength) % marks.length;
			skipLength++;
		}

		public int getHash() {
			return marks[0] * marks[1];
		}
	}
}
