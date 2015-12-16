package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CalMenu extends Main{
    private JButton calculate,back;
    private JTextField fibbo,fact;
    private JTextField fibboOut,factOut;
    public CalMenu()
    {
        fibbo=new JTextField();
        fibbo.setBounds(5,5,150,30);
        fibbo.setText("Fibonaccis numbers");
        fibbo.setVisible(false);
        fact=new JTextField();
        fact.setBounds(160+50,5,150,30);
        fact.setText("Factorial Numbers");
        fact.setVisible(false);
        calculate=new JButton();
        calculate.setBounds(5,40,150+150+50+5,30);
        calculate.setText("Calculate");
        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try
                {
                    int fibboIn=Integer.parseInt(fibbo.getText());
                    Thread fiboThread=new Thread(new Runnable() {
                        public void run() {
                            fibboOut.setText("" + fibonacci(fibboIn));
                        }
                    });
                    fiboThread.run();
                }
                catch(NumberFormatException ex)
                {
                    fibbo.setText("Not a Number");
                }
                try
                {
                    int factNumber=Integer.parseInt(fact.getText());
                    Thread factThread=new Thread(new Runnable() {
                        public void run() {
                            factOut.setText("" + factorial(factNumber));
                        }
                    });
                    factThread.run();
                }
                catch(NumberFormatException ex)
                {
                    fact.setText("Not a Number");
                }
            }
        });
        fibboOut=new JTextField();
        fibboOut.setBounds(5,75,150,30);
        fibboOut.setEditable(false);
        fibboOut.setVisible(false);
        factOut=new JTextField();
        factOut.setBounds(160+50,75,150,30);
        factOut.setEditable(false);
        factOut.setVisible(true);
        back=new JButton();
        back.setBounds(5,110,150+150+55,30);
        back.setText("Back");
        back.setVisible(false);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                visible(false);
                mainVisible(true);
            }
        });
        frame.add(back);
        frame.add(factOut);
        frame.add(fibboOut);
        frame.add(calculate);
        frame.add(fact);
        frame.add(fibbo);
    }
    public void visible(boolean tf)
    {
        frame.setSize(370,175);
        frame.setTitle("Lesson 11 - Calculator Menu");
        fibbo.setVisible(tf);
        fact.setVisible(tf);
        back.setVisible(tf);
        fibboOut.setVisible(tf);
        factOut.setVisible(tf);
    }
    private int fibonacci (int n)
    {    
        if (n <= 2)        
            return 1;
        else   
            return fibonacci (n - 1) + fibonacci (n - 2);
    }
    private int factorial (int n)
    {    
        if (n == 1)       
            return 1;   
        else       
            return n * factorial (n - 1); 
    }
}
