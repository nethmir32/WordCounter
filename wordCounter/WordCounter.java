import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounter extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton countButton;
    private JLabel resultLabel;

    public WordCounter() {
        setTitle("Word Counter");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        textField = new JTextField(20);
        countButton = new JButton("Count Words");
        resultLabel = new JLabel("Number of words: ");

        countButton.addActionListener(this);

        add(textField);
        add(countButton);
        add(resultLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countButton) {
            String text = textField.getText();
            int wordCount = countWords(text);
            resultLabel.setText("Number of words: " + wordCount);
        }
    }

    private int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        new WordCounter();
    }
}
