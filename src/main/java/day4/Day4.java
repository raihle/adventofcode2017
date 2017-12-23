package day4;

import util.Input;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day4 {
	public static void main(String[] args) {
		List<String> passphrases = Input.allLines("day4");
		System.out.println(passphrases.stream().filter(Day4::passphraseIsFreeOfDuplicates).count());
		System.out.println(passphrases.stream().filter(Day4::passphraseIsFreeOfAnagrams).count());
	}

	private static boolean passphraseIsFreeOfDuplicates(String passphrase) {
		String[] words = passphrase.split(" ");
		Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
		return uniqueWords.size() == words.length;
	}

	private static boolean passphraseIsFreeOfAnagrams(String passphrase) {
		String[] words = passphrase.split(" ");
		Set<String> uniqueWords = Arrays.stream(words).map(Day4::sortString).collect(Collectors.toSet());
		return uniqueWords.size() == words.length;
	}

	private static String sortString(String unsorted) {
		char[] chars = unsorted.toCharArray();
		Arrays.sort(chars);
		return String.valueOf(chars);
	}
}
