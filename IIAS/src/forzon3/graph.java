/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forzon3;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author chaitany
 */
public class graph extends javax.swing.JPanel {
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
     * Creates new form graph
     */
    public graph() {
        
        initComponents();
        
connection();
try{
      pst=con.prepareStatement("SELECT * FROM `graph_sale_month`");
     rs=pst.executeQuery();
     while(rs.next()){
System.out.print(rs.getInt("Year")+" "+rs.getInt("January")+" "+rs.getInt("February")+" "+rs.getInt("March")+" "+rs.getInt("April")+" "+rs.getInt("May")+" "+rs.getInt("June")+" "+rs.getInt("July")+" "+rs.getInt("August")+" "+rs.getInt("September")+" "+rs.getInt("October")+" "+rs.getInt("November")+" "+rs.getInt("December"));
System.out.println();
DefaultTableModel add=new DefaultTableModel();
add=(DefaultTableModel)jTable1.getModel();
add.addRow(new Object[]{String.valueOf(rs.getInt("Year")),
String.valueOf(rs.getInt("January")),
String.valueOf(rs.getInt("February")),
String.valueOf(rs.getInt("March")),
String.valueOf(rs.getInt("April")),
String.valueOf(rs.getInt("May")),
String.valueOf(rs.getInt("June")),
String.valueOf(rs.getInt("July")),
String.valueOf(rs.getInt("August")),
String.valueOf(rs.getInt("September")),
String.valueOf(rs.getInt("October")),
String.valueOf(rs.getInt("November")),
String.valueOf(rs.getInt("December"))
});

     }
}
      catch (Exception ex) {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(null);

        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 100, 1690, 440);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Year", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true, false, false, false, false, false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFillsViewportHeight(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(8).setResizable(false);
            jTable1.getColumnModel().getColumn(9).setResizable(false);
            jTable1.getColumnModel().getColumn(10).setResizable(false);
            jTable1.getColumnModel().getColumn(11).setResizable(false);
            jTable1.getColumnModel().getColumn(12).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 570, 1690, 170);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(710, 760, 79, 25);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 1690, 840);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
int i=jTable1.getSelectedRow();
        int l1=Integer.parseInt(jTable1.getValueAt(i, 0).toString());
int l2=Integer.parseInt(jTable1.getValueAt(i, 1).toString());
int l3=Integer.parseInt(jTable1.getValueAt(i, 2).toString());
int l4=Integer.parseInt(jTable1.getValueAt(i, 3).toString());
int l5=Integer.parseInt(jTable1.getValueAt(i, 4).toString());
int l6=Integer.parseInt(jTable1.getValueAt(i, 5).toString());
int l7=Integer.parseInt(jTable1.getValueAt(i, 6).toString());
int l8=Integer.parseInt(jTable1.getValueAt(i, 7).toString());
int l9=Integer.parseInt(jTable1.getValueAt(i, 8).toString());
int l10=Integer.parseInt(jTable1.getValueAt(i, 9).toString());
int l11=Integer.parseInt(jTable1.getValueAt(i, 10).toString());
int l12=Integer.parseInt(jTable1.getValueAt(i, 11).toString());
int l13=Integer.parseInt(jTable1.getValueAt(i, 12).toString());
        try{
            String query="Year "+l1+"  ";
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
            jPanel2.removeAll();
             jPanel2.add(panel,BorderLayout.CENTER);
              
              jPanel2.validate();
           
          
        }
        catch(Exception ex){
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
