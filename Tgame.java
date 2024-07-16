import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Tgame extends JFrame {
    int k = 0; // Player turn indicator (0 for Player 1, 1 for Player 2 / Computer)
    int count = 0; // Total moves made
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b;
    JTextField tf;

    public Tgame(String s) {
        super(s);
    }

    public void setComponent() {
        // Initialize buttons and other components
        // (your existing code for setting up buttons, text field, etc.)
    }

    // Check the game board for a winner or draw
    public void check() {
        count++;
        // Check for rows, columns, and diagonals for 'X' and '0'
        // (your existing check() method)
    }

    // Method to make the computer's move
    public void computerMove() {
        // Basic AI: Randomly select an available button
        JButton[] buttons = { b1, b2, b3, b4, b5, b6, b7, b8, b9 };
        JButton selectedButton = null;

        do {
            int index = (int) (Math.random() * 9); // Random index from 0 to 8
            selectedButton = buttons[index];
        } while (!selectedButton.isEnabled()); // Keep selecting until an enabled button is found

        selectedButton.setText("0");
        selectedButton.setEnabled(false);
        int result = check();
        if (result == 2) {
            tf.setText("Player 2 (Computer) Won");
            enableButtons(false);
        } else if (result == 3) {
            tf.setText("Game Draw");
        }
        k = 0; // Switch back to Player 1's turn
    }

    // ActionListener for buttons (Player moves)
    class ButtonListener implements ActionListener {
        private JButton button;

        public ButtonListener(JButton button) {
            this.button = button;
        }

        public void actionPerformed(ActionEvent e) {
            if (button.isEnabled()) {
                if (k == 0) {
                    button.setText("X");
                    button.setEnabled(false);
                    int result = check();
                    if (result == 1) {
                        tf.setText("Player 1 Won");
                        enableButtons(false);
                    } else if (result == 3) {
                        tf.setText("Game Draw");
                    } else {
                        k = 1; // Switch to Player 2 (Computer)'s turn
                        computerMove(); // Make computer move
                    }
                }
            }
        }
    }

    // Method to enable or disable all buttons
    public void enableButtons(boolean enable) {
        b1.setEnabled(enable);
        b2.setEnabled(enable);
        b3.setEnabled(enable);
        b4.setEnabled(enable);
        b5.setEnabled(enable);
        b6.setEnabled(enable);
        b7.setEnabled(enable);
        b8.setEnabled(enable);
        b9.setEnabled(enable);
    }

    public static void main(String[] args) {
        TTgame jf = new TTgame("Tic Tac Toe");
        jf.setVisible(true);
        jf.setSize(325, 450);
        jf.setLocation(500, 200);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setComponent();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Add action listeners to all buttons
        jf.b1.addActionListener(jf.new ButtonListener(jf.b1));
        jf.b2.addActionListener(jf.new ButtonListener(jf.b2));
        jf.b3.addActionListener(jf.new ButtonListener(jf.b3));
        jf.b4.addActionListener(jf.new ButtonListener(jf.b4));
        jf.b5.addActionListener(jf.new ButtonListener(jf.b5));
        jf.b6.addActionListener(jf.new ButtonListener(jf.b6));
        jf.b7.addActionListener(jf.new ButtonListener(jf.b7));
        jf.b8.addActionListener(jf.new ButtonListener(jf.b8));
        jf.b9.addActionListener(jf.new ButtonListener(jf.b9));
    }
}
