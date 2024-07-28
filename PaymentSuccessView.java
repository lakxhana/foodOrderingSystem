
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

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PaymentSuccessView extends View {
	private JPanel currentPanel;
	private JPanel contentPanel = new Content();

	public PaymentSuccessView() {
		currentPanel = new UiComponent();
		setLayout(new BorderLayout());
		this.add(currentPanel, BorderLayout.CENTER);
		this.setTitle("Payment Successful Screen");

	}

	public class UiComponent extends JPanel {
		private Image backgroundImage;

		public UiComponent() {
			backgroundImage = new ImageIcon(getClass().getResource("/img/background.jpg")).getImage();
			setLayout(new BorderLayout());

			middlePanel.add(contentPanel, BorderLayout.CENTER);
			this.add(bottomPanel, BorderLayout.SOUTH);	
			
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
		// --------- font ------------------------------
		Font titleFont = new Font("Serif", Font.PLAIN, 40);
		Font font = new Font("Serif", Font.BOLD, 20);
		Font fontBig = new Font("Serif", Font.BOLD, 20);
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
			gbc.fill = GridBagConstraints.HORIZONTAL; // Allow components to fill horizontal space
			gbc.anchor = GridBagConstraints.CENTER; // Center components

			// Order Summary section
			JLabel orderSummaryLabel = new JLabel("Payment Successful!");
			orderSummaryLabel.setFont(titleFont);
			orderSummaryLabel.setForeground(Color.white);
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = GridBagConstraints.REMAINDER; // Span across all columns
			gbc.anchor = GridBagConstraints.EAST; // Center the order summary label
			descriptionPanel.add(orderSummaryLabel, gbc);

			// Add vertical spacing
			gbc.gridx = 0;
			gbc.gridy = 1;
			descriptionPanel.add(Box.createVerticalStrut(verticalSectionSpacing), gbc);

			JLabel label1 = new JLabel("We have messaged you the movie tickets.");
			label1.setFont(font);
			label1.setForeground(Color.white);
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.gridwidth = 1;
			descriptionPanel.add(label1, gbc);

			JLabel label2 = new JLabel("Enjoy the movie!");
			label2.setFont(font);
			label2.setForeground(Color.white);
			gbc.gridx = 0;
			gbc.gridy = 3;
			gbc.gridwidth = 1;
			descriptionPanel.add(label2, gbc);

			this.setLayout(new GridBagLayout()); // Set layout for the container panel
			GridBagConstraints containerGbc = new GridBagConstraints();
			containerGbc.gridx = 0;
			containerGbc.gridy = 0;
			containerGbc.weightx = 1.0;
			containerGbc.weighty = 1.0;
			containerGbc.anchor = GridBagConstraints.CENTER;
			this.add(descriptionPanel, containerGbc);
			
		}
		
	}

	public void addButtonListener(ActionListener listener) {
		nextButton.addActionListener(listener);
		backButton.addActionListener(listener);
		exitButton.addActionListener(listener);
	}
}
