package ChatApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow
{   JFrame frame = new JFrame("ChatApp");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JTextArea input = new JTextArea();
    JButton button = new JButton("Send");

    int width = 600;
    int height = 900;

    JTextArea text = new JTextArea();
    JScrollPane scroll = new JScrollPane(text);

    public ChatWindow(GuestClient c)
    {
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        input.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        scroll.setPreferredSize(new Dimension(width - 40, height - 150));
        panel1.add(scroll);

        frame.add(panel1, BorderLayout.CENTER);

        panel2.setLayout(new BorderLayout());
        panel2.add(input, BorderLayout.CENTER);

        button.addActionListener(e -> {
            c.send(input.getText());
            input.setText(null);
        });
        button.setSize(150,150);
        panel2.add(button, BorderLayout.EAST);
        frame.add(panel2, BorderLayout.SOUTH);

    }

    public void writeBox(String w)
    {
        text.append(w);
    }

}
