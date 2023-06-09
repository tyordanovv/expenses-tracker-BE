package com.expenses.tracker.expensestracker.transaction.entity;

public enum TransactionCategory {
    // Expense
    EXPENSE_GROCERY("Grocery"),
    EXPENSE_FOOD("Food"),
    EXPENSE_UTILITIES("Utilities"),
    EXPENSE_HEALTHCARE("Healthcare"),
    EXPENSE_ENTERTAINMENT("Entertainment"),
    EXPENSE_TRANSPORTATION("Transportation"),
    EXPENSE_INSURANCE("Insurance"),
    EXPENSE_MORTGAGE("Mortgage"),
    EXPENSE_EDUCATION("Education"),
    EXPENSE_TRAVEL("Travel"),
    EXPENSE_CHARITY("Charity"),
    EXPENSE_SUBSCRIPTIONS("Subscriptions"),
    EXPENSE_HOME("Home"),
    EXPENSE_PETS("Pets"),
    EXPENSE_HAIRCUTS("Haircuts"),
    EXPENSE_RENT("Rent"),
    EXPENSE_OTHER("Other"),
    //Income
    INCOME_SALARY("Salary"),
    INCOME_BONUS("Bonus"),
    INCOME_DIVIDEND("Dividend"),
    INCOME_OTHER("Other");


    private final String displayName;

    TransactionCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
