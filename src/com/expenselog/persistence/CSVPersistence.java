package com.expenselog.persistence;


import com.expenselog.Transaction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class handles reading from and writing to a CSV file. The name of the file is always the name of the profile.
 * In order to minimize file operations, the class also saves read values in an ArrayList, as well as in a HashMap.
 * The first one is primarily used for iterating through all of the elements, whereas the latter one is for identifying
 * transactions as per their transactionIds.
 *
 * Created by Dániel Jávorszky on 17/10/15.
 */

public class CSVPersistence {

    private static String currentProfileName;
    private static ArrayList<String> fileArray;
    private static HashMap<Integer, String> transactionMap;
    private static boolean empty;
    private static boolean needUpdate = false;

    /**
     * This method saves an individual Transaction to the CSV file, and sets the "needUpdate" boolean flag to true.
     * @param transaction
     * @return
     */

    public static boolean saveTransaction(Transaction transaction) {

        if (fileArray == null || !currentProfileName.equals(transaction.getProfileName()) || needUpdate) {
            readFile(transaction.getProfileName());
        }

        try {
            Files.write(Paths.get("data/" + transaction.getProfileName() + ".csv"),
                    transaction.toString(true).getBytes(), StandardOpenOption.APPEND);
            needUpdate = true;
            return true;
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return false;
    }

    // TODO Write this.
    public static Transaction readTransaction(int id) {

        return null;
    }

    // TODO Write this.
    public static boolean updateTransaction(int id, Transaction transaction) {

        return false;
    }

    // TODO Write this.
    public static boolean deleteTransaction(int id) {

        return false;
    }

    /**
     * This function is responsible for reading the profile's CSV file and initializing and popoulating the
     * ArrayList and HashMap.
     *
     * If the file doesn't exist, then it creates a new one and sets the ArrayList and HashMap objects to be new, empty
     * objects.
     *
     * The file's name will be the value of the profileName variable.
     *
     * If a profile's file has been read already, the method will return its ArrayList already in memory, unless the
     * needUpdate variable is set to true, in which case it will re-read and update the internal variables.
     *
     * @param profileName
     * @return
     */
    public static ArrayList<String> readFile(String profileName) {
        if (profileName.equals(currentProfileName) && !needUpdate) {
            return fileArray;
        }

        transactionMap = new HashMap<Integer, String>();
        currentProfileName = profileName;
        fileArray = new ArrayList<String>();

        File file = new File("data/" + profileName + ".csv");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            else {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    fileArray.add(line);
                    String[] lineArray = line.split(";");
                    transactionMap.put(Integer.valueOf(lineArray[4]), line);
                }
                reader.close();
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

        empty = fileArray.isEmpty();

        return fileArray;
    }

    public static boolean deleteProfile(String profileName) {
        try {
            Files.deleteIfExists(Paths.get("data/" + profileName + ".csv"));
            return true;
        }
        catch (IOException ioe) {
            System.out.println("Couldn't delete file for some reason.");
            return false;
        }
    }

}
