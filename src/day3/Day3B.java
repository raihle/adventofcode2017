package day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static day3.Day3.lastCellInLayer;
import static day3.Day3.layerOfCell;

public class Day3B {
	public static void main(String[] args) {
		long valueToBeat = 325489;
		int cell = 1;

		while (valueOfCell(cell) <= valueToBeat) {
			cell++;
		}
		System.out.println("Done at " + cell + ": " + valueOfCell(cell));
	}

	private static final Map<Integer, Position> cellPositions = new HashMap<>();
	private static final Map<Position, Integer> positionCells = new HashMap<>();
	private static final Map<Integer, Long> cellValues = new HashMap<>();

	private static long valueOfCell(int cell) {
		if (cell == 1) {
			return 1;
		}
		if (!cellValues.containsKey(cell)) {
			List<Integer> toSum = adjacentLowerCells(cell);
			long sum = toSum.stream().mapToLong(Day3B::valueOfCell).sum();
			cellValues.put(cell, sum);
		}
		return cellValues.get(cell);
	}

	private static List<Integer> adjacentLowerCells(int cell) {
		Position pos = positionOfCell(cell);
		List<Position> adjacents = adjacentPositions(pos);
		return adjacents.stream()
				.mapToInt(Day3B::cellAtPosition)
				.filter(it -> it < cell)
				.boxed()
				.collect(Collectors.toList());
	}

	private static List<Position> adjacentPositions(Position pos) {
		List<Position> adjacents = new ArrayList<>(8);
		for (int x = -1; x <= 1; x++) {
			for (int y = -1; y <= 1; y++) {
				if (x == 0 && y == 0) continue;
				adjacents.add(new Position(pos.x + x, pos.y + y));
			}
		}
		return adjacents;
	}

	private static Position positionOfCell(int cell) {
		if (!cellPositions.containsKey(cell)) {
			memoizeLayerPositions(layerOfCell(cell));
		}
		return cellPositions.get(cell);
	}

	private static int cellAtPosition(Position pos) {
		if (!positionCells.containsKey(pos)) {
			int layer = Math.max(Math.abs(pos.x), Math.abs(pos.y));
			memoizeLayerPositions(layer);
		}
		return positionCells.get(pos);
	}

	private static void memoizeLayerPositions(int layer) {
		int cell = lastCellInLayer(layer - 1) + 1;
		for (int y = 1 - layer; y < layer; y++) {
			memoizePosition(layer, y, cell++);
		}
		for (int x = layer; x > -layer; x--) {
			memoizePosition(x, layer, cell++);
		}
		for (int y = layer; y > -layer; y--) {
			memoizePosition(-layer, y, cell++);
		}
		for (int x = -layer; x <= layer; x++) {
			memoizePosition(x, -layer, cell++);
		}
	}

	private static void memoizePosition(int x, int y, int cell) {
		Position pos = new Position(x, y);
		cellPositions.put(cell, pos);
		positionCells.put(pos, cell);
	}

	static class Position {
		final int x;
		final int y;

		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Position position = (Position) o;

			return x == position.x && y == position.y;
		}

		@Override
		public int hashCode() {
			int result = x;
			result = 31 * result + y;
			return result;
		}
	}
}
