
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;


public class CustomerSupportController {
	private CustomerSupportView customerSupportView;
	private FAQView faqView;
	
	public CustomerSupportController(CustomerSupportView customerSupportView) {
        this.customerSupportView = customerSupportView;
        this.customerSupportView.addCallButtonListener(new CallButtonListener());
        this.customerSupportView.addFaqButtonListener(new FaqButtonListener());
        this.customerSupportView.addButtonListener(new NavigationButtonListener());
    }
    
	class CallButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Implement the logic for the call button
            JOptionPane.showMessageDialog(null, "Calling customer support...");
        }
    } 
	
	 class FaqButtonListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Sample FAQ data
	            List<String> faqs = Arrays.asList(
	                "\n\nQ: How long will a movie usually be screened at CineMy?",
	                "A: A movie will normally be screened for at least 2 weeks, or longer, depending on market demand.\n\n",
	                "Q: What is the age range for 'Children' ticket?",
	                "A: Children aged 3 to 12 years old is based on Year of Birth.\n\n",
	                "Q: Can I select my own seats through CineMy E-Payment Ticketing?",
	                "A: Yes, you can select any available seats through the CineMy E-Payment Ticketing.\n\n",
	                "Q: What should I do if I received an 'Unsuccessful' message after the payment?",
	                "A: Check if your card was charged. If no, please proceed to repurchase the tickets. If yes, please contact our Customer Support (Monday-Friday from 9am to 6pm excluding Public Holidays) for assistance.\n\n"
	            );

	            faqView = new FAQView(faqs);
	            faqView.addButtonListener(new NavigationButtonListener());
	            customerSupportView.setVisible(false);
	            faqView.setVisible(true);
	        }
	    }

    
	 class NavigationButtonListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String command = e.getActionCommand();
	            if (command.equals("Back")) {
	            	 FirstScreenModel firstScreenModel = new FirstScreenModel();
	                 FirstScreenView firstScreenView = new FirstScreenView();
	                 FirstScreenController firstScreenController = new FirstScreenController(firstScreenModel, firstScreenView);
	                 firstScreenController.updateView();
	                 customerSupportView.dispose();	            } 
	        }
	    }

	
}

