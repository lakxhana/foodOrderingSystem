public class DiscountModel {
    private double discountPercentage;

    public DiscountModel(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double calculateDiscount(double originalPrice, double discountPercentage) {
        return originalPrice - (originalPrice * discountPercentage / 100);
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
