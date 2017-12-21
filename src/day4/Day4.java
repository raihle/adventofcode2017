package day4;

import util.Util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day4 {
	public static void main(String[] args) {
		List<String> passphrases = Util.allLines("input", Day4.class);
		System.out.println(passphrases.stream().filter(Day4::passphraseIsFreeOfDuplicates).count());
		System.out.println(passphrases.stream().filter(Day4::passphraseIsFreeOfAnagrams).count());
	}

	static boolean passphraseIsFreeOfDuplicates(String passphrase) {
		String[] words = passphrase.split(" ");
		Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
		return uniqueWords.size() == words.length;
	}

	static boolean passphraseIsFreeOfAnagrams(String passphrase) {
		String[] words = passphrase.split(" ");
		List<String> wordsWithSortedLetters = Arrays.asList(words).stream().map(Day4::sortString).collect(Collectors.toList());
		Set<String> uniqueWords = new HashSet<>(wordsWithSortedLetters);
		return uniqueWords.size() == words.length;
	}

	static String sortString(String unsorted) {
		char[] chars = unsorted.toCharArray();
		Arrays.sort(chars);
		return String.valueOf(chars);
	}
}
