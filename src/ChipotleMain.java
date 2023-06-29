import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChipotleMain {
    JLabel counterLabel, perSecLabel;
    int chipotleCounter;
    Font font1, font2;
    ChipotleHandler cHandler = new ChipotleHandler();

    public static void main(String[] args) {
        new ChipotleMain();

    }

    public ChipotleMain(){
        chipotleCounter = 0;

        createFont();
        createUI();

    }

    public void createFont() {
        font1 = new Font("Comic Sans MS", Font.PLAIN, 32); // For counterLabel
        font2 = new Font("Comic Sans MS", Font.PLAIN, 15); // For perSecLabel
    }

    public void createUI(){
        // Create a black window with given width and height.
        int WINDOW_WIDTH = 800;
        int WINDOW_HEIGHT = 600;

        JFrame window = new JFrame();
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        // Add the chipotle image panel
        JPanel chipotlePanel = new JPanel();
        chipotlePanel.setBounds(100, 220, 200, 134);
        chipotlePanel.setBackground(Color.black);
        window.add(chipotlePanel);

        // Get the chipotle image and turn it into a button
        ImageIcon chipotle = new ImageIcon(getClass().getClassLoader().getResource("chipotle.png"));
        JButton chipotleButton = new JButton();
        chipotleButton.setBackground(Color.black);
        chipotleButton.setFocusPainted(false);
        chipotleButton.setBorder(null);
        chipotleButton.setIcon(chipotle);
        chipotleButton.addActionListener(cHandler); // Handles what happens when clicked
        chipotlePanel.add(chipotleButton);

        // Add the count tracker and per second tracker
        JPanel counterPanel = new JPanel();
        counterPanel.setBounds(100, 100, 450, 100);
        counterPanel.setBackground(Color.black);
        counterPanel.setLayout(new GridLayout(2, 1));
        window.add(counterPanel);

        counterLabel = new JLabel(chipotleCounter + " burritos");
        counterLabel.setForeground(Color.white);
        counterLabel.setFont(font1);
        counterPanel.add(counterLabel);

        perSecLabel = new JLabel();
        perSecLabel.setForeground(Color.white);
        perSecLabel.setFont(font2);
        counterPanel.add(perSecLabel);

        window.setVisible(true);

    }

    public class ChipotleHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            chipotleCounter++;
            counterLabel.setText(chipotleCounter + " burritos");
        }
    }
}