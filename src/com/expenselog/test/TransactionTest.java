package com.expenselog.test;

import com.expenselog.Transaction;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Dániel Jávorszky on 17/10/15.
 */
public class TransactionTest {

    @Test
    public void testToString() throws Exception {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("dd/MMM/yyyy - HH:mm");

        Transaction transaction = new Transaction(date, 100.0, "MyCategory", "MyDescription", "MyProfile", 1);

        String transactionString = transaction.toString();

        String controlMessage = df.format(date) + ";100.0;MyCategory;MyDescription;1";

        assertEquals(transactionString, controlMessage);
    }

    @Test
    public void testToStringWithNewLine() throws Exception {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("dd/MMM/yyyy - HH:mm");

        Transaction transaction = new Transaction(date, 100.0, "MyCategory", "MyDescription", "MyProfile");

        String transactionString = transaction.toString(true);

        String controlMessage = df.format(date) + ";100.0;MyCategory;MyDescription;1" + System.lineSeparator();

        assertEquals(transactionString, controlMessage);
    }

    @Test
    public void testToTransaction() throws Exception {
        String stringToTransaction = "17/Oct/2015 - 14:27;100.0;MyCategory;MyDescription;1";

        Transaction transaction = Transaction.toTransaction(stringToTransaction, "MyProfile");

        DateFormat df = new SimpleDateFormat("dd/MMM/yyy - HH:mm");
        Date date = df.parse("17/Oct/2015 - 14:27");

        assertNotEquals(transaction, null);
        assertEquals(transaction.getAmount(), 100.0, 0);
        assertEquals(transaction.getCategoryName(), "MyCategory");
        assertEquals(transaction.getDate(), date);
        assertEquals(transaction.getDescription(), "MyDescription");
        assertEquals(transaction.getTransactionId(), 1);
        assertEquals(transaction.getProfileName(), "MyProfile");
    }
}