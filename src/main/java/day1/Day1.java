package day1;

import util.Input;

public class Day1 {
	public static void main(String[] args) {
		String digits = Input.firstLine("day1");
		String repeatedDigits = keepRepeatedChars(digits);
		System.out.println(sumDigits(repeatedDigits));

		String repeatedHalfwayDigits = keepCharsRepeatedAfter(digits.length() / 2, digits);
		System.out.println(sumDigits(repeatedHalfwayDigits));
	}

	private static String keepRepeatedChars(String input) {
		return keepCharsRepeatedAfter(1, input);
	}

	private static String keepCharsRepeatedAfter(int offset, String input) {
		int length = input.length();
		StringBuilder result = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			if (input.charAt(i) == input.charAt((i + offset) % length)) {
				result.append(input.charAt(i));
			}
		}
		return result.toString();
	}

	private static long sumDigits(String digits) {
		return digits.chars().map((i) -> ((char) i) - '0').sum();
	}
}
