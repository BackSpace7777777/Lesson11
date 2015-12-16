package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Towers extends Main{
    private int numberOfMoves=0;
    private JTextField in;
    private JButton submit,back;
    private Thread t;
    public Towers()
    {
        in=new JTextField();
        in.setBounds(5,5,150,30);
        in.setText("Enter number of rings 3-10");
        in.setVisible(false);
        submit=new JButton();
        submit.setText("Submit");
        submit.setBounds(160,5,150,30);
        submit.setVisible(false);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t=new Thread(new Runnable() {
                    public void run() {
                        try
                        {
                            int tempIn=Integer.parseInt(in.getText());
                            if(tempIn<3||tempIn>10)
                            {
                                in.setText("Not between 3 and 10");
                            }
                            else
                            {
                                move(tempIn,1,3,2);
                                frame.setTitle("Lesson 11 - Towers of Hanoi, it took " + numberOfMoves + " moves");
                            }
                        }
                        catch(NumberFormatException ex)
                        {
                            in.setText("Not a number");
                        }
                    }
                });
                t.run();
            }
        });
        back=new JButton();
        back.setText("Back");
        back.setBounds(315,5,150,30);
        back.setVisible(false);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                visible(false);
                mainVisible(true);
            }
        });
        frame.add(back);
        frame.add(submit);
        frame.add(in);
    }
    public void visible(boolean tf)
    {
        frame.setSize(640,70);
        frame.setTitle("Lesson 11 - Towers of Hanoi");
        in.setVisible(tf);
        submit.setVisible(tf);
        back.setVisible(tf);
    }
    private void move(int numberOfRings,int i,int j,int k)
    {
        if(numberOfRings>0)
        {
            numberOfMoves++;
            move(numberOfRings-1,i,j,k);
            move(numberOfRings-1,k,j,i);
        }
    }
}
