import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class hangman extends JFrame {
    private static JFrame hang;

    public static void levelAnimal() {
        levelanimal obj = new levelanimal();
        // obj.setVisible(true);
        hang.dispose();
    }

    public static void levelFlower() {
        levelflower obj = new levelflower();
        // obj.setVisible(true);
        hang.dispose();
    }

    public static void levelCountries() {
        levelcountries obj = new levelcountries();
        // obj.setVisible(true);
        hang.dispose();
    }

    public static void main(String[] args) {
        hang = new JFrame();
        hang.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hang.setSize(905, 700);
        hang.setResizable(false);
        hang.setTitle("HANGMAN");

        hang.setLayout(null);

        JLabel head = new JLabel("Choose the Interest you want to play.");
        head.setFont(new Font("Arial", Font.PLAIN, 25));
        head.setForeground(Color.decode("#D0312D"));
        head.setBounds(250, 10, 500, 50);
        hang.add(head);

        JLabel label1 = new JLabel("Animals");
        label1.setFont(new Font("Arial", Font.PLAIN, 25));
        label1.setForeground(Color.decode("#D0312D"));
        label1.setBounds(160, 310, 100, 50);
        hang.add(label1);

        JLabel label2 = new JLabel("Countries");
        label2.setFont(new Font("Arial", Font.PLAIN, 25));
        label2.setForeground(Color.decode("#D0312D"));
        label2.setBounds(630, 310, 200, 50);
        hang.add(label2);

        JLabel label3 = new JLabel("Flowers");
        label3.setFont(new Font("Arial", Font.PLAIN, 25));
        label3.setForeground(Color.decode("#D0312D"));
        label3.setBounds(380, 600, 100, 50);
        hang.add(label3);

        ImageIcon photo1 = new ImageIcon("images\\animal.png");
        JButton button1 = new JButton(photo1);
        button1.setBounds(50, 80, 320, 220);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                levelAnimal();
            }
        });
        hang.add(button1);

        ImageIcon photo2 = new ImageIcon("images\\countries.png");
        JButton button2 = new JButton(photo2);
        button2.setBounds(520, 80, 320, 220);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                levelCountries();
            }
        });
        hang.add(button2);

        ImageIcon photo3 = new ImageIcon("images\\flowers.png");
        JButton button3 = new JButton(photo3);
        button3.setBounds(285, 370, 320, 220);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                levelFlower();
            }
        });
        hang.add(button3);

        hang.getContentPane().setBackground(Color.decode("#FFE87C"));
        hang.setVisible(true);
    }
}