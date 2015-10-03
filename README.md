## expense-log
Under development.
A simple program which helps you track your expenses and income.

This file needs to be organized better, and find a way to track/create/approve/decline the features, bugs. Also find a place for similar instructions like this.

###Plan
#### First milestone is to make the program usable in command line, be able to persist and export data.

* The program should be run by passing parameters to a built .jar file.
* Commands - ideas for commands: exl (short for expense-log) "income" -> "inc", "expense" -> "exp" "add-category" -> "ac", "remove-category" -> "rc"
* Add an expense with the command "exl exp 100' for example 
* Add income with "exl inc 300"
* Ability to handle different profiles. The above command adds exp/inc to the default user and as a different category
* Ability to add expense to a certain category (this should throw error if category not exists)
* Ability to add/remove category (exl add-category travel)
** If removing a category, provide the existing expenses to find their new category
* Persist data into a csv file under default.csv for the default profile.
* Show the current balance "exl bal" <- "excl balance"
* Show all months balances, show yearly balance(s), show certain month's balance
* Show these balances with categories, category totals, etc.

#### Second milestone is to provide a GUI
* Java GUI features for all the command line features

#### Third milestone - maybe webapp?
* Should we go on as a Java EE?

#### Mobile app seems so far far away for now... :-(

### Random Ideas

* Manage different currencies
* provide some graph in the command line ;-)
* Find previous examples on the net. Try the free ones out.
* Gather feature ideas from friends
* etc

