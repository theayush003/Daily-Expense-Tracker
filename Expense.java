public class Expense {
    private double amount;
    private String category;
    private String description;

    // Constructor
    public Expense(double amount, String category, String description) {
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    // Getters
    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    // Override toString() for easy printing
    @Override
    public String toString() {
        return "Amount: " + amount + ", Category: " + category + ", Description: " + description;
    }
}