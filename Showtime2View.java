import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Showtime2View extends View  {

	JPanel panel3 = new JPanel();
	JLabel text = new JLabel("Select a Movie Time:");

	JPanel panelTop = new JPanel();
	JPanel panelImax = new JPanel();
	JLabel labelImax = new JLabel("IMAX:");	
	JPanel panelTopButtons = new JPanel();
	JPanel panelTopButtons2 = new JPanel();
	JButton topButton1 = new JButton("7.00pm");
	JButton topButton2 = new JButton("8.10pm");
	JButton topButton3 = new JButton("9.30pm");
	JButton topButton4 = new JButton("1.00am");
	
	JPanel panelMid = new JPanel();
	JPanel panel3D = new JPanel();
	JLabel label3D = new JLabel("3D:");	
	JPanel panelMidButtons = new JPanel();
	JPanel panelMidButtons2 = new JPanel();
	JButton midButton1 = new JButton("7.15pm");
	JButton midButton2 = new JButton("10.20pm");
	JButton midButton3 = new JButton("12.10pm");
	
	JPanel panelBottom = new JPanel();
	JPanel panel2D = new JPanel();
	JLabel label2D = new JLabel("2D:");	
	JPanel panelBottomButtons = new JPanel();
	JPanel panelBottomButtons2 = new JPanel();
	JButton bottomButton1 = new JButton("9.45pm");
	JButton bottomButton2 = new JButton("11.30pm");
	
	public Showtime2View(){
			updateView();
	}
	
	public void updateView() {
		this.setTitle("Showtime Screen 2");
		
		//topPanel
		panelImax.setOpaque(false);
		panelTopButtons.setOpaque(false);
		panelTopButtons2.setOpaque(false);
		panelTop.setOpaque(false);
		//panelTop.setBackground(Color.BLACK);
		labelImax.setForeground(Color.WHITE);
		panelImax.setLayout(new BorderLayout());
		panelImax.add(labelImax, BorderLayout.WEST);
		topButton1.setPreferredSize(new Dimension(100, 30));
		topButton2.setPreferredSize(new Dimension(100, 30));
		topButton3.setPreferredSize(new Dimension(100, 30));
		topButton4.setPreferredSize(new Dimension(100, 30));
		panelTopButtons.setLayout(new FlowLayout());
		panelTopButtons.add(topButton1);
		panelTopButtons.add(topButton2);
		panelTopButtons.add(topButton3);
		panelTopButtons.add(topButton4);
		panelTopButtons2.setLayout(new BorderLayout());
		panelTopButtons2.add(panelTopButtons, BorderLayout.WEST);
		panelTop.setLayout(new GridLayout(2,1));
        panelTop.add(panelImax);
        panelTop.add(panelTopButtons2);
		
		//midPanel
        panel3D.setOpaque(false);
        panelMidButtons.setOpaque(false);
        panelMidButtons2.setOpaque(false);
		panelMid.setOpaque(false);
        //panelMid.setBackground(Color.BLACK);
        label3D.setForeground(Color.WHITE);
        panel3D.setLayout(new BorderLayout());
		panel3D.add(label3D, BorderLayout.WEST);
		midButton1.setPreferredSize(new Dimension(100, 30));
		midButton2.setPreferredSize(new Dimension(100, 30));
		midButton3.setPreferredSize(new Dimension(100, 30));
		panelMidButtons.setLayout(new FlowLayout());
		panelMidButtons.add(midButton1);
		panelMidButtons.add(midButton2);
		panelMidButtons.add(midButton3);
		panelMidButtons2.setLayout(new BorderLayout());
		panelMidButtons2.add(panelMidButtons, BorderLayout.WEST);
		panelMid.setLayout(new GridLayout(2,1));
        panelMid.add(panel3D);
        panelMid.add(panelMidButtons2);
		
		//bottomPanel
        panel2D.setOpaque(false);
        panelBottomButtons.setOpaque(false);
        panelBottomButtons2.setOpaque(false);
		panelBottom.setOpaque(false);
        //panelBottom.setBackground(Color.BLACK);
        label2D.setForeground(Color.WHITE);
        panel2D.setLayout(new BorderLayout());
		panel2D.add(label2D, BorderLayout.WEST);
		bottomButton1.setPreferredSize(new Dimension(100, 30));
		bottomButton2.setPreferredSize(new Dimension(100, 30));
		panelBottomButtons.setLayout(new FlowLayout());
		panelBottomButtons.add(bottomButton1);
		panelBottomButtons.add(bottomButton2);
		panelBottomButtons2.setLayout(new BorderLayout());
		panelBottomButtons2.add(panelBottomButtons, BorderLayout.WEST);
		panelBottom.setLayout(new GridLayout(2,1));
        panelBottom.add(panel2D);
        panelBottom.add(panelBottomButtons2);
		
		//panel3
        panel3.setOpaque(false);
        text.setForeground(Color.WHITE);
		panel3.setLayout(new GridLayout(4,1));
		panel3.add(text);
		panel3.add(panelTop);
		panel3.add(panelMid);
		panel3.add(panelBottom);

		//middlePanel
		middlePanel.setLayout(new GridBagLayout()); // Use GridBagLayout for centering
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Add panel3 to the bottom, spanning both columns
        gbc.gridx = 0;
        gbc.gridy = 1; 
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 50, 75, 50); // Optional: Add some padding around the panel
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0; // Allow panel3 to take up remaining vertical space
        middlePanel.add(panel3, gbc);
        
	}
}
