package com.parser.segment.field;

import java.util.List;

import com.parser.segment.time.TimeBase;

public abstract class FieldParserBase {

	TimeBase timeSegment;

	final String FREQUENCY = "/";
	final String EXACT = "e";
	final String RANGE = "-";
	final String LIST = ",";
	final String WILDCARD = "*";

	public FieldParserBase(TimeBase seg) {
		this.timeSegment = seg;
	}

	public void validateValueBasedChecks(TimeBase seg, int value) {

		int maxPoss = seg.getMaximum();
		int minPoss = seg.getMinimum();

		if (value > maxPoss || value < minPoss)
			throw new RuntimeException(String.format(
					"Value for this time segment is not in allowed [ %s - %s ] min max range", minPoss, maxPoss));

	}

	public abstract List<Integer> deriveExpValues();

}
