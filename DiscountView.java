import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiscountView extends View {
    private JTextField discountedPriceField;
    public JButton redeemButton1;
    public JButton redeemButton2;
    public JButton redeemButton3;
    private JButton applyVoucherButton;
    private JLabel redeemMessageLabel;
    private double totalPrice;

    public DiscountView(double totalPrice) {
        super();
        this.setTitle("Discount"); // Set the title of the screen to "Discount"
        this.totalPrice = totalPrice;

        // Remove default middle panel and create a new transparent one
        this.remove(middlePanel);
        CustomPanel newMiddlePanel = new CustomPanel();
        newMiddlePanel.setLayout(new GridBagLayout());
        newMiddlePanel.setOpaque(false);
        this.add(newMiddlePanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.WEST; // Align to the left
        gbc.insets = new Insets(10, 10, 10, 10);

        // Add voucher options with redeem buttons
        JPanel voucherPanel1 = createVoucherPanel("Discount 10% for a first-time user");
        JPanel voucherPanel2 = createVoucherPanel("Discount RM5 if you buy more than 3 tickets");
        JPanel voucherPanel3 = createVoucherPanel("15% off for early birds");

        redeemButton1 = (JButton) voucherPanel1.getComponent(1);
        redeemButton2 = (JButton) voucherPanel2.getComponent(1);
        redeemButton3 = (JButton) voucherPanel3.getComponent(1);

        redeemButton1.addActionListener(new RedeemButtonListener(10));
        redeemButton2.addActionListener(new RedeemButtonListener(5));
        redeemButton3.addActionListener(new RedeemButtonListener(15));

        newMiddlePanel.add(voucherPanel1, gbc);
        newMiddlePanel.add(voucherPanel2, gbc);
        newMiddlePanel.add(voucherPanel3, gbc);

        // Label for redeem message
        redeemMessageLabel = new JLabel();
        redeemMessageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        redeemMessageLabel.setForeground(Color.WHITE);
        newMiddlePanel.add(redeemMessageLabel, gbc);

        // Center the apply voucher button
        gbc.anchor = GridBagConstraints.CENTER;
        applyVoucherButton = new JButton("Apply Voucher");
        applyVoucherButton.setBackground(Color.LIGHT_GRAY);
        applyVoucherButton.setForeground(Color.WHITE); // Darker font color
        applyVoucherButton.setFocusPainted(false);
        applyVoucherButton.setBorderPainted(false);
        newMiddlePanel.add(applyVoucherButton, gbc);

        // Discounted price field
        discountedPriceField = new JTextField(10);
        discountedPriceField.setEditable(false);
        discountedPriceField.setHorizontalAlignment(JTextField.RIGHT);
        discountedPriceField.setFont(new Font("Arial", Font.BOLD, 16));
        discountedPriceField.setForeground(Color.WHITE);
        discountedPriceField.setOpaque(false);
        discountedPriceField.setBorder(null);

        JPanel discountPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        discountPanel.setOpaque(false);
        JLabel discountLabel = new JLabel("Price after Discount:");
        discountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        discountLabel.setForeground(Color.WHITE);
        discountPanel.add(discountLabel);
        discountPanel.add(discountedPriceField);
        discountPanel.setVisible(false); // Initially hidden
        newMiddlePanel.add(discountPanel, gbc);

        this.setVisible(true);
    }

    private JPanel createVoucherPanel(String text) {
        JPanel voucherPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        voucherPanel.setOpaque(false);
        JLabel voucherLabel = new JLabel(text);
        voucherLabel.setFont(new Font("Arial", Font.BOLD, 16));
        voucherLabel.setForeground(Color.WHITE);

        JButton redeemButton = new JButton("Redeem");
        redeemButton.setBackground(Color.LIGHT_GRAY);
        redeemButton.setForeground(Color.WHITE); // Darker font color
        redeemButton.setFocusPainted(false);
        redeemButton.setBorderPainted(false);
        redeemButton.setPreferredSize(new Dimension(100, 30));

        
        voucherPanel.add(voucherLabel);
        voucherPanel.add(redeemButton);

        return voucherPanel;
    }

    private class RedeemButtonListener implements ActionListener {
        private final double discount;

        public RedeemButtonListener(double discount) {
            this.discount = discount;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            showRedeemMessage();
            // Disable all redeem buttons to sync and prevent multiple redemptions
            redeemButton1.setEnabled(false);
            redeemButton2.setEnabled(false);
            redeemButton3.setEnabled(false);
        }
    }

    public void showRedeemMessage() {
        redeemMessageLabel.setText("You have redeemed a voucher!");
    }

    public void showDiscountedPrice() {
        discountedPriceField.getParent().setVisible(true);
    }

    public double getOriginalPrice() {
        return totalPrice;
    }

    public void setDiscountedPrice(double price) {
        discountedPriceField.setText(String.format("RM %.2f", price));
    }

    public JButton getApplyVoucherButton() {
        return applyVoucherButton;
    }

    public JButton getCalculateButton() {
        return nextButton;
    }

    public void display() {
        this.setVisible(true);
    }

    public void close() {
        this.dispose();
    }

    // CustomPanel class is used to maintain the background image
    private class CustomPanel extends JPanel {
        private Image backgroundImage;

        public CustomPanel() {
            // Load the background image
            backgroundImage = new ImageIcon(getClass().getResource("/img/background.jpg")).getImage();
            setLayout(new BorderLayout());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
