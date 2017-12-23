package day10;

import util.Input;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Day10 {
	public static void main(String[] args) {
		String input = Input.firstLine("day10");
		int[] lengthsA = parseInputA(input);
		int[] lengthsB = parseInputB(input);

		KnotHash knotHashA = new KnotHash(256);
		knotHashA.addAll(lengthsA);
		int[] sparseHash = knotHashA.getSparseHash();
		System.out.println(sparseHash[0] * sparseHash[1]);

		KnotHash knotHashB = new KnotHash(256);
		for (int i = 0; i < 64; i++) {
			knotHashB.addAll(lengthsB);
		}
		int[] denseHash = knotHashB.getDenseHash(16);
		for (int hashPart : denseHash) {
			System.out.print(String.format("%02X", hashPart));
		}
		System.out.println();
	}

	private static int[] parseInputA(String input) {
		return Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
	}

	private static int[] parseInputB(String input) {
		// your input should be taken not as a list of numbers, but as a string of bytes instead
		// add the following lengths to the end of the sequence: 17, 31, 73, 47, 23
		return IntStream.concat(input.chars(), IntStream.of(17, 31, 73, 47, 23)).toArray();
	}

	private static class KnotHash {
		private final int[] marks;
		private int currentMark;
		private int skipLength;

		KnotHash(int size) {
			currentMark = 0;
			skipLength = 0;
			marks = new int[size];
			for (int i = 0; i < size; i++) {
				marks[i] = i;
			}
		}

		void addAll(int[] lengths) {
			for (int length : lengths) {
				add(length);
			}
		}

		void add(int length) {
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

		int[] getSparseHash() {
			return marks.clone();
		}

		int[] getDenseHash(int blockSize) {
			if (marks.length % blockSize != 0) {
				throw new IllegalArgumentException("Block size " + blockSize + " does not divide string size " + marks.length);
			}
			int[] denseHash = new int[marks.length / blockSize];
			for (int i = 0; i < denseHash.length; i++) {
				int blockHash = 0;
				for (int j = 0; j < blockSize; j++) {
					blockHash = blockHash ^ marks[blockSize * i + j];
				}
				denseHash[i] = blockHash;
			}
			return denseHash;
		}
	}
}
