import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FirstScreenController {
    private FirstScreenModel model;
    private FirstScreenView view;

    public FirstScreenController(FirstScreenModel firstScreenModel, FirstScreenView firstScreenView) {
        this.model = firstScreenModel;
        this.view = firstScreenView;
        this.view.addButtonListener(new ButtonListener());
    }

    public void updateView() {
        view.updateFirstScreenView();
    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.touchButton) {
                System.out.println("Navigating to Showtime1 screen.");
                // Initialize the next view and controller only when button is clicked
                Showtime1Model showtime1Model = new Showtime1Model();
                Showtime1View showtime1View = new Showtime1View();
                Showtime1Controller showtime1Controller = new Showtime1Controller(showtime1Model, showtime1View);
                showtime1Controller.updateView();
                showtime1View.setVisible(true);
                view.dispose();
                
            } else if (e.getSource() == view.helplineButton) {
            	view.dispose();
                System.out.println("Navigating to CustomerSupportView.");
                CustomerSupportView view = new CustomerSupportView();
                CustomerSupportController controller = new  CustomerSupportController(view);
                CustomerSupportModel model = new CustomerSupportModel();
                
            }
        }
    }
}
