package com.expenselog;

public class Main {

	public static void main(String[] args) {

		ArgsProcessor ap = new ArgsProcessor(args);
		ap.processArgs();
		//Task t = ap.getTask();

	}

}
