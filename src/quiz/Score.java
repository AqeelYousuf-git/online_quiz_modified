package quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Score extends JFrame implements ActionListener {

    JButton playAgain, exitBtn;

    Score(String name, double score, int total) {
        setTitle("Score");
        setBounds(0, 0, 600, 380);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        JLabel qno = new JLabel("Thank You " + name + " for playing Simple Minds");
        qno.setBounds(40, 40, 520, 35);
        qno.setFont(new Font("Arial", Font.BOLD, 24));
        add(qno);

        JLabel scorelbl = new JLabel("Your score is " + String.format("%.2f", score) + " / " + total);
        scorelbl.setBounds(40, 120, 500, 40);
        scorelbl.setFont(new Font("Arial", Font.BOLD, 30));
        scorelbl.setForeground(new Color(30, 144, 254));
        add(scorelbl);

        playAgain = new JButton("Play Again");
        playAgain.setBounds(120, 230, 150, 35);
        playAgain.setBackground(new Color(30, 144, 254));
        playAgain.setForeground(Color.WHITE);
        playAgain.addActionListener(this);
        add(playAgain);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(300, 230, 150, 35);
        exitBtn.setBackground(new Color(30, 144, 254));
        exitBtn.setForeground(Color.WHITE);
        exitBtn.addActionListener(this);
        add(exitBtn);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playAgain) {
            this.setVisible(false);
            new Login().setVisible(true);
        } else {
            this.setVisible(false);
            System.exit(0);
        }
    }
}