import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class OrderSummaryView extends View {
	  public JLabel totalAmountLabel = new JLabel("");

    public JPanel topRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    private JPanel currentPanel;
    private JPanel contentPanel = new Content();
    public double totalPrice;
    public JLabel time = new JLabel("");
    

    public OrderSummaryView(double totalPrice) {
        this.totalPrice = totalPrice;
        currentPanel = new UiComponent();
        setLayout(new BorderLayout());
        this.add(currentPanel, BorderLayout.CENTER);
        this.setTitle("Order Summary Screen");
        new TimeUpdater(time);
       
    }

    public class UiComponent extends JPanel {
        private Image backgroundImage;

        public UiComponent() {
            backgroundImage = new ImageIcon(getClass().getResource("/img/background.jpg")).getImage();
            setLayout(new BorderLayout());
            middlePanel.setLayout(new BorderLayout()); // Ensure the layout is set
            middlePanel.add(contentPanel, BorderLayout.CENTER);
            add(middlePanel, BorderLayout.CENTER); // Add middlePanel to UiComponent
           
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public class Content extends JPanel {
        private JPanel descriptionPanel = new JPanel();
        private int verticalSectionSpacing = 15;
        private String contactNumber = "";
        // --------- font ------------------------------
        Font titleFont = new Font("Serif", Font.PLAIN, 30);
        Font font = new Font("Serif", Font.BOLD, 20);
        Font fontBig = new Font("Serif", Font.BOLD, 30);
        // ---------------------------------------------
        

        public Content() {
            // ----- set transparent --------------------
            descriptionPanel.setOpaque(false);
            this.setOpaque(false);
            // -------------------------------------------
            // Create a main panel with GridBagLayout
            descriptionPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.anchor = GridBagConstraints.WEST;
            // Order Summary section
            JLabel orderSummaryLabel = new JLabel("Order Summary");
            orderSummaryLabel.setFont(titleFont);
            orderSummaryLabel.setForeground(Color.white);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            descriptionPanel.add(orderSummaryLabel, gbc);

            // Add vertical spacing
            gbc.gridx = 0;
            gbc.gridy = 1;
            descriptionPanel.add(Box.createVerticalStrut(verticalSectionSpacing), gbc);

            // Total section
            JLabel totalLabel = new JLabel("TOTAL");
            totalLabel.setForeground(Color.white);
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            descriptionPanel.add(totalLabel, gbc);

            // Set initial total price
            totalAmountLabel = new JLabel(String.format("%.2f", totalPrice), JLabel.CENTER); 
            totalAmountLabel.setForeground(Color.white);
            totalAmountLabel.setFont(fontBig);
            gbc.gridx = 1;
            gbc.gridy = 2;
            descriptionPanel.add(totalAmountLabel, gbc);

            // Add vertical spacing
            gbc.gridx = 0;
            gbc.gridy = 3;
            descriptionPanel.add(Box.createVerticalStrut(verticalSectionSpacing), gbc);

            // Contact Number section
            JLabel contactNumberLabel = new JLabel("Contact Number");
            contactNumberLabel.setForeground(Color.white);
            contactNumberLabel.setFont(font);
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.gridwidth = 1;
            descriptionPanel.add(contactNumberLabel, gbc);

            JTextField contactNumberTextField = new JTextField(15);
            contactNumberTextField.setFont(font);
            gbc.gridx = 1;
            gbc.gridy = 4;
            descriptionPanel.add(contactNumberTextField, gbc);
        

            // ---------Keyboard-------------------
            Keyboard keyboard = new Keyboard(contactNumberTextField, contactNumber);
            
            // ----------Add Focus Listener-------------
            contactNumberTextField.addFocusListener(new FocusListener() {

                @Override
                public void focusGained(FocusEvent e) {
                    System.out.println("Text field gained focus");
                    middlePanel.add(keyboard, BorderLayout.SOUTH);
                    middlePanel.revalidate();
                    middlePanel.repaint();
                }

                @Override
                public void focusLost(FocusEvent e) {
                    System.out.println("Text field lost focus");
                    middlePanel.remove(keyboard);
                    middlePanel.revalidate();
                    middlePanel.repaint();
                }
            });

            // --------Add Document Listener-----------
            contactNumberTextField.getDocument().addDocumentListener(new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    contactNumber = contactNumberTextField.getText();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    contactNumber = contactNumberTextField.getText();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    contactNumber = contactNumberTextField.getText();
                }
            });

            this.add(descriptionPanel);
            this.add(Box.createVerticalStrut(600));
            this.add(bottomPanel);
            
        }
    }

    public double getOriginalPrice() {
        return totalPrice;
    }

    @Override
    public void addButtonListener(ActionListener listener) {
        nextButton.addActionListener(listener);
        backButton.addActionListener(listener);
        exitButton.addActionListener(listener);
    }
}
