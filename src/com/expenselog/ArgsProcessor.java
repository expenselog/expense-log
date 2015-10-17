package com.expenselog;

public class ArgsProcessor {

	public ArgsProcessor(String[] args) {
		this.args = args;
		maArray = MainArg.values(); 
	}

	public void processArgs() {	
		verifyArgs(); //Kell?
		setMainArgs();
		validateArgs();
	}

	//Check for validity, can be converted to double, existing category, existing profile, etc
	private void validateArgs() {
		
	}

	//Check if the necessary args are given and exist at all in the command line
	private void verifyArgs() {
		
	}

	//TODO Make this smarter, or make validate smarter?
	//TODO At least stop the iteration when fount the right spot
	private void setMainArgs() {
		for (int i = 0; i < args.length; i = i + 2) {

			for (MainArg ma : MainArg.values()) {
				boolean added = ma.setValue(args[i], args[i + 1]);

				if (added) {
					break;
				}
			}
		}
	}

	/*MainArg findArgBasedOnKey(String key) {
		boolean found = false;
		MainArg ma;
		for (MainArg ma2 : MainArg.values()) {
			
			
			ma = ma2;
			if (found == true) {
				break;
			}
		}
		
		return ma;
	}*/
	
	/*Task getTask() {
	//Returns the Task which should be created based on the command given in the arguments
		Task t = TaskFactory.getTask(MainArg.COMMAND);
		t.getObligatoryArgs();
		t.getOptionalArgs();
		
		checkIfUserGaveAllTheNeededArgs();
		
		t.setUp(maArray);
		return t;
	}*/

	String args[];
	MainArg[] maArray;
}
