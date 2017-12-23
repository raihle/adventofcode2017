package day5;

import util.Input;

import java.util.List;
import java.util.function.Function;

public class Day5 {
	public static void main(String[] args) {
		List<String> input = Input.allLines("day5");
		int[] jumps = input.stream().mapToInt(Integer::parseInt).toArray();

		System.out.println(calculateJumpCount(jumps, Day5::strategyA));
		System.out.println(calculateJumpCount(jumps, Day5::strategyB));
	}

	private static int calculateJumpCount(int[] jumps, Function<Integer, Integer> postJumpModifier) {
		// Clone the input array because we need to keep track of updates, and modifying input is evil
		int[] jumpsClone = jumps.clone();
		int jumpCount = 0;
		int jumpPointer = 0;
		while (jumpPointer >= 0 && jumpPointer < jumpsClone.length) {
			int nextJump = jumpsClone[jumpPointer];
			jumpsClone[jumpPointer] = postJumpModifier.apply(nextJump);
			jumpPointer = jumpPointer + nextJump;
			jumpCount++;
		}
		return jumpCount;
	}

	private static int strategyA(int jump) {
		// after each jump, the offset of that instruction increases by 1
		return jump + 1;
	}

	private static int strategyB(int jump) {
		// if the offset was three or more, instead decrease it by 1. Otherwise, increase it by 1 as before.
		return jump >= 3 ? jump - 1 : jump + 1;
	}
}
