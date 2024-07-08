package maininfo;

import java.awt.*;
import javax.swing.*;

public class Load extends JFrame  {
    
    JFrame fr1 = new JFrame();
    JProgressBar jprog;
    JPanel prp;
    JLabel lblwait, lblpup, lblm, lblq;

    Load() {
        
        setTitle("Loading");
        setSize(800, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        ImageIcon logoIcon = new ImageIcon("C:\\Users\\PC\\OneDrive\\Documents\\NetBeansProjects\\MainInfo\\PUP.png");
        JLabel lblLogo = new JLabel(logoIcon);
        lblLogo.setBounds(15, 50, 200, 150);
        add(lblLogo); 
        
        lblpup = new JLabel("Polytechnic University of the Philippines  - Biñan Campus");
        lblpup.setBounds(190, 30, 700, 200);
        lblpup.setFont(new Font("Times New Roman", Font.BOLD, 21));
        lblpup.setForeground(Color.BLACK);
        add(lblpup);
        
        lblm = new JLabel("MY");
        lblm.setBounds(350,200,500,50);
        lblm.setFont(new Font("Impact", Font.BOLD, 60));
        lblm.setForeground(new Color(145, 95, 109));
        add(lblm);
        
        lblq = new JLabel("MYSQL");
        lblq.setBounds(300,250,500,50);
        lblq.setFont(new Font("Impact", Font.BOLD, 60));
        lblq.setForeground(new Color(145, 95, 109));
        add(lblq);
        
        lblwait = new JLabel("Loading data, Please Wait...");
        lblwait.setBounds(100, 280, 200, 200);
        lblwait.setFont(new Font("Impact", Font.PLAIN, 15));
        lblwait.setForeground(new Color(145, 95, 109));
        add(lblwait);
        
        prp = new JPanel();
        prp.setBounds(0, 0, 800, 600);
        prp.setBackground(new Color(255, 168, 255));
        add(prp);
      
        jprog = new JProgressBar();
        jprog.setString("Loading...");
        jprog.setBounds(100, 400, 600, 30);
        jprog.setFont(new Font("Aptos", Font.BOLD, 12));
        jprog.setStringPainted(true);
        jprog.setBackground(new Color(245, 247, 207));
        jprog.setForeground(new Color(255, 91, 255));
        add(jprog);
        
        setVisible(true);
        new BackgroundTask().execute();
    }

    private class BackgroundTask extends SwingWorker<Void, Integer> {
        @Override
        protected Void doInBackground() throws Exception {
            int i = 0;
            while (i < 100) {
                publish(i + 6);
                Thread.sleep(200);
                i += 10;
            }
            return null;
        }

        @Override
        protected void process(java.util.List<Integer> chunks) {
            int value = chunks.get(chunks.size() - 1);
            jprog.setValue(value);
        }

        @Override
        protected void done() {
            Load.this.dispose();
            fr1.dispose();
            Info infos = new Info();
            infos.setVisible(true);  
            jprog.setValue(100);
        }
    }
}