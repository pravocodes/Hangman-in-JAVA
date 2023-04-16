import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AnimalEasy extends JFrame {
    static String selected_word;
    static String selected_hint;
    static int score = 0;
    static int count = 0;
    static int win_count = 0;
    static boolean run = true;
    public static JLabel[] han;

    public AnimalEasy() {
        JFrame frame = new JFrame("Main");
        frame.setSize(905, 700);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        selected_word = "";
        Random rand = new Random();
        int randomIndex = rand.nextInt(10);
        try {
            List<String> lines = Files
                    .readAllLines(Paths.get("textfiles\\animals_easy.txt"));

            selected_word = lines.get(randomIndex).toUpperCase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println(selected_word);
        selected_hint = "";
        try {
            List<String> lines = Files
                    .readAllLines(Paths.get("textfiles\\animalhints_easy.txt"));
            selected_hint = lines.get(randomIndex).toUpperCase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println(selected_hint);

        int x = 250;
        JLabel[] labels = new JLabel[selected_word.length()];
        frame.setLayout(null);
        for (int i = 0; i < selected_word.length(); i++) {
            x += 60;
            // System.out.println(x);
            labels[i] = new JLabel("_");
            labels[i].setOpaque(true);
            labels[i].setBackground(new Color(0xE7FFFF));
            labels[i].setFont(new Font("Arial", Font.PLAIN, 40));
            labels[i].setBounds(x, 450, 40, labels[i].getPreferredSize().height);
            frame.add(labels[i]);
        }

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

        String[] h123 = { "h1", "h2", "h3", "h4", "h5", "h6", "h7" };
        Map<String, Image> hangman = new HashMap<>();
        for (String let : h123) {
            // System.out.println(let);
            try {
                hangman.put(let,
                        ImageIO.read(new File("images\\" + let + ".png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // System.out.println(hangman);

        String[][] han = { { "c1", "h1" }, { "c2", "h2" }, { "c3", "h3" }, { "c4", "h4" }, { "c5", "h5" },
                { "c6", "h6" }, { "c7", "h7" } };
        Map<String, JLabel> hang = new HashMap<>();

        for (String[] p1 : han) {
            JLabel label = new JLabel();
            label.setOpaque(true);
            label.setBackground(Color.decode("#E7FFFF"));
            label.setIcon(new ImageIcon(hangman.get(p1[1])));
            hang.put(p1[0], label);
        }

        JLabel c1 = hang.get("c1");
        JLabel c2 = hang.get("c2");
        JLabel c3 = hang.get("c3");
        JLabel c4 = hang.get("c4");
        JLabel c5 = hang.get("c5");
        JLabel c6 = hang.get("c6");
        JLabel c7 = hang.get("c7");
        c1.setBounds(450, 5, 400, 400);
        frame.add(c1);

        Object[][] button = { { "b1", "A", 0, 580 }, { "b2", "B", 70, 580 }, { "b3", "C", 140, 580 },
                { "b4", "D", 210, 580 }, { "b5", "E", 280, 580 }, { "b6", "F", 350, 580 }, { "b7", "G", 420, 580 },
                { "b8", "H", 490, 580 }, { "b9", "I", 560, 580 }, { "b10", "J", 620, 580 }, { "b11", "K", 700, 580 },
                { "b12", "L", 770, 580 }, { "b13", "M", 840, 580 }, { "b14", "N", 0, 620 }, { "b15", "O", 70, 620 },
                { "b16", "P", 140, 620 }, { "b17", "Q", 210, 620 }, { "b18", "R", 280, 620 }, { "b19", "S", 350, 620 },
                { "b20", "T", 420, 620 }, { "b21", "U", 490, 620 }, { "b22", "V", 560, 620 }, { "b23", "W", 620, 620 },
                { "b24", "X", 700, 620 }, { "b25", "Y", 770, 620 }, { "b26", "Z", 840, 620 } };
        for (Object[] q1 : button) {
            JButton btn = new JButton(new ImageIcon(images.get(q1[1])));
            btn.setName((String) q1[0]);
            btn.setBorderPainted(false);
            btn.setBackground(new Color(0xE7FFFF));
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
                            System.out.println(score);
                            int answer = JOptionPane.showConfirmDialog(frame, "YOU WON!\nWANT TO PLAY AGAIN?",
                                    "GAME OVER",
                                    JOptionPane.YES_NO_OPTION);
                            if (answer == JOptionPane.YES_OPTION) {
                                frame.dispose();
                                win_count = 0;
                                new AnimalEasy().setVisible(true);
                            } else {
                                frame.dispose();
                            }
                        }
                    } else {
                        count++;
                        if (count == 1) {
                            c1.setVisible(false);
                            c2.setBounds(450, 5, 400, 400);
                            frame.add(c2);
                        } else if (count == 2) {
                            c2.setVisible(false);
                            c3.setBounds(450, 5, 400, 400);
                            frame.add(c3);
                        } else if (count == 3) {
                            c3.setVisible(false);
                            c4.setBounds(450, 5, 400, 400);
                            frame.add(c4);
                        } else if (count == 4) {
                            c4.setVisible(false);
                            c5.setBounds(450, 5, 400, 400);
                            frame.add(c5);
                        } else if (count == 5) {
                            c5.setVisible(false);
                            c6.setBounds(450, 5, 400, 400);
                            frame.add(c6);
                        } else if (count == 6) {
                            c6.setVisible(false);
                            c7.setBounds(450, 5, 400, 400);
                            frame.add(c7);
                        }

                        if (count == 6) {
                            score = 0;
                            JOptionPane.showMessageDialog(frame, selected_word, "revealed word",
                                    JOptionPane.INFORMATION_MESSAGE);
                            int answer = JOptionPane.showConfirmDialog(frame, "YOU LOST!\nWANT TO PLAY AGAIN?",
                                    "GAME OVER",
                                    JOptionPane.YES_NO_OPTION);
                            if (answer == JOptionPane.YES_OPTION) {
                                frame.dispose();
                                win_count = 0;
                                new AnimalEasy();
                            } else {
                                frame.dispose();
                            }
                        }
                    }
                }

            });
            frame.add(btn);
        }

        // Hangman placement
        // String[] frame = { "h1", "h2", "h3", "h4", "h5", "h6", "h7" };
        // JLabel[] hangLabels = new JLabel[frame.length];
        // for (int i = 0; i < h123.length; i++) {
        // hangLabels[i] = new JLabel();
        // hangLabels[i].setBackground(new Color(231, 255, 255));
        // hangLabels[i].setIcon(new ImageIcon(hangman.get(frame[i])));
        // }

        // // Placement of first hangman image
        // hangLabels[0].setBounds(400, -50, hangLabels[0].getPreferredSize().width,
        // hangLabels[0].getPreferredSize().height);
        // hintButton
        ImageIcon hintpic = new ImageIcon("images\\Hint.png");
        JButton hangbutton = new JButton(hintpic);
        hangbutton.setBounds(10, 250, 450, hangbutton.getPreferredSize().height);
        hangbutton.setBackground(Color.decode("#E7FFFF"));
        hangbutton.setOpaque(true);
        hangbutton.setBorder(null);
        hangbutton.setIcon(hintpic);
        hangbutton.addActionListener(e -> {
            JLabel hi1 = new JLabel(selected_hint);
            int n = hi1.getWidth();
            System.out.println(n);
            hi1.setBounds(10, 250, 500000, 50);
            hi1.setBackground(Color.decode("#E7FFFF"));
            hi1.setFont(new Font("The Times New Roman", Font.PLAIN, 12));
            hangbutton.setVisible(false);
            frame.add(hi1);

        });
        frame.add(hangbutton);

        // ExitButton
        ImageIcon exitIcon = new ImageIcon("images\\exit.png");
        JButton exitButton = new JButton(exitIcon);
        exitButton.setBounds(760, 10, exitButton.getPreferredSize().width, exitButton.getPreferredSize().height);
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.setBackground(new Color(231, 255, 255));
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(e -> {
            int answer = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the game?", "ALERT",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (answer == JOptionPane.YES_OPTION) {
                frame.dispose();
            }
        });
        frame.add(exitButton);

        JLabel scoreLabel = new JLabel("SCORE: " + score);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        scoreLabel.setBounds(10, 10, 200, 30);
        frame.add(scoreLabel);

        // setContentPane(frame);
        // frame.setVisible(true);

        frame.getContentPane().setBackground(Color.decode("#E7FFFF"));
        frame.setVisible(true);
    }

    // public static void main(String[] args) {
    // new AnimalEasy().setVisible(true);

    // }

}