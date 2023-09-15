package test.com.parser.segment.field;

import org.junit.Test;

import main.com.parser.segment.field.ExactParser;
import main.com.parser.segment.time.TimeBase;
import main.com.parser.segment.time.WeekDay;

public class ExactParserTest {

	private ExactParser exactParser;

	@Test
	public void testExactParserDeriveValueValid() {

		TimeBase timeSeg = new WeekDay("3");
		exactParser = new ExactParser(timeSeg);
		assert exactParser.deriveExpValues().get(0) == 3;

	}

	@Test(expected = Exception.class)
	public void testExactParserDeriveValueInValid() {

		TimeBase timeSeg = new WeekDay("58");
		exactParser = new ExactParser(timeSeg);
		assert exactParser.deriveExpValues().get(0) == 3;

	}

}
