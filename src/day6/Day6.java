package day6;

import util.Util;

import java.util.*;

public class Day6 {
	public static void main(String[] args) {
		String input = Util.firstLine("input", Day6.class);
		int[] counts = Arrays.stream(input.split("\t")).mapToInt(Integer::parseInt).toArray();
		MemoryBanks banks = new MemoryBanks(counts);

		// We use string representations to check for duplicates instead of using the int[]
		// object directly, because arrays don't override hashCode or equals
		Map<String, Integer> seen = new HashMap<>();
		int redistributions = 0;
		while (!seen.containsKey(banks.toString())) {
			seen.put(banks.toString(), redistributions);
			int fullestBank = banks.getFullestBank();
			banks.redistributeFrom(fullestBank);
			redistributions++;
		}
		System.out.println(banks + " duplicated at step " + redistributions);
		int firstSeenAt = seen.get(banks.toString());
		int loopSize = redistributions - firstSeenAt;
		System.out.println("First seen at step " + firstSeenAt + " (loop size " + loopSize + ")");
	}

	private static class MemoryBanks {
		int[] counts;

		MemoryBanks(int[] initialCounts) {
			counts = initialCounts.clone();
		}

		int getFullestBank() {
			int fullestIndex = 0;
			int fullestCount = 0;
			for (int i = 0; i < counts.length; i++) {
				if (counts[i] > fullestCount) {
					fullestCount = counts[i];
					fullestIndex = i;
				}
			}
			return fullestIndex;
		}

		void redistributeFrom(int index) {
			int toDistribute = counts[index];
			counts[index] = 0;
			distribute(toDistribute, (index + 1) % counts.length);
		}

		@Override
		public String toString() {
			return Arrays.toString(counts);
		}

		private void distribute(int amount, int startIndex) {
			int index = startIndex;
			for (; amount > 0; amount--) {
				counts[index]++;
				index = (index + 1) % counts.length;
			}
		}
	}
}
