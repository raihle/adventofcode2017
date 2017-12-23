package day11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HexMoverTest {
	@Test
	void new_HexMover_is_at_origin() {
		HexMover unit = new HexMover();
		assertEquals(0, unit.getStepsFromOrigin());
	}

	@Test
	void ne_ne_ne_is_three_steps_away() {
		HexMover unit = new HexMover();
		unit.move(HexMover.Direction.NORTH_EAST);
		unit.move(HexMover.Direction.NORTH_EAST);
		unit.move(HexMover.Direction.NORTH_EAST);
		assertEquals(3, unit.getStepsFromOrigin());
	}

	@Test
	void ne_ne_sw_sw_is_0_steps_away() {
		HexMover unit = new HexMover();
		unit.move(HexMover.Direction.NORTH_EAST);
		unit.move(HexMover.Direction.NORTH_EAST);
		unit.move(HexMover.Direction.SOUTH_WEST);
		unit.move(HexMover.Direction.SOUTH_WEST);
		assertEquals(0, unit.getStepsFromOrigin());
	}

	@Test
	void ne_ne_s_s_is_two_steps_away() {
		HexMover unit = new HexMover();
		unit.move(HexMover.Direction.NORTH_EAST);
		unit.move(HexMover.Direction.NORTH_EAST);
		unit.move(HexMover.Direction.SOUTH);
		unit.move(HexMover.Direction.SOUTH);
		assertEquals(2, unit.getStepsFromOrigin());
	}

	@Test
	void se_sw_se_sw_sw_is_three_steps_away() {
		HexMover unit = new HexMover();
		unit.move(HexMover.Direction.SOUTH_EAST);
		unit.move(HexMover.Direction.SOUTH_WEST);
		unit.move(HexMover.Direction.SOUTH_EAST);
		unit.move(HexMover.Direction.SOUTH_WEST);
		unit.move(HexMover.Direction.SOUTH_WEST);
		assertEquals(3, unit.getStepsFromOrigin());
	}

	@Test
	void nw_ne_is_one_step_away() {
		HexMover unit = new HexMover();
		unit.move(HexMover.Direction.NORTH_WEST);
		unit.move(HexMover.Direction.NORTH_EAST);
		assertEquals(1, unit.getStepsFromOrigin());
	}

	@Test
	void nw_sw_nw_se_is_four_steps_away() {
		HexMover unit = new HexMover();
		unit.move(HexMover.Direction.NORTH_WEST);
		unit.move(HexMover.Direction.SOUTH_WEST);
		unit.move(HexMover.Direction.NORTH_WEST);
		unit.move(HexMover.Direction.SOUTH_WEST);
		assertEquals(4, unit.getStepsFromOrigin());
	}
}