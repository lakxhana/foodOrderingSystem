import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FirstScreenView extends View{
    // Components
   
    JPanel topRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JLabel time = new JLabel("");

    JButton touchButton = new JButton("touchToStart");
    JLabel selfService = new JLabel("Self-Service Movie Kiosk");
    JButton helplineButton = new JButton();
    ImageIcon helplinePic = new ImageIcon("helpline.png");

    public FirstScreenView() {
    	updateFirstScreenView();
    }

    
    public void updateFirstScreenView() {

        // Resize helplinePic
        Image originalImage = helplinePic.getImage();
        Image resizedImage = originalImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH); // Resize the image to 50x50 pixels
        helplinePic = new ImageIcon(resizedImage);

        // Bottom panel setup with helplineButton
        helplineButton.setText("Do you need help?");
        helplineButton.setIcon(helplinePic);
        helplineButton.setHorizontalTextPosition(JButton.CENTER);
        helplineButton.setVerticalTextPosition(JButton.BOTTOM);
        helplineButton.setBackground(Color.WHITE); // Set background color
        helplineButton.setForeground(Color.BLACK); // Set text color
        helplineButton.setIconTextGap(5);
        helplineButton.setBorder(BorderFactory.createEtchedBorder());
        helplineButton.setEnabled(true);
        rightPanel.add(helplineButton);

        bottomPanel.add(leftPanel, BorderLayout.WEST);
        bottomPanel.add(rightPanel, BorderLayout.EAST);
        topPanel.add(topRightPanel, BorderLayout.EAST);

        //middle panel layout
        middlePanel.setLayout(new GridBagLayout()); // Use GridBagLayout for centering
        GridBagConstraints gbc = new GridBagConstraints();

        //middle panel - selfService label
        selfService.setOpaque(false); // Make the label opaque to show background color
        //selfService.setBackground(Color.WHITE); // Set background color to white
        selfService.setForeground(Color.WHITE); // Set text color to black
        selfService.setFont(new Font("Times New Roman", Font.BOLD, 40)); // Set font to Arial, bold, size 24
        gbc.gridx = 0;
        gbc.gridy = 0; // Positioned at the top
        gbc.insets = new Insets(0, 0, 75, 0); // Add some space between label and button(padding)
        gbc.anchor = GridBagConstraints.CENTER;
        middlePanel.add(selfService, gbc);

        //middle panel - touchButton label
        gbc.gridx = 0;
        gbc.gridy = 1; // Positioned below the label
        touchButton.setPreferredSize(new Dimension(150, 80));
        touchButton.setBackground(Color.WHITE); // Set background color
        middlePanel.add(touchButton, gbc);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(middlePanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);

        this.setVisible(true);
        new TimeUpdater(time);
        
        removeNextButton();
        removeBackButton();
        removeExitButton();
        
    }
    public class CustomPanel extends JPanel {
        private Image backgroundImage;

        public CustomPanel() {
            // Load the background image
            backgroundImage = new ImageIcon(getClass().getResource("/img/background.jpg")).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    private void removeNextButton() {
        Container parent = nextButton.getParent();
        if (parent != null) {
            parent.remove(nextButton);
            parent.revalidate();
            parent.repaint();
        }
        }
    
    private void removeBackButton() {
        Container parent = backButton.getParent();
        if (parent != null) {
            parent.remove(backButton);
            parent.revalidate();
            parent.repaint();
        }
        }
    
    private void removeExitButton() {
        Container parent = exitButton.getParent();
        if (parent != null) {
            parent.remove(exitButton);
            parent.revalidate();
            parent.repaint();
        }
        }
    

    //button navigation shits. kene tgk controller
    public void addButtonListener(ActionListener listener) {
        touchButton.addActionListener(listener);
        helplineButton.addActionListener(listener);
    }
    
    
}
