package com.anabuigues.tdd.chapter9;

import java.util.List;

public class ExpressionFixer {

	public void fixExpressions(List<MathExpression> expressions) {
		boolean listHasChanged = true;
		
		while (listHasChanged) {
			listHasChanged = false;
			
			for (int i = 0; i < expressions.size(); i++) {
				MathExpression exp = expressions.get(i);
				exp.setExpression(exp.getExpression().trim());
				
				if (MathRegex.isNumberAndOperator(expressions.get(i).getExpression())) {
					splitByOperator(expressions, expressions.get(i).getExpression(), i);
					listHasChanged = true;
					break;
				}
				if (expressions.get(i).IsEmpty()) {
					expressions.remove(i);
					listHasChanged = true;
					break;
				}
			}
		}
	}

	public void splitByOperator(List<MathExpression> expressions,
			String inputExpression, int position) {
		Splitter splitter = new Splitter("([\\+|\\-|\\*|/])");		
		String[] nextExps = splitter.split(inputExpression);
		
		int j = position;
		expressions.remove(position);
		for (String subExp : nextExps) {
			expressions.add(j, new MathExpression(subExp.trim()));
			j++;
		}
	}
}
