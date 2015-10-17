package com.expenselog.tasks;

import com.expenselog.tasks.exception.IncompleteTaskException;

import java.util.Date;
import java.util.HashMap;

/**
 * The abstract Task class should be extended by each tasks. It provides the bare necessities that every Task object
 * should have.
 *
 * Created by Dániel Jávorszky on 15/10/15.
 */
public abstract class Task {

    protected String profileName;
    protected double amount;
    protected Date date;
    protected String categoryName;
    protected String description;

    /**
     * execute is the main method for tasks, and should be implemented by each subclasses.
     * @return
     */
    public abstract boolean execute();

    /**
     * validateTask checks if the profileName, date and categoryName are null. If they are, it throws an exception.
     * @throws IncompleteTaskException
     */
    public void validateTask() throws IncompleteTaskException {
        if (profileName == null || date == null || categoryName == null) {
            throw new IncompleteTaskException();
        }
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }
}
