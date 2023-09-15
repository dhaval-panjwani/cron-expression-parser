package test.com.parser;

import org.junit.Test;

import main.com.parser.impl.CronExpressionParser;

public class ParserTest {

	private CronExpressionParser parser;

	@Test
	public void testValidCronExpression1() {
		parser = new CronExpressionParser();

		String actual = parser.parseAndDisplay("*/15 0 1,15 * 1-5 /usr/bin/find");

		assert actual.contains("day of month  1 15");
		assert actual.contains("minute        0 15 30 45");
		assert actual.contains("hour          0");
		assert actual.contains("day of week   1 2 3 4 5");
		assert actual.contains("month         1 2 3 4 5 6 7 8 9 10 11 12");
		assert actual.contains("command       /usr/bin/find");
	}

	@Test
	public void testValidCronExpression2() {
		parser = new CronExpressionParser();

		String actual = parser.parseAndDisplay("*/30 0 1,18 * 4-5 /usr/bin/find");

		assert actual.contains("day of month  1 18");
		assert actual.contains("minute        0 30");
		assert actual.contains("hour          0");
		assert actual.contains("day of week   4 5");
		assert actual.contains("month         1 2 3 4 5 6 7 8 9 10 11 12");
		assert actual.contains("command       /usr/bin/find");
	}

	@Test
	public void testValidCronExpression3() {
		parser = new CronExpressionParser();

		String actual = parser.parseAndDisplay("*/30 0 1,18 * 4-5 grep hello.txt | wc -l");

		assert actual.contains("day of month  1 18");
		assert actual.contains("minute        0 30");
		assert actual.contains("hour          0");
		assert actual.contains("day of week   4 5");
		assert actual.contains("month         1 2 3 4 5 6 7 8 9 10 11 12");
		assert actual.contains("command       grep hello.txt | wc -l");
	}

	@Test
	public void testValidCronExpression4NoCommand() {
		parser = new CronExpressionParser();

		String actual = parser.parseAndDisplay("*/20 0 1-4 * 4-5");

		assert actual.contains("day of month  1 2 3 4");
		assert actual.contains("minute        0 20 40");
		assert actual.contains("hour          0");
		assert actual.contains("day of week   4 5");
		assert actual.contains("month         1 2 3 4 5 6 7 8 9 10 11 12");
		assert actual.contains("command       ");
	}

	@Test(expected = Exception.class)
	public void testNotValidCronExpression1() {
		parser = new CronExpressionParser();

		String actual = parser.parseAndDisplay("*/20 31 1-4 * 4-5");

		assert actual.contains("day of month  1 2 3 4");
	}

	@Test(expected = Exception.class)
	public void testNotValidCronExpression2() {
		parser = new CronExpressionParser();

		String actual = parser.parseAndDisplay("*/70 0 1-4 * 4-5");

		assert actual.contains("day of month  1 2 3 4");
	}
}
