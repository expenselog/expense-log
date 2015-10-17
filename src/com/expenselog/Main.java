package com.expenselog;

import com.expenselog.tasks.Task;

public class Main {

	public static void main(String[] args) {

		ArgsProcessor ap = new ArgsProcessor(args);
		ap.processArgs();
		Task t = TaskFactory.getTask(MainArg.COMMAND);
		TaskFactory.setupTask(t);
		t.execute();
	}

}
