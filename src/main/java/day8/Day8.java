package day8;

import util.Input;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day8 {
	public static void main(String[] args) {
		Registers registers = new Registers();
		List<String> rows = Input.allLines("day8");

		String highestRegister = "";
		int highestValue = Integer.MIN_VALUE;
		for (String row : rows) {
			Instruction instruction = new Instruction(row);
			instruction.run(registers);
			if (registers.highestValue > highestValue) {
				highestValue = registers.highestValue;
				highestRegister = registers.highestRegister;
			}
		}

		System.out.println("Highest final: " + registers.highestValue + " (" + registers.highestRegister + ")");
		System.out.println("Highest ever:  " + highestValue + " (" + highestRegister + ")");
	}

	static class Instruction {
		private static final String INSTRUCTION_REGEX = "^(\\w+) (inc|dec) (-?\\d+) if (\\w+) (<|<=|>|>=|==|!=) (-?\\d+)$";
		private static final Pattern INSTRUCTION_PATTERN = Pattern.compile(INSTRUCTION_REGEX);

		private Predicate<Registers> condition;
		private Consumer<Registers> action;

		Instruction(String row) {
			Matcher matcher = INSTRUCTION_PATTERN.matcher(row);
			matcher.find();
			String register = matcher.group(1);
			MutationOperator operator = MutationOperator.forCode(matcher.group(2));
			int amount = Integer.parseInt(matcher.group(3));
			String conditionRegister = matcher.group(4);
			ComparisonOperator conditionOperator = ComparisonOperator.forCode(matcher.group(5));
			int conditionAmount = Integer.parseInt(matcher.group(6));

			condition = makeCondition(conditionRegister, conditionOperator, conditionAmount);
			action = makeAction(register, operator, amount);
		}

		void run(Registers registers) {
			if (condition.test(registers)) {
				action.accept(registers);
			}
		}

		private Predicate<Registers> makeCondition(String register, ComparisonOperator operator, int amount) {
			return (registers) -> operator.perform(registers.get(register), amount);
		}

		private Consumer<Registers> makeAction(String register, MutationOperator operator, int amount) {
			return (registers) -> registers.put(register, operator.perform(registers.get(register), amount));
		}
	}

	static class Registers {
		private Map<String, Integer> base;
		private String highestRegister;
		private int highestValue;

		Registers() {
			base = new HashMap<>();
		}

		int get(String register) {
			if (!base.containsKey(register)) {
				base.put(register, 0);
			}
			return base.get(register);
		}

		void put(String register, int newValue) {
			if (newValue > highestValue) {
				highestRegister = register;
				highestValue = newValue;
			}
			base.put(register, newValue);
		}

		@Override
		public String toString() {
			return base.toString();
		}
	}

	enum MutationOperator {
		INC("inc", (current, amount) -> current + amount),
		DEC("dec", (current, amount) -> current - amount);

		private static Map<String, MutationOperator> lookup = new HashMap<>();

		static {
			for (MutationOperator s : MutationOperator.values())
				lookup.put(s.getCode(), s);
		}

		static MutationOperator forCode(String code) {
			return lookup.get(code);
		}

		private BiFunction<Integer, Integer, Integer> action;
		private String code;

		MutationOperator(String code, BiFunction<Integer, Integer, Integer> action) {
			this.action = action;
			this.code = code;
		}

		String getCode() {
			return code;
		}

		int perform(int current, int amount) {
			return action.apply(current, amount);
		}
	}

	enum ComparisonOperator {
		LESS_THAN("<", (current, amount) -> current < amount),
		LESS_THAN_OR_EQUAL("<=", (current, amount) -> current <= amount),
		GREATER_THAN(">", (current, amount) -> current > amount),
		GREATER_THAN_OR_EQUAL(">=", (current, amount) -> current >= amount),
		EQUAL("==", (current, amount) -> current.equals(amount)),
		NOT_EQUAL("!=", (current, amount) -> !current.equals(amount));

		private static Map<String, ComparisonOperator> lookup = new HashMap<>();

		static {
			for (ComparisonOperator s : ComparisonOperator.values())
				lookup.put(s.getCode(), s);
		}

		static ComparisonOperator forCode(String code) {
			return lookup.get(code);
		}

		private BiFunction<Integer, Integer, Boolean> check;
		private String code;

		ComparisonOperator(String code, BiFunction<Integer, Integer, Boolean> check) {
			this.check = check;
			this.code = code;
		}

		String getCode() {
			return code;
		}

		boolean perform(int current, int amount) {
			return check.apply(current, amount);
		}
	}
}
