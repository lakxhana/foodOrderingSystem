import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Showtime1View extends View {
		
	JPanel middle2Panel = new JPanel();
	JPanel middle3Panel = new JPanel();
	JPanel middleTopLeft = new JPanel();
	JLabel selectMovieLabel = new JLabel("Select Movie:Today");
	JLabel date = new JLabel("Date:");
	JLabel dateLabel = new JLabel();
	
	//Buttons for movie 
	JButton movie1Button = new JButton();
	JButton movie2Button = new JButton();
	JButton movie3Button = new JButton();
	JButton movie4Button = new JButton();
	JButton movie5Button = new JButton();
	JButton movie6Button = new JButton();

	//image for movie
	ImageIcon  movie1pic = new  ImageIcon(getClass().getResource("/movieImage/movie1.jpg"));
	ImageIcon  movie2pic = new  ImageIcon(getClass().getResource("/movieImage/movie2.jpg"));
	ImageIcon  movie3pic = new  ImageIcon(getClass().getResource("/movieImage/movie3.jpg"));
	ImageIcon  movie4pic = new  ImageIcon(getClass().getResource("/movieImage/movie4.jpg"));
	ImageIcon  movie5pic = new  ImageIcon(getClass().getResource("/movieImage/movie5.jpg"));
	ImageIcon  movie6pic = new  ImageIcon(getClass().getResource("/movieImage/movie6.jpg"));

	public Showtime1View() {

		updateView();
	}
	
	public void updateView() {
		this.setTitle("Showtime Screen 1");
		
		//middleTopLeft panel (grid layout (2,1))
		//dateLabel and selectMovie label 
		dateLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        LocalDate currentDate = LocalDate.now();// Get the current date 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");// Format the date
        String formattedDate = currentDate.format(formatter);
        dateLabel.setText(formattedDate);// Set the formatted date to the JLabel
        middleTopLeft.setLayout(new GridLayout (2,1));
        middleTopLeft.add(selectMovieLabel);
        middleTopLeft.add(dateLabel);
        
        //movie list
        //movie1Button.addActionListener((ActionListener) this);
        movie1Button.setIcon(new ImageIcon(movie1pic.getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH)));
        movie1Button.setText("Inside Out");
        movie1Button.setHorizontalTextPosition(JButton.CENTER);
        movie1Button.setVerticalTextPosition(JButton.BOTTOM);
        movie1Button.setIconTextGap(5);
        movie1Button.setBorder(BorderFactory.createEtchedBorder());
        movie1Button.setEnabled(true);
        
        //movie2Button.addActionListener((ActionListener) this);
        movie2Button.setIcon(new ImageIcon(movie2pic.getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH)));
        movie2Button.setText("Haikyuu");
        movie2Button.setHorizontalTextPosition(JButton.CENTER);
        movie2Button.setVerticalTextPosition(JButton.BOTTOM);
        movie2Button.setIconTextGap(5);
        movie2Button.setBorder(BorderFactory.createEtchedBorder());
        movie2Button.setEnabled(true);
        
        //movie3Button.addActionListener((ActionListener) this);
        movie3Button.setIcon(new ImageIcon(movie3pic.getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH)));
        movie3Button.setText("Barbie");
        movie3Button.setHorizontalTextPosition(JButton.CENTER);
        movie3Button.setVerticalTextPosition(JButton.BOTTOM);
        movie3Button.setIconTextGap(5);
        movie3Button.setBorder(BorderFactory.createEtchedBorder());
        movie3Button.setEnabled(true);
        
        //movie4Button.addActionListener((ActionListener) this);
        movie4Button.setIcon(new ImageIcon(movie4pic.getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH)));
        movie4Button.setText("Oppenheimer");
        movie4Button.setHorizontalTextPosition(JButton.CENTER);
        movie4Button.setVerticalTextPosition(JButton.BOTTOM);
        movie4Button.setIconTextGap(5);
        movie4Button.setBorder(BorderFactory.createEtchedBorder());
        movie4Button.setEnabled(true);
        
        //movie5Button.addActionListener((ActionListener) this);
        movie5Button.setIcon(new ImageIcon(movie5pic.getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH)));
        movie5Button.setText("Final Girl");
        movie5Button.setHorizontalTextPosition(JButton.CENTER);
        movie5Button.setVerticalTextPosition(JButton.BOTTOM);
        movie5Button.setIconTextGap(5);
        movie5Button.setBorder(BorderFactory.createEtchedBorder());
        movie5Button.setEnabled(true);
        
        //movie6Button.addActionListener((ActionListener) this);
        movie6Button.setIcon(new ImageIcon(movie6pic.getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH)));
        movie6Button.setText("Divergent");
        movie6Button.setHorizontalTextPosition(JButton.CENTER);
        movie6Button.setVerticalTextPosition(JButton.BOTTOM);
        movie6Button.setIconTextGap(5);
        movie6Button.setBorder(BorderFactory.createEtchedBorder());
        movie6Button.setEnabled(true);
        
        //middle3Panel-movieslist
        //-------middle3panel---------------------------
        middle3Panel.setLayout(new GridLayout(2,4));
        middle3Panel.add(movie1Button);
        middle3Panel.add(movie2Button);
        middle3Panel.add(movie3Button);
        middle3Panel.add(movie4Button);
        middle3Panel.add(movie5Button);
        middle3Panel.add(movie6Button);

        //------------------middlePanel----------------
        middlePanel.setLayout(new GridBagLayout()); // Use GridBagLayout for centering
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0; 
        gbc.weightx = 1;
        gbc.weighty = 1;
        //gbc.anchor = GridBagConstraints.CENTER; // Center the middleTopLeft panel
        gbc.insets = new Insets(0, 10, 0, 10); // Optional: Add some padding around the panel //to arrange middle panel2
        gbc.fill = GridBagConstraints.NONE;
        middlePanel.add(middleTopLeft, gbc);
        gbc.gridy = 1; // Move to the next row for the next component
        middlePanel.add(middle3Panel, gbc);
		
		this.add(middlePanel);
		this.setVisible(true);
	}
	
	@Override
	public void addButtonListener(ActionListener listener) {
        nextButton.addActionListener(listener);
        backButton.addActionListener(listener);
        exitButton.addActionListener(listener);
        movie1Button.addActionListener(listener);
        movie2Button.addActionListener(listener);
        movie3Button.addActionListener(listener);
        movie4Button.addActionListener(listener);
        movie5Button.addActionListener(listener);
        movie6Button.addActionListener(listener);

    }
	
}
