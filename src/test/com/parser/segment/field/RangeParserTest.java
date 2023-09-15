package test.com.parser.segment.field;

import org.junit.Test;

import main.com.parser.segment.field.RangeParser;
import main.com.parser.segment.time.WeekDay;

public class RangeParserTest {

	RangeParser parser;

	@Test
	public void testAValidRangeExp() {
		parser = new RangeParser(new WeekDay("2-6"));

		// 2 3 4 5 6
		assert parser.deriveExpValues().size() == 5;
	}

}
