/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forzon3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.text.DateFormat;
import java.util.Date;  
import java.text.SimpleDateFormat;
import static java.time.Instant.now;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
public class Bill extends javax.swing.JPanel {
    
  public void PanelB(){
     jLabel2.setBorder(null);
      jLabel3.setBorder(null);
  }
  public void labellB(JLabel label1){
      
           Color myWhite1 = new Color(204,51,255); 
            label1.setBorder(new MatteBorder(3, 3, 0, 3, myWhite1)); 
}
   public void labellB1(JLabel label1){
     
           Color myWhite1 = new Color(204,51,255); 
            label1.setBorder(new MatteBorder(0, 0, 3, 0, myWhite1)); 
}
      
 public  ResultSet rs=null;
    public Connection  con=null;
    public PreparedStatement pst=null;
      public PreparedStatement pst1=null;
      public  ResultSet rs2=null;

    public PreparedStatement pst2=null;
     public  ResultSet rs3=null;

    public PreparedStatement pst3=null;
     public void connection(){
     try{
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/froze","root","");
    
      }
          catch(Exception e){
    System.out.println(e);    
        }
      }
     public static java.sql.Date getCurrentDate() {
    java.util.Date today = new java.util.Date();
    return new java.sql.Date(today.getTime());
}
     public void  Stock_update(String item_c,int qut){
         try{
                  connection();
          pst3=con.prepareStatement("SELECT * FROM `stock_information` WHERE `date`='"+jLabel18.getText()+"' && `item_code`='"+item_c+"'");
rs3=pst3.executeQuery();
     rs3.next();
     int dtemp=rs3.getInt("dymanic_quality");
     int dym=dtemp-qut;
     System.out.println(qut+"\t"+dtemp+"\tUPDATE `stock_information` SET `dymanic_quality`='"+dym+"'WHERE `date`='"+jLabel18.getText()+"' && `item_code`='"+item_c+"'");
              pst2=con.prepareStatement("UPDATE `stock_information` SET `dymanic_quality`='"+dym+"'WHERE `date`='"+jLabel18.getText()+"' && `item_code`='"+item_c+"'");        
            pst2.executeUpdate();
          
         }
         catch(Exception e){
             System.out.println(e);
         }
         
     }
public void graph_information(int graph_month){
      connection();
        
   String[] md=getCurrentDate().toString().split("-");
   System.out.println(md[0]);
   System.out.println(md[1]);
   System.out.println(md[2]);
    int adde=graph_month;
try{
   
      pst=con.prepareStatement("SELECT * FROM `graph_sale_month`");
     rs=pst.executeQuery();
    int yeae = 0;
    while(rs.next()){
    yeae=rs.getInt("Year");
}
   if(yeae!= Integer.parseInt(md[0])){
    
             connection();
                pst=con.prepareStatement("INSERT INTO `graph_sale_month`(`Year`, `January`, `February`, `March`, `April`, `May`, `June`, `July`, `August`, `September`, `October`, `November`, `December`)values(?,?,?,?,?,?,?,?,?,?,?,?,?)");        
        pst.setInt(1, Integer.parseInt(md[0]));
        pst.setInt(2, adde);
        pst.setInt(3, 0);
        pst.setInt(4, 0);
        pst.setInt(5, 0);
        pst.setInt(6, 0);
        pst.setInt(7, 0);
        pst.setInt(8, 0);
        pst.setInt(9, 0);
        pst.setInt(10, 0);
        pst.setInt(11, 0);
        pst.setInt(12, 0);
        pst.setInt(13, 0);
            pst.executeUpdate();
                 JOptionPane.showMessageDialog(this,"Add"); 

   }
   else{
                  connection();
                 pst=con.prepareStatement("SELECT * FROM `graph_sale_month` where Year='"+Integer.parseInt(md[0])+"'");
    int month=0; 
       ResultSet rs1=null;
   Connection  con1=null;
    PreparedStatement pst1=null;
           con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/froze","root","");
    
      
    rs=pst.executeQuery();
   switch(Integer.parseInt(md[1])){  
       case 1:     
           while(rs.next()){month=rs.getInt("January");}
            adde=adde+month;
            pst1=con1.prepareStatement("UPDATE `graph_sale_month` SET `January`="+adde+" WHERE `Year`="+Integer.parseInt(md[0])+";");
             pst1.execute();
           
           System.out.println("update 1");
           break;
       case 2:  
           while(rs.next()){ month=rs.getInt("February");}
            adde=adde+month;
            pst1=con1.prepareStatement("UPDATE `graph_sale_month` SET `February`="+adde+" WHERE `Year`="+Integer.parseInt(md[0])+";");
             pst1.execute();
          
           System.out.println("update 2");
           break;
       case 3:            
            while(rs.next()){month=rs.getInt("March");}
            adde=adde+month;
           
            pst1=con1.prepareStatement("UPDATE `graph_sale_month` SET `March`="+adde+" WHERE `Year`="+Integer.parseInt(md[0])+";");
      pst1.execute();
           break;   
      case 4:   
           while(rs.next()){month=rs.getInt("April");}
             adde=adde+month;
            pst1=con1.prepareStatement("UPDATE `graph_sale_month` SET `April`="+adde+" WHERE `Year`="+Integer.parseInt(md[0])+";");
             pst1.execute();
          
           System.out.println("update 4");
           break;
       case 5:
            while(rs.next()){month=rs.getInt("May");}
             adde=adde+month;
            pst1=con1.prepareStatement("UPDATE `graph_sale_month` SET `May`="+adde+" WHERE `Year`="+Integer.parseInt(md[0])+";");
             pst1.execute();
          
            System.out.println("update 1");
           break;
       case 6:
           while(rs.next()){  month=rs.getInt("June");}
             adde=adde+month;
            pst1=con1.prepareStatement("UPDATE `graph_sale_month` SET `June`="+adde+" WHERE `Year`="+Integer.parseInt(md[0])+";");
             pst1.execute();
          
           System.out.println("update 1");
           break;
        case 7:
          while(rs.next()){ month=rs.getInt("July"); }
            adde=adde+month;
            pst1=con1.prepareStatement("UPDATE `graph_sale_month` SET `July`="+adde+" WHERE `Year`="+Integer.parseInt(md[0])+";");
             pst1.execute();
           
          System.out.println("update 1");
           break;
       case 8:
           while(rs.next()){ month=rs.getInt("August");}
            adde=adde+month;
            pst1=con1.prepareStatement("UPDATE `graph_sale_month` SET `August`="+adde+" WHERE `Year`="+Integer.parseInt(md[0])+";");
             pst1.execute();
          
           System.out.println("update 1");
           break;
        case 9:
            while(rs.next()){month=rs.getInt("September");}
             adde=adde+month;
            pst1=con1.prepareStatement("UPDATE `graph_sale_month` SET `September`="+adde+" WHERE `Year`="+Integer.parseInt(md[0])+";");
             pst1.execute();
          
            System.out.println("update 1");
           break;
      case 10:
             while(rs.next()){month=rs.getInt("October");}
             adde=adde+month;
            pst1=con1.prepareStatement("UPDATE `graph_sale_month` SET `October`="+adde+" WHERE `Year`="+Integer.parseInt(md[0])+";");
             pst1.execute();
          
             System.out.println("update 1");
           break;
      case 11:
             while(rs.next()){  month=rs.getInt("November");}
             adde=adde+month;
            pst1=con1.prepareStatement("UPDATE `graph_sale_month` SET `November`="+adde+" WHERE `Year`="+Integer.parseInt(md[0])+";");
             pst1.execute();
          
             System.out.println("update 1");
           break;
      case 12:
             while(rs.next()){  month=rs.getInt("December");}
             adde=adde+month;
            pst1=con1.prepareStatement("UPDATE `graph_sale_month` SET `December`="+adde+" WHERE `Year`="+Integer.parseInt(md[0])+";");
             pst1.execute();
          
             System.out.println("update 1");
           break;
     
     
           
   }
       
   }
       }
      catch (Exception ex) {
      System.out.print(ex);
      }

}
  public void  Stock_update_return(String item_c,int qut){
         try{
                  connection();
          pst3=con.prepareStatement("SELECT * FROM `stock_information` WHERE `date`='"+jLabel18.getText()+"' && `item_code`='"+item_c+"'");
rs3=pst3.executeQuery();
     rs3.next();
     int dtemp=rs3.getInt("dymanic_quality");
     int dym=dtemp+qut;
     System.out.println(qut+"\t"+dtemp+"\tUPDATE `stock_information` SET `dymanic_quality`='"+dym+"'WHERE `date`='"+jLabel18.getText()+"' && `item_code`='"+item_c+"'");
              pst2=con.prepareStatement("UPDATE `stock_information` SET `dymanic_quality`='"+dym+"'WHERE `date`='"+jLabel18.getText()+"' && `item_code`='"+item_c+"'");        
            pst2.executeUpdate();
          
         }
         catch(Exception e){
             System.out.println(e);
         }
         
     }
     
     public void sell(){
        
         try{
             connection();
                pst=con.prepareStatement("insert into sales(user_id, type, name, Total) values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);        
            pst.setString(1,jTextField1.getText());
            pst.setString(2, jLabel19.getText());
            pst.setString(3,jTextField2.getText());
            pst.setString(4, jTextField9.getText());
            
            pst.executeUpdate();
                 pst3=con.prepareStatement("insert into net_flow_sell(`Order_Id`, `user_id`, `name`, `Total`, `type`,date) values(?,?,?,?,?,?)");        
            pst3.setString(1,jLabel27.getText());
            pst3.setString(2, jTextField1.getText());
            pst3.setString(3,jTextField2.getText());
            pst3.setString(4, jTextField9.getText());
             pst3.setString(5, jLabel15.getText());
            pst3.setDate(6,getCurrentDate());
            pst3.executeUpdate();
            
  try{
    
String  itecode="",itename="";

    connection();
                for(int i=0;i<jTable1.getRowCount();i++){
        pst1=con.prepareStatement("insert into sales_information(`order_id`, `sr.no.`, `item_code`, `item_name`, `quality`, `Amount`,price) values(?,?,?,?,?,?,?)");
                    itecode=  jTable1.getValueAt(i, 0).toString();
            itename=  jTable1.getValueAt(i, 1).toString();
          int p=Integer.parseInt(jTable1.getValueAt(i, 2).toString());
          int q=Integer.parseInt(jTable1.getValueAt(i, 3).toString());
          int am=Integer.parseInt(jTable1.getValueAt(i, 4).toString());
          Stock_update(itecode,q);
           System.out.print(itecode+" "+itename+" "+q+" "+p+" "+am);
          System.out.println();
              pst1.setInt(1, Integer.parseInt(jLabel27.getText()));
             pst1.setInt(2,i);
            pst1.setString(3,itecode);
             pst1.setString(4,itename);
          
             pst1.setInt(5,q);
             pst1.setInt(6,am);
             pst1.setInt(7, p);
         pst1.executeUpdate();
                     JOptionPane.showMessageDialog(this,"Success"); 
 
                }
              
  }   
catch(SQLException ex){
  System.out.print("lie 113"+ex);   
}
  
       
         }
         catch(SQLException e){
             
             System.out.print("lie 120"+e);
         }
     }
     
           public void swithPanel(JPanel panel){
        jLayeredPane1.removeAll();
        jLayeredPane1.add(panel);
        jLayeredPane1.repaint();
        jLayeredPane1.revalidate();
    }
           
           
     public void return_sell(){
        
         try{
             connection();
                pst=con.prepareStatement("insert into inflow_sell(`Order_Id`, `user_id`, `name`, `Total`, `Sum`, `percentage`,date,pay) values(?,?,?,?,?,?,?,?)");        
            pst.setInt(1,Integer.parseInt(jTextField10.getText()));
            pst.setString(2, jLabel39.getText());
            pst.setString(3,jTextField11.getText());
            pst.setFloat(4, Float.parseFloat(jTextField16.getText()));
            pst.setInt(5,Integer.parseInt( jTextField17.getText()));
            pst.setInt(6,Integer.parseInt( jComboBox1.getSelectedItem().toString()));
     pst.setDate(7,  getCurrentDate());
     pst.setFloat(8,Float.parseFloat(jTextField18.getText()));
            pst.executeUpdate();
            pst3=con.prepareStatement("UPDATE `net_flow_sell` SET `Total`='"+jTextField16.getText()+"'WHERE `Order_Id`='"+jTextField10.getText()+"'");
            pst3.executeUpdate();
  try{
    
String  itecode="",itename="";

    connection();
                for(int i=0;i<jTable4.getRowCount();i++){
                   itecode= jTable4.getValueAt(i, 0).toString();
            itename=  jTable4.getValueAt(i, 1).toString();
          int q=Integer.parseInt(jTable4.getValueAt(i, 2).toString());
          int am=Integer.parseInt(jTable4.getValueAt(i, 3).toString());
           int p=Integer.parseInt(jTable4.getValueAt(i, 4).toString());
            int rq=Integer.parseInt(jTable4.getValueAt(i, 5).toString());
             Stock_update_return(itecode,rq);
        
            pst1=con.prepareStatement("insert into inflow_sell_information(`Order_id`, `item_code`, `item_name`, `quality`, `Amount`, `price`, `return_quantity`) values(?,?,?,?,?,?,?)");
          
          pst1.setInt(1, Integer.parseInt(jTextField10.getText()));
            
            pst1.setString(2,itecode);
             pst1.setString(3,itename);
             pst1.setInt(4,q);
             pst1.setInt(5,am);
              pst1.setInt(6,p);
               pst1.setInt(7,rq);
         pst1.executeUpdate();
                }
              
  }   
catch(SQLException ex){
  System.out.print("lie 113"+ex);   
}
  
                   JOptionPane.showMessageDialog(this,"Success"); 
 
         }
         catch(SQLException e){
             
             System.out.print("lie 120"+e);
         }
     }
           
           
        public void vendor_information(String Id){
            connection();
try{
      pst=con.prepareStatement("SELECT * FROM `vendor_information` where vendor_Id='"+Id+"';");
     rs=pst.executeQuery();
     if(rs.next()){
    jTextField2.setText(rs.getString("vendor_name"));
   jLabel19.setText(rs.getString("type"));

     }
    }   catch (SQLException ex) {
            Logger.getLogger(login2.class.getName()).log(Level.SEVERE, null, ex);
        }

        }   
    
            public void item_info(String Item){
            connection();
try{
      pst=con.prepareStatement("SELECT * FROM item where item_code='"+Item+"'");
     rs=pst.executeQuery();
     if(rs.next()){
    jTextField5.setText(rs.getString("item_name"));
    int pr;
    pr=rs.getInt("price");
jTextField6.setText(String.valueOf(pr));
     }
    }   catch (SQLException ex) {
            Logger.getLogger(login2.class.getName()).log(Level.SEVERE, null, ex);
        }

        }   
           
            public void item_info2(String Item){
            connection();
try{
      pst=con.prepareStatement("SELECT * FROM item where item_code='"+Item+"'");
     rs=pst.executeQuery();
     if(rs.next()){
    int pr;
    pr=rs.getInt("price");
jTextField6.setText(String.valueOf(pr));
     }
    }   catch (SQLException ex) {
            Logger.getLogger(login2.class.getName()).log(Level.SEVERE, null, ex);
        }

        }   
           
    
           
     public void jaspaerprint(){
         HashMap m= new HashMap();
 m.put("invoice",Integer.parseInt(jLabel27.getText()));
 try{
     JasperDesign jdesign= JRXmlLoader.load("C:\\Users\\Tushar\\Desktop\\Forzon3\\src\\forzon3\\ill.jrxml");
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
     
 public void jaspaerprint_return(){
         HashMap m= new HashMap();
 m.put("invoice_no",Integer.parseInt(jTextField10.getText()));
 try{
     JasperDesign jdesign= JRXmlLoader.load("C:\\Users\\Tushar\\Desktop\\Forzon3\\src\\forzon3\\return_Bill.jrxml");
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
    
     public int ord;
    /**
     * Creates new form Bill
     */
    public Bill() {
    
        initComponents();
        String dates=getCurrentDate().toString();
        jLabel18.setText(dates);
        jLabel38.setText(dates);
    }
public void clear_sell(){
    jTextField1.setText("");
    jTextField2.setText("");
    jLabel27.setText("");
    jLabel19.setText("");
    jTextField4.setText("");
    jTextField5.setText("");
    jTextField6.setText("");
    int set_s=0;
       jSpinner1.setValue(set_s);
       jTextField8.setText("");
       jTextField9.setText("");
       DefaultTableModel add=new DefaultTableModel();
        add=(DefaultTableModel)jTable1.getModel();
        add.setRowCount(0);
    
}
   public void clear_inflow(){
       jTextField10.setText("");
       jTextField11.setText("");
       jLabel39.setText("");
       jTextField12.setText("");
       jTextField13.setText("");
       jTextField14.setText("");
       int set_s=0;
       jSpinner2.setValue(set_s);
       jTextField15.setText("");
       jTextField17.setText("");
       jTextField18.setText("");
       jTextField16.setText("");
       DefaultTableModel add=new DefaultTableModel();
        add=(DefaultTableModel)jTable4.getModel();
        add.setRowCount(0);
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
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setOpaque(false);
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLayeredPane1.setLayout(new java.awt.CardLayout());

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 3, 3, new java.awt.Color(0, 255, 51)));
        jPanel4.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 51));
        jLabel4.setText("vendor  ID:");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(50, 100, 150, 29);

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(204, 51, 255));
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        jPanel4.add(jTextField1);
        jTextField1.setBounds(50, 150, 373, 40);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 255, 51));
        jLabel5.setText("NAME:");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(473, 100, 74, 29);

        jTextField2.setBackground(new java.awt.Color(0, 0, 0));
        jTextField2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel4.add(jTextField2);
        jTextField2.setBounds(473, 150, 373, 40);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 51));
        jLabel6.setText("ORDER NO.:");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(896, 100, 143, 29);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 255, 51));
        jLabel7.setText("TYPE OF VENDOR:");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(1319, 100, 218, 29);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 255, 51));
        jLabel8.setText("VENDOR INFORMATION :");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(50, 50, 300, 29);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 51));
        jLabel9.setText("SELLING PRODUCT INFORMATION:");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(50, 200, 412, 29);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 255, 51));
        jLabel10.setText("ITEM CODE:");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(50, 250, 138, 29);

        jTextField4.setBackground(new java.awt.Color(0, 0, 0));
        jTextField4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(204, 51, 255));
        jTextField4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });
        jPanel4.add(jTextField4);
        jTextField4.setBounds(50, 300, 279, 40);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 255, 51));
        jLabel11.setText("ITEM NAME:");
        jPanel4.add(jLabel11);
        jLabel11.setBounds(379, 250, 136, 29);

        jTextField5.setBackground(new java.awt.Color(0, 0, 0));
        jTextField5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel4.add(jTextField5);
        jTextField5.setBounds(379, 300, 279, 40);

        jLabel12.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 255, 51));
        jLabel12.setText("PRICE:");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(708, 250, 79, 29);

        jTextField6.setBackground(new java.awt.Color(0, 0, 0));
        jTextField6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
        });
        jPanel4.add(jTextField6);
        jTextField6.setBounds(708, 300, 279, 40);

        jLabel13.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 255, 51));
        jLabel13.setText("QUANTITY:");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(1037, 250, 125, 29);

        jLabel14.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 255, 51));
        jLabel14.setText("AMOUNT:");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(1366, 250, 108, 29);

        jTextField8.setBackground(new java.awt.Color(0, 0, 0));
        jTextField8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(255, 255, 255));
        jTextField8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel4.add(jTextField8);
        jTextField8.setBounds(1366, 300, 279, 40);

        jTable1.setBackground(new java.awt.Color(51, 51, 51));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51), 3));
        jTable1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM CODE", "ITEM NAME", "PRICE", "QUANTITY", "AMOUNT"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setGridColor(new java.awt.Color(204, 51, 255));
        jTable1.setName(""); // NOI18N
        jTable1.setRowHeight(30);
        jTable1.setRowMargin(5);
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(50, 370, 1142, 263);

        jButton1.setBackground(new java.awt.Color(0, 255, 51));
        jButton1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);
        jButton1.setBounds(1230, 460, 415, 50);

        jButton2.setBackground(new java.awt.Color(0, 255, 51));
        jButton2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton2.setText("Print and Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);
        jButton2.setBounds(1230, 520, 415, 50);

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);
        jButton3.setBounds(1230, 580, 200, 50);

        jButton4.setBackground(new java.awt.Color(0, 255, 51));
        jButton4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton4.setText("Delete All");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);
        jButton4.setBounds(1445, 580, 200, 50);

        jLabel15.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 255, 51));
        jLabel15.setText("TOTAL:");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(1230, 370, 82, 29);

        jTextField9.setBackground(new java.awt.Color(0, 0, 0));
        jTextField9.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(255, 255, 255));
        jTextField9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel4.add(jTextField9);
        jTextField9.setBounds(1230, 410, 415, 40);

        jSpinner1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jSpinner1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51), 3));
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        jPanel4.add(jSpinner1);
        jSpinner1.setBounds(1037, 300, 279, 40);

        jLabel16.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 255, 51));
        jPanel4.add(jLabel16);
        jLabel16.setBounds(980, 76, 0, 0);

        jLabel17.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 255, 51));
        jLabel17.setText("DATE:");
        jPanel4.add(jLabel17);
        jLabel17.setBounds(1440, 10, 120, 30);

        jLabel18.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 255, 51));
        jPanel4.add(jLabel18);
        jLabel18.setBounds(1510, 10, 160, 30);

        jLabel19.setBackground(new java.awt.Color(51, 51, 51));
        jLabel19.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel4.add(jLabel19);
        jLabel19.setBounds(1320, 150, 320, 40);

        jLabel27.setBackground(new java.awt.Color(51, 51, 51));
        jLabel27.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel4.add(jLabel27);
        jLabel27.setBounds(896, 150, 373, 40);

        jLayeredPane1.add(jPanel4, "card2");

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(null);

        jLabel20.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 255, 51));
        jLabel20.setText("ORDER ID:");
        jPanel3.add(jLabel20);
        jLabel20.setBounds(50, 50, 123, 29);

        jTextField3.setBackground(new java.awt.Color(51, 51, 51));
        jTextField3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(0, 255, 51));
        jTextField3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel3.add(jTextField3);
        jTextField3.setBounds(50, 100, 800, 35);

        jLabel21.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 255, 51));
        jLabel21.setText("OUT:");
        jPanel3.add(jLabel21);
        jLabel21.setBounds(50, 160, 57, 29);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item code", "item name", "Quantity"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(50, 190, 750, 430);

        jLabel22.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 255, 51));
        jLabel22.setText("IN:");
        jPanel3.add(jLabel22);
        jLabel22.setBounds(890, 160, 30, 29);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item code", "Item name", "Quantity", "price", "Amount"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(880, 190, 760, 350);

        jButton5.setBackground(new java.awt.Color(204, 51, 255));
        jButton5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 255, 51));
        jButton5.setText(">>");
        jPanel3.add(jButton5);
        jButton5.setBounds(810, 190, 61, 50);

        jButton6.setBackground(new java.awt.Color(0, 255, 51));
        jButton6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton6.setText("PRINT AND SAVE");
        jPanel3.add(jButton6);
        jButton6.setBounds(1140, 580, 290, 50);

        jButton7.setBackground(new java.awt.Color(255, 51, 51));
        jButton7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton7.setText("REMOVE");
        jPanel3.add(jButton7);
        jButton7.setBounds(1460, 580, 180, 50);

        jButton8.setBackground(new java.awt.Color(204, 51, 255));
        jButton8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton8.setText("Search");
        jPanel3.add(jButton8);
        jButton8.setBounds(850, 90, 140, 50);

        jLabel23.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 255, 51));
        jLabel23.setText("TOTAL:");
        jPanel3.add(jLabel23);
        jLabel23.setBounds(850, 560, 82, 29);

        jTextField7.setBackground(new java.awt.Color(51, 51, 51));
        jTextField7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(0, 255, 51));
        jTextField7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel3.add(jTextField7);
        jTextField7.setBounds(850, 590, 260, 35);

        jLayeredPane1.add(jPanel3, "card3");

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 3, 3, new java.awt.Color(0, 255, 51)));
        jPanel5.setLayout(null);

        jLabel24.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 255, 51));
        jLabel24.setText("ORDER NO.:");
        jPanel5.add(jLabel24);
        jLabel24.setBounds(50, 100, 160, 29);

        jTextField10.setBackground(new java.awt.Color(51, 51, 51));
        jTextField10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(204, 51, 255));
        jTextField10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField10KeyPressed(evt);
            }
        });
        jPanel5.add(jTextField10);
        jTextField10.setBounds(50, 150, 373, 30);

        jLabel25.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 255, 51));
        jLabel25.setText("NAME:");
        jPanel5.add(jLabel25);
        jLabel25.setBounds(473, 100, 74, 29);

        jTextField11.setBackground(new java.awt.Color(51, 51, 51));
        jTextField11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(204, 51, 255));
        jTextField11.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel5.add(jTextField11);
        jTextField11.setBounds(473, 150, 373, 30);

        jLabel26.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 255, 51));
        jLabel26.setText("VENDOR ID:");
        jPanel5.add(jLabel26);
        jLabel26.setBounds(896, 100, 170, 29);

        jLabel28.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 255, 51));
        jLabel28.setText("VENDOR INFORMATION :");
        jPanel5.add(jLabel28);
        jLabel28.setBounds(50, 50, 300, 29);

        jLabel29.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 255, 51));
        jLabel29.setText("SELLING PRODUCT INFORMATION:");
        jPanel5.add(jLabel29);
        jLabel29.setBounds(50, 200, 412, 29);

        jLabel30.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 255, 51));
        jLabel30.setText("ITEM CODE:");
        jPanel5.add(jLabel30);
        jLabel30.setBounds(50, 230, 138, 29);

        jTextField12.setBackground(new java.awt.Color(51, 51, 51));
        jTextField12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(204, 51, 255));
        jTextField12.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField12KeyPressed(evt);
            }
        });
        jPanel5.add(jTextField12);
        jTextField12.setBounds(50, 280, 279, 30);

        jLabel31.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 255, 51));
        jLabel31.setText("ITEM NAME:");
        jPanel5.add(jLabel31);
        jLabel31.setBounds(380, 230, 136, 29);

        jTextField13.setBackground(new java.awt.Color(51, 51, 51));
        jTextField13.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField13.setForeground(new java.awt.Color(204, 51, 255));
        jTextField13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField13);
        jTextField13.setBounds(380, 280, 279, 30);

        jLabel32.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 255, 51));
        jLabel32.setText("PRICE:");
        jPanel5.add(jLabel32);
        jLabel32.setBounds(710, 230, 79, 29);

        jTextField14.setBackground(new java.awt.Color(51, 51, 51));
        jTextField14.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField14.setForeground(new java.awt.Color(204, 51, 255));
        jTextField14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField14KeyPressed(evt);
            }
        });
        jPanel5.add(jTextField14);
        jTextField14.setBounds(710, 280, 279, 30);

        jLabel33.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 255, 51));
        jLabel33.setText("QUANTITY:");
        jPanel5.add(jLabel33);
        jLabel33.setBounds(1030, 230, 125, 29);

        jLabel34.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 255, 51));
        jLabel34.setText("AMOUNT:");
        jPanel5.add(jLabel34);
        jLabel34.setBounds(1360, 230, 108, 29);

        jTextField15.setBackground(new java.awt.Color(51, 51, 51));
        jTextField15.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField15.setForeground(new java.awt.Color(204, 51, 255));
        jTextField15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel5.add(jTextField15);
        jTextField15.setBounds(1360, 280, 279, 30);

        jTable4.setBackground(new java.awt.Color(51, 51, 51));
        jTable4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51), 3));
        jTable4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTable4.setForeground(new java.awt.Color(0, 204, 0));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Item Name", "Quality", "Amount", "price", "Return Quantity"
            }
        ));
        jTable4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable4.setName(""); // NOI18N
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jPanel5.add(jScrollPane4);
        jScrollPane4.setBounds(40, 340, 1142, 263);

        jButton9.setBackground(new java.awt.Color(204, 51, 255));
        jButton9.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton9.setText("CHANGE");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton9);
        jButton9.setBounds(1200, 530, 415, 50);

        jButton10.setBackground(new java.awt.Color(0, 255, 51));
        jButton10.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton10.setText("Print and Save");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton10);
        jButton10.setBounds(1200, 600, 415, 50);

        jLabel35.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 255, 51));
        jLabel35.setText("TOTAL:");
        jPanel5.add(jLabel35);
        jLabel35.setBounds(1200, 450, 82, 29);

        jTextField16.setBackground(new java.awt.Color(51, 51, 51));
        jTextField16.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextField16.setForeground(new java.awt.Color(204, 51, 255));
        jTextField16.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel5.add(jTextField16);
        jTextField16.setBounds(1200, 480, 415, 30);

        jSpinner2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner2StateChanged(evt);
            }
        });
        jPanel5.add(jSpinner2);
        jSpinner2.setBounds(1030, 280, 279, 30);

        jLabel36.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 255, 51));
        jPanel5.add(jLabel36);
        jLabel36.setBounds(980, 76, 0, 0);

        jLabel37.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 255, 51));
        jLabel37.setText("DATE:");
        jPanel5.add(jLabel37);
        jLabel37.setBounds(1330, 100, 80, 30);

        jLabel38.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 255, 51));
        jLabel38.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel5.add(jLabel38);
        jLabel38.setBounds(1330, 150, 200, 30);

        jLabel39.setBackground(new java.awt.Color(51, 51, 51));
        jLabel39.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(204, 51, 255));
        jLabel39.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel5.add(jLabel39);
        jLabel39.setBounds(896, 150, 373, 30);

        jLabel40.setForeground(new java.awt.Color(0, 255, 51));
        jLabel40.setText("Sum :");
        jPanel5.add(jLabel40);
        jLabel40.setBounds(1210, 330, 170, 20);
        jPanel5.add(jTextField17);
        jTextField17.setBounds(1210, 360, 160, 20);

        jLabel41.setForeground(new java.awt.Color(0, 255, 51));
        jLabel41.setText("percentage of pay");
        jPanel5.add(jLabel41);
        jLabel41.setBounds(1410, 330, 150, 14);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "20", "25", "30" }));
        jPanel5.add(jComboBox1);
        jComboBox1.setBounds(1400, 360, 150, 20);

        jLabel42.setForeground(new java.awt.Color(0, 255, 51));
        jLabel42.setText("pay of Street vendor");
        jPanel5.add(jLabel42);
        jLabel42.setBounds(1200, 410, 150, 14);
        jPanel5.add(jTextField18);
        jTextField18.setBounds(1340, 410, 240, 20);

        jLayeredPane1.add(jPanel5, "card2");

        jPanel1.add(jLayeredPane1);
        jLayeredPane1.setBounds(0, 100, 1695, 675);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 51)));
        jPanel2.setLayout(null);

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 204, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("IN");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 51, 255)));
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3);
        jLabel3.setBounds(847, 50, 847, 50);

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 204, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("OUT");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 0, 3, new java.awt.Color(204, 51, 255)));
        jLabel2.setOpaque(true);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 50, 847, 50);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bill System");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 1695, 50);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1695, 100);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 1695, 775);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
PanelB();
        labellB(jLabel2);
  Color myWhite1 = new Color(204,51,255); 
           jLabel3.setBorder(new MatteBorder(0, 0, 3, 0, myWhite1)); 
swithPanel(jPanel4);
clear_sell();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
PanelB();
        labellB(jLabel3);
           Color myWhite1 = new Color(204,51,255); 
           jLabel2.setBorder(new MatteBorder(0, 0, 3, 0, myWhite1)); 
swithPanel(jPanel5);
clear_inflow();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
       if(jTextField6.getText().equals("")){
        }
       else{
        try{
        connection();
          pst=con.prepareStatement("SELECT * FROM `stock_information` WHERE `date`='"+jLabel18.getText()+"' && `item_code`='"+jTextField4.getText()+"'");
rs=pst.executeQuery();
     rs.next();
     if(rs.getInt("dymanic_quality")>=Integer.parseInt(jSpinner1.getValue().toString())){
      
        int pr=Integer.parseInt(jTextField6.getText());
        int Q=Integer.parseInt(jSpinner1.getValue().toString());
        int total=pr*Q;
        jTextField8.setText(String.valueOf(total));
     }
     else
     {
             JOptionPane.showMessageDialog(this,"Not Available The  Item Qty."); 
             jTextField4.setText("");
jTextField5.setText("");
jTextField6.setText("");
jTextField8.setText("");
int ff=0;
jSpinner1.setValue(ff);
 
     }

 
        
       
     }catch(Exception e){
         System.out.print(e);
     }
       }
        // TODO add your handling code here:
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
  
             
 DefaultTableModel add=new DefaultTableModel();
 add=(DefaultTableModel)jTable1.getModel();
        for(int i=jTable1.getRowCount()-1;i>=0;i--){
       
  
 add.removeRow(i);
         }
  int sum=0;
        
        for(int i=0;i<jTable1.getRowCount();i++){
            sum=sum+Integer.parseInt(jTable1.getValueAt(i, 4).toString());
        }
        jTextField9.setText(String.valueOf(sum));

         // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        sell();
        jaspaerprint();
        graph_information(Integer.parseInt(jTextField9.getText()));
   clear_sell();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel add=new DefaultTableModel();
        add=(DefaultTableModel)jTable1.getModel();
        add.addRow(new Object[]{
            jTextField4.getText(),
            jTextField5.getText(),
            jTextField6.getText(),
            jSpinner1.getValue().toString(),
            jTextField8.getText()
        });
        int sum=0;
        int i;
        for( i=0;i<jTable1.getRowCount();i++){
            sum=sum+Integer.parseInt(jTable1.getValueAt(i, 4).toString());
        }
        jTextField9.setText(String.valueOf(sum));
jTextField4.setText("");
jTextField5.setText("");
jTextField6.setText("");
jTextField8.setText("");
int ff=0;
jSpinner1.setValue(ff);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        
        ord=0;
        try{
            connection();
            pst=con.prepareStatement("SELECT * FROM `sales`");
            rs=pst.executeQuery();

            while(rs.next()){
                ord=rs.getInt("Order_id");
            }

            jLabel27.setText(String.valueOf(ord+1));
con.close();
        }catch(Exception e){
            System.out.print(e);
        }
        
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        vendor_information(jTextField1.getText());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jSpinner2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner2StateChanged
      
        if(jTextField14.getText().equals("")){
        }
        else{
        int pr=Integer.parseInt(jTextField14.getText());
        int Q=Integer.parseInt(jSpinner2.getValue().toString());
        int total=pr*Q;
        jTextField15.setText(String.valueOf(total));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jSpinner2StateChanged

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
if(jTextField11.getText().equals("")){
        
                   JOptionPane.showMessageDialog(this,"please Enter the order Id"); 
 
    }
else{
        return_sell();
jaspaerprint_return();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
if(jTextField12.getText().equals("")){
    
}
else{
        int i=jTable4.getSelectedRow();
 DefaultTableModel add=new DefaultTableModel();
 add=(DefaultTableModel)jTable4.getModel();
 if(i>=0){
     add.setValueAt(jSpinner2.getValue().toString(), i, 5);
    int qu= a1-Integer.parseInt(jSpinner2.getValue().toString());
      add.setValueAt(qu, i, 2);
      int amm=a2-Integer.parseInt(jTextField15.getText());
     add.setValueAt(amm, i, 3); 
 }
 else{
          JOptionPane.showMessageDialog(this,"error");     
clear_inflow();
 }
}
       int sum=0;
        int j;
        for( j=0;j<jTable4.getRowCount();j++){
            sum=sum+Integer.parseInt(jTable4.getValueAt(j, 3).toString());
        }
        
       jTextField17.setText(String.valueOf(sum));
       float pay=(sum*Integer.parseInt(jComboBox1.getSelectedItem().toString()))/100;
       jTextField18.setText(String.valueOf(pay));
       jTextField16.setText(String.valueOf(sum-pay));

 
 // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyPressed
     ResultSet rs1=null;
    
    PreparedStatement itemi =null;
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
           try{
              
        connection();
          pst=con.prepareStatement("SELECT * FROM  `sales` where Order_id='"+jTextField10.getText()+"'");
     rs=pst.executeQuery();
      
     if(rs.next()){
if(rs.getString("Order_id").equals(jTextField10.getText())){
    jTextField11.setText(rs.getString("name"));
    jLabel39.setText(rs.getString("user_id"));
    DefaultTableModel add=new DefaultTableModel();
        add=(DefaultTableModel)jTable4.getModel();
         itemi=con.prepareStatement("SELECT * FROM   `sales_information` where Order_id='"+jTextField10.getText()+"'");
     rs1=itemi.executeQuery();
     
    while(rs1.next()){
   
        add.addRow(new Object[]{
            rs1.getString("item_code"),
            rs1.getString("item_name"),
            rs1.getInt("quality"),
            rs1.getInt("Amount"),
           rs1.getInt("price"),0
           
        });
    }
   
}

 }
     else{
     

     JOptionPane.showMessageDialog(this,"Invaid order no");       
    clear_inflow();
}
   
     }catch(Exception e){
         System.out.print(e);
     }
  
   
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10KeyPressed

    private void jTextField14KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14KeyPressed
public int a1,a2,a3;
    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
int i=jTable4.getSelectedRow();
TableModel model=jTable4.getModel();
        jTextField12.setText(model.getValueAt(i,0).toString());
        jTextField13.setText(model.getValueAt(i,1).toString());
    a1=Integer.parseInt(model.getValueAt(i,2).toString());
    a2=Integer.parseInt(model.getValueAt(i,3).toString());
jTextField14.setText(model.getValueAt(i,4).toString());        

// TODO add your handling code here:
    }//GEN-LAST:event_jTable4MouseClicked

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        item_info(jTextField4.getText());
}
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
int j=jTable1.getSelectedRow();
 DefaultTableModel add=new DefaultTableModel();
 add=(DefaultTableModel)jTable1.getModel();
 add.removeRow(j);
  int sum=0;
        int i;
        for( i=0;i<jTable1.getRowCount();i++){
            sum=sum+Integer.parseInt(jTable1.getValueAt(i, 4).toString());
        }
        jTextField9.setText(String.valueOf(sum));


     // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyPressed
item_info2(jTextField12.getText());
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12KeyPressed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    public javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
