import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FoodOrderingScreenController {

    private int[] counters = new int[5];
    private FoodOrderingScreenView view;
    private FoodOrderingScreenModel model;
    private ArrayList<String> foodItem;
    private ArrayList<String> foodPrice;
    private double totalTicketPrice;

    public FoodOrderingScreenController(FoodOrderingScreenView view, FoodOrderingScreenModel model) {
        this.view = view;
        this.model = model;
        this.foodItem = model.getFoodItems();
        this.foodPrice = model.getFoodPrice();
        this.totalTicketPrice = model.calculateTotalPrice(counters);

        view.addButtonListener(new ButtonListener());
        updateFoodItem();
        updateTotalPrice(); // Update the total price initially
    }

    public void updateFoodItem() {
        view.updateView(foodItem, foodPrice);
    }

    private void updateCounterLabel(int index) {
        switch (index) {
            case 0:
                view.quantityLabel1.setText("" + counters[index]);
                break;
            case 1:
                view.quantityLabel2.setText("" + counters[index]);
                break;
            case 2:
                view.quantityLabel3.setText("" + counters[index]);
                break;
            case 3:
                view.quantityLabel4.setText("" + counters[index]);
                break;
            case 4:
                view.quantityLabel5.setText("" + counters[index]);
                break;
        }
        updateTotalPrice();
    }

    private void updateTotalPrice() {
        double total = model.calculateTotalPrice(counters);
        view.totalAmountLabel.setText(String.format("%.2f", total));
    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.nextButton) {
                showDiscountView();
            }

            if (e.getSource() == view.backButton) {
                view.dispose();
                
                new SelectSeatsView();
    		   
            }
            
            if(e.getSource()== view.exitButton) {
            	showFirstScreenView();
            }

            if (e.getSource() == view.addButton1) {
                counters[0]++;
                updateCounterLabel(0);
            }

            if (e.getSource() == view.removeButton1) {
                if (counters[0] > 0) {
                    counters[0]--;
                    updateCounterLabel(0);
                }
            }

            if (e.getSource() == view.addButton2) {
                counters[1]++;
                updateCounterLabel(1);
            }

            if (e.getSource() == view.removeButton2) {
                if (counters[1] > 0) {
                    counters[1]--;
                    updateCounterLabel(1);
                }
            }

            if (e.getSource() == view.addButton3) {
                counters[2]++;
                updateCounterLabel(2);
            }

            if (e.getSource() == view.removeButton3) {
                if (counters[2] > 0) {
                    counters[2]--;
                    updateCounterLabel(2);
                }
            }

            if (e.getSource() == view.addButton4) {
                counters[3]++;
                updateCounterLabel(3);
            }

            if (e.getSource() == view.removeButton4) {
                if (counters[3] > 0) {
                    counters[3]--;
                    updateCounterLabel(3);
                }
            }

            if (e.getSource() == view.addButton5) {
                counters[4]++;
                updateCounterLabel(4);
            }

            if (e.getSource() == view.removeButton5) {
                if (counters[4] > 0) {
                    counters[4]--;
                    updateCounterLabel(4);
                }
            }
        }

        private void showDiscountView() {
            double totalPrice = Double.parseDouble(view.totalAmountLabel.getText());
            view.dispose();

            DiscountModel discountModel = new DiscountModel(10); 
            DiscountView discountView = new DiscountView(totalPrice);
            DiscountController discountController = new DiscountController(discountModel, discountView);

        }
        
        private void showFirstScreenView() {
            
            view.dispose();
            FirstScreenModel firstScreenModel = new FirstScreenModel();
            FirstScreenView firstScreenView = new FirstScreenView();
            FirstScreenController firstScreenController = new FirstScreenController(firstScreenModel, firstScreenView);
            firstScreenController.updateView();
        }
    }
}
