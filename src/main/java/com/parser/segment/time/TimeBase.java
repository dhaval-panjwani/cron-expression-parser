package com.parser.segment.time;

public abstract class TimeBase<T> {

	String exp;
	Integer min, max;

	public TimeBase(String exp) {
		this.exp = exp;
	}

	public Integer getMinimum() {
		return min;
	}

	public Integer getMaximum() {
		return max;
	}

	public String getExpression() {
		return exp;
	}

}
