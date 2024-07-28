import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import Showtime1Controller.ButtonListener;

public class Movie3Controller  {
	
	private Movie3Model model;
	private Movie3View view;
	
    public Movie3Controller(Movie3Model movie3model, Movie3View movie3view) {        
        this.model = movie3model;
        this.view = movie3view;
        
	this.view.addButtonListener(new ButtonListener());
    }
    
  //setters and getters---------------------------
    public String getMovieName() {
    	return model.getMovieName();
    }
    public void setMovieName(String movieName) {
    	model.setMovieName(movieName);
    }
    
    public String getAgeRating() {
		return model.getAgeRating();
	}
	public void setAgeRating(String ageRating) {
		model.setAgeRating(ageRating);
	}
    
	public String getDescription() {
		return model.getDescription();
	}
	public void setDescription(String description) {
		model.setDescription(description);
	}
	
	public String getExperiences() {
		return model.getExperiences();
	}
	public void setExperiences(String experiences) {
		model.setExperiences(experiences);
	}
	
	public String getShowTime() {
		return model.getShowTime();
	}
	public void setShowTime(String showTime) {
		model.setShowTime(showTime);
	}
	//----------------------------------------------
	
    public void updateView() {
		view.updateMovie3View(model.getMovieName(), model.getAgeRating(), model.getDescription() );
	}
    
    public class ButtonListener implements ActionListener {
    	@Override
        public void actionPerformed(ActionEvent e) {
    		if (e.getSource() == view.topButton1) {
    			String experience = "IMAX";
    			setExperiences(experience);
    			String showTime = "7.00pm";
    			setShowTime(showTime);
    		    new SelectSeatsView();
    		    view.dispose();
    		} 
    		else if (e.getSource() == view.topButton2) {
    			String experience = "IMAX";
    			setExperiences(experience);
    			String showTime = "8.10pm";
    			setShowTime(showTime);
    		    new SelectSeatsView();
    		    view.dispose();
    		} 
    		else if (e.getSource() == view.topButton3) {
    			String experience = "IMAX";
    			setExperiences(experience);
    			String showTime = "9.30pm";
    			setShowTime(showTime);
    		    new SelectSeatsView();
    		    view.dispose();
    		} 
    		else if (e.getSource() == view.topButton4) {
    			String experience = "IMAX";
    			setExperiences(experience);
    			String showTime = "1.00pm";
    			setShowTime(showTime);
    		    new SelectSeatsView();
    		    view.dispose();
    		} 
    		else if (e.getSource() == view.midButton1) {
    			String experience = "3D";
    			setExperiences(experience);
    			String showTime = "7.15pm";
    			setShowTime(showTime);
    		    new SelectSeatsView();
    		    view.dispose();
    		} 
    		else if (e.getSource() == view.midButton2) {
    			String experience = "3D";
    			setExperiences(experience);
    			String showTime = "10.20pm";
    			setShowTime(showTime);
    		    new SelectSeatsView();
    		    view.dispose();
    		} 
    		else if (e.getSource() == view.midButton3) {
    			String experience = "3D";
    			setExperiences(experience);
    			String showTime = "12.10pm";
    			setShowTime(showTime);
    		    new SelectSeatsView();
    		    view.dispose();
    		} 
    		else if (e.getSource() == view.bottomButton1) {
    			String experience = "2D";
    			setExperiences(experience);
    			String showTime = "9.45pm";
    			setShowTime(showTime);
    		    new SelectSeatsView();
    		    view.dispose();
    		} 
    		else if (e.getSource() == view.bottomButton2) {
    			String experience = "2D";
    			setExperiences(experience);
    			String showTime = "11.30pm";
    			setShowTime(showTime);
    		    new SelectSeatsView();
    		    view.dispose();
    		}
        	if (e.getSource() == view.nextButton) {
                //new SelectSeatsView();
                //view.dispose();
            } 
            if (e.getSource() == view.backButton) {
            	//new Showtime1View();
            	System.out.println("Navigating to Showtime1 screen.");
                // Initialize the next view and controller only when button is clicked
    			Showtime1Model showtime1Model = new Showtime1Model();
    			Showtime1View showtime1View = new Showtime1View();
    			Showtime1Controller showtime1Controller = new Showtime1Controller(showtime1Model, showtime1View);
    			showtime1Controller.updateView();
                view.dispose();
            }
            if (e.getSource() == view.exitButton) {
            	System.out.println("Navigating to FirstScreen screen.");
    			FirstScreenModel firstScreenModel = new FirstScreenModel();
    			FirstScreenView firstScreenView = new FirstScreenView();
    			FirstScreenController firstScreenController = new FirstScreenController(firstScreenModel, firstScreenView);
    			firstScreenController.updateView();
                view.dispose();
            } 
        }
    }
   
}
