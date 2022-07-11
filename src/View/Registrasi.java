package View;

import Controller.*;
import Model.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Registrasi extends JFrame {
    
    private String index[] = new String[3];
    JFrame main;
    JPanel mains;
    JTextField inputEmail;
    JTextField inputNama;
    JPasswordField inputPassword;
    JComboBox kategoriUser;
    JLabel nama;
    JLabel email;
    JLabel password;
    JLabel kategori;
    JButton btnRegistrasi;
    JButton btnMain;

    public void Registrasi() {
        main = new JFrame("REGISTER");
        main.setSize(1000, 1000);
        main.setLayout(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);

        mains = new JPanel();
        mains.setBackground(Color.white);
        mains.setSize(1000, 1000);
        mains.setLayout(null);
        mains.setVisible(true);

        inputNama = new JTextField();
        inputNama.setBounds(150, 120, 550, 50);

        nama = new JLabel("MASUKAN NAMA : ");
        nama.setBounds(1, 100, 300, 100);
        nama.setVisible(true);

        inputEmail = new JTextField();
        inputEmail.setBounds(150, 220, 550, 50);

        email = new JLabel("MASUKAN EMAIL :");
        email.setBounds(1, 200, 300, 100);
        email.setVisible(true);

        password = new JLabel("MASUKAN PASSWORD :");
        password.setBounds(1, 300, 300, 100);
        password.setVisible(true);

        inputPassword = new JPasswordField();
        inputPassword.setBounds(180, 320, 550, 50);
        
        kategori = new JLabel("PILIH CATEGORY :");
        kategori.setBounds(1, 380, 300, 100);
        kategori.setVisible(true);

        kategoriUser = new JComboBox();
        ArrayList<CategoryUser>category=Controller.getCategoryUser();
        for (int i = 0; i < category.size(); i++) {
            index[i]=category.get(i).getName();
        }
 
        for (int i = 0; i < Controller.getCategoryUser().size(); i++) {
          kategoriUser.addItem(Controller.getCategoryUser().get(i).getNameCategory());
        }
        kategoriUser.setBounds(180, 400, 550, 50);

        btnRegistrasi = new JButton("Registrasi");
        btnRegistrasi.setBounds(100, 600, 100, 50);

        btnRegistrasi.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = String.valueOf(inputPassword.getPassword());
                if (password.length() < 7) {
                    JOptionPane.showMessageDialog(null, "Password minimal 8 karakter !");
                } else {
                    MainMenu main1 = new MainMenu();
                    CategoryUser user = new CategoryUser();
                    user.setName(inputNama.getText());
                    user.setEmail(inputEmail.getText());
                    user.setPassword(String.valueOf(inputPassword.getPassword()));
                    user.setIdCategory(kategoriUser.getSelectedIndex()+1);
                    Controller.Register(user);
                    main1.MainMenu();
                    main.setVisible(false);
                }
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

        mains.add(kategoriUser);
        mains.add(nama);
        mains.add(email);
        mains.add(password);
        mains.add(kategori);
        mains.add(inputNama);
        mains.add(inputEmail);
        mains.add(inputPassword);
        mains.add(btnRegistrasi);
        mains.add(btnMain);

        main.add(mains);
        main.setVisible(true);
    }
}
