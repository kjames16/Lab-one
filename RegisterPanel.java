import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class RegisterPanel extends JPanel {
    private Register register;
    private JPanel inputPanel;
    private JTextField input;
    private PursePanel changePanel;

    public RegisterPanel() {
        register = new Register();
        inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));
        changePanel = new PursePanel();
        //changePanel.setLayout(new BoxLayout(changePanel, BoxLayout.PAGE_AXIS));
       // changePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
       // changePanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        input = new JTextField();
        input.setPreferredSize(new Dimension(200, 50));
        input.addActionListener(new inputListener());




        this.add(inputPanel);
        this.add(input);
        this.add(changePanel);




    }

    private class inputListener
            implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            double amt = Double.parseDouble(input.getText());
            Purse p = register.makeChange(amt);
            changePanel.paintComponent(changePanel.getGraphics(),p);


        }
    }
}
