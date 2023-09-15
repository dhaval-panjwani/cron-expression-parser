package com.parser.segment.field;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.parser.segment.time.TimeBase;

public class RangeParser extends FieldParserBase {

	public RangeParser(TimeBase seg) {
		super(seg);
	}

	@Override
	public List<Integer> deriveExpValues() {

		String[] splitted = this.timeSegment.getExpression().split("-");

		if (splitted.length != 2)
			throw new RuntimeException("Not a valid expression for Range - " + this.timeSegment.getExpression());

		int rangeStart = Integer.parseInt(splitted[0]), rangeEnd = Integer.parseInt(splitted[1]);

		validateValueBasedChecks(timeSegment, rangeStart);
		validateValueBasedChecks(timeSegment, rangeEnd);

		if (rangeStart > rangeEnd)
			throw new RuntimeException(
					String.format("Doesn't look like a valid range [ %s , %s ]", rangeStart, rangeEnd));

		return IntStream.range(rangeStart, rangeEnd + 1).boxed().collect(Collectors.toList());
	}

}
