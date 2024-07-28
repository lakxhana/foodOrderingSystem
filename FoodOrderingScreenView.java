import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class FoodOrderingScreenView extends View {
    public JButton addButton1;
    public JButton removeButton1;
    public JButton addButton2;
    public JButton removeButton2;
    public JButton addButton3;
    public JButton removeButton3;
    public JButton addButton4;
    public JButton removeButton4;
    public JButton addButton5;
    public JButton removeButton5;
    public JLabel totalAmountLabel = new JLabel("");

    public JLabel quantityLabel1 = new JLabel("0");
    public JLabel quantityLabel2 = new JLabel("0");
    public JLabel quantityLabel3 = new JLabel("0");
    public JLabel quantityLabel4 = new JLabel("0");
    public JLabel quantityLabel5 = new JLabel("0");
    
    private double totalPrice;

    public FoodOrderingScreenView(double totalPrice) {
        this.totalPrice = totalPrice;
        addButton1 = new JButton("+");
        removeButton1 = new JButton("-");
        addButton2 = new JButton("+");
        removeButton2 = new JButton("-");
        addButton3 = new JButton("+");
        removeButton3 = new JButton("-");
        addButton4 = new JButton("+");
        removeButton4 = new JButton("-");
        addButton5 = new JButton("+");
        removeButton5 = new JButton("-");
    }

    public void updateView(List<String> foodItems, List<String> foodPrices) {
        this.setTitle("Food Ordering Screen");

        middlePanel.removeAll(); 
        middlePanel.setBackground(Color.WHITE);
        middlePanel.setBorder(new LineBorder(Color.BLACK, 2));
        middlePanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.fill = GridBagConstraints.BOTH; 
        gbc.weightx = 1.0; 
        gbc.weighty = 1.0; 

        String[] foodImages = {"/img/popcorn.jpg", "/img/nachos.jpg", "/img/fries.jpg", "/img/water.jpg", "/img/soda.jpg"};
        JLabel[] quantityLabels = {quantityLabel1, quantityLabel2, quantityLabel3, quantityLabel4, quantityLabel5};
        JButton[] addButtons = {addButton1, addButton2, addButton3, addButton4, addButton5};
        JButton[] removeButtons = {removeButton1, removeButton2, removeButton3, removeButton4, removeButton5};

        for (int i = 0; i < foodItems.size(); i++) {
            ImageIcon imgIcon = new ImageIcon(getClass().getResource(foodImages[i]));
            Image imgScaled = imgIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(imgScaled);
            JLabel label = new JLabel(scaledIcon);
            label.setPreferredSize(new Dimension(100, 100));

            JTextArea textArea = new JTextArea();
            textArea.setOpaque(false);
            textArea.setEditable(false);
            textArea.setText(foodItems.get(i) + " - " + foodPrices.get(i));
            textArea.setForeground(Color.WHITE);

      
            JPanel textAreaPanel = new JPanel(new GridBagLayout());
            textAreaPanel.setOpaque(false);
            GridBagConstraints textAreaGbc = new GridBagConstraints();
            textAreaGbc.gridx = 0;
            textAreaGbc.gridy = 0;
            textAreaGbc.anchor = GridBagConstraints.WEST; 
            textAreaPanel.add(textArea, textAreaGbc);

            quantityLabels[i].setOpaque(false);
            quantityLabels[i].setForeground(Color.WHITE);

            gbc.gridx = 0;
            gbc.gridy = i;
            middlePanel.add(label, gbc);

            gbc.gridx = 1;
            middlePanel.add(textAreaPanel, gbc);

            gbc.gridx = 2;
            gbc.fill = GridBagConstraints.NONE; 
            middlePanel.add(removeButtons[i], gbc);

            gbc.gridx = 3;
            middlePanel.add(quantityLabels[i], gbc);

            gbc.gridx = 4;
            middlePanel.add(addButtons[i], gbc);
            gbc.gridy++;
        }

        JLabel totalLabel = new JLabel("Total: RM ", JLabel.CENTER);
        totalAmountLabel = new JLabel(String.format("%.2f", totalPrice), JLabel.CENTER); 

        totalLabel.setForeground(Color.WHITE);
        totalAmountLabel.setForeground(Color.WHITE);

        gbc.gridx = 2;
        gbc.gridwidth = 2; 
        gbc.gridy++; 
        middlePanel.add(totalLabel, gbc);

        gbc.gridx = 4; 
        gbc.gridwidth = 1; 
        middlePanel.add(totalAmountLabel, gbc);

        middlePanel.revalidate();
        middlePanel.repaint();
    }

    public double getOriginalPrice() {
        return totalPrice;
    }
    
  
    
    @Override
    public void addButtonListener(ActionListener listener) {
        addButton1.addActionListener(listener);
        removeButton1.addActionListener(listener);

        addButton2.addActionListener(listener);
        removeButton2.addActionListener(listener);

        addButton3.addActionListener(listener);
        removeButton3.addActionListener(listener);

        addButton4.addActionListener(listener);
        removeButton4.addActionListener(listener);

        addButton5.addActionListener(listener);
        removeButton5.addActionListener(listener);
        
        nextButton.addActionListener(listener);
        backButton.addActionListener(listener);
        exitButton.addActionListener(listener);
    }
}
