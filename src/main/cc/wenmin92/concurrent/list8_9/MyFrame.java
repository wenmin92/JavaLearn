package cc.wenmin92.concurrent.list8_9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    private final JLabel label = new JLabel("Event Dispatching Thread Sample");
    private final JButton button = new JButton("countUp");

    public MyFrame() {
        super("MyFrame");
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(label);
        getContentPane().add(button);
        button.addActionListener(e -> {
            if (e.getSource() == button) {
                countUp();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void countUp() {
       new Thread(() -> {
           for (int i = 0; i < 10; i++) {
               System.out.println(Thread.currentThread().getName() + ":countUp:setText(" + i + ")");
               int finalI = i;
               SwingUtilities.invokeLater(() -> label.setText("" + finalI));
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) { }
           }
       }).start();
    }
}
