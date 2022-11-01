package Sprint_3.Lektion_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SwingTest2 extends JFrame implements ActionListener {

    JLabel l1 = new JLabel("Hej Magnus");
    JButton b1 = new JButton("Tryck här");

    JLabel l2 = new JLabel("Hej Elefanten!");
    JButton b2 = new JButton("Tryck inte här");
    JLabel l3 = new JLabel("Hej Sigge");
    JButton b3 = new JButton("Tryck kanske här");
    JPanel p1 = new JPanel();
    JPanel np = new JPanel();
    JPanel sp = new JPanel();
    JPanel cp = new JPanel();
    JPanel ep = new JPanel();

    SwingTest2() {
        p1.setLayout(new BorderLayout(3, 2));
        add(p1);
        p1.add(np, BorderLayout.NORTH);
        p1.add(sp,BorderLayout.SOUTH);
        p1.add(cp,BorderLayout.CENTER);
        p1.add(ep, BorderLayout.EAST);
        b1.addActionListener(this);
        b3.addActionListener(this);
        b1.setForeground(Color.GREEN);
        ep.add(b1);
        ep.setBackground(Color.ORANGE);
        np.add(l1);
        cp.add(l2);
        cp.setBackground(Color.YELLOW);
        np.add(b2);
        sp.add(l3);
        sp.add(b3);
        pack();

        setLocation(300, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l2.setForeground(Color.red);


        p1.setBackground(Color.LIGHT_GRAY);


    }

    public static void main(String[] args) {
        SwingTest2 st2 = new SwingTest2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object b = e.getSource();
        if(b==b1) {
            if (l2.getText().equalsIgnoreCase("Hej Elefanten!")) {
                l2.setText(("Hej Myran!"));
            } else {
                l2.setText("Hej Elefanten!");
            }
        }else if(b==b3){
            if(l3.getText().equalsIgnoreCase("Hej Sigge")){
                l3.setText("Hej Johan");
            }else {
                l3.setText("Hej Sigge");
            }
        }

    }
}
