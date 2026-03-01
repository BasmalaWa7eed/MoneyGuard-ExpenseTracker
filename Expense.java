package com.expense.tracker;
public class Expense {
    String description ;
    double amount ;
    String category ;

    public Expense (String description , double amount, String category){

        this.description = description;
        this.amount = amount;
        this.category = category;

    }
    public double getAmount() {
        return amount;
    }
    public String getCategory() {
        return category;
    }
    public String getDescription() {
        return description;
    }

    @Override
    public String toString (){

    return   "Item: " + description + " | Cost: " + amount + " EGP | Category: " + category;

    }
}
