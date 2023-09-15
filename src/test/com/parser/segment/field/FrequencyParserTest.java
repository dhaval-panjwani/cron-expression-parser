package test.com.parser.segment.field;

import org.junit.Test;

import main.com.parser.segment.field.FrequencyParser;
import main.com.parser.segment.time.Minute;

public class FrequencyParserTest {

	FrequencyParser parser;

	@Test
	public void testFrequencyExp() {
		parser = new FrequencyParser(new Minute("*/10"));
		// 0 10 20 30 40 50
		assert parser.deriveExpValues().size() == 6;

		parser = new FrequencyParser(new Minute("30/10"));
		// 30 40 50
		assert parser.deriveExpValues().size() == 3;
	}
}
