package com.parser.segment.time;

public class Day extends TimeBase {

	public Day(String exp) {
		super(exp);
		this.min = 0;
		this.max = 30;
	}

}
