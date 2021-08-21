package practice.swing;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyFrom extends JFrame{
    private JButton button1;
    private JPanel MyPanel;
    private JLabel MyLabel;

    public MyFrom() {
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                MyLabel.setText("Hello Wordl!!");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyFrom");
        frame.setContentPane(new MyFrom().MyPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}