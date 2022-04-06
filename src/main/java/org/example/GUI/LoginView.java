package org.example.GUI;

import org.example.Presenter.PresenterLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView implements ILoginView {
    private JFrame frame = new JFrame();
    private Container x = new Container();
    private JLabel usr = new JLabel("Username:");
    private JLabel psw = new JLabel("Password:");
    private JTextField t1 = new JTextField();
    private JTextField t2 = new JTextField();
    private JButton b = new JButton("Login");

    public void setUsername(String s) {
        usr.setText(s);
    }

    public String getUsername() {
        return usr.getText();
    }

    public void setPassword(String s) {
        psw.setText(s);
    }

    public String getPassword() {
        return psw.getText();
    }

    //public JButton getB() {
      //  return b;
   // }

    public LoginView() {
        frame.setTitle("Login");
        frame.setBounds(800, 350, 320, 250);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);

        x = frame.getContentPane();
        x.setLayout(null);

        usr.setFont(new Font("Arial", Font.PLAIN, 16));
        usr.setSize(100, 12);
        usr.setLocation(50, 20);
        x.add(usr);

        t1.setFont(new Font("Arial", Font.PLAIN, 20));
        t1.setSize(200, 30);
        t1.setLocation(50, 40);
        x.add(t1);

        psw.setFont(new Font("Arial", Font.PLAIN, 16));
        psw.setSize(100, 12);
        psw.setLocation(50, 80);
        x.add(psw);

        t2.setFont(new Font("Arial", Font.PLAIN, 20));
        t2.setSize(200, 30);
        t2.setLocation(50, 100);
        x.add(t2);

        b.setFont(new Font("Arial", Font.PLAIN, 20));
        b.setSize(135, 30);
        b.setLocation(82, 150);
        x.add(b);

        frame.setVisible(true);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String usrValue = t1.getText();
                String pswValue = t2.getText();
                PresenterLogin.verificareLogin(usrValue, pswValue);
            }
        });
    }
}
