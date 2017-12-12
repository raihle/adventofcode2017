package day3;

public class Day3 {
	public static void main(String[] args) {
		int desiredCell = 325489;
		int layer = layerOfCell(desiredCell);
		System.out.println(layer + distanceToOrthogonalCellInLayer(layer, desiredCell));
	}

	/*
	The side length of layer n, starting from 0, is ( n * 2 + 1 ), which is an enumeration of all odd numbers.
	 */
	private static int cellsPerSideOfLayer(int layer) {
		return (layer * 2) + 1;
	}

	/*
	Each layer (including the previous ones) contains ( side-length ^ 2 ) cells.
	 */
	private static int lastCellInLayer(int layer) {
		return (int) Math.pow(cellsPerSideOfLayer(layer), 2);
	}

	/*
	Working backwards, the layer of a cell can be found by taking the square root of the cell id and rounding up to the
	nearest side-length (odd number), subtracting one, then dividing by two. It turns out "rounding" up to odd and then
	subtracting is just a waste, since we can just discard the remainder instead.
	 */
	private static int layerOfCell(int cell) {
		return (int) Math.ceil(Math.sqrt(cell)) / 2;
	}

	/*
	An "orthogonal" cell is a cell that can be reached by moving only in one direction,
	i.e. orthogonal cells are the cells in any given layer that are reachable in the fewest number of steps.
	 */
	private static int firstOrthogonalCellInLayer(int layer) {
		if (layer == 0) return 1;
		int lastCellOfPreviousLayer = lastCellInLayer(layer - 1);
		return lastCellOfPreviousLayer + (cellsPerSideOfLayer(layer) / 2);
	}

	/*
	The number of steps away from the closest orthogonal cell is the number of steps that must be moved within
	the current layer. After reaching an orthogonal cell, the number of steps remaining is just the layer number.
	The layer must be the layer of the cell, or else behavior is undefined.
	 */
	private static int distanceToOrthogonalCellInLayer(int layer, int cell) {
		// Find the distance to the "first" orthogonal cell. Because of symmetry we can perform a simple remainder
		// calculation to find the closest orthogonal, but we are still only trying to move "back" to the orthogonal,
		// so we also need to try moving "forward" in case that is closer
		int ortho = firstOrthogonalCellInLayer(layer);
		int distance = Math.abs(cell - ortho);
		int cellsMovedPerRotation = cellsPerSideOfLayer(layer) - 1;
		int rotatedDistance = distance % cellsMovedPerRotation;
		int forwardDistance = cellsMovedPerRotation - rotatedDistance;
		return Math.min(rotatedDistance, forwardDistance);
	}
}
