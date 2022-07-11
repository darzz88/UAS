package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Controller.*;
import Model.*;

public class Login extends JFrame {

    JFrame main;
    JPanel mains;
    JTextField inputEmail;
    JPasswordField inputPassword;
    JButton btnLogin;
    JButton btnMain;
    JLabel email;
    JLabel password;
    JComboBox categoryUser;

    public void Login() {
        main = new JFrame("LOGIN");
        main.setSize(1000, 1000);
        main.setLayout(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);

        mains = new JPanel();
        mains.setBackground(Color.white);
        mains.setSize(1000, 1000);
        mains.setLayout(null);
        mains.setVisible(true);

        email = new JLabel("MASUKAN EMAIL : ");
        email.setBounds(1, 70, 300, 100);
        email.setVisible(true);

        inputEmail = new JTextField("");
        inputEmail.setBounds(120, 100, 550, 50);

        password = new JLabel("MASUKAN PASSWORD : ");
        password.setBounds(1, 175, 300, 100);
        password.setVisible(true);

        inputPassword = new JPasswordField("");
        inputPassword.setBounds(150, 200, 550, 50);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(100, 600, 100, 50);
        btnLogin.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.LogIn(inputEmail.getText(), String.valueOf(inputPassword.getPassword()));      
                main.setVisible(false);
            }
        });

        btnMain = new JButton("Back");
        btnMain.setBounds(200, 600, 100, 50);
        btnMain.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu main1 = new MainMenu();
                main1.MainMenu();
                main.setVisible(false);
            }
        });
        main.add(mains);
        mains.add(inputEmail);
        mains.add(inputPassword);
        mains.add(email);
        mains.add(password);
        mains.add(btnLogin);
        mains.add(btnMain);
    }

}
