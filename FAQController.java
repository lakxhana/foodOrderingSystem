import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FAQController {
    private FAQView view;
    private FAQModel model;

    public FAQController(FAQView view, FAQModel model) {
        this.view = view;
        this.model = model;
        view.addButtonListener(new ButtonListener());
    }

    // Define the ButtonListener class inside FAQController
    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Back")) {
                // Handle the Back button action
                view.setVisible(false);
                view.dispose(); // Dispose of the FAQView window
                CustomerSupportView view = new CustomerSupportView();
                CustomerSupportController controller = new  CustomerSupportController(view);
                CustomerSupportModel model = new CustomerSupportModel();
            } 

            }
        }
    
}
