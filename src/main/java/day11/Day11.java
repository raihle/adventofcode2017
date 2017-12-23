package day11;

import util.Input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day11 {
	public static void main(String[] args) {
		String input = Input.firstLine("day11");
		String[] moveCodes = input.split(",");
		List<HexMover.Direction> moves = Arrays.stream(moveCodes).map(HexMover.Direction::forCode).collect(Collectors.toList());

		HexMover mover = new HexMover();
		int maxDistance = 0;
		for (HexMover.Direction move : moves) {
			mover.move(move);
			maxDistance = Math.max(maxDistance, mover.getStepsFromOrigin());
		}

		System.out.println("Current distance: " + mover.getStepsFromOrigin());
		System.out.println("Largest distance: " + maxDistance);
	}
}
