import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import Showtime1Controller.ButtonListener;


public class Showtime2Controller {
	 private Showtime2View view;
	 private Showtime2Model model;

	 public Showtime2Controller(Showtime2Model showtime2Model, Showtime2View showtime2view) {
		 this.model = showtime2Model;
		 this.view = showtime2view;
		 //this.view.addButtonListener(new ButtonListener());

	 }

	public void updateView() {
			view.updateView();
		}
	 

}
