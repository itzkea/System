package maininfo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {
    
    JFrame fr = new JFrame();
    JLabel lblwc, lbltoo, lblmy, lblstud, lblsn, lblmn, lblcourse, lblyl, lbladdress, lblcn, lblbday, lblposition, lblaffiliation;
    JTextField fldID, fldfn, fldmn, fldsn, fldcourse, fldyl, fldaddress, fldcontact, fldbday, fldposition, fldaff;
    JPanel pnlpurple, pnlviolet;
    JButton btnregister;
    JComboBox<String> cbmonth, cbdate, cbyear;
    
    String[] Month = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    String[] Day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String[] Year = {"2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000"};
    Connection conn;
    
    Signup() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_cite", "root", "");
            Statement st = conn.createStatement();
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection error", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } 
        
        setTitle("Register");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        pnlpurple = new JPanel();
        pnlpurple.setBounds(350, 0, 800, 600);
        pnlpurple.setBackground(new Color(255, 168, 255));
        pnlpurple.setLayout(null);
        add(pnlpurple);

        pnlviolet = new JPanel();
        pnlviolet.setBounds(0, 0, 500, 600);
        pnlviolet.setBackground(new Color(255, 91, 255));
        pnlviolet.setLayout(null);
        add(pnlviolet);
        
        lblwc = new JLabel("WELCOME");
        lblwc.setBounds(40, 170, 500, 50);
        lblwc.setFont(new Font("Aptos", Font.BOLD, 50));
        lblwc.setForeground(Color.white);
        pnlviolet.add(lblwc);

        lbltoo = new JLabel("TO");
        lbltoo.setBounds(140, 230, 150, 50);
        lbltoo.setFont(new Font("Aptos", Font.BOLD, 50));
        lbltoo.setForeground(Color.WHITE);
        pnlviolet.add(lbltoo);

        lblmy = new JLabel("MYSQL");
        lblmy.setBounds(90, 290, 300, 50);
        lblmy.setFont(new Font("Aptos", Font.BOLD, 50));
        lblmy.setForeground(Color.WHITE);
        pnlviolet.add(lblmy);
        
        lblstud = new JLabel("Student Number: ");
        lblstud.setBounds(45, 15, 200, 100);
        lblstud.setFont(new Font("Aptos", Font.PLAIN, 18));
        lblstud.setForeground(Color.BLACK);
        pnlpurple.add(lblstud);
        
        lblsn = new JLabel("Last Name: ");
        lblsn.setBounds(90, 55, 200, 100);
        lblsn.setFont(new Font("Aptos", Font.PLAIN, 18));
        lblsn.setForeground(Color.BLACK);
        pnlpurple.add(lblsn);
        
        lblsn = new JLabel("First Name: ");
        lblsn.setBounds(90, 95, 200, 100);
        lblsn.setFont(new Font("Aptos", Font.PLAIN, 18));
        lblsn.setForeground(Color.BLACK);
        pnlpurple.add(lblsn);
        
        lblmn = new JLabel("Middle Name: ");
        lblmn.setBounds(70, 135, 200, 100);
        lblmn.setFont(new Font("Aptos", Font.PLAIN, 18));
        lblmn.setForeground(Color.BLACK);
        pnlpurple.add(lblmn);
        
        lblcourse = new JLabel("Course: ");
        lblcourse.setBounds(115, 175, 200, 100);
        lblcourse.setFont(new Font("Aptos", Font.PLAIN, 18));
        lblcourse.setForeground(Color.BLACK);
        pnlpurple.add(lblcourse);
        
        lblyl = new JLabel("Year Level: ");
        lblyl.setBounds(90, 215, 200, 100);
        lblyl.setFont(new Font("Aptos", Font.PLAIN, 18));
        lblyl.setForeground(Color.BLACK);
        pnlpurple.add(lblyl);
        
        lbladdress = new JLabel("Address: ");
        lbladdress.setBounds(110, 255, 200, 100);
        lbladdress.setFont(new Font("Aptos", Font.PLAIN, 18));
        lbladdress.setForeground(Color.BLACK);
        pnlpurple.add(lbladdress);
        
        lblcn = new JLabel("Contact Number: ");
        lblcn.setBounds(45, 295, 200, 100);
        lblcn.setFont(new Font("Aptos", Font.PLAIN, 18));
        lblcn.setForeground(Color.BLACK);
        pnlpurple.add(lblcn);
        
        lblbday = new JLabel("Birthday: ");
        lblbday.setBounds(110, 335, 200, 100);
        lblbday.setFont(new Font("Aptos", Font.PLAIN, 18));
        lblbday.setForeground(Color.BLACK);
        pnlpurple.add(lblbday);
        
        lblposition = new JLabel("Position: ");
        lblposition.setBounds(110, 375, 200, 100);
        lblposition.setFont(new Font("Aptos", Font.PLAIN, 18));
        lblposition.setForeground(Color.BLACK);
        pnlpurple.add(lblposition);
        
        lblaffiliation = new JLabel("Affiliation: ");
        lblaffiliation.setBounds(105, 415, 200, 100);
        lblaffiliation.setFont(new Font("Aptos", Font.PLAIN, 18));
        lblaffiliation.setForeground(Color.BLACK);
        pnlpurple.add(lblaffiliation);
        
        fldID = new JTextField();
        fldID.setBounds(190, 50, 150, 30);
        fldID.setBackground(Color.WHITE);
        fldID.setBorder(null);
        fldID.setForeground(Color.BLACK);
        pnlpurple.add(fldID);
        
        fldsn = new JTextField();
        fldsn.setBounds(190, 90, 150, 30);
        fldsn.setBackground(Color.WHITE);
        fldsn.setBorder(null);
        fldsn.setForeground(Color.BLACK);
        pnlpurple.add(fldsn);
        
        fldfn = new JTextField();
        fldfn.setBounds(190, 130, 150, 30);
        fldfn.setBackground(Color.WHITE);
        fldfn.setBorder(null);
        fldfn.setForeground(Color.BLACK);
        pnlpurple.add(fldfn);
        
        fldmn = new JTextField();
        fldmn.setBounds(190, 170, 150, 30);
        fldmn.setBackground(Color.WHITE);
        fldmn.setBorder(null);
        fldmn.setForeground(Color.BLACK);
        pnlpurple.add(fldmn);
        
        fldcourse = new JTextField();
        fldcourse.setBounds(190, 210, 150, 30);
        fldcourse.setBackground(Color.WHITE);
        fldcourse.setBorder(null);
        fldcourse.setForeground(Color.BLACK);
        pnlpurple.add(fldcourse);
        
        fldyl = new JTextField();
        fldyl.setBounds(190, 250, 150, 30);
        fldyl.setBackground(Color.WHITE);
        fldyl.setBorder(null);
        fldyl.setForeground(Color.BLACK);
        pnlpurple.add(fldyl);
        
        fldaddress = new JTextField();
        fldaddress.setBounds(190, 290, 150, 30);
        fldaddress.setBackground(Color.WHITE);
        fldaddress.setBorder(null);
        fldaddress.setForeground(Color.BLACK);
        pnlpurple.add(fldaddress);
        
        fldcontact = new JTextField();
        fldcontact.setBounds(190, 330, 150, 30);
        fldcontact.setBackground(Color.WHITE);
        fldcontact.setBorder(null);
        fldcontact.setForeground(Color.BLACK);
        pnlpurple.add(fldcontact);
        
        fldposition = new JTextField();
        fldposition.setBounds(190, 410, 150, 30);
        fldposition.setBackground(Color.WHITE);
        fldposition.setBorder(null);
        fldposition.setForeground(Color.BLACK);
        pnlpurple.add(fldposition);
        
        fldaff = new JTextField();
        fldaff.setBounds(190, 450, 150, 30);
        fldaff.setBackground(Color.WHITE);
        fldaff.setBorder(null);
        fldaff.setForeground(Color.BLACK);
        pnlpurple.add(fldaff);
        
        cbmonth = new JComboBox<>(Month);
        cbmonth.setBounds(190, 370, 90, 30);
        cbmonth.setBackground(Color.WHITE);
        cbmonth.setBorder(null);
        cbmonth.setForeground(Color.BLACK);
        pnlpurple.add(cbmonth);
        
        cbdate = new JComboBox<>(Day);
        cbdate.setBounds(285, 370, 50, 30);
        cbdate.setBackground(Color.WHITE);
        cbdate.setBorder(null);
        cbdate.setForeground(Color.BLACK);
        pnlpurple.add(cbdate);
        
        cbyear = new JComboBox<>(Year);
        cbyear.setBounds(340, 370, 75, 30);
        cbyear.setBackground(Color.WHITE);
        cbyear.setBorder(null);
        cbyear.setForeground(Color.BLACK);
        pnlpurple.add(cbyear);
        
        btnregister = new JButton("Register");
        btnregister.setBounds(260, 500, 100, 30);
        btnregister.setBorderPainted(false);
        btnregister.setBackground(new Color(255, 255, 255));
        pnlpurple.add(btnregister);
        btnregister.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnregister) {
            String studID = fldID.getText();
            String sn = fldsn.getText();
            String fn = fldfn.getText();
            String mn = fldmn.getText();
            String course = fldcourse.getText();
            String yl = fldyl.getText();
            String address = fldaddress.getText();
            String contact = fldcontact.getText();
            String month = (String) cbmonth.getSelectedItem();
            String day = (String) cbdate.getSelectedItem();
            String year = (String) cbyear.getSelectedItem();
            String birthday = year + "-" + month + "-" + day;
            String position = fldposition.getText();
            String affiliation = fldaff.getText();
            
            if (studID.isEmpty() || sn.isEmpty() || fn.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Registration Failed! Please fill in all required fields.", "Register", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                     String query = "INSERT INTO `tbl_cite` (`stud_ID`,`stud_LName`,`stud_FName`,`stud_MName`,`course`,`yearLevel`,`address`,`contactNum`,`BDAY`,`Position`,`Organization`,`Affiliation`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";                   
                     
                     conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_cite", "root", "");
                     PreparedStatement pst = conn.prepareStatement(query);
                    
                    pst.setString(1,fldID.getText());
                    pst.setString(2,fldsn.getText());
                    pst.setString(3,fldfn.getText());
                    pst.setString(4,fldmn.getText());
                    pst.setString(5,fldcourse.getText());
                    pst.setString(6,fldyl.getText());
                    pst.setString(7,fldaddress.getText());
                    pst.setString(8,fldcontact.getText());
                    pst.setString(9,fldbday.getText());
                    pst.setString(10,fldposition.getText());
                    pst.setString(11,fldaff.getText());
                    
                    pst.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Registered Successfully!", "Register", JOptionPane.INFORMATION_MESSAGE);
                    
                    Loadings loads = new Loadings();
                    fr.dispose();
                    
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    
                    JOptionPane.showMessageDialog(null, "Registration Failed! Database error.", "Register", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
