package quiz;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JTextField nameField;
    JButton rulesBtn, backBtn;

    Login() {
        setTitle("Quiz Application");
        setSize(520, 330);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Simple Minds");
        heading.setBounds(130, 30, 300, 50);
        heading.setFont(new Font("Arial", Font.BOLD, 40));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        JLabel prompt = new JLabel("Enter your name");
        prompt.setBounds(190, 110, 200, 25);
        prompt.setFont(new Font("Arial", Font.BOLD, 18));
        add(prompt);

        nameField = new JTextField();
        nameField.setBounds(140, 150, 230, 30);
        nameField.setFont(new Font("Arial", Font.BOLD, 16));
        add(nameField);

        rulesBtn = new JButton("Rules");
        rulesBtn.setBounds(140, 210, 110, 30);
        rulesBtn.setBackground(new Color(30, 144, 254));
        rulesBtn.setForeground(Color.WHITE);
        rulesBtn.addActionListener(this);
        add(rulesBtn);
        getRootPane().setDefaultButton(rulesBtn);  

        backBtn = new JButton("Exit");
        backBtn.setBounds(260, 210, 110, 30);
        backBtn.setBackground(new Color(30, 144, 254));
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        add(backBtn);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rulesBtn) {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your name");
                return;
            }
            try {
                int userId = getOrCreateUser(name);
                dispose();
                new Rules(name, userId).setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
            }
        } else {
            System.exit(0);
        }
    }

    private int getOrCreateUser(String name) throws Exception {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT id FROM users WHERE name = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            PreparedStatement ins = con.prepareStatement(
                "INSERT INTO users (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            ins.setString(1, name);
            ins.executeUpdate();
            ResultSet keys = ins.getGeneratedKeys();
            keys.next();
            return keys.getInt(1);
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}