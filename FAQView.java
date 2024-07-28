import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class FAQView extends View{
	private JTextArea faqTextArea;
	
	
	public FAQView(List<String> faqs) {
        setTitle("FAQ");
//        setSize(744, 1133);
//        setLocationRelativeTo(null);
//        setLayout(new BorderLayout());
        
        // Set up the title label
        JLabel titleLabel = new JLabel("Frequently Asked Questions");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE );
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding around the title

        // Set up the text area for FAQs
        faqTextArea = new JTextArea();
        faqTextArea.setFont(new Font("Serif", Font.PLAIN, 18));
        faqTextArea.setEditable(false);
        faqTextArea.setOpaque(false); // Make the text area background transparent
        faqTextArea.setBackground(new Color(0, 0, 0, 0));
        faqTextArea.setForeground(Color.WHITE);
        faqTextArea.setLineWrap(true); // Enable line wrapping
        faqTextArea.setWrapStyleWord(true); // Wrap at word boundaries
        faqTextArea.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding


        displayFAQs(faqs); // Display FAQs initially
        
        // Add the title label and text area to the middle panel
        middlePanel.setLayout(new BorderLayout());
        middlePanel.add(titleLabel, BorderLayout.NORTH);
        middlePanel.add(faqTextArea, BorderLayout.CENTER);

        removeExitButton();
        removeNextButton();
        revalidate();
        repaint();

    }

    public void displayFAQs(List<String> faqs) {
        StringBuilder sb = new StringBuilder();
        for (String faq : faqs) {
            sb.append(faq).append("\n");
        }
        faqTextArea.setText(sb.toString());
    }
    
    @Override
    public void addButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
        nextButton.addActionListener(listener);
        exitButton.addActionListener(listener);
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
