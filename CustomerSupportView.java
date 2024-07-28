
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CustomerSupportView extends View {
    
    private JButton callButton;
    private JButton faqButton;
    
   
    public CustomerSupportView() {
    	
    	setTitle("Customer Support");
    	
    	// Remove the default content of middlePanel and add new content
        middlePanel.removeAll();
        middlePanel.setLayout(new GridBagLayout());
        middlePanel.setBackground(Color.WHITE);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
    	
        ImageIcon supportIconImage = new ImageIcon("src/img/support.png");
        JLabel supportIcon = new JLabel(resizeIcon(supportIconImage, 120, 120));
        supportIcon.setOpaque(false); // Make the icon background transparent
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        middlePanel.add(supportIcon, gbc);

        JLabel titleLabel = new JLabel("Customer Support");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 26));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(0, 0, 0, 0));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridy = 1;
        middlePanel.add(titleLabel, gbc);

        JLabel questionLabel = new JLabel("Are you facing any problem?");
        questionLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        questionLabel.setOpaque(true);
        questionLabel.setBackground(new Color(0, 0, 0, 0));
        questionLabel.setForeground(Color.WHITE);
        gbc.gridy = 2;
        middlePanel.add(questionLabel, gbc);

        JLabel infoLabel = new JLabel("If you need instant support then use call option to reach us quickly.");
        infoLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        infoLabel.setOpaque(true);
        infoLabel.setBackground(new Color(0, 0, 0, 0));
        infoLabel.setForeground(Color.WHITE);
        gbc.gridy = 3;
        middlePanel.add(infoLabel, gbc);
        
        // Create call button with icon on top and text below
        callButton = new JButton("Call us", resizeIcon(new ImageIcon("src/img/telephone.png"), 40, 40));
        callButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        callButton.setHorizontalTextPosition(SwingConstants.CENTER);
        callButton.setOpaque(true);
        callButton.setBackground(Color.WHITE);
        callButton.setForeground(Color.BLACK);
        callButton.setPreferredSize(new Dimension(120, 70));  // Adjust the button size here
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        middlePanel.add(callButton, gbc);
        
        // Empty space to create a gap
        //gbc.gridx = 1;
       	//middlePanel.add(Box.createHorizontalStrut(20), gbc);

        // Create FAQ button with icon on top and text below
        faqButton = new JButton("FAQ", resizeIcon(new ImageIcon("src/img/faq.png"), 40,40));
        faqButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        faqButton.setHorizontalTextPosition(SwingConstants.CENTER);
        faqButton.setOpaque(true);
        faqButton.setBackground(Color.WHITE);
        faqButton.setForeground(Color.BLACK);
        faqButton.setPreferredSize(new Dimension(120, 70));  // Adjust the button size here
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        middlePanel.add(faqButton, gbc);

            
        // Revalidate and repaint to update the middle panel
        middlePanel.revalidate();
        middlePanel.repaint();
        
        removeNextButton();
        removeExitButton();
    	}
    
	    private Icon resizeIcon(ImageIcon icon, int width, int height) {
	    	 Image img = icon.getImage();
	         Image resizedImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	         return new ImageIcon(resizedImage);
	}

		public void addCallButtonListener(ActionListener listener) {
	        callButton.addActionListener(listener);
	    }
	
	    public void addFaqButtonListener(ActionListener listener) {
	        faqButton.addActionListener(listener);
	    }
	    
	    private void removeNextButton() {
	        Container parent = nextButton.getParent();
	        if (parent != null) {
	            parent.remove(nextButton);
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
	    
	    
} 
