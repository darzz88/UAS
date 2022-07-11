package View;

import Controller.*;
import Model.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LihatData extends JFrame {

    private DataBaseHandler conn = new DataBaseHandler();
    private String index[] = new String[3];
    JTable table;
    DefaultTableModel model;
    JFrame main;
    JPanel mains;
    JLabel kategori;
    JComboBox kategoriUser;
    JButton btnSearch;
    JButton btnMain;

    public void LihatData() {
        
        main = new JFrame("LIHAT DATA");
        main.setSize(1000, 1000);
        main.setLayout(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);

        mains = new JPanel();
        mains.setBackground(Color.white);
        mains.setSize(1000, 1000);
        mains.setLayout(null);
        mains.setVisible(true);
        
        kategori = new JLabel("PILIH CATEGORY :");
        kategori.setBounds(1, 100, 300, 100);
        kategori.setVisible(true);

        kategoriUser = new JComboBox();
 
        for (int i = 0; i < Controller.getCategoryUser().size(); i++) {
          kategoriUser.addItem(Controller.getCategoryUser().get(i).getNameCategory());
        }
        kategoriUser.setBounds(150, 120, 550, 50);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(100, 600, 100, 50);
        btnSearch.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.LihatUser((int) kategoriUser.getSelectedIndex()+1);     
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
        mains.add(kategori);
        mains.add(kategoriUser);
        mains.add(btnSearch);
        mains.add(btnMain);
     
        main.setVisible(true);     
    }
}
