package com.parser.segment.time;

public class Month extends TimeBase {

	public Month(String exp) {
		super(exp);
		this.min = 1;
		this.max = 12;
	}

}
