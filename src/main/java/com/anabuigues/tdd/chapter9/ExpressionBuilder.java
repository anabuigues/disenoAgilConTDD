package com.anabuigues.tdd.chapter9;

import java.util.ArrayList;
import java.util.List;

public class ExpressionBuilder {

	private static String inputText;
	private static int currentIndex = 0;
	private static List<MathExpression> allExpressions;
	private MathExpression subExpression;
	

	private ExpressionBuilder() {
	}

	public static ExpressionBuilder create() {
		ExpressionBuilder builder = new ExpressionBuilder();
		ExpressionBuilder.allExpressions = new ArrayList<MathExpression>();
		ExpressionBuilder.currentIndex = 0;
		ExpressionBuilder.inputText = "";
		builder.subExpression = new MathExpression("");
		return builder;
	}

	public ExpressionBuilder processNewSubExpression() {
		ExpressionBuilder builder = new ExpressionBuilder();
		builder.subExpression = new MathExpression("");
		updateIndex();
		return builder;
	}

	public boolean thereAreMoreChars() {
		return currentIndex < maxLength();
	}

	public void addSubExpressionChar() {
		String subExp = subExpression.getExpression();
		subExp += String.valueOf(inputText.charAt(currentIndex));
		subExpression.setExpression(subExp);
		if (subExpression.getOrder() == -1)
			subExpression.setOrder(currentIndex);
		updateIndex();
	}

	public void subExpressionEndFound() {
		allExpressions.add(subExpression);
		updateIndex();
	}

	public char getCurrentChar() {
		return inputText.charAt(currentIndex);
	}

	public int maxLength() {
		return inputText.length();
	}

	private void updateIndex() {
		currentIndex++;
	}

	public static String getInputText() {
		return inputText;
	}

	public static void setInputText(String inputText) {
		ExpressionBuilder.inputText = inputText;
	}

	public static int getCurrentIndex() {
		return currentIndex;
	}

	public static void setCurrentIndex(int currentIndex) {
		ExpressionBuilder.currentIndex = currentIndex;
	}

	public static List<MathExpression> getAllExpressions() {
		return allExpressions;
	}

	public static void setAllExpressions(List<MathExpression> allExpressions) {
		ExpressionBuilder.allExpressions = allExpressions;
	}

	public MathExpression getSubExpression() {
		return subExpression;
	}

	public void setSubExpression(MathExpression subExpression) {
		this.subExpression = subExpression;
	}
}
