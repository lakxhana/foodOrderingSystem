import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardPaymentController {
	private CardPaymentModel model;
	private CardPaymentView view;

	public CardPaymentController(CardPaymentModel model, CardPaymentView view) {
        this.model = model;
        this.view = view;

        view.addButtonListener(new ButtonListener());
    }

	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {			
			System.out.printf("CardPaymentController");
			double totalPrice = 0;
			if (e.getSource() == view.backButton) {
				 new OrderSummaryController(new OrderSummaryModel(totalPrice), new OrderSummaryView(totalPrice));
			} else if (e.getSource() == view.nextButton) {				
				new PaymentSuccessController(new PaymentSuccessModel(), new PaymentSuccessView());
			} else {
				 FirstScreenModel firstScreenModel = new FirstScreenModel();
		            FirstScreenView firstScreenView = new FirstScreenView();
		            FirstScreenController firstScreenController = new FirstScreenController(firstScreenModel, firstScreenView);
		            firstScreenController.updateView();
			}
		}
	}
}
