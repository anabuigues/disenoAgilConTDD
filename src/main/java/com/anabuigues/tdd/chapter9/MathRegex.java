package com.anabuigues.tdd.chapter9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathRegex {

	public static final String OPERATORS = "[\\+|\\-|\\*|/]";

	public static boolean isExpressionValid(String expression) {
		Pattern pattern = Pattern
				.compile("^((-)?\\d+( )*"+OPERATORS+"( )*)+(-)?\\d+$");
		Matcher matcher = pattern.matcher(expression);
		return matcher.find() || isNumber(expression) || isOperator(expression);
	}

	public static boolean isNumberAndOperator(String expression) {
		Pattern startsWithOperator = Pattern.compile("^( )*(" + OPERATORS
				+ ")( )+");
		Pattern endsWithOperator = Pattern.compile("( )+(" + OPERATORS
				+ ")( )*$");

		if (startsWithOperator.matcher(expression).find()
				|| endsWithOperator.matcher(expression).find()) {
			return true;
		}
		return false;
	}

	public static boolean isSubExpression(String expression) {
		Pattern operatorPattern = Pattern.compile(" [\\+|\\-|\\*|/] ");
		Pattern numberPattern = Pattern.compile("\\d+");
		if (operatorPattern.matcher(expression).find()
				&& numberPattern.matcher(expression).find()) {
			return true;
		}
		return false;
	}

	public static boolean isNumber(String token) {
		return isExactMatch(token, "\\d+");
	}

	public static boolean isOperator(String token) {
		return isExactMatch(token, OPERATORS);
	}

	public static boolean isExactMatch(String token, String regex) {
		Pattern exactPattern = Pattern.compile("^" + regex + "$");
		return exactPattern.matcher(token).find();
	}
}
