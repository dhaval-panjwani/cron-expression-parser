package test.com.parser.segment.field;

import org.junit.Test;

import main.com.parser.segment.field.ListParser;
import main.com.parser.segment.time.Minute;

public class ListParserTest {

	ListParser parser;

	@Test
	public void testListExpressions() {
		parser = new ListParser(new Minute("2-4,7,8"));
		// 2 3 4 7 8
		assert parser.deriveExpValues().size() == 5;

		parser = new ListParser(new Minute("2-6,3,5"));
		// 2 3 4 5 6
		assert parser.deriveExpValues().size() == 5;
	}

}
