import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;

        // Add button listeners
        view.addButtonListener(new ButtonListener());
    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.nextButton) {
                view.setVisible(false);
                view.dispose();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Implementation not needed for this example
    }
}
