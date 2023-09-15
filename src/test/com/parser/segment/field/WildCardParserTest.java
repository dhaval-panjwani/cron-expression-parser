package test.com.parser.segment.field;

import org.junit.Test;

import main.com.parser.segment.field.WildCardParser;
import main.com.parser.segment.time.WeekDay;

public class WildCardParserTest {

	WildCardParser parser;

	@Test
	public void testWildCardScenarioValid() {
		parser = new WildCardParser(new WeekDay("*"));
		assert parser.deriveExpValues().size() == 7;
	}
}
