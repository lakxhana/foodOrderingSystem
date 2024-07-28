import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiscountController {
    private DiscountModel model;
    private DiscountView view;
    private double totalPrice;
    private double discountedPrice;

    public DiscountController(DiscountModel model, DiscountView view) {
        this.model = model;
        this.view = view;
        this.totalPrice = view.getOriginalPrice();
        this.discountedPrice = totalPrice; // Initialize discountedPrice with the original total price

        view.redeemButton1.addActionListener(new RedeemButtonListener(10));
        view.redeemButton2.addActionListener(new RedeemButtonListener(5));
        view.redeemButton3.addActionListener(new RedeemButtonListener(15));

        view.getApplyVoucherButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.showDiscountedPrice();
            }
        });

        view.nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
               
                OrderSummaryController orderController = new OrderSummaryController(new OrderSummaryModel(discountedPrice), new OrderSummaryView(discountedPrice));
                System.out.println("Total Price in Discount:"+discountedPrice);
            }
        });

        view.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	view.dispose();
                new FoodOrderingScreenController(new FoodOrderingScreenView(totalPrice), new FoodOrderingScreenModel(totalPrice));
                
            }
        });

        view.exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 FirstScreenModel firstScreenModel = new FirstScreenModel();
                 FirstScreenView firstScreenView = new FirstScreenView();
                 FirstScreenController firstScreenController = new FirstScreenController(firstScreenModel, firstScreenView);
                 view.dispose();
            }
        });
    }

    private class RedeemButtonListener implements ActionListener {
        private final double discount;

        public RedeemButtonListener(double discount) {
            this.discount = discount;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            view.showRedeemMessage();
            applyDiscount(discount);
            view.redeemButton1.setEnabled(false);
            view.redeemButton2.setEnabled(false);
            view.redeemButton3.setEnabled(false);
        }
    }

    private void applyDiscount(double discount) {
        discountedPrice = totalPrice;

        if (discount == 10 || discount == 15) {
            discountedPrice = model.calculateDiscount(totalPrice, discount);
        } else if (discount == 5 && totalPrice > 3) {
            discountedPrice = totalPrice - discount;
        }

        totalPrice = discountedPrice;
        view.setDiscountedPrice(discountedPrice);
    }
}
