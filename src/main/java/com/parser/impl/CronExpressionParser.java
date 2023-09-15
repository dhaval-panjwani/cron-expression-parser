package com.parser.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.parser.Parser;
import com.parser.segment.field.FieldParserFactory;
import com.parser.segment.time.Day;
import com.parser.segment.time.Hour;
import com.parser.segment.time.Minute;
import com.parser.segment.time.Month;
import com.parser.segment.time.WeekDay;

public class CronExpressionParser implements Parser {

	private static final String LINE_SEPERATOR = System.lineSeparator();
	private static final int COLUMN_SIZE = 14;
	private static final String MINUTE = "minute";
	private static final String HOUR = "hour";
	private static final String DAY_OF_MONTH = "day of month";
	private static final String MONTH = "month";
	private static final String DAY_OF_WEEK = "day of week";
	private static final String COMMAND = "command";

	private static final List<String> displayOrder = Arrays.asList(MINUTE, HOUR, DAY_OF_MONTH, MONTH, DAY_OF_WEEK);
	private Map<String, List<Integer>> parsedMap;
	private String command;

	public CronExpressionParser() {
		parsedMap = new HashMap<>();
		command = new String();
	}

	@Override
	public String parseAndDisplay(String cronExpression) {

		System.out.println("Input CRON Expression : " + cronExpression);

		parse(cronExpression);
		return display();
	}

	private void parse(String cronExpression) {

		parsedMap = new HashMap<>();
		String[] cronArgs = cronExpression.split("\\s+");
		FieldParserFactory parserFactory = new FieldParserFactory();

		/*
		 * We expect this cron format - min hour dayOfMonth month dayOfWeek command with
		 * total 6 arguments 6th command arg can have multiple spaces
		 */

		parsedMap.put(MINUTE, parserFactory.getFieldParser(new Minute(cronArgs[0])).deriveExpValues());
		parsedMap.put(HOUR, parserFactory.getFieldParser(new Hour(cronArgs[1])).deriveExpValues());
		parsedMap.put(DAY_OF_MONTH, parserFactory.getFieldParser(new Day(cronArgs[2])).deriveExpValues());
		parsedMap.put(MONTH, parserFactory.getFieldParser(new Month(cronArgs[3])).deriveExpValues());
		parsedMap.put(DAY_OF_WEEK, parserFactory.getFieldParser(new WeekDay(cronArgs[4])).deriveExpValues());
		command = extractCommandFromExp(cronExpression);
	}

	private String display() {

		StringBuffer strBuff = new StringBuffer();

		for (String seg : displayOrder) {

			if (parsedMap.get(seg) == null || parsedMap.get(seg).isEmpty())
				continue;

			strBuff.append(String.format(seg + " ".repeat(COLUMN_SIZE - seg.length()) + "%s",
					parsedMap.get(seg).stream().map(val -> val.toString()).collect(Collectors.joining(" "))));
			strBuff.append(LINE_SEPERATOR);

		}

		strBuff.append(String.format(COMMAND + " ".repeat(COLUMN_SIZE - COMMAND.length()) + "%s", this.command));

		return strBuff.toString();

	}

	private String extractCommandFromExp(String cronExpression) {
		String COMMAND_REGEX = "(?:\\S{1,}\\s){5}(.*)";
		Pattern p = Pattern.compile(COMMAND_REGEX);
		Matcher m = p.matcher(cronExpression);
		return m.find() ? m.group(1) : "";
	}

}
