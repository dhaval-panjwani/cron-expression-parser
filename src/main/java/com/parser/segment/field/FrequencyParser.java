package com.parser.segment.field;

import java.util.ArrayList;
import java.util.List;

import com.parser.segment.time.TimeBase;

public class FrequencyParser extends FieldParserBase {

	public FrequencyParser(TimeBase seg) {
		super(seg);
	}

	@Override
	public List<Integer> deriveExpValues() {
		String[] splitted = this.timeSegment.getExpression().split("/");
		List<Integer> values = new ArrayList<>();

		if (splitted.length != 2)
			throw new RuntimeException("Not a valid expression for Frequency - " + this.timeSegment.getExpression());

		int firstStep = (splitted[0].equals("*")) ? this.timeSegment.getMinimum() : Integer.parseInt(splitted[0]);
		int stepFrequency = Integer.parseInt(splitted[1]);

		if (stepFrequency > timeSegment.getMaximum())
			throw new RuntimeException(
					String.format("Step Frequency %s is greater than allowed time segment max value %s", stepFrequency,
							timeSegment.getMaximum()));

		if (firstStep > timeSegment.getMaximum())
			throw new RuntimeException(String.format("First step %s is greater than allowed time segment max value %s",
					firstStep, timeSegment.getMaximum()));

		for (int i = firstStep; i < this.timeSegment.getMaximum(); i += stepFrequency)
			values.add(i);

		return values;
	}

}
