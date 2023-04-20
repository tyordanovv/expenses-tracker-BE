package com.expenses.tracker.expensestracker.transaction.entity;

public enum IncomeCategory {
    // Income
    INCOME_SALARY("Salary"),
    INCOME_BONUS("Bonus"),
    INCOME_DIVIDEND("Dividend"),
    INCOME_OTHER("Other");


    private final String displayName;

    IncomeCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
