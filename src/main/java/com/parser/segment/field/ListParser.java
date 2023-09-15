package com.parser.segment.field;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.parser.segment.time.TimeBase;

public class ListParser extends FieldParserBase {

	private FieldParserFactory fieldParserFactory;

	public ListParser(TimeBase type) {
		super(type);
		fieldParserFactory = new FieldParserFactory();
	}

	@Override
	public List<Integer> deriveExpValues() {
		String[] splitted = this.timeSegment.getExpression().split(",");
		List<Integer> expValues = new ArrayList<>();

		for (String exp : splitted) {
			TimeBase timeSeg = new TimeBase(exp) {
				@Override
				public Integer getMinimum() {
					return timeSegment.getMinimum();
				}

				@Override
				public Integer getMaximum() {
					return timeSegment.getMaximum();
				}
			};
			expValues.addAll(fieldParserFactory.getFieldParser(timeSeg).deriveExpValues());
		}

		// keep only distinct values in sorted way
		// example 6,4-6 should be returning values as 4 5 6
		return expValues.stream().distinct().sorted().collect(Collectors.toList());
	}

}
