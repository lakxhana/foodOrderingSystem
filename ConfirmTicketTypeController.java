import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmTicketTypeController {
    private ConfirmTicketTypeModel model;
    private ConfirmTicketTypeView view;
    
    private int noSeat;

    public ConfirmTicketTypeController(ConfirmTicketTypeView view, ConfirmTicketTypeModel model) {
        this.view = view;
        this.model = model;
        addListeners();
    }
    
    public void setNoSeats(int noSeat) {
        this.noSeat = noSeat;
        System.out.println("No seats set to: " + noSeat);
    }

    private void addListeners() {
        // Add listeners for ticket category buttons
        for (String category : new String[]{"Senior", "Student", "Adult", "OKU"}) {
            addCategoryListeners(category);
        }

        view.addButtonListener(new ButtonListener());
    }

    private void addCategoryListeners(String category) {
        JButton minusButton = view.getMinusButton(category);
        JButton plusButton = view.getPlusButton(category);
        JTextField counterField = view.getCounterField(category);

        // Remove existing action listeners
        for (ActionListener al : minusButton.getActionListeners()) {
            minusButton.removeActionListener(al);
        }
        for (ActionListener al : plusButton.getActionListeners()) {
            plusButton.removeActionListener(al);
        }
        
        minusButton.addActionListener(e -> {
            try {
                int count = Integer.parseInt(counterField.getText());
                if (count > 0) {
                    count--;
                    counterField.setText(String.valueOf(count));
                    counterField.setHorizontalAlignment(JTextField.CENTER); // Center the text
                    updateModel(category, count);
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace(); // Handle the exception (e.g., show a message dialog)
            }
        });

        plusButton.addActionListener(e -> {
            try {
                int totalCount = model.getTotalCount();
                int count = Integer.parseInt(counterField.getText());
                if (totalCount < noSeat) {
                    count++;
                    counterField.setText(String.valueOf(count));
                    counterField.setHorizontalAlignment(JTextField.CENTER); // Center the text
                    updateModel(category, count);
                } else {
                    // Optionally show a message that no more tickets can be added
                    JOptionPane.showMessageDialog(view, "No more seats available", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace(); // Handle the exception (e.g., show a message dialog)
            }
        });
    }

    private void updateModel(String category, int count) {
        switch (category) {
            case "Senior":
                model.setSeniorCount(count);
                break;
            case "Student":
                model.setStudentCount(count);
                break;
            case "Adult":
                model.setAdultCount(count);
                break;
            case "OKU":
                model.setOkuCount(count);
                break;
        }

        SwingUtilities.invokeLater(() -> view.updateTotalPrice(model.calculateTotalPrice()));
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.getNextButton()) {
                int totalSelectedSeats = model.getTotalCount();
                if (totalSelectedSeats != noSeat) {
                    JOptionPane.showMessageDialog(view,
                        "Please select exactly " + noSeat + " seats.",
                        "Seat Selection Error",
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                double totalTicketPrice = model.calculateTotalPrice();
                view.dispose();
                new FoodOrderingScreenController(new FoodOrderingScreenView(totalTicketPrice), new FoodOrderingScreenModel(totalTicketPrice));
                System.out.println("Navigating to Food Ordering Screen.");
            }

            if (e.getSource() == view.getExitButton()) {
                System.out.println("Navigating to FirstScreen screen.");
                FirstScreenModel firstScreenModel = new FirstScreenModel();
                FirstScreenView firstScreenView = new FirstScreenView();
                FirstScreenController firstScreenController = new FirstScreenController(firstScreenModel, firstScreenView);
                firstScreenController.updateView();
                view.dispose();
            }
            
            if (e.getSource() == view.getBackButton()) {
                new SelectSeatsView();
                view.dispose();
            }
        }
    }
}
