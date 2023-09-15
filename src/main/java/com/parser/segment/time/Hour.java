package com.parser.segment.time;

public class Hour extends TimeBase {

	public Hour(String exp) {
		super(exp);
		this.min = 0;
		this.max = 23;
	}

}
