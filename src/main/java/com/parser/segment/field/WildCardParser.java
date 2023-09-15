package com.parser.segment.field;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.parser.segment.time.TimeBase;

public class WildCardParser extends FieldParserBase {

	public WildCardParser(TimeBase timeSeg) {
		super(timeSeg);
	}

	@Override
	public List<Integer> deriveExpValues() {
		return IntStream.range(timeSegment.getMinimum(), timeSegment.getMaximum() + 1).boxed()
				.collect(Collectors.toList());
	}

}
