/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forzon3;

import static forzon3.empoyeedas.jLabel10;
import static forzon3.empoyeedas.jLabel12;
import static forzon3.empoyeedas.jLabel16;
import static forzon3.empoyeedas.jLabel18;
import static forzon3.empoyeedas.jLabel20;
import static forzon3.empoyeedas.jLabel31;
import static forzon3.empoyeedas.jLabel37;
import static forzon3.empoyeedas.jLabel39;
import static forzon3.empoyeedas.jLabel49;
import static forzon3.empoyeedas.jLabel8;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.opencv.core.Core;

/**
 *
 * @author chaitany
 */
public class login2 extends javax.swing.JFrame {
    public String user;
    public  ResultSet rs=null;
    public Connection  con=null;
    public PreparedStatement pst=null;
                     public void resize1(JLabel a,BufferedImage d){
      ImageIcon myimage1=new ImageIcon(d);
        Image img3=myimage1.getImage();
        Image img4=img3.getScaledInstance(a.getWidth(),a.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon i11=new ImageIcon(img4);   
       a.setIcon(i11);
}
public void resize(JLabel a,String d){
      ImageIcon myimage1=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(d)));
        Image img3=myimage1.getImage();
        Image img4=img3.getScaledInstance( a.getWidth(),a.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon i11=new ImageIcon(img4);   
       a.setIcon(i11);
}
public void resize1(JButton s,String c){
      ImageIcon myimage1=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(c)));
        Image img3=myimage1.getImage();
        Image img4=img3.getScaledInstance( s.getWidth(),s.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon i11=new ImageIcon(img4);
       s.setIcon(i11);
}

        /**
     * Creates new form login2
     */
    public login2() {
        initComponents();
    resize(jLabel4,"black.jpg");
   
    resize(jLabel5,"purpleice1.jpg");
     resize1(lb,"login.png");
     resize1(sb,"SIGNIN.png");
     resize(jLabel7,"iias3.png");
     resize(jLabel9,"iias3.png");
     connection();
try{
      pst=con.prepareStatement("SELECT * FROM login");
     rs=pst.executeQuery();
     if(rs.next()){
        String type=rs.getString("type"); 
        if(type.equals("Admin")){
           jPanel3.setVisible(false);
          
        }
        else{
         
            jPanel3.setVisible(true);   
         
        }
     }
    }   catch (SQLException ex) {
            Logger.getLogger(login2.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void connection(){
     try{
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/froze","root","");
    
        System.out.println("Database connection terminated");
     
      }
          catch(Exception e){
    System.out.println(e);    
        }
    

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
        jPanel2 = new javax.swing.JPanel();
        lb = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        l1 = new javax.swing.JTextField();
        l2 = new javax.swing.JPasswordField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        sb = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        s1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        s2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        s3 = new javax.swing.JPasswordField();
        s4 = new javax.swing.JPasswordField();
        sl1 = new javax.swing.JLabel();
        sl2 = new javax.swing.JLabel();
        sl3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(1010, 500));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel2.setLayout(null);

        lb.setToolTipText("LOGIN");
        lb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbActionPerformed(evt);
            }
        });
        jPanel2.add(lb);
        lb.setBounds(410, 0, 90, 500);

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 102), 4));
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2);
        jLabel2.setBounds(410, 0, 90, 500);
        jPanel2.add(jLabel7);
        jLabel7.setBounds(60, 0, 300, 300);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 255, 51));
        jLabel11.setText("USER ID:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(25, 280, 103, 29);

        jLabel12.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 255, 51));
        jLabel12.setText("PASSWORD:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(25, 380, 146, 29);

        l1.setBackground(new java.awt.Color(51, 51, 51));
        l1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        l1.setForeground(new java.awt.Color(204, 51, 255));
        l1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        l1.setToolTipText("Enter User_ID");
        l1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        l1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(l1);
        l1.setBounds(25, 330, 365, 40);
        l1.getAccessibleContext().setAccessibleName("");

        l2.setBackground(new java.awt.Color(51, 51, 51));
        l2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        l2.setForeground(new java.awt.Color(204, 51, 255));
        l2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        l2.setToolTipText("Enter Password");
        l2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        l2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(l2);
        l2.setBounds(25, 430, 365, 40);

        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(jLabel16);
        jLabel16.setBounds(140, 280, 250, 30);

        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(jLabel17);
        jLabel17.setBounds(180, 380, 210, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 40, 500, 500);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel3.setLayout(null);

        sb.setToolTipText("SIGNIN");
        sb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sbActionPerformed(evt);
            }
        });
        jPanel3.add(sb);
        sb.setBounds(0, 0, 90, 500);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 102), 4));
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setRequestFocusEnabled(false);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel6);
        jLabel6.setBounds(0, 0, 90, 500);
        jLabel6.getAccessibleContext().setAccessibleDescription("");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 255, 51));
        jLabel13.setText("USER ID:");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(115, 20, 103, 29);

        s1.setBackground(new java.awt.Color(51, 51, 51));
        s1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        s1.setForeground(new java.awt.Color(204, 51, 255));
        s1.setToolTipText("Enter User ID");
        s1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel3.add(s1);
        s1.setBounds(115, 70, 365, 40);

        jLabel14.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 255, 51));
        jLabel14.setText("USER NAME:");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(115, 140, 147, 29);

        s2.setBackground(new java.awt.Color(51, 51, 51));
        s2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        s2.setForeground(new java.awt.Color(204, 51, 255));
        s2.setToolTipText("Enter User Name");
        s2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        s2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s2ActionPerformed(evt);
            }
        });
        jPanel3.add(s2);
        s2.setBounds(115, 190, 365, 40);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 255, 51));
        jLabel8.setText("PASSWORD:");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(115, 270, 146, 29);

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 255, 51));
        jLabel15.setText("CONFORM PASSWORD:");
        jLabel15.setAutoscrolls(true);
        jPanel3.add(jLabel15);
        jLabel15.setBounds(115, 390, 276, 29);

        s3.setBackground(new java.awt.Color(51, 51, 51));
        s3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        s3.setForeground(new java.awt.Color(204, 51, 255));
        s3.setToolTipText("Enter Password");
        s3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel3.add(s3);
        s3.setBounds(115, 320, 365, 40);

        s4.setBackground(new java.awt.Color(51, 51, 51));
        s4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        s4.setForeground(new java.awt.Color(204, 51, 255));
        s4.setToolTipText("Reenter Password");
        s4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel3.add(s4);
        s4.setBounds(115, 440, 365, 40);

        sl1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(sl1);
        sl1.setBounds(230, 16, 210, 30);

        sl2.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(sl2);
        sl2.setBounds(270, 136, 190, 30);

        sl3.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(sl3);
        sl3.setBounds(280, 270, 190, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(910, 40, 500, 500);

        jPanel4.setBackground(new java.awt.Color(204, 51, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 4));
        jPanel4.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText(" -");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel3);
        jLabel3.setBounds(910, 0, 40, 30);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel1);
        jLabel1.setBounds(960, 0, 40, 40);
        jPanel4.add(jLabel9);
        jLabel9.setBounds(5, 5, 30, 30);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("WELCOME TO IIAS");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(40, 4, 230, 30);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(0, 0, 1000, 40);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setToolTipText("");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel4.setFocusable(false);
        jLabel4.setMaximumSize(new java.awt.Dimension(500, 500));
        jLabel4.setMinimumSize(new java.awt.Dimension(500, 500));
        jLabel4.setNextFocusableComponent(jLabel4);
        jLabel4.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 40, 500, 500);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setToolTipText("");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51), 3));
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(500, 40, 500, 500);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1000, 540);

        setSize(new java.awt.Dimension(1001, 540));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void s2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s2ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
   System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void lbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbActionPerformed
int f=jPanel2.getX();
 System.out.println(f);
        if(f<=-410){
        Animacion.Animacion.mover_derecha(-410,0,2,2,jPanel2);
        Animacion.Animacion.mover_derecha(500,910,2,2,jPanel3);
   s1.setText("");
   s2.setText("");
   s3.setText("");
   s4.setText("");
  }
        else
        {
            if(l1.getText().equals("") && l2.getText().equals("")){
                
            
            if(l1.getText().equals("")){
                jLabel16.setText("Field is empty");
            }
            else
            {
                 jLabel16.setText("");
            }
              if(l2.getText().equals("")){
                jLabel17.setText("Field is empty");
            }
            else
            {
                 jLabel17.setText("");
            }
            }
            else{
                jLabel16.setText("");
                jLabel17.setText("");
              connection();
try{
      pst=con.prepareStatement("SELECT * FROM login where user_id='"+l1.getText()+"';");
     rs=pst.executeQuery();
     if(rs.next()){
 user=rs.getString("user_id");
 String pass=rs.getString("password");
 if(l1.getText().equals(user)&& l2.getText().equals(pass)){
     if(rs.getString("type").equals("Admin")){
               
         System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
     Dashboard1 das=new Dashboard1();
      das.pl8.setText(user);
      das.pl4.setText(user);
            das.setVisible(true);
            
     this.dispose();
     }
     else{
            
         System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
     empoyeedas das1=new empoyeedas();
     das1.pl8.setText(user);

        connection();
        try{
            pst=con.prepareStatement("SELECT * FROM `employee` where user_id='"+user+"'");
            rs=pst.executeQuery();
            while(rs.next()){
                das1.pl4.setText(rs.getString("name"));
                 das1.pl5.setText(rs.getString("user_id"));
                 das1.jLabel8.setText(rs.getString("name"));
                 das1.jLabel10.setText(rs.getString("user_id"));
                 das1.jLabel14.setText(rs.getString("Address"));
                 das1.jLabel12.setText(rs.getString("adhar_card_no"));
                 das1.jLabel16.setText(rs.getString("Contact_no"));
                 das1.jLabel18.setText(rs.getString("dob"));
                 das1.jLabel39.setText(rs.getString("gender"));
                 das1.jLabel31.setText(rs.getString("position"));
                 das1.jLabel37.setText(rs.getString("join_date"));
                 das1.jLabel20.setText(rs.getString("education"));
                 das1.jLabel41.setText(rs.getString("salary"));
                BufferedImage im= ImageIO.read(rs.getBinaryStream("image"));
                resize1( das1.jLabel49,im);

            }
        }
        catch (Exception ex) {
            System.out.print(ex);
        }

            das1.setVisible(true);
     this.dispose();
     }
 }
 else
 {
     JOptionPane.showMessageDialog(rootPane,"Invaid User Name and Password"); }        
    }
}
catch(Exception e){
    
}}}

        // TODO add your handling code here:
    }//GEN-LAST:event_lbActionPerformed

    private void sbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sbActionPerformed
int l=jPanel3.getX();
 System.out.println(l);
        if(l>=910){
             Animacion.Animacion.mover_izquierda(910,500,1,2, jPanel3);
             Animacion.Animacion.mover_izquierda(0,-410,1,2, jPanel2);
        l1.setText("");
        l2.setText("");
       
  }
        else
        {
      
          if(s1.getText().equals("")||s2.getText().equals("")||s3.getText().equals("")||s4.getText().equals(""))
          {
            if(s1.getText().equals("")){
                sl1.setText("Field is empty");
            }
            else
            {
                sl1.setText("");
            }
            if(s2.getText().equals("")){
                sl2.setText("Field is empty");
            }
            else
            {
                sl2.setText("");
            }
            if(s3.getText().equals("")||s4.getText().equals(""))
            {
                sl3.setText("Field is empty");
            }
            else
            {
                sl3.setText("");
                 if(s3.getText().equals(s4.getText()))
              {
             }       
              else
              {
                  sl3.setText(" Password  Mismatch");
                
              }
            }
          }
          else
          {
              sl2.setText("");
              sl1.setText("");
              sl3.setText("");
              if(s3.getText().equals(s4.getText()))
              {
                  String  a,b,c;
                sl3.setText("");
                try{
                    a=s1.getText();
                    b=s2.getText();
                    c=s3.getText();
                connection();
                pst=con.prepareStatement("insert into login(user_id,password,user_name,type) values(?,?,?,?)");
            pst.setString(1,a);
            pst.setString(2,b);
            pst.setString(3,c);
            pst.setString(4, "admin");
            pst.executeUpdate();
                JOptionPane.showMessageDialog(rootPane,"Succesfully Sign up"); 
   
                }
                catch(Exception e){
                    System.out.println(e);
                }
              }       
              else
              {
                  sl3.setText(" Password  Mismatch");
                
              }
        }
        }  
            

        // TODO add your handling code here:
    }//GEN-LAST:event_sbActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
setState(ICONIFIED);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
 login2 l=new login2();
        /* Create and display the form */
        l.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField l1;
    private javax.swing.JPasswordField l2;
    private javax.swing.JButton lb;
    private javax.swing.JTextField s1;
    private javax.swing.JTextField s2;
    private javax.swing.JPasswordField s3;
    private javax.swing.JPasswordField s4;
    private javax.swing.JButton sb;
    private javax.swing.JLabel sl1;
    private javax.swing.JLabel sl2;
    private javax.swing.JLabel sl3;
    // End of variables declaration//GEN-END:variables
}
