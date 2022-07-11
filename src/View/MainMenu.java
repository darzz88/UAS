/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.*;
import Model.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainMenu extends JFrame {

    JFrame main;
    JLabel label1;
    JPanel mains;
    JButton btnLogin;
    JButton btnRegister;
    JButton btnDataPengguna;
    JLabel title;

    public void MainMenu() {

        main = new JFrame("MAIN MENU");
        main.setSize(1000, 1000);
        main.setLayout(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);

        mains = new JPanel();
        mains.setBackground(Color.white);
        mains.setSize(1000, 1000);
        mains.setLayout(null);
        mains.setVisible(true);
        
        ImageIcon img = new ImageIcon("tes.jpg");
        label1 = new JLabel(img);
        label1.setBounds(300, 10, 200, 100);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(300, 200, 200, 50);
        btnLogin.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                login.Login();
                main.setVisible(false);
            }
        });

        btnRegister = new JButton("Registrasi");
        btnRegister.setBounds(300, 300, 200, 50);

        btnRegister.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registrasi registrasi = new Registrasi();
                registrasi.Registrasi();
                main.setVisible(false);
            }
        });

        btnDataPengguna = new JButton("Lihat Data Pengguna");
        btnDataPengguna.setBounds(300, 400, 200, 50);
        btnDataPengguna.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LihatData lihatdata = new LihatData();
                lihatdata.LihatData();
                main.setVisible(false);
            }
        });
        
        main.add(mains);
        mains.add(label1);
        mains.add(btnLogin);
        mains.add(btnRegister);
        mains.add(btnDataPengguna);
    }
}
