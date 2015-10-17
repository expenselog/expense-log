package com.expenselog;

import com.sun.org.apache.xml.internal.utils.StringBufferPool;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is the model for an individual transaction.
 *
 * Created by Dániel Jávorszky on 17/10/15.
 * Created by Ádám T. Nagy on 17/10/15.
 */

public class Transaction {

	public Transaction(Date date, double amount, String categoryName, String description, String profileName) {
		this(date, amount, categoryName, description, profileName, 1);
	}

	public Transaction(Date date, double amount, String categoryName, String description, String profileName,
						int transactionId) {
		this.date = date;
		this.amount = amount;
		this.categoryName = categoryName;
		this.description = description;
		this.profileName = profileName;

		// TODO implement ids.
		this.transactionId = transactionId;
	}

	public double getAmount() {
		return amount;
	}

	public Date getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	public boolean isExpense() {
		return (amount < 0);
	}

	public String getProfileName() {
		return profileName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public int getTransactionId() {
		return transactionId;
	}

	@Override
	public String toString() {
		return toString(false);
	}

	public String toString(boolean newLine) {
		StringBuilder sb = new StringBuilder(10);
		DateFormat df = new SimpleDateFormat("dd/MMM/yyyy - HH:mm");
		sb.append(df.format(date));
		sb.append(";");
		sb.append(amount);
		sb.append(";");
		sb.append(categoryName);
		sb.append(";");
		sb.append(description);
		sb.append(";");
		sb.append(transactionId);
		if (newLine) {
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}

	public static Transaction toTransaction(String representation, String profileName) {
		String[] array = representation.split(";");

		DateFormat dt = new SimpleDateFormat("dd/MMM/yyy - HH:mm");
		Date date = null;
		try {
			date = dt.parse(array[0]);
		}
		catch (ParseException pe) {
			pe.printStackTrace();
			return null;
		}
		double amount = Double.valueOf(array[1]);
		String categoryName = array[2];
		String description = array[3];
		int transactionId = Integer.valueOf(array[4]);

		return new Transaction(date, amount, categoryName, description, profileName);

	}

	//TODO Implement Comparator

	private final Date date;
	private final double amount;
	private final String categoryName;
	private final String description;
	private final String profileName;


	private final int transactionId;
}
