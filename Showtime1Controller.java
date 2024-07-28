import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Showtime1Controller {
	
	 private Showtime1View view;
	 private Showtime1Model model;
	 //private View mainView;
	
	public Showtime1Controller(Showtime1Model showtime1Model, Showtime1View showtime1view) {
		this.model = showtime1Model;
		this.view = showtime1view;
		//this.mainView = mainview;
		this.view.addButtonListener(new ButtonListener());
	}
	
	public void updateView() {
		view.updateView();
	}

	public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.nextButton) {
                //new Showtime2View();
                //view.dispose();
            } 
            if (e.getSource() == view.backButton) {
    			System.out.println("Navigating to FirstScreen screen.");
    			FirstScreenModel firstScreenModel = new FirstScreenModel();
    			FirstScreenView firstScreenView = new FirstScreenView();
    			FirstScreenController firstScreenController = new FirstScreenController(firstScreenModel, firstScreenView);
    			firstScreenController.updateView();
                //new FirstScreenView();
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
            
            if(e.getSource() == view.movie1Button) {
            	// Movie1View();
    			System.out.println("Navigating to Movie1View screen.");
                // Initialize the next view and controller only when button is clicked
    			Movie1Model movie1Model = new Movie1Model();
                Movie1View movie1View = new Movie1View();
                Movie1Controller movie1Controller = new Movie1Controller(movie1Model, movie1View);
                movie1Controller.updateView();
                view.dispose();
    			
    		}
    		if(e.getSource() == view.movie2Button) {
    			System.out.println("Navigating to Movie2View screen.");
                // Initialize the next view and controller only when button is clicked
    			Movie2Model movie2Model = new Movie2Model();
                Movie2View movie2View = new Movie2View();
                Movie2Controller movie2Controller = new Movie2Controller(movie2Model, movie2View);
                movie2Controller.updateView();    			
                view.dispose();
    			
    		}
    		if(e.getSource() == view.movie3Button) {
    			System.out.println("Navigating to Movie3View screen.");
                // Initialize the next view and controller only when button is clicked
    			Movie3Model movie3Model = new Movie3Model();
                Movie3View movie3View = new Movie3View();
                Movie3Controller movie3Controller = new Movie3Controller(movie3Model, movie3View);
                movie3Controller.updateView();
                view.dispose();
    			
    		}
    		if(e.getSource() == view.movie4Button) {
    			System.out.println("Navigating to Movie4View screen.");
                // Initialize the next view and controller only when button is clicked
    			Movie4Model movie4Model = new Movie4Model();
                Movie4View movie4View = new Movie4View();
                Movie4Controller movie4Controller = new Movie4Controller(movie4Model, movie4View);
                movie4Controller.updateView();
                view.dispose();
    			
    		}
    		if(e.getSource() == view.movie5Button) {
    			System.out.println("Navigating to Movie5View screen.");
                // Initialize the next view and controller only when button is clicked
    			Movie5Model movie5Model = new Movie5Model();
                Movie5View movie5View = new Movie5View();
                Movie5Controller movie5Controller = new Movie5Controller(movie5Model, movie5View);
                movie5Controller.updateView();    			
                view.dispose();
    			
    		}
    		if(e.getSource() == view.movie6Button) {
    			System.out.println("Navigating to Movie6View screen.");
                // Initialize the next view and controller only when button is clicked
    			Movie6Model movie6Model = new Movie6Model();
                Movie6View movie6View = new Movie6View();
                Movie6Controller movie6Controller = new Movie6Controller(movie6Model, movie6View);
                movie6Controller.updateView();    			
                view.dispose();
    			
    		}
        }
    }
}