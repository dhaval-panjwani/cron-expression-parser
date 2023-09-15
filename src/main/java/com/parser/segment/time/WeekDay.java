package com.parser.segment.time;

public class WeekDay extends TimeBase {

	public WeekDay(String exp) {
		super(exp);
		this.min = 0;
		this.max = 6;
	}

}
