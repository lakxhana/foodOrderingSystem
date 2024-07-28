import javax.swing.*;
import java.awt.*;

public class SelectSeatsView extends View {
    private JButton[][] seatButtons;
    private int numbSeats;

    public SelectSeatsView() {
        numbSeats = 0; // Initialize numbSeats
        initSeatSelectionPanel();
    }

    public void initSeatSelectionPanel() {
        CustomPanel seatPanel = createSeatSelectionPanel();
        middlePanel.add(seatPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    private CustomPanel createSeatSelectionPanel() {
        CustomPanel panel = new CustomPanel();
        panel.setLayout(new GridBagLayout()); // Use GridBagLayout to center the components

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around components
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        // Box around screen label
        JPanel screenBox = new JPanel();
        screenBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Black border, 2 pixels thick
        screenBox.setBackground(Color.LIGHT_GRAY); // Light gray background
        screenBox.setPreferredSize(new Dimension(200, 40)); // Set preferred size for the box

        // Label for screen
        JLabel screenLabel = new JLabel("Screen");
        screenLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set font and size
        screenBox.add(screenLabel);

        gbc.gridy++;
        panel.add(screenBox, gbc); // Add the screenBox to the CustomPanel centered

        // Panel for the seating grid
        JPanel gridPanel = new JPanel(new GridLayout(8, 9, 5, 5)); // Inner panel for the grid
        seatButtons = new JButton[8][9];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                int seatNumber = i * 9 + j + 1;
                JButton seatButton = new JButton(Integer.toString(seatNumber)); // Display only the seat number
                seatButton.setBackground(Color.WHITE);
                seatButton.setPreferredSize(new Dimension(60, 30)); // Set the preferred size to make the buttons larger
                seatButtons[i][j] = seatButton;
                gridPanel.add(seatButton);

                // Add action listener to each seat button for toggling color
                seatButton.addActionListener(e -> {
                    JButton button = (JButton) e.getSource();
                    if (button.getBackground() == Color.WHITE) {
                        button.setForeground(Color.GRAY); 
                        button.setBackground(Color.DARK_GRAY); // Change background color to DARK_GRAY
                        setNumbSeats(getNumbSeats() + 1); // Increment seat count
                    } else {
                        button.setForeground(Color.BLACK); 
                        button.setBackground(Color.WHITE); // Revert background color to WHITE
                        setNumbSeats(getNumbSeats() - 1); // Decrement seat count
                    }
                    nextButton.setEnabled(numbSeats > 0); // Enable next button if any seats are selected
                });
            }
        }

        gbc.gridy++;
        panel.add(gridPanel, gbc); // Add the gridPanel to the CustomPanel centered

        nextButton.setEnabled(false); // Initially disable the next button

        nextButton.addActionListener(e -> {
            System.out.println("Number of selected seats: " + numbSeats);
            ConfirmTicketTypeModel confirmModel = new ConfirmTicketTypeModel();
            ConfirmTicketTypeView confirmView = new ConfirmTicketTypeView();
            ConfirmTicketTypeController confirmController = new ConfirmTicketTypeController(confirmView, confirmModel);
            confirmController.setNoSeats(numbSeats); // Set the noSeat value
            this.dispose();
        });

        backButton.addActionListener(e -> {
            System.out.println("Navigating to Showtime1 screen.");
            Showtime1Model showtime1Model = new Showtime1Model();
            Showtime1View showtime1View = new Showtime1View();
            Showtime1Controller showtime1Controller = new Showtime1Controller(showtime1Model, showtime1View);
            showtime1Controller.updateView();
            this.dispose();
        });

        exitButton.addActionListener(e -> {
            System.out.println("Navigating to FirstScreen screen.");
            FirstScreenModel firstScreenModel = new FirstScreenModel();
            FirstScreenView firstScreenView = new FirstScreenView();
            FirstScreenController firstScreenController = new FirstScreenController(firstScreenModel, firstScreenView);
            firstScreenController.updateView();
            this.dispose();
        });

        return panel;
    }

    public JButton[][] getSeatButtons() {
        return seatButtons;
    }

    public int getNumbSeats() {
        return numbSeats;
    }

    public void setNumbSeats(int numbSeats) {
        this.numbSeats = numbSeats;
        System.out.println("No seats set to: " + numbSeats);
    }
}
