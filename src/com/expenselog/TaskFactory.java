package com.expenselog;

public class TaskFactory {

	public static Task getTask(MainArg maCommand) {

		if (maCommand.getValue().equals("list")) {
			Task t = new ListTask();
			return t;
		}

		if (maCommand.getValue().equals("add-expense") ||
			maCommand.getValue().equals("add-income")) {
			Task t = new TransactionTask();
			return t;
		}

		return null;
	}
}
