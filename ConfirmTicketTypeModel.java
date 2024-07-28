public class ConfirmTicketTypeModel {
    private int seniorCount;
    private int studentCount;
    private int adultCount;
    private int okuCount;

    // Prices for each ticket category
    private double seniorPrice = 10.0; // Example price
    private double studentPrice = 8.0; // Example price
    private double adultPrice = 15.0;  // Example price
    private double okuPrice = 5.0;     // Example price

    // Getters and setters for counts
    public int getSeniorCount() {
        return seniorCount;
    }

    public void setSeniorCount(int seniorCount) {
        this.seniorCount = seniorCount >= 0 ? seniorCount : 0; // Ensure non-negative counts
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount >= 0 ? studentCount : 0; // Ensure non-negative counts
    }

    public int getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(int adultCount) {
        this.adultCount = adultCount >= 0 ? adultCount : 0; // Ensure non-negative counts
    }

    public int getOkuCount() {
        return okuCount;
    }

    public void setOkuCount(int okuCount) {
        this.okuCount = okuCount >= 0 ? okuCount : 0; // Ensure non-negative counts
    }

    // Getters and setters for prices
    public double getSeniorPrice() {
        return seniorPrice;
    }

    public void setSeniorPrice(double seniorPrice) {
        this.seniorPrice = seniorPrice >= 0 ? seniorPrice : 0.0; // Ensure non-negative prices
    }

    public double getStudentPrice() {
        return studentPrice;
    }

    public void setStudentPrice(double studentPrice) {
        this.studentPrice = studentPrice >= 0 ? studentPrice : 0.0; // Ensure non-negative prices
    }

    public double getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(double adultPrice) {
        this.adultPrice = adultPrice >= 0 ? adultPrice : 0.0; // Ensure non-negative prices
    }

    public double getOkuPrice() {
        return okuPrice;
    }

    public void setOkuPrice(double okuPrice) {
        this.okuPrice = okuPrice >= 0 ? okuPrice : 0.0; // Ensure non-negative prices
    }

    // Method to calculate total price based on counts and prices
    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        totalPrice += seniorCount * seniorPrice;
        totalPrice += studentCount * studentPrice;
        totalPrice += adultCount * adultPrice;
        totalPrice += okuCount * okuPrice;
        return totalPrice;
    }
    
    public int getTotalCount() {
        return seniorCount + studentCount + adultCount + okuCount;
    }

   
}
