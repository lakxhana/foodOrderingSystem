
public class Main {
   
    public static void main(String[] args) {
      
            // Initialize models and views for each screen
            FirstScreenModel firstScreenModel = new FirstScreenModel();
            FirstScreenView firstScreenView = new FirstScreenView();
            FirstScreenController firstScreenController = new FirstScreenController(firstScreenModel, firstScreenView);
            firstScreenController.updateView();

            //demo video: https://youtu.be/HrGji_c4Gug
    }

}
