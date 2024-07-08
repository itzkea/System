package maininfo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Info extends JFrame implements ActionListener {

    JPanel purple;
    DefaultTableModel model;
    JTable table;
    JScrollPane pane;
    JTableHeader header;
    JLabel lblsearch, lbldelete, lblstud, lblln, lblfn, lblmn, lblcourse, lbllevel, lbladd, lblnum, lblday, lblpos, lblaff;
    JButton btnsearch, btndelete, btnlogout, btnreset, btnadd, btnref;
    JTextField txtsearch, txtstud, txtln, txtfn, txtmn, txtcourse, txtcontact, txtbday, txtaff, txtlevel, txtaddress, txtposition;
    Connection conn;

    Info() {

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_cite", "root", "");
            Statement st = conn.createStatement();
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection error", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        setTitle("Information Record");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        lblstud = new JLabel("Student No: ");
        lblstud.setBounds(800, 100, 150, 30);
        lblstud.setFont(new Font("Aptos", Font.PLAIN, 15));
        lblstud.setForeground(Color.BLACK);
        add(lblstud);

        txtstud = new JTextField();
        txtstud.setBounds(950, 100, 150, 30);
        txtstud.setBorder(null);
        txtstud.setForeground(Color.BLACK);
        add(txtstud);

        lblln = new JLabel("Last Name: ");
        lblln.setBounds(800, 150, 150, 30);
        lblln.setFont(new Font("Aptos", Font.PLAIN, 15));
        lblln.setForeground(Color.BLACK);
        add(lblln);

        txtln = new JTextField();
        txtln.setBounds(950, 150, 150, 30);
        txtln.setBorder(null);
        txtln.setForeground(Color.BLACK);
        add(txtln);

        lblfn = new JLabel("First Name: ");
        lblfn.setBounds(800, 200, 150, 30);
        lblfn.setFont(new Font("Aptos", Font.PLAIN, 15));
        lblfn.setForeground(Color.BLACK);
        add(lblfn);

        txtfn = new JTextField();
        txtfn.setBounds(950, 200, 150, 30);
        txtfn.setBorder(null);
        txtfn.setForeground(Color.BLACK);
        add(txtfn);

        lblmn = new JLabel("Middle Name: ");
        lblmn.setBounds(800, 250, 150, 30);
        lblmn.setFont(new Font("Aptos", Font.PLAIN, 15));
        lblmn.setForeground(Color.BLACK);
        add(lblmn);

        txtmn = new JTextField();
        txtmn.setBounds(950, 250, 150, 30);
        txtmn.setBorder(null);
        txtmn.setForeground(Color.BLACK);
        add(txtmn);

        lblcourse = new JLabel("Course: ");
        lblcourse.setBounds(800, 300, 150, 30);
        lblcourse.setFont(new Font("Aptos", Font.PLAIN, 15));
        lblcourse.setForeground(Color.BLACK);
        add(lblcourse);

        txtcourse = new JTextField();
        txtcourse.setBounds(950, 300, 150, 30);
        txtcourse.setBorder(null);
        txtcourse.setForeground(Color.BLACK);
        add(txtcourse);

        lbllevel = new JLabel("Year Level: ");
        lbllevel.setBounds(800, 350, 150, 30);
        lbllevel.setFont(new Font("Aptos", Font.PLAIN, 15));
        lbllevel.setForeground(Color.BLACK);
        add(lbllevel);

        txtlevel = new JTextField();
        txtlevel.setBounds(950, 350, 150, 30);
        txtlevel.setBorder(null);
        txtlevel.setForeground(Color.BLACK);
        add(txtlevel);

        lbladd = new JLabel("Address: ");
        lbladd.setBounds(800, 400, 150, 30);
        lbladd.setFont(new Font("Aptos", Font.PLAIN, 15));
        lbladd.setForeground(Color.BLACK);
        add(lbladd);

        txtaddress = new JTextField();
        txtaddress.setBounds(950, 400, 150, 30);
        txtaddress.setBorder(null);
        txtaddress.setForeground(Color.BLACK);
        add(txtaddress);

        lblnum = new JLabel("Contact No: ");
        lblnum.setBounds(800, 450, 150, 30);
        lblnum.setFont(new Font("Aptos", Font.PLAIN, 15));
        lblnum.setForeground(Color.BLACK);
        add(lblnum);

        txtcontact = new JTextField();
        txtcontact.setBounds(950, 450, 150, 30);
        txtcontact.setBorder(null);
        txtcontact.setForeground(Color.BLACK);
        add(txtcontact);

        lblday = new JLabel("Birthday: ");
        lblday.setBounds(800, 500, 150, 30);
        lblday.setFont(new Font("Aptos", Font.PLAIN, 15));
        lblday.setForeground(Color.BLACK);
        add(lblday);

        txtbday = new JTextField();
        txtbday.setBounds(950, 500, 150, 30);
        txtbday.setBorder(null);
        txtbday.setForeground(Color.BLACK);
        add(txtbday);

        lblpos = new JLabel("Position: ");
        lblpos.setBounds(800, 550, 150, 30);
        lblpos.setFont(new Font("Aptos", Font.PLAIN, 15));
        lblpos.setForeground(Color.BLACK);
        add(lblpos);

        txtposition = new JTextField();
        txtposition.setBounds(950, 550, 150, 30);
        txtposition.setBorder(null);
        txtposition.setForeground(Color.BLACK);
        add(txtposition);

        lblaff = new JLabel("Affiliation: ");
        lblaff.setBounds(800, 600, 150, 30);
        lblaff.setFont(new Font("Aptos", Font.PLAIN, 15));
        lblaff.setForeground(Color.BLACK);
        add(lblaff);

        txtaff = new JTextField();
        txtaff.setBounds(950, 600, 150, 30);
        txtaff.setBorder(null);
        txtaff.setForeground(Color.BLACK);
        add(txtaff);

        btnsearch = new JButton("Search");
        btnsearch.setBounds(150, 40, 100, 30);
        btnsearch.setBorderPainted(false);
        btnsearch.setBackground(new Color(255, 255, 255));
        add(btnsearch);
        btnsearch.addActionListener(this);
        
        btnlogout = new JButton("Logout");
        btnlogout.setBounds(850, 40, 150, 30);
        btnlogout.setBorderPainted(false);
        btnlogout.setBackground(new Color(255, 255, 255));
        add(btnlogout);
        btnlogout.addActionListener(this);

        btnreset = new JButton("Reset");
        btnreset.setBounds(500, 615, 150, 30);
        btnreset.setBorderPainted(false);
        btnreset.setBackground(new Color(255, 255, 255));
        add(btnreset);
        btnreset.addActionListener(this);

        btnadd = new JButton("Add");
        btnadd.setBounds(300, 615, 150, 30);
        btnadd.setBorderPainted(false);
        btnadd.setBackground(new Color(255, 255, 255));
        add(btnadd);
        btnadd.addActionListener(this);
        
        btndelete = new JButton("Delete");
        btndelete.setBounds(100, 615, 150, 30);
        btndelete.setBorderPainted(false);
        btndelete.setBackground(new Color(255, 255, 255));
        add(btndelete);
        btndelete.addActionListener(this); 
        


        txtsearch = new JTextField();
        txtsearch.setBounds(300, 40, 300, 30);
        txtsearch.setBackground(Color.WHITE);
        txtsearch.setBorder(null);
        txtsearch.setForeground(Color.BLACK);
        add(txtsearch);

        String[] header = {"Student Number", "Last Name", "First Name", "Middle Name", "Course", "Year Level", "Address", "Contact Number", "Birthday", "Position", "Affiliation"};

        model = new DefaultTableModel(header, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 90, 750, 500);
        add(scrollPane);

        purple = new JPanel();
        purple.setBounds(0, 0, 1100, 600);
        purple.setBackground(new Color(255, 168, 255));
        add(purple);

        displayData(model);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnlogout) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to Logout?");

            if (choice == JOptionPane.YES_OPTION) {
                dispose();
                Login log = new Login();
                log.setVisible(true);
                log.setResizable(false);
            }

        } else if (e.getSource() == btnreset) {
            txtstud.setText("");
            txtln.setText("");
            txtfn.setText("");
            txtmn.setText("");
            txtcourse.setText("");
            txtlevel.setText("");
            txtaddress.setText("");
            txtcontact.setText("");
            txtbday.setText("");
            txtposition.setText("");
            txtaff.setText("");
            
        } else if (e.getSource() == btnsearch) {
            Search();
        } else if (e.getSource() == btnadd) {
            dispose();
            Add up = new Add();
            up.setVisible(true);
        }
        else if (e.getSource() == btndelete) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String stud_ID = (String)table.getValueAt(selectedRow, 0);
                delete(stud_ID);
            }
        }
    }

    private void Search() {
        String searchNum = txtsearch.getText();
        if (searchNum.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter student number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String query = "SELECT * FROM tbl_cite WHERE stud_ID = ?";
            PreparedStatement withdrawPS = conn.prepareStatement(query);
            withdrawPS.setString(1, searchNum);
            ResultSet withdrawRS = withdrawPS.executeQuery();

            if (withdrawRS.next()) {
                String studnum = withdrawRS.getString("stud_ID");
                String Lastname = withdrawRS.getString("stud_LastName");
                String Firstname = withdrawRS.getString("stud_FirstName");
                String Middle = withdrawRS.getString("stud_MiddleName");
                String course = withdrawRS.getString("Course");
                String yearLevel = withdrawRS.getString("YearLevel");
                String address = withdrawRS.getString("Address");
                String contact = withdrawRS.getString("Contact_No");
                String Bday = withdrawRS.getString("Birthday");
                String position = withdrawRS.getString("Position");
                String aff = withdrawRS.getString("Affiliation");

                txtstud.setText(studnum);
                txtln.setText(Lastname);
                txtfn.setText(Firstname);
                txtmn.setText(Middle);
                txtcourse.setText(course);
                txtlevel.setText(yearLevel);
                txtaddress.setText(address);
                txtcontact.setText(contact);
                txtbday.setText(Bday);
                txtposition.setText(position);
                txtaff.setText(aff);
            } else {
                JOptionPane.showMessageDialog(null, "Student number not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void displayData(DefaultTableModel model) {
        String query = "SELECT * FROM tbl_cite";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                String studnum = rs.getString("stud_ID");
                String Lastname = rs.getString("stud_LastName");
                String Firstname = rs.getString("stud_FirstName");
                String Middle = rs.getString("stud_MiddleName");
                String course = rs.getString("Course");
                String yearLevel = rs.getString("YearLevel");
                String address = rs.getString("Address");
                String contact = rs.getString("Contact_No");
                String Bday = rs.getString("Birthday");
                String position = rs.getString("Position");
                String aff = rs.getString("Affiliation");

                String[] rowData = {studnum, Lastname, Firstname, Middle, course, yearLevel, address, contact, Bday, position, aff};
                model.addRow(rowData);
            }
            table.setBackground(new Color(255, 236, 178));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
   private void delete(String stud_ID) {
        try {
            String sql = "DELETE FROM tbl_cite WHERE stud_ID=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, stud_ID);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                refreshTable();
                JOptionPane.showMessageDialog(null, "Row deleted successfully from database!", "Delete", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void refreshTable() {
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    
        displayData(model);
    }
    
   
}