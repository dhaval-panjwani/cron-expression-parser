package com.parser.segment.field;

import com.parser.segment.time.TimeBase;

public class FieldParserFactory {

	private static final String WILDCARD_REGEX = "*";
	private static final String RANGE_REGEX = "[0-9]+-[0-9]+";
	private static final String LIST_REGEX = ".*,.*";
	private static final String FREQUENCY_REGEX = ".*\\/.*";
	private static final String EXACT_REGEX = "^[0-9]+$";

	public FieldParserBase getFieldParser(TimeBase timeSegment) {

		String timeSegExp = timeSegment.getExpression();

		if (timeSegExp.equals(WILDCARD_REGEX))
			return new WildCardParser(timeSegment);
		else if (timeSegExp.matches(RANGE_REGEX))
			return new RangeParser(timeSegment);
		else if (timeSegExp.matches(LIST_REGEX))
			return new ListParser(timeSegment);
		else if (timeSegExp.matches(FREQUENCY_REGEX))
			return new FrequencyParser(timeSegment);
		else if (timeSegExp.matches(EXACT_REGEX))
			return new ExactParser(timeSegment);

		return null;
	}

}
