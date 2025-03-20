import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private List<Expense> expenses;
    private static final String FILE_NAME = "expenses.txt";

    // Constructor
    public ExpenseManager() {
        expenses = new ArrayList<>();
        loadExpenses(); 												// Load expenses from file when the manager is created
    }

    // Add an expense
    public void addExpense(double amount, String category, String description) {
        Expense expense = new Expense(amount, category, description);
        expenses.add(expense);
        saveExpenses(); 												3// Save expenses to file after adding
    }

    // View all expenses
    public void viewAllExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    // View total expenses for the day, week, or month
    public void viewSummary(String period) {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        System.out.println("Total expenses for " + period + ": " + total);
    }

    // Save expenses to a file
    private void saveExpenses() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Expense expense : expenses) {
                writer.write(expense.getAmount() + "," + expense.getCategory() + "," + expense.getDescription());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving expenses to file: " + e.getMessage());
        }
    }

    // Load expenses from a file
    private void loadExpenses() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                double amount = Double.parseDouble(parts[0]);
                String category = parts[1];
                String description = parts[2];
                expenses.add(new Expense(amount, category, description));
            }
        } catch (IOException e) {
            System.out.println("Error loading expenses from file: " + e.getMessage());
        }
    }
}