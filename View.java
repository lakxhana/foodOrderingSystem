import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class View extends JFrame {

    // don't change this file
	
	  
    JPanel topPanel = new JPanel(new BorderLayout());
    CustomPanel middlePanel = new CustomPanel();
    JPanel bottomPanel = new JPanel(new BorderLayout());

  
    JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

    JPanel topRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));


    JButton exitButton = new JButton("Exit");
    JButton backButton = new JButton("Back");
    JButton nextButton = new JButton("Next");

    JLabel time = new JLabel("");

    public View() {
        Dimension buttonSize = new Dimension(100, 50); 
        exitButton.setPreferredSize(buttonSize);
        backButton.setPreferredSize(buttonSize);
        nextButton.setPreferredSize(buttonSize);

        exitButton.setOpaque(true);
        exitButton.setBorderPainted(false);
        nextButton.setOpaque(true);
        nextButton.setBorderPainted(false);
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        
        exitButton.setForeground(Color.WHITE);
        nextButton.setForeground(Color.WHITE);
        backButton.setForeground(Color.WHITE);
        
        exitButton.setBackground(Color.BLACK);
        nextButton.setBackground(Color.BLACK);
        backButton.setBackground(Color.BLACK);
        
      
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Main Screen");
        this.setSize(744, 1133);
        this.setLocationRelativeTo(null);

        topPanel.setPreferredSize(new Dimension(this.getWidth(), 100)); 
        bottomPanel.setPreferredSize(new Dimension(this.getWidth(), 100)); 

        // Add buttons to the appropriate panels
        leftPanel.add(exitButton);
        leftPanel.add(backButton);
        rightPanel.add(nextButton);
        topRightPanel.add(time, BorderLayout.CENTER);
        time.setPreferredSize(new Dimension(100, 80));


        bottomPanel.add(leftPanel, BorderLayout.WEST);
        bottomPanel.add(rightPanel, BorderLayout.EAST);
        topPanel.add(topRightPanel, BorderLayout.EAST);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(middlePanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);

        this.setVisible(true);
        new TimeUpdater(time);
    }

    
    public void addButtonListener(ActionListener listener) {
        nextButton.addActionListener(listener);
        backButton.addActionListener(listener);
        exitButton.addActionListener(listener);
    }


    public class CustomPanel extends JPanel {
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
