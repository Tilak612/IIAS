/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forzon3;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tushar
 */
public class add_stock extends javax.swing.JPanel {
    public  ResultSet rs=null;
    public Connection  con=null;
    public PreparedStatement pst=null;
      public PreparedStatement pst1=null;
     public void connection(){
     try{
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/froze","root","");
     System.out.println("joy");
      }
          catch(Exception e){
    System.out.println(e);    
        }
      }
 
public void item_info(String Item){
            connection();
try{
     System.out.println("SELECT * FROM item where item_code='"+Item+"'");
     
      pst=con.prepareStatement("SELECT * FROM item where item_code='"+Item+"'");
     rs=pst.executeQuery();
     if(rs.next()){
   jTextField4.setText(rs.getString("item_name"));
    int pr;
    pr=rs.getInt("price");
jTextField7.setText(String.valueOf(pr));
   System.out.println("joy2");
     
     }
    }   catch (Exception ex) {
         System.out.println(ex);
        }

        }   
    /**
     * Creates new form add_stock
     */
    public add_stock() {
         connection();
        initComponents();
        jLabel2.setText(getCurrentDate().toString());
    }
     public static java.sql.Date getCurrentDate() {
    java.util.Date today = new java.util.Date();
    return new java.sql.Date(today.getTime());
}
      public void sell(){
        
         try{
             connection();
                pst=con.prepareStatement("insert into stock(`date`, `manufacture_cost`, `Total cost`) values(?,?,?)");        
         pst.setDate(1, getCurrentDate());
         pst.setInt(2, Integer.parseInt(jTextField1.getText()));
         pst.setInt(3, Integer.parseInt(jTextField8.getText()));
         
          
         pst.executeUpdate();
            
  try{
    
String  itecode="",itename="";

    connection();
                for(int i=0;i<jTable2.getRowCount();i++){
        pst1=con.prepareStatement("insert into stock_information(`date`, `item_code`, `item_name`, `quality`, `dymanic_quality`,`Amount`,price) values(?,?,?,?,?,?,?)");
                    itecode=  jTable2.getValueAt(i, 0).toString();
            itename=  jTable2.getValueAt(i, 1).toString();
          int q=Integer.parseInt(jTable2.getValueAt(i, 2).toString());
          int p=Integer.parseInt(jTable2.getValueAt(i, 3).toString());
          int am=Integer.parseInt(jTable2.getValueAt(i, 4).toString());
         
           System.out.print(itecode+" "+itename+" "+q+" "+p+" "+am);
          System.out.println();
              pst1.setDate(1,getCurrentDate());
         
            pst1.setString(2,itecode);
             pst1.setString(3,itename);
             pst1.setInt(4,q);
               pst1.setInt(5,q);
             pst1.setInt(6,am);
             
             pst1.setInt(7, p);
         pst1.executeUpdate();
                   
                }
                  JOptionPane.showMessageDialog(this,"Success"); 
 
              
  }   
catch(SQLException ex){
  System.out.print("lie 113"+ex);   
}
  
       
         }
         catch(SQLException e){
             
             System.out.print("lie 120"+e);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1623, 832));

        jPanel1.setLayout(null);

        jLabel1.setText("Date:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 23, 46, 14);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(66, 23, 64, 14);

        jLabel3.setText("Manufacturing Cost");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(579, 11, 97, 37);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(686, 9, 170, 30);

        jTable2.setBackground(new java.awt.Color(51, 51, 51));
        jTable2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51), 3));
        jTable2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM CODE", "ITEM NAME", "PRICE", "QUANTITY", "AMOUNT"
            }
        ));
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable2.setGridColor(new java.awt.Color(204, 51, 255));
        jTable2.setName(""); // NOI18N
        jTable2.setRowHeight(30);
        jTable2.setRowMargin(5);
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 190, 870, 263);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 255, 51));
        jLabel10.setText("ITEM NAME:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(220, 70, 136, 29);

        jTextField4.setBackground(new java.awt.Color(0, 0, 0));
        jTextField4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(204, 51, 255));
        jTextField4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField4);
        jTextField4.setBounds(220, 110, 150, 40);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 255, 51));
        jLabel11.setText("ITEM CODE:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(20, 70, 138, 29);

        jTextField5.setBackground(new java.awt.Color(0, 0, 0));
        jTextField5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(204, 51, 255));
        jTextField5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField5);
        jTextField5.setBounds(20, 120, 150, 40);

        jLabel12.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 255, 51));
        jLabel12.setText("AMOUNT");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(790, 60, 130, 30);

        jTextField6.setBackground(new java.awt.Color(0, 0, 0));
        jTextField6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(204, 51, 255));
        jTextField6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField6);
        jTextField6.setBounds(790, 100, 150, 40);

        jLabel13.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 255, 51));
        jLabel13.setText("QUANTITY:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(570, 60, 125, 29);

        jSpinner1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jSpinner1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51), 3));
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        jPanel1.add(jSpinner1);
        jSpinner1.setBounds(570, 110, 170, 40);

        jLabel14.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 255, 51));
        jLabel14.setText("PRICE");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(400, 70, 72, 29);

        jTextField7.setBackground(new java.awt.Color(0, 0, 0));
        jTextField7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(204, 51, 255));
        jTextField7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField7);
        jTextField7.setBounds(400, 110, 150, 40);

        jTextField8.setBackground(new java.awt.Color(0, 0, 0));
        jTextField8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(204, 51, 255));
        jTextField8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField8KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField8);
        jTextField8.setBounds(940, 260, 150, 40);

        jLabel15.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 255, 51));
        jLabel15.setText("TOTAL STOCK COST");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(890, 220, 240, 30);

        jButton1.setBackground(new java.awt.Color(0, 255, 51));
        jButton1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(895, 330, 280, 50);

        jButton2.setBackground(new java.awt.Color(0, 255, 51));
        jButton2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(890, 390, 280, 50);

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(880, 450, 140, 50);

        jButton4.setBackground(new java.awt.Color(0, 255, 51));
        jButton4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton4.setText("Delete All");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(1030, 450, 140, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
   
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
           if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            item_info(jTextField5.getText());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        int pr=Integer.parseInt(jTextField7.getText());
        int Q=Integer.parseInt(jSpinner1.getValue().toString());
        int total=pr*Q;
        jTextField6.setText(String.valueOf(total));
        // TODO add your handling code here:
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyPressed

    private void jTextField8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel add=new DefaultTableModel();
        add=(DefaultTableModel)jTable2.getModel();
        add.addRow(new Object[]{
            jTextField5.getText(),
            jTextField4.getText(),
           jTextField7.getText(),
            jSpinner1.getValue().toString(),
           jTextField6.getText()
        });
        int sum=0;
        int i;
        for( i=0;i<jTable2.getRowCount();i++){
            sum=sum+Integer.parseInt(jTable2.getValueAt(i, 4).toString());
        }
       jTextField8.setText(String.valueOf(sum));

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
if(jTextField1.getText().equals("")||(jTextField8.getText().equals("")&&jTextField8.getText().equals("0"))){
       JOptionPane.showMessageDialog(this,"Entry are empty"); 
 
              
}
else{
        sell();        

}   // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int j=jTable2.getSelectedRow();
        DefaultTableModel add=new DefaultTableModel();
        add=(DefaultTableModel)jTable2.getModel();
        add.removeRow(j);
        int sum=0;
        int i;
        for( i=0;i<jTable2.getRowCount();i++){
            sum=sum+Integer.parseInt(jTable2.getValueAt(i, 4).toString());
        }
      jTextField8.setText(String.valueOf(sum));

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        DefaultTableModel add=new DefaultTableModel();
        add=(DefaultTableModel)jTable2.getModel();
        for(int i=jTable2.getRowCount()-1;i>=0;i--){

            add.removeRow(i);
        }
         
        int sum=0;

        for(int i=0;i<jTable2.getRowCount();i++){
            sum=sum+Integer.parseInt(jTable2.getValueAt(i, 4).toString());
        }
        jTextField8.setText(String.valueOf(sum));
add.setRowCount(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
