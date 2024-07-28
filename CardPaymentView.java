

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CardPaymentView extends View {
	private JPanel currentPanel;
	private JPanel contentPanel = new Content();

	public CardPaymentView() {
		currentPanel = new UiComponent();
		setLayout(new BorderLayout());
		this.add(currentPanel, BorderLayout.CENTER);
		this.setTitle("Payment Screen");
	}
	
	public class Content extends JPanel {
		private JPanel descriptionPanel = new JPanel();
		private int verticalSectionSpacing = 15;
		// --------- font ------------------------------
		Font titleFont = new Font("Serif", Font.PLAIN, 20);
		Font font = new Font("Serif", Font.BOLD, 15);
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
			gbc.anchor = GridBagConstraints.WEST;
			// Order Summary section
			JLabel orderSummaryLabel = new JLabel("Swipe or scan a card to pay for this order.");
			orderSummaryLabel.setFont(titleFont);
			orderSummaryLabel.setForeground(Color.white);
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 2;
			gbc.anchor = GridBagConstraints.WEST;
			descriptionPanel.add(orderSummaryLabel, gbc);

			// Add vertical spacing
			gbc.gridx = 0;
			gbc.gridy = 1;
			descriptionPanel.add(Box.createVerticalStrut(verticalSectionSpacing), gbc);

			gbc.gridx = 1;
			gbc.gridy = 2;
			descriptionPanel.add(new ImagePanel(), gbc);

			gbc.gridx = 1;
			gbc.gridy = 3;
			descriptionPanel.add(new CardType(), gbc);

			// -----------------------------------------------------------------------------------------
			this.add(descriptionPanel);
			this.add(bottomPanel);
		}
	}
	
	public class UiComponent extends JPanel {
		private Image backgroundImage; 
		
		public UiComponent() {
			backgroundImage = new ImageIcon(getClass().getResource("/img/background.jpg")).getImage();
			setLayout(new BorderLayout());
			
			topPanel.setPreferredSize(new Dimension(this.getWidth(), 100)); 
			topPanel.setOpaque(false);
			bottomPanel.setOpaque(false);
			leftPanel.setOpaque(false);
			rightPanel.setOpaque(false);
			
			time.setForeground(Color.white);
			topRightPanel.add(time, BorderLayout.CENTER);		
			topRightPanel.setOpaque(false);
	        time.setPreferredSize(new Dimension(100, 80));
	        
			topPanel.add(topRightPanel, BorderLayout.EAST);
			bottomPanel.setPreferredSize(new Dimension(this.getWidth(), 100)); 
			
//			contentPanel.setPreferredSize(new Dimension(744, 1133));
			this.add(topPanel, BorderLayout.NORTH);
//			this.add(contentPanel, BorderLayout.WEST);		
			middlePanel.add(contentPanel);
	        this.add(bottomPanel, BorderLayout.SOUTH);	       		
//	        this.setPreferredSize(new Dimension(744, 1133));
		}			
			
		@Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }		
	}

	public class ImagePanel extends JPanel {
		private static final int BORDER_RADIUS = 50; // Radius of the rounded corners
		private static final int BORDER_WIDTH = 5; // Width of the border
		private static final int PADDING = BORDER_WIDTH / 2; // Padding inside the border
		private final Image image;

		public ImagePanel() {
			// Load the image
			ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/hand_gesture.png"));

			// Scale the image to fit within the inner panel
			int scaledWidth = 300 - 2 * PADDING;
			int scaledHeight = 300 - 2 * PADDING;
			image = imageIcon.getImage().getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);

			// Set the preferred size to 400x400 including border and padding
			this.setPreferredSize(new Dimension(300, 250));
			this.setOpaque(false); // Ensure the background is not painted
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g.create();

			// Enable anti-aliasing for smoother borders
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			// Paint the background within the rounded rectangle
			g2.setColor(getBackground());
			int width = getWidth();
			int height = getHeight();
			g2.fillRoundRect(PADDING, PADDING, width - 2 * PADDING, height - 2 * PADDING, BORDER_RADIUS, BORDER_RADIUS);

			// Draw the rounded rectangle border
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke(BORDER_WIDTH));
			g2.drawRoundRect(PADDING, PADDING, width - 2 * PADDING, height - 2 * PADDING, BORDER_RADIUS, BORDER_RADIUS);

			// Draw the image within the rounded rectangle
			g2.setClip(new RoundRectangle2D.Float(PADDING, PADDING, width - 2 * PADDING, height - 2 * PADDING,
					BORDER_RADIUS, BORDER_RADIUS));
			int imageX = (width - image.getWidth(null)) / 2;
			int imageY = (height - image.getHeight(null)) / 2;
			g2.drawImage(image, imageX, imageY, this);

			g2.dispose();
		}
	}

	public class CardType extends JPanel {
		public CardType() {
			// Load the image
			ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/visa_ms.png"));

			// Scale the image to 400x400
			Image image = imageIcon.getImage();
			Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(scaledImage);

			// Create a JLabel with the scaled image
			JLabel imageLabel = new JLabel(imageIcon);

			// Set the preferred size to 400x400
			this.setPreferredSize(new Dimension(300, 200));
			this.setLayout(new BorderLayout());
			this.add(imageLabel, BorderLayout.CENTER);
			this.setOpaque(false);
			
		}
	}
	
	public void addButtonListener(ActionListener listener) {
        nextButton.addActionListener(listener);
        backButton.addActionListener(listener);
        exitButton.addActionListener(listener);
    }
}
