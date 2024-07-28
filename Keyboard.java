import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Keyboard extends JPanel {
        private final JFrame f = new JFrame("Keyboard");

//        private final JPanel keyboard = new JPanel();
        private JTextField inputText;
        private String textBeforeChange;

        private final String[][] key = {
            {"`", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "=", "Backspace"},
            {"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\"},
            {"Caps", "A", "S", "D", "F", "G", "H", "J", "K", "L", ";", "'", "Enter"},
            {"Shift", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "/", "\u2191"},
            {" ", "<", "\u2193", ">"}
        };

        public Keyboard(JTextField inputTextField, String existingText) {
            this.setLayout(new GridBagLayout());
            inputText = inputTextField;
            textBeforeChange = existingText;
            System.out.println("textBeforeChange: "+textBeforeChange);
            
            Insets zeroInset = new Insets(0, 0, 0, 0);
            Font monospace = new Font(Font.MONOSPACED, Font.PLAIN, 12);

            JPanel pRow;
            JButton b;

            GridBagConstraints cRow = new GridBagConstraints(),
                               cButton = new GridBagConstraints();
            cRow.anchor = GridBagConstraints.WEST;
            cButton.ipady = 21;

            // first dimension of the key array
            // representing a row on the keyboard
            for (int row = 0, i = 0; row < key.length; ++row) {
                pRow = new JPanel(new GridBagLayout());

                cRow.gridy = row;

                // second dimension representing each key
                for (int col = 0; col < key[row].length; ++col, ++i) {

                    // specify padding and insets for the buttons
                    switch (key[row][col]) {
                        case "Backspace":   cButton.ipadx = 0; break;
                        case "Tab":         cButton.ipadx = 17; break;
                        case "Caps":        cButton.ipadx = 10; break;
                        case "Enter":       cButton.ipadx = 27; break;
                        case "Shift":       cButton.ipadx = 27; break;
                        case "/":
                            cButton.insets = new Insets(0, 0, 0, 24);
                            break;
                        case " ":
                            cButton.ipadx = 512;
                            cButton.insets = new Insets(0, 0, 0, 0);
                            break;
                        default:
                            cButton.ipadx = 7;
                            cButton.insets = zeroInset;
                    }

                    b = new JButton(key[row][col]);
                    b.setFont(monospace);
                    b.setFocusable(false);
                    
                    // Add ActionListener to the button
                    b.addActionListener(new KeyClickListener(key[row][col]));
                    
                    pRow.add(b, cButton);
                }

                this.add(pRow, cRow);
            }

            f.add(this);
        }
        
     // ActionListener implementation to handle button clicks
        private class KeyClickListener implements ActionListener {
            private final String key;

            public KeyClickListener(String key) {
                this.key = key;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the button click here
                System.out.println("Clicked: " + key);
                          
                if (key != "Enter" && key != "Tab" && key != "Caps" && key != "Shift" && key != "Backspace")  {
                	textBeforeChange+=key;
                    inputText.setText(textBeforeChange);     
                } else if (key == "Backspace") {
                	 textBeforeChange = textBeforeChange.substring(0, textBeforeChange.length() - 1);
                	 inputText.setText(textBeforeChange);     
                }
                // You can perform any action you want here
//                if (nameTextField.isFocusOwner()) {
//                	nameText += key;
//                	nameTextField.setText(nameText);
//                } else if (contactTextField.isFocusOwner()) {
//                	contactText += key;
//                	contactTextField.setText(contactText);                
//                }
            }
        }

        public void launch() {
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.pack();
            f.setResizable(false);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        }
    }