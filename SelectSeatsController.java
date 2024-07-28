public class SelectSeatsController {
    private SelectSeatsModel model;
    private SelectSeatsView view;

    public SelectSeatsController(SelectSeatsView view, SelectSeatsModel model) {
        this.view = view;
        this.model = model;
        this.view.initSeatSelectionPanel(); // Initialize seat selection panel
        this.view.setVisible(true); // Show the view
    }

    public void bookSeat(int row, int col) {
        model.bookSeat(row, col);
    }

    public void unbookSeat(int row, int col) {
        model.unbookSeat(row, col);
    }

    public int getNumberOfSelectedSeats() {
        return view.getNumbSeats();
    }
    
    public void navigateToConfirmTicketType() {
    	int numberOfSelectedSeats = getNumberOfSelectedSeats();
        System.out.println("Number of selected seats: " + numberOfSelectedSeats);
        ConfirmTicketTypeModel confirmTicketTypeModel = new ConfirmTicketTypeModel(); // Create model
        ConfirmTicketTypeView confirmTicketTypeView = new ConfirmTicketTypeView(); // Create view
        ConfirmTicketTypeController confirmTicketTypeController = new ConfirmTicketTypeController(confirmTicketTypeView, confirmTicketTypeModel); // Create controller
        confirmTicketTypeController.setNoSeats(numberOfSelectedSeats); // Set the noSeat value
        confirmTicketTypeView.setVisible(true); // Show the new view
        view.dispose(); // Dispose the current view
    }
    
    
}
