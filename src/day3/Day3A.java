package day3;

import static day3.Day3.cellsPerSideOfLayer;
import static day3.Day3.lastCellInLayer;

public class Day3A {
	public static void main(String[] args) {
		int desiredCell = 325489;
		int layer = Day3.layerOfCell(desiredCell);
		System.out.println(layer + distanceToOrthogonalCellInLayer(layer, desiredCell));
	}

	/**
	 * An "orthogonal" cell is a cell that can be reached by moving only in one direction,
	 * i.e. orthogonal cells are the cells in any given layer that are reachable in the fewest number of steps.
	 */
	private static int firstOrthogonalCellInLayer(int layer) {
		if (layer == 0) return 1;
		int lastCellOfPreviousLayer = lastCellInLayer(layer - 1);
		return lastCellOfPreviousLayer + (cellsPerSideOfLayer(layer) / 2);
	}

	/**
	 * The number of steps away from the closest orthogonal cell is the number of steps that must be moved within
	 * the current layer. After reaching an orthogonal cell, the number of steps remaining is just the layer number.
	 * The layer must be the layer of the cell, or else behavior is undefined.
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
