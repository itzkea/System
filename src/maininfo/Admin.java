package maininfo;

import java.sql.Connection;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Admin extends JFrame implements ActionListener {
    
    JLabel lbladmin, lblpass, MY, WEL,SQL, TO;
    JTextField txtid, txtword;
    JPanel clr,vio;
    JButton reg;
    Connection conn;
    
 Admin(){
     
      try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_cite", "root", ""); 

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection error", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
     
     setTitle("Create Account");
     setSize(800,600);
     setLayout(null);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setLocationRelativeTo(null);
     
     reg = new JButton("Register");
     reg.setBounds(625,330,100,30);
     reg.setBorderPainted(false);
     reg.setBackground(new Color(255, 255, 255));
     add(reg);
     reg.addActionListener(this);
     
     clr = new JPanel();
     clr.setBounds(350, 0, 800, 600);
     clr.setBackground(new Color(255, 168, 255));
     clr.setLayout(null);
     add(clr);

     vio = new JPanel();
     vio.setBounds(0, 0, 500, 600);
     vio.setBackground(new Color(255, 91, 255));
     vio.setLayout(null);
     add(vio);
     
     txtid = new JTextField();
     txtid.setBounds(225,220,150,30);
     txtid.setBackground(Color.WHITE);
     txtid.setBorder(null);
     txtid.setForeground(Color.BLACK);
     clr.add(txtid);
     
     lbladmin = new JLabel("Create Admin ID: ");
     lbladmin.setBounds(60,220,200,30);
     lbladmin.setFont(new Font("Aptos", Font.PLAIN, 18));
     lbladmin.setForeground(Color.BLACK);
     clr.add(lbladmin);
     
     lblpass = new JLabel("Create Password: ");
     lblpass.setBounds(55,270,200,30);
     lblpass.setFont(new Font("Aptos", Font.PLAIN, 18));
     lblpass.setForeground(Color.BLACK);
     clr.add(lblpass);
     
     txtword = new JTextField();
     txtword.setBounds(225,270,150,30);
     txtword.setBackground(Color.WHITE);
     txtword.setBorder(null);
     txtword.setForeground(Color.BLACK);
     clr.add(txtword);
     
     WEL = new JLabel("WELCOME");
     WEL.setBounds(40, 170, 500, 50);
     WEL.setFont(new Font("Aptos", Font.BOLD, 50));
     WEL.setForeground(Color.WHITE);
     vio.add(WEL);

     TO = new JLabel("TO");
     TO.setBounds(140, 230, 150, 50);
     TO.setFont(new Font("Aptos", Font.BOLD, 50));
     TO.setForeground(Color.WHITE);
     vio.add(TO);

     SQL = new JLabel("MYSQL");
     SQL.setBounds(90, 290, 300, 50);
     SQL.setFont(new Font("Aptos", Font.BOLD, 50));
     SQL.setForeground(Color.WHITE);
     vio.add(SQL);
     
     
     
     setVisible(true);
       
       
    
 }   
 
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reg) {
            String adminID = txtid.getText();
            String password = txtword.getText();

            if (adminID.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (registerAdmin(adminID, password)) {
                JOptionPane.showMessageDialog(this, "Registered Successfully!", "Register", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                Login log = new Login();
                log.setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(this, "Registration Failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

   private boolean registerAdmin(String adminID, String password) {
    
        try {
            
            String query = "INSERT INTO `tbl_admin` (admin_id, password) VALUES (?, ?)";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_cite", "root", "");
               PreparedStatement pst = conn.prepareStatement(query);
            
            pst.setString(1, adminID);
            pst.setString(2, password);
            int affectedRows = pst.executeUpdate();
        
            return affectedRows > 0;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}