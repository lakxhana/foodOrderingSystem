import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Movie6View extends Showtime2View{

	JPanel panel1 = new JPanel();
	String movieName = "Divergent";
	JLabel movieNameLabel = new JLabel("MovieTitle: " + movieName);
	String ageRating = "PG-13";
	JLabel ageRatingLabel = new JLabel("Age Rating: " + ageRating);
	
	JPanel panel2 = new JPanel();
	String description = "<html>Sypnopsis:In a world divided by factions based on virtues, Tris learns she's Divergent and won't fit in. When she discovers a plot to destroy Divergents, Tris and the mysterious Four must find out what makes Divergents dangerous before it's too late.</html>";
	JLabel descriptionLabel = new JLabel(description);
	
	public Movie6View() {
		updateMovie6View(movieName, ageRating, description); // Update the view for Movie1Viezw	
    }
	
	//calling variables movieName, ageRating, description
	public void updateMovie6View(String name, String ageRate, String desc) {
		
		name = movieName;
		ageRate = ageRating;
		desc = description;
		
		this.setTitle("Movie1: Inside Out");
			
		//panel1----movieTitle&ageRating
		movieNameLabel.setForeground(Color.WHITE);
		ageRatingLabel.setForeground(Color.WHITE);
		panel1.setOpaque(false);
		panel1.setPreferredSize(new Dimension(50, 50)); // Width x Height
		panel1.setMinimumSize(new Dimension(50, 50));
		panel1.setMaximumSize(new Dimension(50, 50));
		panel1.setLayout(new GridLayout(2,1));
		panel1.add(movieNameLabel);
		panel1.add(ageRatingLabel);
				
		//panel2-----movieDescription/Sypnopsis
		descriptionLabel.setForeground(Color.WHITE);
		panel2.setOpaque(false);
		panel2.setPreferredSize(new Dimension(10, 10)); // Width x Height
		panel2.setMinimumSize(new Dimension(10, 10));
		panel2.setMaximumSize(new Dimension(10, 10));
		panel2.setLayout(new GridLayout(1,1));
		//panel2.add(descriptionTop);
		panel2.add(descriptionLabel);		
		
		//middlePanel
		middlePanel.setLayout(new GridBagLayout()); // Use GridBagLayout for centering
		GridBagConstraints gbc = new GridBagConstraints();
		        
        // Add panel1 to the top left
		gbc.gridx = 0;
        gbc.gridy = 0; 
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(20, 50, 10, 5); // Optional: Add some padding around the panel
        gbc.fill = GridBagConstraints.HORIZONTAL;
        middlePanel.add(panel1, gbc);
		        
        // Add panel2 to the top right
        gbc.gridx = 1;
        gbc.gridy = 0; 
        gbc.weightx = 1;
        gbc.insets = new Insets(20, 5, 10, 50); // Optional: Add some padding around the panel
        gbc.fill = GridBagConstraints.BOTH;
        middlePanel.add(panel2, gbc);
		
        
        // Add panel3 to the bottom, spanning both columns
        gbc.gridx = 0;
        gbc.gridy = 1; 
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 50, 75, 50); // Optional: Add some padding around the panel
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0; // Allow panel3 to take up remaining vertical space
        middlePanel.add(panel3, gbc);
		
	}
	@Override
	public void addButtonListener(ActionListener listener) {
        nextButton.addActionListener(listener);
        backButton.addActionListener(listener);
        exitButton.addActionListener(listener);
        topButton1.addActionListener(listener);
        topButton2.addActionListener(listener);
        topButton3.addActionListener(listener);
        topButton4.addActionListener(listener);
        midButton1.addActionListener(listener);
        midButton2.addActionListener(listener);
        midButton3.addActionListener(listener);
        bottomButton1.addActionListener(listener);
        bottomButton2.addActionListener(listener);

    }
	

}
