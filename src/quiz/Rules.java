package quiz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rules extends JFrame implements ActionListener {

    String name;
    int userId;
    JButton startBtn, backBtn;

    Rules(String name, int userId) {
        this.name = name;
        this.userId = userId;

        setTitle("Rules");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Welcome " + name + " to Simple Minds");
        heading.setBounds(50, 20, 600, 35);
        heading.setFont(new Font("Arial", Font.BOLD, 26));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        JLabel rules = new JLabel(
            "<html>"
            + "1. The quiz contains 10 questions.<br><br>"
            + "2. Each question has a duration of 15 seconds.<br><br>"
            + "3. Some questions may have more than one correct answer. Tick all of them.<br>"
            + "&nbsp;&nbsp;&nbsp;Each correct tick gains marks and each incorrect tick loses marks (with a minimum of 0 per question).<br><br>"
            + "4. Unanswered questions receive zero marks.<br><br>"
            + "5. Upon submission, your score is recorded in the database."
            + "</html>");
        rules.setBounds(50, 80, 600, 280);
        rules.setFont(new Font("Arial", Font.PLAIN, 16));
        add(rules);

        backBtn = new JButton("Back");
        backBtn.setBounds(250, 390, 100, 30);
        backBtn.setBackground(new Color(30, 144, 254));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        add(backBtn);

        startBtn = new JButton("Start");
        startBtn.setBounds(400, 390, 100, 30);
        startBtn.setBackground(new Color(30, 144, 254));
        startBtn.setForeground(Color.WHITE);
        startBtn.addActionListener(this);
        add(startBtn);
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
        if (e.getSource() == startBtn) {
            new Quiz(name, userId).setVisible(true);
        } else {
            new Login().setVisible(true);
        }
    }
}