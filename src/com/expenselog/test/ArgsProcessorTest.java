package com.expenselog.test;

import static org.junit.Assert.*;

import com.expenselog.ArgsProcessor;
import com.expenselog.MainArg;
import org.junit.Test;

public class ArgsProcessorTest {

	@Test
	public void testSetMainArgs() {

		/*String [] allShortArgsWithValues = {minusC, command,
												minusD, date,
												minusA, amount,
												minusCT, category,
												minusDC, description};*/

		String [] allShortArgsWithValuesReverse = {minusDC, description,
															minusCT, category,
															minusA, amount,
															minusD, date,
															minusC, command};

		ArgsProcessor ap = new ArgsProcessor(allShortArgsWithValuesReverse);
		ap.processArgs();
		
		for (MainArg ma : MainArg.values()) {
			System.out.println(ma.name() + " " + ma);
		}
		
		assertEquals(MainArg.COMMAND.toString(), command);
		assertEquals(MainArg.DATE.toString(), date);
		assertEquals(MainArg.AMOUNT.toString(), amount);
		assertEquals(MainArg.CATEGORY.toString(), category);
		assertEquals(MainArg.DESCRIPTION.toString(), description);
	}

	private String minusC = "-c";
	private String minusMinusCommand = "--command";
	private String command = "Command";
	
	private String minusD = "-d";
	private String minusMinusDate = "--date";
	private String date = "2015-10-17";
	
	private String minusA = "-a";
	private String minusMinusAmount = "--amount";
	private String amount = "123.456";

	private String minusCT = "-ct";
	private String minusMinusCategory = "--category";
	private String category = "Category";

	private String minusDC = "-dc";
	private String minusMinusDescription = "--description";
	private String description = "Description";

}
