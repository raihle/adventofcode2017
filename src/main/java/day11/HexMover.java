package day11;

import java.util.HashMap;
import java.util.Map;

class HexMover {
	private int x;
	private int y;

	HexMover() {
		x = 0;
		y = 0;
	}

	public void move(Direction direction) {
		x += direction.xDelta;
		y += direction.yDelta;
	}

	public int getStepsFromOrigin() {
		// Horizontal movement has to be staggered (NW/SW/NW/SW etc to move west) unless we
		// also want to cover vertical distance, so the vertical distance is irrelevant if
		// the horizontal distance is greater
		if (Math.abs(x) > Math.abs(y)) {
			// Hex magic ~~*
			return Math.abs(x);
		}
		// Vertical movement need not be staggered, but can still be combined with horizontal
		// when necessary
		return (Math.abs(x) + Math.abs(y)) / 2;

		// This could be avoided if we had a better model of our position, but that would
		// instead require different movement rules depending on which column we are in
	}

	enum Direction {
		NORTH("n", 0, -2),
		NORTH_EAST("ne", 1, -1),
		NORTH_WEST("nw", -1, -1),
		SOUTH_EAST("se", 1, 1),
		SOUTH_WEST("sw", -1, 1),
		SOUTH("s", 0, 2);

		private static final Map<String, Direction> lookup = new HashMap<>();

		static {
			for (Direction dir : Direction.values())
				lookup.put(dir.getCode(), dir);
		}

		public static Direction forCode(String code) {
			return lookup.get(code);
		}

		private String code;
		private final int xDelta;
		private final int yDelta;

		Direction(String code, int xDelta, int yDelta) {
			this.code = code;
			this.xDelta = xDelta;
			this.yDelta = yDelta;
		}

		String getCode() {
			return code;
		}
	}
}
