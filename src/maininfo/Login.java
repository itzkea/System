package maininfo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    
    JFrame f = new JFrame();
    JLabel lblwelcome, lblaccount, lblusername, lblpassword, lblto, lblsql;
    JButton btnlogin, btnsignup;
    JPanel colorpurple, colorviolet;
    JTextField txtadmin;
    JPasswordField txtpass;
    
    Login() {
        setTitle("MYSQL");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        colorpurple = new JPanel();
        colorpurple.setBounds(350,0,800,600);
        colorpurple.setBackground(new Color(255,168,255));
        colorpurple.setLayout(null);
        add(colorpurple);

        colorviolet = new JPanel();
        colorviolet.setBounds(0,0,500,600);
        colorviolet.setBackground(new Color(255,91,255));
        colorviolet.setLayout(null);
        add(colorviolet);

        lblusername = new JLabel("Admin ID: ");
        lblusername.setBounds(80,220,200,30);
        lblusername.setFont(new Font("Aptos", Font.PLAIN, 18));
        lblusername.setForeground(Color.BLACK);
        colorpurple.add(lblusername);

        lblpassword = new JLabel("Password: ");
        lblpassword.setBounds(75,270,200,30);
        lblpassword.setFont(new Font("Aptos", Font.PLAIN, 18));
        lblpassword.setForeground(Color.BLACK);
        colorpurple.add(lblpassword);

        lblwelcome = new JLabel("WELCOME");
        lblwelcome.setBounds(40,170,500,50);
        lblwelcome.setFont(new Font("Aptos", Font.BOLD, 50));
        lblwelcome.setForeground(Color.white);
        colorviolet.add(lblwelcome);

        lblto = new JLabel("TO");
        lblto.setBounds(140,230,150,50);
        lblto.setFont(new Font("Aptos", Font.BOLD, 50));
        lblto.setForeground(Color.WHITE);
        colorviolet.add(lblto);

        lblsql = new JLabel("MYSQL");
        lblsql.setBounds(90,290,300,50);
        lblsql.setFont(new Font("Aptos", Font.BOLD, 50));
        lblsql.setForeground(Color.WHITE);
        colorviolet.add(lblsql);
        
        lblaccount = new JLabel("Don't have an account? ");
        lblaccount.setBounds(50,470,200,30);
        lblaccount.setFont(new Font("Aptos", Font.PLAIN , 14));
        lblaccount.setForeground(Color.BLACK);
        colorviolet.add(lblaccount);
        
        txtadmin = new JTextField();
        txtadmin.setBounds(170,220,150,30);
        txtadmin.setBackground(Color.WHITE);
        txtadmin.setBorder(null);
        txtadmin.setForeground(Color.BLACK);
        colorpurple.add(txtadmin);
     
        txtpass = new JPasswordField();
        txtpass.setBounds(170,270,150,30);
        txtpass.setBackground(Color.WHITE);
        txtpass.setBorder(null);
        txtpass.setForeground(Color.BLACK);
        colorpurple.add(txtpass);
        
        btnlogin = new JButton("Login");
        btnlogin.setBounds(255,330,80,30);
        btnlogin.setBorderPainted(false);
        btnlogin.setBackground(new Color(255,255,255));
        btnlogin.setFont(new Font("Aptos", Font.PLAIN , 14));
        colorpurple.add(btnlogin);
        btnlogin.addActionListener(this); 
        
        btnsignup = new JButton("Sign Up");
        btnsignup.setBounds(210,470,100,30);
        btnsignup.setBorderPainted(false);
        btnsignup.setBackground(new Color(255,255,255));
        btnsignup.setFont(new Font("Aptos", Font.PLAIN , 14));
        colorviolet.add(btnsignup); 
        btnsignup.addActionListener(this);

        setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Admin = txtadmin.getText();
        String Password = txtpass.getText();
                
        if(e.getSource() == btnsignup){
            Signup up = new Signup();
            up.setVisible(true);
            f.dispose();
        
    }
        else if(e.getSource()== btnlogin)
             if (Admin.equals("kea") && Password.equals("arciaga")) {
        {   
            f.dispose();
            Load load = new Load();
            load.setVisible(true);
        } 
             }
             
        else {
        JOptionPane.showMessageDialog(null, "Login Failed!", "Failed", JOptionPane.ERROR_MESSAGE);
    }        
  }
}

    
   
