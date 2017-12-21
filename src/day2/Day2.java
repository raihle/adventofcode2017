package day2;

import util.Util;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class Day2 {
	public static void main(String[] args) {
		List<String> rows = Util.allLines("input", Day2.class);

		int[] subtractionChecksums = calculateChecksums(Day2::largestDifference, rows);
		System.out.println(Arrays.stream(subtractionChecksums).sum());

		int[] divisionChecksums = calculateChecksums(Day2::remainderlessDivision, rows);
		System.out.println(Arrays.stream(divisionChecksums).sum());
	}

	private static int[] calculateChecksums(ToIntFunction<String> checksumStrategy, List<String> rows) {
		return rows.stream().mapToInt(checksumStrategy).toArray();
	}

	private static int largestDifference(String row) {
		int[] cells = getCells(row);
		return Arrays.stream(cells).max().getAsInt() - Arrays.stream(cells).min().getAsInt();
	}

	private static int remainderlessDivision(String row) {
		int[] cells = getCells(row);
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				if (i == j) continue;
				if (cells[i] % cells[j] == 0) {
					return cells[i] / cells[j];
				}
			}
		}
		throw new IllegalArgumentException("Row contains no cells which result in a remainder-less division");
	}

	private static int[] getCells(String row) {
		return Arrays.stream(row.split("\t")).mapToInt(Integer::parseInt).toArray();
	}
}
