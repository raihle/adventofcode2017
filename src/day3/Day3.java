package day3;

class Day3 {
	/**
	 * The side length of layer n, starting from 0, is ( n * 2 + 1 ), which is an enumeration of all odd numbers.
	 */
	static int cellsPerSideOfLayer(int layer) {
		return (layer * 2) + 1;
	}

	/**
	 * Each layer (including the previous ones) contains ( side-length ^ 2 ) cells.
	 */
	static int lastCellInLayer(int layer) {
		if (layer < 0) return 0;
		return (int) Math.pow(cellsPerSideOfLayer(layer), 2);
	}

	/**
	 * Working backwards, the layer of a cell can be found by taking the square root of the cell id and rounding up to the
	 * nearest side-length (odd number), subtracting one, then dividing by two. It turns out "rounding" up to odd and then
	 * subtracting is just a waste, since we can just discard the remainder instead.
	 */
	static int layerOfCell(int cell) {
		return (int) Math.ceil(Math.sqrt(cell)) / 2;
	}
}
