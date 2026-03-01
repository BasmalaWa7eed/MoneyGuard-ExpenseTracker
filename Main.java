package com.expense.tracker;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in) ;
        System.out.println("--- Welcome to MoneyGuard System ---");

        System.out.println("What is your name?");
        String UserName = input.next();

        System.out.println("Hello "+UserName+"! How much do you have for this month ?");
        int totalBudget = input.nextInt() ;


        Map <String,Integer> BudgetPlan = new HashMap<>();
        String[] categories = {
                "Food" , "Transport" , "Savings" , "Self-care" , "Emergency"
        };
        System.out.println("\n--- Budget Allocation ---");
        for (String cat : categories ) {
            System.out.println("Please enter the percentage for "+cat+": ");
            double percent = input.nextDouble();
            int amount = (int) ((percent/100)*totalBudget) ;
            BudgetPlan.put(cat , amount) ;
        }



        System.out.println("\n--- Your Monthly Plan ---");
        for (Map.Entry<String,Integer> entry: BudgetPlan.entrySet()){

            System.out.println(entry.getKey()+ ": "+ entry.getValue());
        }

        System.out.println("Do you want to add a new expense? (yes/no)");
        double totalSpent = 0 ;
        String choice = input.next();

        while (choice.equalsIgnoreCase("yes")){
            System.out.print("What did you buy? ");
            String item = input.next();

            System.out.print("How much did it cost? ");
            double cost = input.nextDouble();

            System.out.print("Which category? (Food, Transport...): ");
            String cat = input.next();


            if (BudgetPlan.containsKey(cat)) {
                int remaining = BudgetPlan.get(cat) - (int)cost;
                BudgetPlan.put(cat, remaining);
                System.out.println("Remaining in " + cat + ": " + remaining);
            }


            totalSpent += cost;
            double spentPercentage = (totalSpent / totalBudget) * 100;

            if (spentPercentage >= 100) {
                System.out.println("[!!!] LIMIT REACHED: 100% of budget spent!");
            }
            else if (spentPercentage >= 75) {
                System.out.println("!!! ALERT: 75% of budget spent !!!");
            } else if (spentPercentage >= 50) {
                System.out.println("!! Warning: 50% of budget spent !!");
            } else if (spentPercentage >= 25) {
                System.out.println("[i] Heads up: 25% of budget spent.");
            }


            System.out.print("\nDo you want to add another expense? (yes/no): ");
            choice = input.next();
        }

        System.out.println("\n--- FINAL BUDGET SUMMARY ---");
        for (Map.Entry<String, Integer> entry : BudgetPlan.entrySet()) {
            System.out.println(entry.getKey() + " Remaining: " + entry.getValue());
        }

        System.out.println("Total Spent: " + (int)totalSpent);
        double remainingTotal = totalBudget - totalSpent;
        System.out.println("Total Balance Remaining: " + (int)remainingTotal );

    }
}
