import java.util.ArrayList;
import java.util.List;

public class FoodOrderingScreenModel {
    private ArrayList<String> foodItems;
    private ArrayList<String> foodPrice;
    private double totalTicketPrice;

    public FoodOrderingScreenModel(double totalTicketPrice) {
        this.foodItems = new ArrayList<>();
        this.foodPrice = new ArrayList<>();
        this.totalTicketPrice = totalTicketPrice;
        initializeFoodItems();
        initializeFoodPrices();
    }

    private void initializeFoodItems() {
        foodItems.add("Popped popcorn.");
        foodItems.add("Creamy Cheddar Nacho Chips");
        foodItems.add("Crispy Fries Smothered in Cheese.");
        foodItems.add("Chilled Water.");
        foodItems.add("Effervescent Citrus Soda.");
    }

    private void initializeFoodPrices() {
        foodPrice.add("9");
        foodPrice.add("19");
        foodPrice.add("17");
        foodPrice.add("2");
        foodPrice.add("4");
    }

    public ArrayList<String> getFoodItems() {
        return this.foodItems;
    }

    public ArrayList<String> getFoodPrice() {
        return this.foodPrice;
    }

    public double calculateTotalPrice(int[] quantities) {
        double total = totalTicketPrice;
        for (int i = 0; i < quantities.length; i++) {
            total += quantities[i] * Double.parseDouble(foodPrice.get(i));
        }
        return total;
    }
}
