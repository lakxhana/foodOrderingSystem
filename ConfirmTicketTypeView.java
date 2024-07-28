import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ConfirmTicketTypeView extends View {
    private Map<String, JButton> minusButtons = new HashMap<>();
    private Map<String, JButton> plusButtons = new HashMap<>();
    private Map<String, JTextField> counterFields = new HashMap<>();
    private JLabel totalPriceLabel;
    private double totalPrice;

    // Define prices for each ticket category
    private Map<String, Double> ticketPrices = new HashMap<>();
    {
        ticketPrices.put("Senior", 10.0);
        ticketPrices.put("Student", 8.0);
        ticketPrices.put("Adult", 12.0);
        ticketPrices.put("OKU", 6.0);
    }

    public ConfirmTicketTypeView() {
        showTicketTypePanel();
    }

    public void showTicketTypePanel() {
        // Remove all components from the middlePanel before adding new ones
        this.setTitle("Confirm Ticket Screen");
        middlePanel.removeAll();

        CustomPanel mainPanel = new CustomPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Ticket categories and counters
        String[] categories = {"Senior", "Student", "Adult", "OKU"};
        for (int i = 0; i < categories.length; i++) {
            addTicketCounter(mainPanel, categories[i], i + 1);
        }

        // Total price label
        totalPriceLabel = new JLabel("Total: RM 0.00"); // Initialize with RM format
        totalPriceLabel.setForeground(Color.WHITE);
        totalPriceLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = categories.length + 2; // Adjust the row as necessary
        gbc.gridwidth = 5; // Span across all columns
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(totalPriceLabel, gbc);

        // Set mainPanel in the middle of the frame
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(mainPanel, BorderLayout.CENTER);
        contentPane.setOpaque(false); // Ensure it's transparent for background image to show
        middlePanel.add(contentPane, BorderLayout.CENTER);

        this.setVisible(true);

        // Add action listeners to buttons
        //addActionListeners();
    }

    private void addTicketCounter(JPanel panel, String category, int row) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel categoryLabel = new JLabel(category);
        categoryLabel.setForeground(Color.WHITE);
        categoryLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(categoryLabel, gbc);

        JButton minusButton = new JButton("-");
        minusButton.setForeground(Color.BLACK);
        minusButton.setBackground(Color.WHITE);
        minusButton.setPreferredSize(new Dimension(60, 40));
        gbc.gridx = 1;
        panel.add(minusButton, gbc);
        minusButtons.put(category, minusButton);

        JTextField counterField = new JTextField("0", 1); //counterField!!!!!!
        counterField.setHorizontalAlignment(JTextField.CENTER);
        counterField.setPreferredSize(new Dimension(60, 40));
        gbc.gridx = 2;
        panel.add(counterField, gbc);
        counterFields.put(category, counterField);

        JButton plusButton = new JButton("+");
        plusButton.setForeground(Color.BLACK);
        plusButton.setBackground(Color.WHITE);
        plusButton.setPreferredSize(new Dimension(60, 40));
        gbc.gridx = 3;
        panel.add(plusButton, gbc);
        plusButtons.put(category, plusButton);
        //nextButton.addActionListener(e -> new FoodOrderingScreenView(totalPrice));
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JButton getMinusButton(String category) {
        return minusButtons.get(category);
    }

    public JButton getPlusButton(String category) {
        return plusButtons.get(category);
    }

    public JTextField getCounterField(String category) {
        return counterFields.get(category);
    }
    
    public void updateTotalPrice(double totalPrice) {
        totalPriceLabel.setText("Total: RM " + String.format("%.2f", totalPrice));
    }
}
