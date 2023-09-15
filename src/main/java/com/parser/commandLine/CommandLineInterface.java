package com.parser.commandLine;

import com.parser.impl.CronExpressionParser;

public class CommandLineInterface {

	public static void main(String[] args) {

		// potentially incorrect arguments scenario
		if (args.length != 1) {
			throw new IllegalArgumentException("Please check your input arguments");
		}

		System.out.print(new CronExpressionParser().parseAndDisplay(args[0]));
	}

}
