package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
    public static JFrame frame=new JFrame("Lesson 11");
    private static JButton calculators,towers;
    private static CalMenu cm;
    private static Towers t;
    public static void main(String[] args) 
    {
        frame.setSize(320,70);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(3);
        frame.setLayout(null);
        calculators=new JButton();
        calculators.setText("Calculators");
        calculators.setBounds(5,5,150,30);
        calculators.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainVisible(false);
                cm.visible(true);
            }
        });
        towers=new JButton();
        towers.setText("Towers");
        towers.setBounds(160,5,150,30);
        towers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainVisible(false);
                t.visible(true);
            }
        });
        t=new Towers();
        cm=new CalMenu();
        frame.add(towers);
        frame.add(calculators);
        frame.setVisible(true);
    }
    public static void mainVisible(boolean tf)
    {
        frame.setSize(320,70);
        frame.setTitle("Lesson 11");
        calculators.setVisible(tf);
        towers.setVisible(tf);
    }
}
