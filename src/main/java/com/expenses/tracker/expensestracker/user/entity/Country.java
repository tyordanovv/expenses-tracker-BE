package com.expenses.tracker.expensestracker.user.entity;

public enum Country {
    BG,
    EN,
    DE;

    public static Country selectDefault() {
        return BG;
    }
}