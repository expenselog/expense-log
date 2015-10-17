package com.expenselog.test;

import com.expenselog.Transaction;
import com.expenselog.persistence.CSVPersistence;
import org.junit.Test;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by DánielJávorszky on 17/10/15.
 */
public class CSVPersistenceTest {

    @Test
    public void testSaveTransaction() throws Exception {
        CSVPersistence.deleteProfile("MyTestProfile");

        Date date = new Date();
        DateFormat df = new SimpleDateFormat("dd/MMM/yyyy - HH:mm");

        Transaction transaction = new Transaction(date, 100.0, "MyCategory", "MyDescription", "MyTestProfile", 1);

        String transactionString = transaction.toString();

        String controlMessage = df.format(date) + ";100.0;MyCategory;MyDescription;1";

        CSVPersistence.saveTransaction(transaction);
        ArrayList<String> savedEntries = CSVPersistence.readFile("MyTestProfile");

        assertEquals(savedEntries.get(0), controlMessage);
    }

    // TODO Write this.
    @Test
    public void testReadTransaction() throws Exception {

    }

    // TODO Write this.
    @Test
    public void testUpdateTransaction() throws Exception {

    }

    // TODO Write this.
    @Test
    public void testDeleteTransaction() throws Exception {

    }

    @Test
    public void testReadFile() throws Exception {
        CSVPersistence.deleteProfile("MyTestProfile");
        CSVPersistence.deleteProfile("MyOtherTestProfile");

        // Test to see if it works with a not-yet existing file.
        ArrayList<String> emptyFile = CSVPersistence.readFile("MyTestProfile");

        File file = new File("data/MyTestProfile.csv");

        assertEquals(file.exists(), true);
        assertEquals(emptyFile.isEmpty(), true);

        // Test to see if after adding the transaction, the file is re-read.
        Transaction transaction = new Transaction(new Date(), 100.0, "MyCategory", "MyDescription", "MyTestProfile");
        CSVPersistence.saveTransaction(transaction);

        ArrayList<String> fileWithOneRecord = CSVPersistence.readFile("MyTestProfile");

        assertEquals(fileWithOneRecord.size(), 1);

        CSVPersistence.deleteProfile("MyTestProfile");

        // Test to see if a new, empty file is created.

        ArrayList<String> newEmptyFile = CSVPersistence.readFile("MyOtherTestProfile");
        assertEquals(newEmptyFile.isEmpty(), true);

        CSVPersistence.deleteProfile("MyOtherTestProfile");

    }

    @Test
    public void testDeleteProfile() throws Exception {
        CSVPersistence.deleteProfile("MyTestProfile");

        ArrayList<String> emptyFile = CSVPersistence.readFile("MyTestProfile");

        // Test if file is created
        File file = new File("data/MyTestProfile.csv");

        assertEquals(file.exists(), true);

        // Test if file gets deleted
        CSVPersistence.deleteProfile("MyTestProfile");

        assertEquals(file.exists(), false);
    }
}