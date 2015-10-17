package com.expenselog;

public enum MainArg {
	COMMAND("-c", "--command"), DATE("-d","--date"),
	AMOUNT("-a","--amount"), CATEGORY("-ct","--category"),
	DESCRIPTION("-dc","--description"), PROFILE("-p","--profile");

	private String shortKey;
	private String longKey;
	private String value;

	private MainArg (String shortKey, String longKey) {
		this.shortKey = shortKey;
		this.longKey = longKey;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean setValue(String key, String value) {
		if (shortKey.equals(key) || longKey.equals(key)) {
			this.value = value;
			return true;
		}
		return false;
	}

	public String getValue() {
		return value;
	}
	
	public String getShortKey() {
		return shortKey;
	}
	
	public String getLongKey() {
		return longKey;
	}

	@Override
	public String toString() {
		return value;
	}
	
	/*
	public boolean isShortKey(String key){
		boolean equals = shortKey.equals(key);
		return equals;
	}
	
	public boolean isLongKey(String key){
		boolean equals = longKey.equals(key);
		return equals;
	}
	*/
}
