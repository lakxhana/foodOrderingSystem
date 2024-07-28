import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class OrderSummaryController {
    private OrderSummaryModel model;
    private OrderSummaryView view;

    public OrderSummaryController(OrderSummaryModel model, OrderSummaryView view) {
        this.model = model;
        this.view = view;
        updateTotalPrice();
        this.view.addButtonListener(new ButtonListener());
    }
    
    private void updateTotalPrice() {
        double total = model.getTotalPrice();
        view.totalAmountLabel.setText(String.format("%.2f", total));
    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.nextButton) {
                view.dispose();
                System.out.println("Navigating to card payment");
                CardPaymentView view = new CardPaymentView();
                CardPaymentModel model = new CardPaymentModel();
                CardPaymentController cont = new CardPaymentController(model,view);
               
            }
        }
    }
}
