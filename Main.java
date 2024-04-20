import java.util.Scanner;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.color.*;
import java.awt.*;


public class Main extends JFrame{
    private int age, weight, height, max, target;
    private double bmi;
    private String name, solution;
    private JPanel mainPanel;
    private JLabel w0;
    private CardLayout cardLayout;
    public Main() {


        //frame.setLayout(new FlowLayout());
        setSize(new Dimension(500, 500));
        setTitle("Get fit NOW?");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel=new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);
        // Create multiple panels representing different screens
        JPanel screen1 = new JPanel();
        screen1.setLayout(null);
        screen1.add(new JLabel("Screen 1"));

        JPanel screen2 = new JPanel();
        screen2.setLayout(null);
        screen2.add(new JLabel("Screen 2"));

        JPanel screen3 = new JPanel();
        screen3.setLayout(null);
        screen3.add(new JLabel("Screen 3"));

        JPanel screen4 = new JPanel();
        screen4.setLayout(null);
        screen4.add(new JLabel("Screen 4"));

        JPanel screen5 = new JPanel();
        screen5.setLayout(null);
        screen5.add(new JLabel("Screen 5"));
        // Add screens to the main panel with unique names
        mainPanel.add(screen1, "Screen 1");
        mainPanel.add(screen2, "Screen 2");
        mainPanel.add(screen3, "Screen 3");
        mainPanel.add(screen4, "Screen 4");
        mainPanel.add(screen5, "Screen 5");

        JTextField tf1 = new JTextField();
        tf1.setBounds(100, 0, 400, 40);
        JTextField tf2 = new JTextField();
        tf2.setBounds(100, 100, 400, 40);
        JTextField tf3 = new JTextField();
        tf3.setBounds(100, 200, 400, 40);
        JTextField tf4 = new JTextField();
        tf4.setBounds(100, 300, 400, 40);
        JTextField tf5 = new JTextField();
        tf5.setBounds(100, 300, 400, 40);

        JButton button = new JButton("Enter");
        button.setBounds(000,400,500,100);
        JLabel l1  = new JLabel(" Enter Age: ");
        l1.setBounds(0,0,100,40);
        JLabel l2  = new JLabel(" Enter Weight (lbs): ");
        l2.setBounds(0,100,100,40);
        JLabel l3  = new JLabel(" Enter Height (in inches): ");
        l3.setBounds(0,200,100,40);
        JLabel l4  = new JLabel(" Enter Name: ");
        l4.setBounds(0,300,100,40);


        //getContentPane().add(BorderLayout.SOUTH, button);
        getContentPane().add(BorderLayout.CENTER, mainPanel);
        screen1.add(tf1);
        screen1.add(tf2);
        screen1.add(tf3);
        screen1.add(tf4);
        screen1.add(l1);
        screen1.add(l2);
        screen1.add(l3);
        screen1.add(l4);
        screen1.add(tf5);
        screen1.add(button);
        setVisible(true);

        ActionListener enter = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (tf1.getText() == null || tf2.getText() == null || tf3.getText() == null || tf4.getText() == null) {}
                else {
                    age = Integer.parseInt(tf1.getText().toString());
                    System.out.println(age);
                    weight = Integer.parseInt(tf2.getText().toString());
                    System.out.println(weight);
                    height = Integer.parseInt(tf3.getText().toString());
                    System.out.println(height);
                    name = (tf4.getText().toString());
                    System.out.println(name);
                    cardLayout.show(mainPanel, "Screen 2");
                    bmi = 703.0 *((1.0*weight)/Math.pow(height,2));
                    System.out.println(bmi);
                }
            }


        };
        button.addActionListener(enter);


        JLabel s0 = new JLabel("Choose your goal!");
        s0.setBounds(0,0,500,100);

        JButton s1  = new JButton(" Weight Loss ");
        s1.setBounds(0,100,500,100);
        JButton s2  = new JButton(" Sports Performance ");
        s2.setBounds(0,200,500,100);
        JButton s3  = new JButton(" Strength ");
        s3.setBounds(0,300,500,100);

        JLabel d1 = new JLabel("Workout Plan");
        s0.setBounds(0,0,500,100);

        JLabel d2  = new JLabel("Hang Cleans-Set 1: 45lbs x 4-6 Reps\nSet 2: 65lbs x 4-6 Reps\nSet 3: 95lbs x 4-6 Reps ");
        s1.setBounds(0,100,500,100);
        JLabel d3  = new JLabel(" Sports Performance ");
        s2.setBounds(0,200,500,100);
        JLabel d4  = new JLabel(" Strength ");
        s3.setBounds(0,300,500,100);


        screen2.add(s0);
        screen2.add(s1);
        screen2.add(s2);
        screen2.add(s3);
screen4.add(d1);
        screen4.add(d2);
        ActionListener s1c = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solution = "";
                if (bmi >= 25) {
                    solution = "you should aim to hit a BMI of 24.9 by reaching a weight of "+(24.9*(Math.pow(height,2)));
                }
                else if (bmi < 25 && bmi >=18.5) solution = "you are perfectly healthy!";
                else if (bmi < 18.5) solution = "you should aim to hit a BMI of 18.5 by reaching a weight of "+(18.5*(Math.pow(height,2)));
                w0 = new JLabel("At your current weight of "+weight+", and a BMI of "+bmi+", "+solution);
                screen3.add(w0);
                cardLayout.show(mainPanel, "Screen 3");

            }
        };
        s1.addActionListener(s1c);
        ActionListener s2c = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Screen 4");
            }
        };
        s2.addActionListener(s2c);
        ActionListener s3c = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Screen 5");
            }
        };
        s3.addActionListener(s3c);

        w0 = new JLabel("At your current weight of "+weight+", and a BMI of "+bmi+", "+solution);
        w0.setBounds(0,0,500,500);



        JLabel bp1  = new JLabel(" Max Bench Press: ");
        bp1.setBounds(0,0,100,40);
        JLabel bp2  = new JLabel(" Target Bench Press: ");
        bp2.setBounds(0,100,100,40);
        JTextField bpf1 =  new JTextField();
        bpf1.setBounds(100,0,400,40);
        JTextField bpf2 =  new JTextField();
        bpf2.setBounds(100,100,400,40);
        JButton putitin = new JButton("Enter");
        putitin.setBounds(0,300,500,40);


        ActionListener enter2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (bpf1.getText() == null || bpf2.getText() == null) {}
                else {
                    max = Integer.parseInt(bpf1.getText().toString());
                    System.out.println(bpf1);
                    target = Integer.parseInt(bpf2.getText().toString());
                    System.out.println(bpf2);
                    JLabel new = new JLabel
                }
            }


        };
        putitin.addActionListener(enter2);
        screen4.add(bp1);
        screen4.add(bp2);
        screen4.add(bpf1);
        screen4.add(bpf2);
        screen4.add(putitin);
    }
    public static void main(String[] args) {
        new Main();
    }
}



