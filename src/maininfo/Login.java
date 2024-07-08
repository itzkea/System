package maininfo;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    
    JFrame f = new JFrame();
    JLabel lblwelcome, lblaccount, lblusername, lblpassword, lblto, lblsql, lblcount;
    JButton btnlogin, btnsignup;
    JPanel colorpurple, colorviolet;
    JTextField txtadmin;
    JPasswordField txtpass;
    
    int failedAttempts;
    boolean isLocked;
    long lockEndTime;

    public Login() {
        setTitle("MYSQL");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        colorpurple = new JPanel();
        colorpurple.setBounds(350, 0, 800, 600);
        colorpurple.setBackground(new Color(255, 168, 255));
        colorpurple.setLayout(null);
        add(colorpurple);

        colorviolet = new JPanel();
        colorviolet.setBounds(0, 0, 500, 600);
        colorviolet.setBackground(new Color(255, 91, 255));
        colorviolet.setLayout(null);
        add(colorviolet);

        lblusername = new JLabel("Admin ID: ");
        lblusername.setBounds(80, 220, 200, 30);
        lblusername.setFont(new Font("Aptos", Font.PLAIN, 18));
        lblusername.setForeground(Color.BLACK);
        colorpurple.add(lblusername);

        lblpassword = new JLabel("Password: ");
        lblpassword.setBounds(75, 270, 200, 30);
        lblpassword.setFont(new Font("Aptos", Font.PLAIN, 18));
        lblpassword.setForeground(Color.BLACK);
        colorpurple.add(lblpassword);

        lblwelcome = new JLabel("WELCOME");
        lblwelcome.setBounds(40, 170, 500, 50);
        lblwelcome.setFont(new Font("Aptos", Font.BOLD, 50));
        lblwelcome.setForeground(Color.WHITE);
        colorviolet.add(lblwelcome);

        lblto = new JLabel("TO");
        lblto.setBounds(140, 230, 150, 50);
        lblto.setFont(new Font("Aptos", Font.BOLD, 50));
        lblto.setForeground(Color.WHITE);
        colorviolet.add(lblto);

        lblsql = new JLabel("MYSQL");
        lblsql.setBounds(90, 290, 300, 50);
        lblsql.setFont(new Font("Aptos", Font.BOLD, 50));
        lblsql.setForeground(Color.WHITE);
        colorviolet.add(lblsql);

        txtadmin = new JTextField();
        txtadmin.setBounds(170, 220, 150, 30);
        txtadmin.setBackground(Color.WHITE);
        txtadmin.setBorder(null);
        txtadmin.setForeground(Color.BLACK);
        colorpurple.add(txtadmin);

        txtpass = new JPasswordField();
        txtpass.setBounds(170, 270, 150, 30);
        txtpass.setBackground(Color.WHITE);
        txtpass.setBorder(null);
        txtpass.setForeground(Color.BLACK);
        colorpurple.add(txtpass);

        btnlogin = new JButton("Login");
        btnlogin.setBounds(255, 330, 80, 30);
        btnlogin.setBorderPainted(false);
        btnlogin.setBackground(new Color(255, 255, 255));
        btnlogin.setFont(new Font("Aptos", Font.PLAIN, 14));
        colorpurple.add(btnlogin);
        btnlogin.addActionListener(this);

        lblcount = new JLabel();
        lblcount.setBounds(85, 300, 300, 30);
        lblcount.setFont(new Font("Arial", Font.BOLD, 10));
        lblcount.setForeground(Color.RED);
        colorpurple.add(lblcount);

        failedAttempts = 0;
        isLocked = false;

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnlogin) {
            if (isLocked) {
                long currentTime = System.currentTimeMillis();
                if (currentTime >= lockEndTime) {
                    isLocked = false;
                    lblcount.setText("");
                } else {
                    return;
                }
            }

            String Admin = txtadmin.getText();
            String Password = new String(txtpass.getPassword());

            if (validateCredentials(Admin, Password)) {
                this.dispose();
                new Load();
            } else {
                failedAttempts++;
                if (failedAttempts >= 4) {
                    isLocked = true;
                    lockEndTime = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(10); 
                    new LockoutCountdown().execute();
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Login Failed!", "Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private boolean validateCredentials(String adminID, String password) {
        
        return "kea".equals(adminID) && "arciaga".equals(password);
    }

    private class LockoutCountdown extends SwingWorker<Void, Integer> {
        
        @Override
        protected Void doInBackground() throws Exception {
            
            long remainingTime;
            while ((remainingTime = lockEndTime - System.currentTimeMillis()) > 0) {
                publish((int) TimeUnit.MILLISECONDS.toSeconds(remainingTime));
                Thread.sleep(1000);
            }
            return null;
        }

        @Override
        protected void process(java.util.List<Integer> chunks) {
            int secondsLeft = chunks.get(chunks.size() - 1);
            lblcount.setText("So many attempts, please wait for " + secondsLeft + " seconds.");
        }

        @Override
        protected void done() {
            lblcount.setText("");
        }
    }
    
}