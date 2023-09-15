package com.parser.segment.field;

import java.util.Collections;
import java.util.List;

import com.parser.segment.time.TimeBase;

public class ExactParser extends FieldParserBase {

	public ExactParser(TimeBase type) {
		super(type);
	}

	@Override
	public List<Integer> deriveExpValues() {

		int value = Integer.valueOf(this.timeSegment.getExpression());
		validateValueBasedChecks(this.timeSegment, value);

		return Collections.singletonList(value);
	}

}
