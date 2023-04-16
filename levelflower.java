import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class levelflower extends JFrame {

    private static JFrame level;
    private static int b = 0;

    public static void easyFlower() {
        FlowersEasy obj = new FlowersEasy();
        // obj.setVisible(true);
        level.dispose();
    }

    public static void mediumFlower() {
        FlowersMedium obj = new FlowersMedium();
        // obj.setVisible(true);
        level.dispose();
    }

    public static void hardFlower() {
        FlowersHard obj = new FlowersHard();
        // obj.setVisible(true);
        level.dispose();
    }

    public static void easyInfo() {
        JOptionPane.showMessageDialog(level, "You have 6 Chances to win the game otherwise your man will be hanged",
                "Easy Rules", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mediumInfo() {
        JOptionPane.showMessageDialog(level, "You have 5 Chances to win the game otherwise your man will be hanged",
                "Medium Rules", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void hardInfo() {
        b++;
        if (b < 3) {
            JOptionPane.showMessageDialog(level, "You have 4 Chances to win the game otherwise your man will be hanged",
                    "Hard Rules",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            Nightmare obj = new Nightmare();
            level.dispose();
        }
    }

    public levelflower() {
        level = new JFrame();
        level.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        level.setSize(300, 350);
        level.setResizable(false);
        level.setTitle("LEVELS");

        level.setLayout(null);

        JLabel head = new JLabel("<html>Choose the level<br>of difficulty.</html>");
        head.setFont(new Font("Arial", Font.PLAIN, 25));
        head.setBounds(50, 10, 200, 50);
        level.add(head);

        ImageIcon photo1 = new ImageIcon("images\\easy.png");
        JButton button1 = new JButton(photo1);
        button1.setBounds(70, 90, 100, 50);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                easyFlower();
            }
        });
        level.add(button1);
        ImageIcon photo2 = new ImageIcon("images\\medium.png");
        JButton button2 = new JButton(photo2);
        button2.setBounds(70, 150, 100, 50);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediumFlower();
            }
        });
        level.add(button2);
        ImageIcon photo3 = new ImageIcon("images\\hard.png");
        JButton button3 = new JButton(photo3);
        button3.setBounds(70, 210, 100, 50);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hardFlower();
            }
        });
        level.add(button3);

        ImageIcon photo4 = new ImageIcon("images\\desc.png");
        JButton desc1 = new JButton(photo4);
        JButton desc2 = new JButton(photo4);
        JButton desc3 = new JButton(photo4);
        desc1.setBounds(190, 90, 70, 50);
        desc1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                easyInfo();
            }
        });
        desc2.setBounds(190, 150, 70, 50);
        desc2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediumInfo();
            }
        });
        desc3.setBounds(190, 210, 70, 50);
        desc3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hardInfo();
            }
        });
        level.add(desc1);
        level.add(desc2);
        level.add(desc3);

        level.getContentPane().setBackground(Color.decode("#E7FFFF"));
        level.setVisible(true);
    }

}
