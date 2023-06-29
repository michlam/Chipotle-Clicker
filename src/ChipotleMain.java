import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChipotleMain {
    JLabel counterLabel, perSecLabel;
    JButton button1, button2, button3, button4;
    int chipotleCounter;
    int timerSpeed;
    double perSecondAdd;
    int perClickAdd;
    boolean timerOn;
    Font font1, font2;
    ChipotleHandler cHandler = new ChipotleHandler();
    Timer timer;

    public static void main(String[] args) {
        new ChipotleMain();

    }

    public ChipotleMain(){
        chipotleCounter = 0;
        perClickAdd = 1;
        timerOn = false;
        perSecondAdd = 0;

        createFont();
        createUI();

    }

    public void createFont() {
        font1 = new Font("Comic Sans MS", Font.PLAIN, 32); // For counterLabel
        font2 = new Font("Comic Sans MS", Font.PLAIN, 15); // For perSecLabel
    }

    public void createUI(){
        // Create a black window with given width and height.
        int WINDOW_WIDTH = 1200;
        int WINDOW_HEIGHT = 800;

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
        chipotleButton.setActionCommand("chipotle");
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


        // Panels for power-ups
        JPanel itemPanel = new JPanel();
        itemPanel.setBounds(700, 170, 250, 250);
        itemPanel.setBackground(Color.black);
        itemPanel.setLayout(new GridLayout(4, 1));
        window.add(itemPanel);

        button1 = new JButton("Cooks");
        button1.setFont(font1);
        button1.setFocusPainted(false);
        button1.addActionListener(cHandler);
        button1.setActionCommand("Cooks");
        itemPanel.add(button1);

        button2 = new JButton("?");
        button2.setFont(font1);
        button2.setFocusPainted(false);
        button2.addActionListener(cHandler);
        button2.setActionCommand("Cursor");
        itemPanel.add(button2);

        button3 = new JButton("?");
        button3.setFont(font1);
        button3.setFocusPainted(false);
        button3.addActionListener(cHandler);
        button3.setActionCommand("Cursor");
        itemPanel.add(button3);

        button4 = new JButton("?");
        button4.setFont(font1);
        button4.setFocusPainted(false);
        button4.addActionListener(cHandler);
        button4.setActionCommand("Cursor");
        itemPanel.add(button4);

        window.setVisible(true);

    }

    public void setTimer() {

        timer = new Timer(timerSpeed, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                chipotleCounter++;
                counterLabel.setText(chipotleCounter + " burritos");
            }
        });
    }

    public void timerUpdate() {
        if(!timerOn) {
            timerOn = true;
        } else {
            timer.stop();
        }

        double speed = 1/perSecondAdd*1000;
        timerSpeed = (int)Math.round(speed);

        String s = String.format("%.1f", perSecondAdd);
        perSecLabel.setText("per second: " + s);

        setTimer();
        timer.start();

    }

    public class ChipotleHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String action = event.getActionCommand();

            switch(action) {
                case "chipotle":
                    chipotleCounter += perClickAdd;
                    counterLabel.setText(chipotleCounter + " burritos");
                    break;
                case "Cooks":
                    perSecondAdd += 0.1;
                    timerUpdate();
            }
        }
    }
}