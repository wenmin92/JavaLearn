package cc.wenmin92.concurrent.list10_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    private final JButton executeBtn = new JButton("Execute");
    private final JButton cancelBtn = new JButton("Cancel");

    public MyFrame() throws HeadlessException {
        super("MyFrame");

        Container pane = getContentPane();
        pane.setLayout(new FlowLayout());
        pane.add(new JLabel("Two-Phase Termination Sample"));
        pane.add(executeBtn);
        pane.add(cancelBtn);
        executeBtn.addActionListener(this);
        cancelBtn.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == executeBtn) {
            Service.service();
        } else if (e.getSource() == cancelBtn) {
            Service.cancel();
        }
    }
}
