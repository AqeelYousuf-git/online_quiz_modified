package quiz;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class Quiz extends JFrame implements ActionListener {

    String name;
    int userId;

    ArrayList<String[]> questions = new ArrayList<>();   
    ArrayList<boolean[]> correct = new ArrayList<>();    
    boolean[][] selected;                                
    int current = 0;
    int timeLeft = 15;
    javax.swing.Timer timer;

    JLabel qNoLabel, questionLabel, hintLabel, timerLabel;
    JCheckBox[] options = new JCheckBox[4];              
    JButton nextBtn, submitBtn;

    Quiz(String name, int userId) {
        this.name = name;
        this.userId = userId;
        loadQuestions();
        selected = new boolean[questions.size()][4];

        setTitle("Quiz");
        setSize(800, 480);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        qNoLabel = new JLabel();
        qNoLabel.setBounds(40, 40, 50, 30);
        qNoLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        add(qNoLabel);

        questionLabel = new JLabel();
        questionLabel.setBounds(90, 30, 660, 60);
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        add(questionLabel);

        hintLabel = new JLabel();
        hintLabel.setBounds(90, 92, 500, 22);
        hintLabel.setFont(new Font("Arial", Font.ITALIC, 15));
        hintLabel.setForeground(new Color(30, 144, 254));
        add(hintLabel);

        for (int i = 0; i < 4; i++) {
            options[i] = new JCheckBox();
            options[i].setBounds(90, 125 + i * 42, 600, 32);
            options[i].setFont(new Font("Arial", Font.PLAIN, 18));
            options[i].setBackground(Color.WHITE);
            add(options[i]);
        }

        timerLabel = new JLabel();
        timerLabel.setBounds(90, 310, 400, 30);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        timerLabel.setForeground(Color.RED);
        add(timerLabel);

        nextBtn = makeButton("Next", 90, 370, 110);
        submitBtn = makeButton("Submit", 220, 370, 110);

        showQuestion();

        timer = new javax.swing.Timer(1000, ev -> {
            timeLeft--;
            timerLabel.setText("Time left - " + timeLeft + " seconds");
            if (timeLeft <= 0) {
                goNext();           
            }
        });
        timer.start();
    }

    private JButton makeButton(String text, int x, int y, int w) {
        JButton b = new JButton(text);
        b.setBounds(x, y, w, 35);
        b.setBackground(new Color(30, 144, 254));
        b.setForeground(Color.WHITE);
        b.addActionListener(this);
        add(b);
        return b;
    }

    private void loadQuestions() {
       String sql = "SELECT q.question, q.opt1, q.opt2, q.opt3, q.opt4, q.correct_options "
           + "FROM questions q "
           + "JOIN (SELECT MIN(id) AS id FROM questions "
           + "      GROUP BY LOWER(TRIM(question))) unique_questions "
           + "ON q.id = unique_questions.id "
           + "ORDER BY RAND() LIMIT 10";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                questions.add(new String[]{rs.getString(1), rs.getString(2), rs.getString(3),
                                           rs.getString(4), rs.getString(5)});

                boolean[] ok = new boolean[4];
                for (String part : rs.getString(6).split(",")) {
                    ok[Integer.parseInt(part.trim()) - 1] = true;  
                }
                correct.add(ok);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
            System.exit(0);
        }
        if (questions.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No questions found in the database.");
            System.exit(0);
        }
    }

    private int countCorrect(int q) {
        int n = 0;
        for (boolean b : correct.get(q)) {
            if (b) n++;
        }
        return n;
    }

    private void showQuestion() {
        String[] q = questions.get(current);
        qNoLabel.setText((current + 1) + ".");
        questionLabel.setText("<html>" + q[0] + "</html>");

        int n = countCorrect(current);
        hintLabel.setText("Select " + n + " correct answer" + (n > 1 ? "s" : ""));

        for (int i = 0; i < 4; i++) {
            options[i].setText(q[i + 1]);
            options[i].setSelected(false);
        }
        boolean last = (current == questions.size() - 1);
        nextBtn.setEnabled(!last);
        submitBtn.setEnabled(last);
        timeLeft = 15;
        timerLabel.setText("Time left - " + timeLeft + " seconds");
    }

    private void recordAnswer() {
        for (int i = 0; i < 4; i++) {
            selected[current][i] = options[i].isSelected();
        }
    }

    private void goNext() {
        recordAnswer();
        if (current == questions.size() - 1) {
            finishQuiz();
        } else {
            current++;
            showQuestion();
        }
    }

    private double marksFor(int q) {
        int n = 0, right = 0, wrong = 0;
        for (int i = 0; i < 4; i++) {
            if (correct.get(q)[i]) {
                n++;
                if (selected[q][i]) right++;
            } else if (selected[q][i]) {
                wrong++;
            }
        }
        return Math.max(0, (double) (right - wrong) / n);
    }

        private void finishQuiz() {
        timer.stop();
        double score = 0;
        for (int i = 0; i < questions.size(); i++) {
            score += marksFor(i);
        }
        score = Math.round(score * 100) / 100.0;      
        saveResult(score);
        dispose();
        new Score(name, score, questions.size()).setVisible(true);
    }

    private void saveResult(double score) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                 "INSERT INTO results (user_id, score, total) VALUES (?, ?, ?)")) {
            ps.setInt(1, userId);
            ps.setDouble(2, score);
            ps.setInt(3, questions.size());
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Could not save result: " + e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent e) {
        goNext();      
    }
}