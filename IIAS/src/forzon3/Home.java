/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forzon3;

import com.sun.webkit.Timer;
import java.awt.BorderLayout;
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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author chaitany
 */
public final class Home extends javax.swing.JPanel {
        public void resize1(JLabel a,BufferedImage d){
      ImageIcon myimage1=new ImageIcon(d);
        Image img3=myimage1.getImage();
        Image img4=img3.getScaledInstance(a.getHeight(),a.getWidth(),Image.SCALE_SMOOTH);
        ImageIcon i11=new ImageIcon(img4);   
       a.setIcon(i11);
}
     public  ResultSet rs=null;
    public Connection  con=null;
    public PreparedStatement pst=null;
    public void resize(JLabel a,String d){
      ImageIcon myimage1=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(d)));
        Image img3=myimage1.getImage();
        Image img4=img3.getScaledInstance( a.getWidth(),a.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon i11=new ImageIcon(img4);   
    a.setIcon(i11);
}
    public void resize3(JButton a,String d){
      ImageIcon myimage1=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(d)));
        Image img3=myimage1.getImage();
        Image img4=img3.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon i11=new ImageIcon(img4);   
       a.setIcon(i11);
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
     * Creates new form Home
     */
    public Home() {
        initComponents();
        resize3(jButton4,"backup.png");
       resize3(jButton2,"restore.png");
       resize(jLabel3,"iias3.png");
        resize(jLabel1,"ICY123.jpg");
       System.out.print("Home");
    grap();
    
    }
    public void auto_image(){
    try{
        connection();
          pst=con.prepareStatement("SELECT * FROM `item`");
     rs=pst.executeQuery();
      System.out.print("why");
     BufferedImage jjk[]=new  BufferedImage[20];
     while(rs.next()){
      
         System.out.print("roy");
        BufferedImage im=null;  
        im= ImageIO.read(rs.getBinaryStream("item_img"));
jLabel1.setIcon(null);
        resize1(jLabel1,im);

System.out.print("ggs");
       
     }
    
  
     
     }catch(Exception e){
         System.out.print(e);
     }
     
    }
     public static java.sql.Date getCurrentDate() {
    java.util.Date today = new java.util.Date();
    return new java.sql.Date(today.getTime());
}
public void grap(){
       int l1=2020;
int l2=10;
int l3=20;
int l4=30;
int l5=40;
int l6=50;
int l7=60;
int l8=70;
int l9=80;
int l10=90;
int l11=100;
int l12=30;
int l13=70;
        try{
            String query="Year ";
             DefaultCategoryDataset dataset =new DefaultCategoryDataset();
        dataset.setValue(l2,query,"January");
        dataset.setValue(l3,query, "February");
        dataset.setValue(l4,query, "March");
        dataset.setValue(l5,query, "April");
        dataset.setValue(l6,query, "May");
        dataset.setValue(l7,query, "June");
        dataset.setValue(l8,query, "July");
        dataset.setValue(l9,query, "August");
        dataset.setValue(l10,query, "September");
        dataset.setValue(l11,query, "October");
        dataset.setValue(l12,query, "November");
        dataset.setValue(l13,query, "December");
            JFreeChart chart = ChartFactory.createLineChart(  
        "Monthly Sale", // Chart title  
        "Month", // X-Axis Label  
        "Rupees(In thousand)", // Y-Axis Label  
        dataset  
        );  
             ChartPanel panel = new ChartPanel(chart);
            jPanel3.removeAll();
             jPanel3.add(panel,BorderLayout.CENTER);
              
              jPanel3.validate();
           
          
        }
        catch(Exception ex){
          System.out.print(ex);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();

        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(null);

        jPanel2.setLayout(null);
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, 0, 300, 300);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 150)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 51, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("      I I A S");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 0, 4, new java.awt.Color(0, 255, 51)));
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel2.setOpaque(true);
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 0, 740, 150);

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 4, 4, 4, new java.awt.Color(204, 51, 255)));
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 740, 740);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(47, 50, 740, 740);

        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel3);
        jPanel3.setBounds(840, 50, 800, 345);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 255, 51));
        jButton2.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jButton2.setText("RESTORE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(1270, 440, 370, 150);

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 51, 255));
        jButton1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jButton1.setText("EXPENCIVE");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(840, 440, 370, 150);

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        jButton4.setBackground(new java.awt.Color(0, 255, 51));
        jButton4.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jButton4.setText("  BACKUP");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6);
        jPanel6.setBounds(1270, 640, 370, 150);

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));

        jButton3.setBackground(new java.awt.Color(204, 51, 255));
        jButton3.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jButton3.setText("SELLING REPORTS");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7);
        jPanel7.setBounds(840, 640, 370, 150);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 1690, 840);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
auto_image();
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
Process p=null;
try{
    Runtime runtime=Runtime.getRuntime();
    String dat=getCurrentDate().toString();
    String backs="C:\\Users\\chaitany\\Desktop\\Frozone\\mysql\\newbackupcode\\"+dat+".sql";
   String dbpass="";
    p=runtime.exec("C:\\xampp\\mysql\\bin\\mysqldump.exe -uroot  --add-drop-database -B froze1 -r C:\\Users\\chaitany\\Desktop\\Frozone\\mysql\\newbackupcode\\ddd.sql");
 System.out.println("Start");
System.out.println(p.waitFor());
    int processcomplete =p.waitFor();
   System.out.println(p.waitFor());
 
if(processcomplete==0){
    System.out.println("successfull");
}
else{
        System.out.println("Insuccessfull");

}
p.destroy();
}
catch(Exception e){
    System.out.print(e);
}
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables
}
