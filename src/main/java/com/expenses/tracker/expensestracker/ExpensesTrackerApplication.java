package com.expenses.tracker.expensestracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpensesTrackerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExpensesTrackerApplication.class, args);
		String clientId = System.getenv("GOOGLE_API_CLIENT_ID");
		String clientSecret = System.getenv("GOOGLE_API_CLIENT_SECRET");

		System.out.println("clientId: " + clientId);
		System.out.println("clientSecret: " + clientSecret);
	}

}
