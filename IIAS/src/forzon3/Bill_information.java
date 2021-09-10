/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forzon3;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author chaitany
 */
public class Bill_information extends javax.swing.JPanel {
    public  ResultSet rs=null;
    public Connection  con=null;
    public PreparedStatement pst=null;
public void connection(){
     try{
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/froze","root","");
    
      }
          catch(Exception e){
    System.out.println(e);    
        }
      }

    /**
     * Creates new form Bill_information
     */
public void bill3_info(){
    
connection();
try{
      pst=con.prepareStatement("SELECT * FROM `sales`");
     rs=pst.executeQuery();
DefaultTableModel add=new DefaultTableModel();
add=(DefaultTableModel)jTable1.getModel();
add.setRowCount(0);

     while(rs.next()){



add.addRow(new Object[]{String.valueOf(rs.getInt("Order_id")),rs.getDate("sell_date"),rs.getString("user_id"),rs.getString("type"),rs.getString("name"),String.valueOf(rs.getInt("Total"))
});

     }
}
      catch (Exception ex) {
      System.out.print(ex);
      }

    
}
    public Bill_information() {
        initComponents();
            bill3_info();    
    }
  public void jaspaerprint(int ji){
         HashMap m= new HashMap();
 m.put("invoice",ji);
 try{
     JasperDesign jdesign= JRXmlLoader.load("C:\\Users\\chaitany\\Desktop\\Forzon3\\src\\forzon3\\ill.jrxml");
     JasperReport ireport= JasperCompileManager.compileReport(jdesign);
     JasperPrint jprint= JasperFillManager.fillReport(ireport, m, con);
     
     JRViewer jv = new JRViewer(jprint); 
    
     jas jr= new jas();
   
     jr.jPanel1.removeAll();
     jr.jPanel1.add(jv,BorderLayout.CENTER);
     
jr.jPanel1.revalidate();

 jr.setVisible(true);
     
}
catch(Exception ex){
    
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        jTable1.setBackground(new java.awt.Color(0, 0, 0));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51), 3));
        jTable1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ORDER ID", "DATE", "USER ID", "TYPE", "NAME", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(204, 51, 255));
        jTable1.setRowHeight(25);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(50, 200, 1640, 560);

        jDateChooser1.setBackground(new java.awt.Color(51, 51, 51));
        jDateChooser1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51), 3));
        jDateChooser1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jDateChooser1);
        jDateChooser1.setBounds(50, 150, 190, 40);

        jButton1.setBackground(new java.awt.Color(0, 255, 51));
        jButton1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(1530, 150, 150, 40);

        jButton2.setBackground(new java.awt.Color(0, 255, 51));
        jButton2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton2.setText("RESET");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(1530, 100, 150, 40);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BILLING INFORMATION");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 25, 1690, 50);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 51));
        jLabel2.setText("CHOOSE DATE:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 100, 190, 50);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 1690, 840);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
int st=jTable1.getSelectedRow();
        int d=Integer.parseInt(jTable1.getValueAt(st, 0).toString());

        jaspaerprint(d);
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
java.util.Date date=new java.util.Date();
			date=jDateChooser1.getDate();
			java.sql.Date sqlDate=new java.sql.Date(date.getTime());

connection();
try{
      pst=con.prepareStatement("SELECT * FROM `sales` where sell_date='"+ sqlDate+"'" );
     rs=pst.executeQuery();
DefaultTableModel add=new DefaultTableModel();
add=(DefaultTableModel)jTable1.getModel();
add.setRowCount(0);

     while(rs.next()){



add.addRow(new Object[]{String.valueOf(rs.getInt("Order_id")),rs.getDate("sell_date"),rs.getString("user_id"),rs.getString("type"),rs.getString("name"),String.valueOf(rs.getInt("Total"))
});

     }
}
      catch (Exception ex) {
      System.out.print(ex);
      }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 bill3_info();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}