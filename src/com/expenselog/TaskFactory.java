package com.expenselog;

import com.expenselog.tasks.ListTask;
import com.expenselog.tasks.Task;
import com.expenselog.tasks.TransactionTask;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	public static void setupTask(Task task) {
		if (task instanceof ListTask) {
			String profileName = MainArg.PROFILE.getValue();

			if (profileName == null ) {
				profileName = "default";
			}

			task.setProfileName(profileName);
			return;
		}

		if (task instanceof TransactionTask) {
			String profileName = MainArg.PROFILE.getValue();

			if (profileName == null ) {
				profileName = "default";
			}

			String dateString = MainArg.DATE.getValue();
			DateFormat df = new SimpleDateFormat("dd/MMM/yyyy - HH:mm");

			Date date = null;
			if (dateString != null) {
				try {
					date = df.parse(dateString);
				}
				catch (ParseException pe) {
					pe.printStackTrace();
					date = new Date();
				}
			}
			else {
				date = new Date();
			}

			double amount = Double.valueOf(MainArg.AMOUNT.getValue());
			if (MainArg.COMMAND.getValue().equals("add-expense") || MainArg.COMMAND.getValue().equals("ae")) {
				amount = amount * -1d;
			}

			task.setProfileName(profileName);
			task.setDate(date);
			task.setAmount(amount);
			task.setCategoryName(MainArg.CATEGORY.getValue());
			task.setDescription(MainArg.DESCRIPTION.getValue());
		}
	}

}
