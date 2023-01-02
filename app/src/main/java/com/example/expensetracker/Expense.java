package com.example.expensetracker;

public class Expense {
    private String expense;
    private int amount;

    public Expense(String expense, int amount) {
        this.expense = expense;
        this.amount = amount;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
