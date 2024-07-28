import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentSuccessController {
	private PaymentSuccessModel model;
	private PaymentSuccessView view;

	public PaymentSuccessController(PaymentSuccessModel model, PaymentSuccessView view) {
        this.model = model;
        this.view = view;

        view.addButtonListener(new ButtonListener());
    }

	public class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {			
			System.out.printf("PaymentSuccessController");
			if (e.getSource() == view.backButton) {
				FirstScreenModel firstScreenModel = new FirstScreenModel();
	            FirstScreenView firstScreenView = new FirstScreenView();
				FirstScreenController firstScreenController = new FirstScreenController(firstScreenModel, firstScreenView);
	            firstScreenController.updateView();
                view.dispose();

			} else if (e.getSource() == view.nextButton){
				FirstScreenModel firstScreenModel = new FirstScreenModel();
	            FirstScreenView firstScreenView = new FirstScreenView();
				FirstScreenController firstScreenController = new FirstScreenController(firstScreenModel, firstScreenView);
	            firstScreenController.updateView();
                view.dispose();

			}else {
				FirstScreenModel firstScreenModel = new FirstScreenModel();
	            FirstScreenView firstScreenView = new FirstScreenView();
				FirstScreenController firstScreenController = new FirstScreenController(firstScreenModel, firstScreenView);
	            firstScreenController.updateView();
                view.dispose();

			}
		}
	}
}
