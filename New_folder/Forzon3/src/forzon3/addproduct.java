/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forzon3;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

/**
 *
 * @author chaitany
 */
public class addproduct extends javax.swing.JPanel {
     public void resize1(JLabel a,BufferedImage d){
      ImageIcon myimage1=new ImageIcon(d);
        Image img3=myimage1.getImage();
        Image img4=img3.getScaledInstance(a.getHeight(),a.getWidth(),Image.SCALE_SMOOTH);
        ImageIcon i11=new ImageIcon(img4);   
       a.setIcon(i11);
}
 public String s="", Icode="";
 public  ResultSet rs=null;
    public Connection  con=null;
    public PreparedStatement pst=null;
      public PreparedStatement pst1=null;
     public void connection(){
     try{
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/froze","root","");
    
      }
          catch(Exception e){
    System.out.println(e);    
        }
      }
       public void swithPanel(JPanel panel){
        jLayeredPane1.removeAll();
        jLayeredPane1.add(panel);
        jLayeredPane1.repaint();
        jLayeredPane1.revalidate();
    }
       public void resize(JLabel a,String d){
      ImageIcon myimage1=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(d)));
        Image img3=myimage1.getImage();
        Image img4=img3.getScaledInstance( a.getWidth(),a.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon i11=new ImageIcon(img4);   
       a.setIcon(i11);
}
    public void autoitemcode(){
         int ord=0;
         
        try{
        connection();
          pst=con.prepareStatement("SELECT * FROM `item`");
     rs=pst.executeQuery();
     
     while(rs.next()){
         ord=rs.getInt("sr_no");
     }
     ord=ord+1;
     Icode="I0"+ord;
     System.out.print(Icode);
    jLabel6.setText(Icode);
     
     }catch(Exception e){
         System.out.print(e);
     }
  
    }   
    /**
     * Creates new form addproduct
     */
    public addproduct() {
        initComponents();
        autoitemcode();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 255, 51));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADD NEW PRODUCT");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1695, 50);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 1695, 50);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ADD");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 0, 5, new java.awt.Color(204, 51, 255)));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 0, 565, 50);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("UPDATE");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(204, 51, 255)));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3);
        jLabel3.setBounds(565, 0, 565, 50);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DELETE");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(204, 51, 255)));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4);
        jLabel4.setBounds(1130, 0, 565, 50);

        add(jPanel2);
        jPanel2.setBounds(0, 50, 1695, 50);

        jLayeredPane1.setLayout(new java.awt.CardLayout());

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 5, 5, new java.awt.Color(204, 51, 255)));
        jPanel3.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 255, 51));
        jLabel5.setText("PRODUCT CODE:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(50, 50, 465, 50);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 51, 255));
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel3.add(jLabel6);
        jLabel6.setBounds(50, 100, 465, 50);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 255, 51));
        jLabel7.setText("PRODUCT NAME:");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(50, 150, 465, 50);

        jTextField1.setBackground(new java.awt.Color(51, 51, 51));
        jTextField1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(204, 51, 255));
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jTextField1.setOpaque(false);
        jPanel3.add(jTextField1);
        jTextField1.setBounds(50, 200, 465, 50);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 255, 51));
        jLabel8.setText("DISCRIPTION:");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(50, 250, 465, 50);

        jTextArea1.setBackground(new java.awt.Color(51, 51, 51));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(204, 51, 255));
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jTextArea1.setOpaque(false);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(50, 300, 465, 330);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 51));
        jLabel9.setText("PRICE:");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(565, 50, 465, 50);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forzon3/DEFAULT ICE CREAM.png"))); // NOI18N
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51), 5));
        jPanel3.add(jLabel10);
        jLabel10.setBounds(1080, 50, 565, 565);

        jTextField2.setBackground(new java.awt.Color(51, 51, 51));
        jTextField2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(204, 51, 255));
        jTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jTextField2.setOpaque(false);
        jPanel3.add(jTextField2);
        jTextField2.setBounds(565, 100, 465, 50);

        jButton1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton1.setText("BROWSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(565, 360, 465, 50);

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton2.setText("CLEAR ALL");
        jPanel3.add(jButton2);
        jButton2.setBounds(565, 460, 465, 50);

        jButton3.setBackground(new java.awt.Color(0, 255, 51));
        jButton3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton3.setText("ADD PRODUCT");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(565, 560, 465, 50);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 255, 51));
        jLabel11.setText("ADD IMAGE:");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(565, 300, 465, 50);

        jLayeredPane1.add(jPanel3, "card2");

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 5, 5, new java.awt.Color(204, 51, 255)));
        jPanel4.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 255, 51));
        jLabel12.setText("PRODUCT CODE:");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(50, 50, 465, 50);

        jLabel14.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 255, 51));
        jLabel14.setText("PRODUCT NAME:");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(50, 150, 465, 50);

        jTextField3.setBackground(new java.awt.Color(51, 51, 51));
        jTextField3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(204, 51, 255));
        jTextField3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jTextField3.setOpaque(false);
        jPanel4.add(jTextField3);
        jTextField3.setBounds(50, 200, 465, 50);

        jLabel15.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 255, 51));
        jLabel15.setText("DISCRIPTION:");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(50, 250, 465, 50);

        jTextArea2.setBackground(new java.awt.Color(51, 51, 51));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(204, 51, 255));
        jTextArea2.setRows(5);
        jTextArea2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jTextArea2.setOpaque(false);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(50, 300, 465, 330);

        jLabel16.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 255, 51));
        jLabel16.setText("PRICE:");
        jPanel4.add(jLabel16);
        jLabel16.setBounds(565, 50, 465, 50);

        jTextField4.setBackground(new java.awt.Color(51, 51, 51));
        jTextField4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(204, 51, 255));
        jTextField4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jTextField4.setOpaque(false);
        jPanel4.add(jTextField4);
        jTextField4.setBounds(565, 100, 465, 50);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forzon3/DEFAULT ICE CREAM.png"))); // NOI18N
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51), 5));
        jPanel4.add(jLabel17);
        jLabel17.setBounds(1080, 50, 565, 565);

        jButton4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton4.setText("BROWSE");
        jPanel4.add(jButton4);
        jButton4.setBounds(565, 360, 465, 50);

        jButton5.setBackground(new java.awt.Color(0, 255, 51));
        jButton5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton5.setText("RESET CHANGES");
        jPanel4.add(jButton5);
        jButton5.setBounds(565, 460, 465, 50);

        jButton6.setBackground(new java.awt.Color(255, 51, 51));
        jButton6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton6.setText("IMPLEMENT CHANGES");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6);
        jButton6.setBounds(565, 560, 465, 50);

        jLabel18.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 255, 51));
        jLabel18.setText("ADD IMAGE:");
        jPanel4.add(jLabel18);
        jLabel18.setBounds(565, 300, 465, 50);

        jButton7.setBackground(new java.awt.Color(204, 51, 255));
        jButton7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton7.setText("SEARCH");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton7);
        jButton7.setBounds(465, 100, 50, 50);

        jTextField5.setBackground(new java.awt.Color(51, 51, 51));
        jTextField5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(204, 51, 255));
        jTextField5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel4.add(jTextField5);
        jTextField5.setBounds(50, 100, 410, 50);

        jLayeredPane1.add(jPanel4, "card2");

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 5, 5, new java.awt.Color(204, 51, 255)));
        jPanel5.setLayout(null);

        jLabel13.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 255, 51));
        jLabel13.setText("PRODUCT CODE:");
        jPanel5.add(jLabel13);
        jLabel13.setBounds(50, 50, 465, 50);

        jLabel19.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 255, 51));
        jLabel19.setText("PRODUCT NAME:");
        jPanel5.add(jLabel19);
        jLabel19.setBounds(50, 150, 465, 50);

        jLabel20.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 255, 51));
        jLabel20.setText("DISCRIPTION:");
        jPanel5.add(jLabel20);
        jLabel20.setBounds(50, 250, 465, 50);

        jTextArea3.setEditable(false);
        jTextArea3.setBackground(new java.awt.Color(51, 51, 51));
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextArea3.setForeground(new java.awt.Color(204, 51, 255));
        jTextArea3.setRows(5);
        jTextArea3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jTextArea3.setOpaque(false);
        jScrollPane3.setViewportView(jTextArea3);

        jPanel5.add(jScrollPane3);
        jScrollPane3.setBounds(50, 300, 465, 330);

        jLabel21.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 255, 51));
        jLabel21.setText("PRICE:");
        jPanel5.add(jLabel21);
        jLabel21.setBounds(565, 50, 465, 50);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forzon3/DEFAULT ICE CREAM.png"))); // NOI18N
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51), 5));
        jPanel5.add(jLabel22);
        jLabel22.setBounds(1080, 50, 565, 565);

        jButton8.setBackground(new java.awt.Color(255, 51, 51));
        jButton8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton8.setText("DELETE");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton8);
        jButton8.setBounds(565, 580, 465, 50);

        jLabel23.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 255, 51));
        jLabel23.setText("ICE CREAM IMAGE :");
        jPanel5.add(jLabel23);
        jLabel23.setBounds(1080, 0, 565, 50);

        jButton11.setBackground(new java.awt.Color(204, 51, 255));
        jButton11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton11.setText("SEARCH");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton11);
        jButton11.setBounds(465, 100, 50, 50);

        jTextField8.setBackground(new java.awt.Color(51, 51, 51));
        jTextField8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(204, 51, 255));
        jTextField8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel5.add(jTextField8);
        jTextField8.setBounds(50, 100, 410, 50);

        jLabel24.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 51, 255));
        jLabel24.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel5.add(jLabel24);
        jLabel24.setBounds(50, 200, 465, 50);

        jLabel25.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 51, 255));
        jLabel25.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel5.add(jLabel25);
        jLabel25.setBounds(565, 100, 465, 50);

        jLayeredPane1.add(jPanel5, "card2");

        add(jLayeredPane1);
        jLayeredPane1.setBounds(0, 100, 1695, 675);
    }// </editor-fold>//GEN-END:initComponents
 public void labellB(JLabel label1){
        jLabel2.setBorder(null);
        jLabel3.setBorder(null);
        jLabel4.setBorder(null);
           Color myWhite1 = new Color(204,51,255); 
            label1.setBorder(new MatteBorder(3, 3, 0, 3, myWhite1)); 
}
   public void labellB1(){
     
           Color myWhite1 = new Color(204,51,255); 
            jLabel2.setBorder(new MatteBorder(0, 0, 3, 0, myWhite1)); 
           jLabel3.setBorder(new MatteBorder(0, 0, 3, 0, myWhite1)); 
 jLabel4.setBorder(new MatteBorder(0, 0, 3, 0, myWhite1)); 

   }
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
swithPanel(jPanel4);
jLabel1.setText("UPDATE PRODUCT");
Color myWhite1 = new Color(204,51,255); 
labellB(jLabel3);   
jLabel2.setBorder(new MatteBorder(0, 0, 3, 0, myWhite1)); 
 jLabel4.setBorder(new MatteBorder(0, 0, 3, 0, myWhite1)); 

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
swithPanel(jPanel5);
jLabel1.setText("DELETE PRODUCT");
Color myWhite1 = new Color(204,51,255); 
labellB(jLabel4);  
jLabel2.setBorder(new MatteBorder(0, 0, 3, 0, myWhite1)); 
 jLabel3.setBorder(new MatteBorder(0, 0, 3, 0, myWhite1)); 
 
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
swithPanel(jPanel3);
jLabel1.setText("ADD NEW PRODUCT");
Color myWhite1 = new Color(204,51,255); 
labellB(jLabel2);   
jLabel3.setBorder(new MatteBorder(0, 0, 3, 0, myWhite1)); 
 jLabel4.setBorder(new MatteBorder(0, 0, 3, 0, myWhite1)); 
   
 // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
JFileChooser chooser = new JFileChooser(); // filechooser object
          
            int option = chooser.showOpenDialog(this); // same as before but with open this time. ok w8
            if(option == JFileChooser.APPROVE_OPTION) {
               s=chooser.getSelectedFile().getAbsolutePath();
               System.out.print(chooser.getSelectedFile().getAbsolutePath());
                 ImageIcon icon = new ImageIcon(s);
            Image img = icon.getImage();
            Image newImg = img.getScaledInstance(jLabel10.getWidth(), jLabel10.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newImc = new ImageIcon(newImg);        
jLabel10.setIcon(newImc);
              //Problem is i havent used file filter in a while so i mite do something wrong. ok
                // close the scanner for memory purposes.
            }
  
  
      
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        
try{
             connection();
                pst=con.prepareStatement("INSERT INTO `item`(`item_code`, `item_name`, `item_img`, `price`, `discription`)values(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);        
            pst.setString(1,jLabel6.getText());
            pst.setString(2, jTextField1.getText());
              File fimg = new File(s); 
              InputStream in = new FileInputStream(fimg);

          pst.setBlob(3,in);
            pst.setString(4,jTextField2.getText());
            pst.setString(5, jTextArea1.getText());
            
            pst.executeUpdate();
                 JOptionPane.showMessageDialog(this,"Add"); 
 
}
catch(SQLException ex){
  System.out.print(ex);   
}    catch (FileNotFoundException ex) {
         Logger.getLogger(addproduct.class.getName()).log(Level.SEVERE, null, ex);
     }
 autoitemcode();
 jTextField1.setText("");
 jTextField2.setText("");
 jTextArea1.setText("");
 jLabel10.setIcon(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        try{
        connection();
        System.out.println("UPDATE `item` SET `item_code`='"+jTextField5.getText()+"',`item_name`='"+jTextField3.getText()+"',`price`='"+jTextField4.getText()+"',`discription`='"+jTextArea2.getText()+"' WHERE `item_code`='"+jTextField5.getText()+"'");
          pst=con.prepareStatement("UPDATE `item` SET `item_code`='"+jTextField5.getText()+"',`item_name`='"+jTextField3.getText()+"',`price`='"+jTextField4.getText()+"',`discription`='"+jTextArea2.getText()+"' WHERE `item_code`='"+jTextField5.getText()+"'");
     pst.execute();
     
             JOptionPane.showMessageDialog(this,"Successfully update Item code"); 
 
     
  
     
     }catch(Exception e){
         System.out.print(e);
     }

 
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       String findkey=jTextField5.getText();
        try{
        connection();
          pst=con.prepareStatement("SELECT * FROM `item` where item_code='"+findkey+"'");
     rs=pst.executeQuery();
     
     if(rs.next()){
         jTextField3.setText(rs.getString("item_name"));
         jTextField4.setText(String.valueOf(rs.getInt("price")));
         jTextArea2.setText(rs.getString("discription"));
       BufferedImage im= ImageIO.read(rs.getBinaryStream("item_img"));
resize1(jLabel17,im);
        
     }
     else
     {
             JOptionPane.showMessageDialog(this,"Invalid Item code"); 
 
     }
  
     
     }catch(Exception e){
         System.out.print(e);
     }

 
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
       String findkey=jTextField8.getText();
        try{
        connection();
          pst=con.prepareStatement("SELECT * FROM `item` where item_code='"+findkey+"'");
     rs=pst.executeQuery();
     
     
     
     
     if(rs.next()){
         jLabel24.setText(rs.getString("item_name"));
         jLabel25.setText(String.valueOf(rs.getInt("price")));
         jTextArea3.setText(rs.getString("discription"));
       BufferedImage im= ImageIO.read(rs.getBinaryStream("item_img"));
resize1(jLabel22,im);
        
     }
     else
     {
             JOptionPane.showMessageDialog(this,"Invalid Item code"); 
 
     }
  
     
     }catch(Exception e){
         System.out.print(e);
     }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
               try{
        connection();
         pst=con.prepareStatement("DELETE FROM `item` WHERE `item_code`='"+jTextField8.getText()+"'");
     pst.execute();
     
             JOptionPane.showMessageDialog(this,"Successfully deleted Item code"); 
 
     
  
     
     }catch(Exception e){
         System.out.print(e);
     }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables

    private void setTitle(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
