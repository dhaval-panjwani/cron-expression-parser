package com.parser.segment.time;

public class Minute extends TimeBase {

	public Minute(String exp) {
		super(exp);
		this.min = 0;
		this.max = 59;
	}

}
