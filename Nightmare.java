import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.io.IOException;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class Nightmare extends JFrame {
    static String selected_word = "pneumonoultramicroscopicsilicovolcanoconiosis".toUpperCase();
    static String selected_hint;
    static int score = 0, t = 0, x = -20;
    static int count = 0;
    static int win_count = 0;
    private JLabel label;
    private Timer timer;
    private int timeLeft = 15;
    static JFrame frame = new JFrame("Main");
    static JLabel[] labels = new JLabel[selected_word.length()];

    public static void callmain() {
        hangman obj = new hangman();
        // obj.setVisible(true);
        frame.dispose();
    }

    public Nightmare() {

        frame.setUndecorated(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);

        // System.out.println(selected_word);
        timeLeft = 15;
        t = 0;
        selected_hint = "Refering to lung desease cause by silica dust";
        // System.out.println(selected_hint);

        int x = -20;
        JLabel[] labels = new JLabel[selected_word.length()];

        for (int i = 0; i < selected_word.length(); i++) {
            x += 34;
            // System.out.println(x);
            labels[i] = new JLabel("_");
            labels[i].setOpaque(true);
            labels[i].setForeground(Color.WHITE);
            labels[i].setBackground(Color.BLACK);
            labels[i].setFont(new Font("Arial", Font.PLAIN, 40));
            labels[i].setBounds(x, 450, 40, labels[i].getPreferredSize().height);
            frame.add(labels[i]);
        }
        // heading
        JLabel l2 = new JLabel("NIGHTMARE MODE ACTIVATED, TRY TO WIN!!!!");
        l2.setFont(new Font("Chiller", Font.BOLD, 76));
        l2.setForeground(Color.RED);
        l2.setBackground(Color.BLACK);
        l2.setBounds(120, 15, 1500, 80);
        l2.setOpaque(true);
        frame.add(l2);

        String[] al = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
                "T", "U", "V", "W", "X", "Y", "Z" };
        Map<String, Image> images = new HashMap<>();
        for (String let : al) {
            // System.out.println(let);
            try {
                images.put(let,
                        ImageIO.read(new File("images\\" + let + ".png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // timer show
        label = new JLabel(String.valueOf(timeLeft));

        label.setFont(new Font("Arial", Font.BOLD, 76));
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        label.setBounds(620, 255, 1500, 80);
        label.setOpaque(true);
        frame.add(label);

        Object[][] button = { { "b1", "A", 280, 735 }, { "b2", "B", 350, 735 }, { "b3", "C", 420, 735 },
                { "b4", "D", 490, 735 }, { "b5", "E", 560, 735 }, { "b6", "F", 630, 735 }, { "b7", "G", 700, 735 },
                { "b8", "H", 770, 735 }, { "b9", "I", 840, 735 }, { "b10", "J", 910, 735 }, { "b11", "K", 980, 735 },
                { "b12", "L", 1050, 735 }, { "b13", "M", 1120, 735 }, { "b14", "N", 280, 800 },
                { "b15", "O", 350, 800 },
                { "b16", "P", 420, 800 }, { "b17", "Q", 490, 800 }, { "b18", "R", 560, 800 }, { "b19", "S", 630, 800 },
                { "b20", "T", 700, 800 }, { "b21", "U", 770, 800 }, { "b22", "V", 840, 800 }, { "b23", "W", 910, 800 },
                { "b24", "X", 980, 800 }, { "b25", "Y", 1050, 800 }, { "b26", "Z", 1120, 800 } };
        for (Object[] q1 : button) {
            JButton btn = new JButton(new ImageIcon(images.get(q1[1])));
            btn.setName((String) q1[0]);
            btn.setBorderPainted(false);
            btn.setBackground(Color.BLACK);
            btn.setFont(new Font("Arial", Font.PLAIN, 10));
            btn.setBounds((int) q1[2], (int) q1[3], btn.getPreferredSize().width - 35, 35);

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String letter = (String) q1[1];
                    String button = (String) q1[0];
                    // Main.check((String) q1[1], (String) q1[0]);
                    btn.setVisible(false);
                    if (selected_word.contains(letter)) {
                        for (int i = 0; i < selected_word.length(); i++) {
                            if (selected_word.charAt(i) == letter.charAt(0)) {
                                win_count++;
                                labels[i].setText(letter.toUpperCase());
                            }
                        }
                        // System.out.println(win_count);
                        if (win_count == selected_word.length()) {
                            score++;
                            // System.out.println(score);
                            int answer = JOptionPane.showConfirmDialog(frame, "YOU WON!\nWANT TO PLAY AGAIN?",
                                    "GAME OVER",
                                    JOptionPane.YES_NO_OPTION);
                            if (answer == JOptionPane.YES_OPTION) {

                                t = 1;
                                win_count = 0;
                                count = 0;
                                frame.dispose();
                                new Nightmare();
                            } else {
                                t = 1;
                                frame.dispose();
                            }
                        }
                    } else {
                        count++;

                        if (count == 2) {
                            score = 0;
                            timer.stop();
                            // JOptionPane.showMessageDialog(frame, selected_word, "revealed word",
                            // JOptionPane.INFORMATION_MESSAGE);
                            int answer = JOptionPane.showConfirmDialog(frame, "YOU LOST!\nWANT TO PLAY AGAIN?",
                                    "GAME OVER",
                                    JOptionPane.YES_NO_OPTION);
                            if (answer == JOptionPane.YES_OPTION) {
                                frame.remove(label);
                                label.revalidate();

                                for (int i = 0; i < selected_word.length(); i++) {
                                    labels[i].setText("_");
                                }
                                // frame.removeAll();
                                // frame.revalidate();
                                count = 0;
                                win_count = 0;
                                frame.dispose();
                                new Nightmare();
                            } else {
                                frame.dispose();
                            }
                        }
                    }
                }

            });
            frame.add(btn);
        }

        // ExitButton
        ImageIcon exitIcon = new ImageIcon("images\\exit.png");
        JButton exitButton = new JButton(exitIcon);
        exitButton.setBounds(1400, 130, exitButton.getPreferredSize().width,
                exitButton.getPreferredSize().height);
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.setBackground(Color.BLACK);
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(e -> {

            int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the game?", "ALERT",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            timer.stop();
            if (answer == JOptionPane.YES_OPTION) {

                t = 1;
                timeLeft = 0;
                frame.dispose();
            }
        });
        frame.add(exitButton);

        // score
        JLabel scoreLabel = new JLabel("SCORE: " + score);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setBounds(10, 130, 200, 30);
        frame.add(scoreLabel);

        // timer function

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                label.setText(String.valueOf(timeLeft));
                if (t == 0 && timeLeft == 0) {
                    timer.stop();
                    JOptionPane.showMessageDialog(frame, " Time's up");
                    JOptionPane.showMessageDialog(frame, " YOU LOST \n ENDING THE NIGHTMARE MODE");
                    callmain();

                }
            }
        });

        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);
        JOptionPane.showMessageDialog(this, "READY, ARE YOU READY \n COUNTDOWN GOING TO START");
        timer.start();
    }

    public static void main(String[] args) {
        new Nightmare();

    }

}