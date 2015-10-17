package com.expenselog.tasks;

import com.expenselog.Transaction;
import com.expenselog.persistence.CSVPersistence;
import com.expenselog.tasks.exception.IncompleteTaskException;

/**
 * This class validates the task, creates a transaction and saves it in the CSV file as per its profileName.
 *
 * Created by Dániel Jávorszky on 17/10/15.
 */
public class TransactionTask extends Task {

    @Override
    public boolean execute() {

        try {
            validateTask();
        }
        catch (IncompleteTaskException ite) {
            System.out.println("Task is invalid, there are missing parameters");
            // TODO print all parameters of the Task in quesiton.
            return false;
        }

        Transaction transaction = new Transaction(date, amount, categoryName, description, profileName);

        return CSVPersistence.saveTransaction(transaction);

    }

}
