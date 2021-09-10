
/*
 * To chang``e this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forzon3;

import static forzon3.Dashboard1.jPanel5;
import static forzon3.street_vendor.jPanel8;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

/**
 *
 * @author chaitany
 */
public class empoyeedas extends javax.swing.JFrame {
     public static java.sql.Date getCurrentDate() {
    java.util.Date today = new java.util.Date();
    return new java.sql.Date(today.getTime());
}
 
    public static boolean isValid(String s) {
        // The given argument to compile() method  
        // is regular expression. With the help of  
        // regular expression we can validate mobile 
        // number.  
        // 1) Begins with 0 or 91 
        // 2) Then contains 7 or 8 or 9. 
        // 3) Then contains 9 digits 
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");

        // Pattern class contains matcher() method 
        // to find matching between given number  
        // and regular expression 
        Matcher m = p.matcher(s);
        return (m.find() && m.group().equals(s));
    }

    public void labellB(JLabel label1, JLabel label2) {
        Color myWhite1 = new Color(0, 255, 51);
        jLabel4.setBorder(new MatteBorder(0, 0, 2, 0, myWhite1));
        jLabel1.setBorder(new MatteBorder(0, 0, 2, 0, myWhite1));

        jLabel27.setBorder(new MatteBorder(0, 0, 2, 0, myWhite1));
        jLabel42.setBorder(new MatteBorder(0, 0, 2, 0, myWhite1));

        jLabel3.setBorder(new MatteBorder(0, 0, 2, 0, myWhite1));
        jLabel5.setBorder(new MatteBorder(0, 0, 2, 0, myWhite1));

        jLabel25.setBorder(new MatteBorder(0, 0, 2, 0, myWhite1));
        jLabel29.setBorder(new MatteBorder(0, 0, 2, 0, myWhite1));

        jLabel24.setBorder(new MatteBorder(0, 0, 2, 0, myWhite1));
        jLabel43.setBorder(new MatteBorder(0, 0, 2, 0, myWhite1));

        jLabel26.setBorder(new MatteBorder(0, 0, 2, 0, myWhite1));
        jLabel47.setBorder(new MatteBorder(0, 0, 2, 0, myWhite1));

        Color myWhite = new Color(204, 51, 255);
        label1.setBorder(new MatteBorder(0, 0, 2, 0, myWhite));
        label2.setBorder(new MatteBorder(0, 0, 2, 0, myWhite));
    }
    //declared variable for register form 
    public String en, eui, ep, eadc, eadd, econ, egender, epos, eed, esa, edob, ejb;
    public String eimg = "C:\\Users\\chaitany\\Desktop\\Forzon3\\src\\forzon3\\emimage\\job.jpg";
//declared vaile for sql 
    public ResultSet rs = null;
    public Connection con = null;
    public PreparedStatement pst = null;

    //It is fuction for reset screen
    public void reset() {

        if (this.menu.getX() == 0) {
            this.menu.setBounds(-190, 50, 250, 900);
        }
        if (this.profiles12.getY() == 40) {
            this.profiles12.setBounds(650, -590, 500, 700);
        }

    }

    public void reset3() {

        if (this.menu.getX() == 0) {
            this.menu.setBounds(-190, 50, 250, 900);
        }
        if (this.profiles12.getY() == 40) {
            this.profiles12.setBounds(650, -590, 500, 700);
        }

    }

    public void reset1() {

        if (this.profiles12.getY() == 40) {
            this.profiles12.setBounds(650, -590, 500, 700);
        }

    }

    public void reset2() {
        if (this.menu.getX() == 0) {
            this.menu.setBounds(-190, 50, 250, 900);
        }

    }
    public void disale(JLabel label1,JTextField texte,JLabel label2,JTextField texte1){
             Color myWhite = new Color(102,102,102);   
           label1.setForeground(myWhite);
      texte.setBorder(new MatteBorder(0, 0, 3, 0, myWhite)); 
      Color myWhite2 = new Color(0,255,51); 
         Color myWhite1 = new Color(204,51,255);   
           label2.setForeground(myWhite2);
      texte1.setBorder(new MatteBorder(0, 0, 3, 0, myWhite1)); 
   
    }
    //End of reset funnction
    //start of camera code funnction
     public DaemonThread myThread = null;
    int count = 0;

    VideoCapture webSource = null;
    Mat frame = new Mat();
    MatOfByte mem = new MatOfByte();
    CascadeClassifier faceDetector = new CascadeClassifier(empoyeedas.class.getResource("haarcascade_frontalface_alt.xml").getPath().substring(1));
    MatOfRect faceDetections = new MatOfRect();
///    

    public void closecamera() {
        if (jButton10.getText().equals("Pause")) {

            myThread.runnable = false;            // stop thread
            // activate start button
           jButton10.setEnabled(true);     // deactivate stop button
           jButton10.setText("OPEN CAMERA");
            webSource.release();
        }
    }

    public class DaemonThread implements Runnable {

        protected volatile boolean runnable = false;

        @Override
        public void run() {
            synchronized (this) {
                while (runnable) {
                    if (webSource.grab()) {
                        try {
                            webSource.retrieve(frame);
                            Graphics g = jPanel22.getGraphics();
                            faceDetector.detectMultiScale(frame, faceDetections);
                            for (Rect rect : faceDetections.toArray()) {
                                // System.out.println("ttt");
                                Imgproc.rectangle(frame, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                                        new Scalar(0, 255, 0));
                            }
                            Imgcodecs.imencode(".bmp", frame, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
                            BufferedImage buff = (BufferedImage) im;
                            if (g.drawImage(buff, 0, 0, 650, 650, 0, 0, buff.getWidth(), buff.getHeight(), null)) {
                                if (runnable == false) {
                                    System.out.println("Paused ..... ");
                                    this.wait();
                                }
                            }
                        } catch (Exception ex) {
                            System.out.println("Error!!");
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
    }
//End function camera

    /**
     * Creates new form Dashboard1
     */
    //Function of resize
    public void resize(JLabel a, String d) {
        try{
        ImageIcon myimage1 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(d)));
        Image img3 = myimage1.getImage();
        Image img4 = img3.getScaledInstance(a.getWidth(), a.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i11 = new ImageIcon(img4);
        a.setIcon(i11);
        }
        catch(Exception e){
            System.out.print("ll"+e);
        }
    }
    
    public void resize3(JButton a,String d){
      ImageIcon myimage1=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(d)));
        Image img3=myimage1.getImage();
        Image img4=img3.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon i11=new ImageIcon(img4);   
       a.setIcon(i11);
}
                      public void resize1(JLabel a,BufferedImage d){
      ImageIcon myimage1=new ImageIcon(d);
        Image img3=myimage1.getImage();
        Image img4=img3.getScaledInstance(a.getWidth(),a.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon i11=new ImageIcon(img4);   
       a.setIcon(i11);
}

    //Function of connection

    public void connection() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/froze", "root", "");

            System.out.println("Database connection terminated");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void swithPanel(JPanel panel) {
        jLayeredPane1.removeAll();
        jLayeredPane1.add(panel);
        jLayeredPane1.repaint();
        jLayeredPane1.revalidate();
    }

    public empoyeedas() {
        initComponents();
      
        jLabel30.setVisible(false);
       resize(pl9, "icons8-pull-down-96 (1).png");
       resize(pl1,"ashoka1.jpg");
         resize(jLabel51,"iias3.png");
          resize(pl6, "tra1.png");
       
        resize(jLabel30, "unnamed.png");
        resize(pl7, "profiles.png");
jPanel12.setVisible(false);
//hOME
jTextField6.setEditable(true);
        jTextField7.setEditable(false); 
disale(jLabel69,jTextField7,jLabel64,jTextField6);
resize3(jButton8,"backup.png");
       resize3(jButton2,"restore.png");
       resize(jLabel53,"iias3.png");
        resize(jLabel55,"ICY123.jpg");
       System.out.print("Home");
    grap();
      
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
            jPanel15.removeAll();
             jPanel15.add(panel,BorderLayout.CENTER);
              
              jPanel15.validate();
           
          
        }
        catch(Exception ex){
          System.out.print(ex);
        }

}/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        profiles12 = new javax.swing.JPanel();
        profiles = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        pl1 = new javax.swing.JLabel();
        pl2 = new javax.swing.JLabel();
        pl3 = new javax.swing.JLabel();
        pl4 = new javax.swing.JLabel();
        pl5 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        pl9 = new javax.swing.JLabel();
        pl8 = new javax.swing.JLabel();
        pl7 = new javax.swing.JLabel();
        pl6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        HOME = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        graph1 = new forzon3.graph();
        bill_information1 = new forzon3.Bill_information();
        bill1 = new forzon3.Bill();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        record2 = new forzon3.Record();
        jPanel13 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel69 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 51), 5));
        jPanel1.setLayout(null);

        menu.setBackground(new java.awt.Color(0, 0, 0));
        menu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 5, 0, new java.awt.Color(0, 255, 102)));
        menu.setName(""); // NOI18N
        menu.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 51), 5));
        jPanel3.setLayout(null);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forzon3/image/menu3.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2);
        jLabel2.setBounds(5, 18, 50, 50);

        jLabel1.setForeground(new java.awt.Color(51, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forzon3/image/Home.png"))); // NOI18N
        jLabel1.setToolTipText("HOME");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 51, 255)));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel1);
        jLabel1.setBounds(5, 75, 50, 50);

        jLabel3.setForeground(new java.awt.Color(51, 255, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forzon3/image/register.png"))); // NOI18N
        jLabel3.setToolTipText("RECORD");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 51)));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel3);
        jLabel3.setBounds(5, 189, 50, 50);

        jLabel25.setForeground(new java.awt.Color(51, 255, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forzon3/VENDOR.png"))); // NOI18N
        jLabel25.setToolTipText("REGISTRATION VENDOR");
        jLabel25.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 51)));
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel25);
        jLabel25.setBounds(5, 246, 50, 50);

        jLabel24.setForeground(new java.awt.Color(51, 255, 0));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forzon3/image/Bill2.png"))); // NOI18N
        jLabel24.setToolTipText("BILL");
        jLabel24.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 51)));
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel24);
        jLabel24.setBounds(5, 303, 50, 50);

        jLabel26.setForeground(new java.awt.Color(51, 255, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forzon3/STOCK.png"))); // NOI18N
        jLabel26.setToolTipText("STOCK");
        jLabel26.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 51)));
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel26);
        jLabel26.setBounds(5, 360, 50, 50);

        jLabel27.setForeground(new java.awt.Color(0, 255, 51));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forzon3/image/profiles.png"))); // NOI18N
        jLabel27.setToolTipText("PROFILE");
        jLabel27.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 51)));
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel27);
        jLabel27.setBounds(5, 132, 50, 50);

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forzon3/image/logout.png"))); // NOI18N
        jLabel28.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(255, 0, 0)));
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel28);
        jLabel28.setBounds(5, 845, 50, 50);

        menu.add(jPanel3);
        jPanel3.setBounds(190, 0, 60, 900);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(0, 255, 102)));
        jPanel4.setLayout(null);

        jLabel4.setBackground(new java.awt.Color(51, 255, 0));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 255, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Home");
        jLabel4.setToolTipText("HOME");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(204, 51, 255)));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel4);
        jLabel4.setBounds(5, 75, 185, 50);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 255, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Record");
        jLabel5.setToolTipText("RECORD");
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 51)));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel5);
        jLabel5.setBounds(5, 189, 185, 50);

        jLabel29.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 255, 0));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("VENDOR");
        jLabel29.setToolTipText("REGISTRATION VENDOR");
        jLabel29.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 51)));
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel29);
        jLabel29.setBounds(5, 246, 185, 50);

        jLabel42.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(51, 255, 0));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Profile");
        jLabel42.setToolTipText("PROFILE");
        jLabel42.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 51)));
        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel42MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel42);
        jLabel42.setBounds(5, 132, 185, 50);

        jLabel43.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(51, 255, 0));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Bill");
        jLabel43.setToolTipText("BILL");
        jLabel43.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 51)));
        jLabel43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel43MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel43);
        jLabel43.setBounds(5, 303, 185, 50);

        jLabel44.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 0, 0));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Log out");
        jLabel44.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 0, 0, new java.awt.Color(255, 0, 0)));
        jPanel4.add(jLabel44);
        jLabel44.setBounds(5, 845, 185, 50);

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel45.setText("Logout");
        jPanel4.add(jLabel45);
        jLabel45.setBounds(56, 618, 84, 29);

        jLabel47.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(51, 255, 0));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Stock");
        jLabel47.setToolTipText("STOCK");
        jLabel47.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 51)));
        jLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel47MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel47);
        jLabel47.setBounds(5, 360, 185, 50);

        menu.add(jPanel4);
        jPanel4.setBounds(0, 0, 190, 895);

        jPanel1.add(menu);
        menu.setBounds(-190, 50, 250, 900);
        menu.getAccessibleContext().setAccessibleName("");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 51), 5));
        jPanel2.setLayout(null);

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forzon3/image/colsed.png"))); // NOI18N
        jLabel46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 8));
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel46MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel46);
        jLabel46.setBounds(1755, 5, 40, 40);

        jLabel50.setFont(new java.awt.Font("Eras Demi ITC", 1, 60)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText(" -");
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel50MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel50);
        jLabel50.setBounds(1700, 7, 40, 30);
        jPanel2.add(jLabel51);
        jLabel51.setBounds(10, 5, 40, 40);

        jLabel52.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(204, 51, 255));
        jLabel52.setText("IIAS(ICE-CREAM IDUSTRIAL ADMINISTRATIVE SUIT)");
        jPanel2.add(jLabel52);
        jLabel52.setBounds(55, 10, 620, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1800, 50);

        profiles12.setOpaque(false);

        profiles.setOpaque(false);
        profiles.setLayout(null);

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 102), 5));
        jPanel11.setLayout(null);

        pl1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 102), 5));
        jPanel11.add(pl1);
        pl1.setBounds(0, 10, 500, 490);

        pl2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        pl2.setForeground(new java.awt.Color(153, 51, 255));
        pl2.setText("HELLO");
        jPanel11.add(pl2);
        pl2.setBounds(50, 540, 60, 22);

        pl3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        pl3.setForeground(new java.awt.Color(153, 51, 255));
        pl3.setText("USER ID: ");
        jPanel11.add(pl3);
        pl3.setBounds(50, 580, 82, 22);

        pl4.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        pl4.setForeground(new java.awt.Color(153, 51, 255));
        pl4.setText("CHAITANYA");
        jPanel11.add(pl4);
        pl4.setBounds(120, 520, 300, 50);

        pl5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        pl5.setForeground(new java.awt.Color(0, 255, 102));
        pl5.setText("123456");
        jPanel11.add(pl5);
        pl5.setBounds(140, 577, 300, 22);

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 3));
        jPanel12.setLayout(null);

        jLabel32.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 255, 51));
        jLabel32.setText("OLD PASSWORD:");
        jPanel12.add(jLabel32);
        jLabel32.setBounds(50, 80, 400, 50);

        jTextField1.setBackground(new java.awt.Color(51, 51, 51));
        jTextField1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(204, 51, 255));
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel12.add(jTextField1);
        jTextField1.setBounds(50, 130, 400, 40);

        jLabel33.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 255, 51));
        jLabel33.setText("NEW PASSWORD:");
        jPanel12.add(jLabel33);
        jLabel33.setBounds(50, 180, 400, 50);

        jTextField9.setBackground(new java.awt.Color(51, 51, 51));
        jTextField9.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(204, 51, 255));
        jTextField9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel12.add(jTextField9);
        jTextField9.setBounds(50, 230, 400, 40);

        jLabel34.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 255, 51));
        jLabel34.setText("COFORM PASSWORD:");
        jPanel12.add(jLabel34);
        jLabel34.setBounds(50, 280, 400, 50);

        jTextField10.setBackground(new java.awt.Color(51, 51, 51));
        jTextField10.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(204, 51, 255));
        jTextField10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel12.add(jTextField10);
        jTextField10.setBounds(50, 330, 400, 40);

        jButton6.setBackground(new java.awt.Color(255, 51, 51));
        jButton6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 255, 51));
        jButton6.setText("SAVE & CHANGE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton6);
        jButton6.setBounds(50, 380, 400, 40);

        jButton7.setBackground(new java.awt.Color(0, 255, 51));
        jButton7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(204, 51, 255));
        jButton7.setText("CANCEL");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton7);
        jButton7.setBounds(50, 430, 400, 40);

        jLabel35.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(204, 51, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("EDIT PASSWORD:");
        jLabel35.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel12.add(jLabel35);
        jLabel35.setBounds(0, 25, 500, 50);

        jPanel11.add(jPanel12);
        jPanel12.setBounds(0, 10, 500, 490);

        jButton5.setBackground(new java.awt.Color(0, 255, 51));
        jButton5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(204, 51, 255));
        jButton5.setText("EDIT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton5);
        jButton5.setBounds(375, 520, 100, 40);

        profiles.add(jPanel11);
        jPanel11.setBounds(0, -10, 500, 650);

        pl9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pl9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pl9MouseClicked(evt);
            }
        });
        profiles.add(pl9);
        pl9.setBounds(380, 645, 50, 50);

        pl8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        pl8.setForeground(new java.awt.Color(255, 255, 255));
        pl8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profiles.add(pl8);
        pl8.setBounds(130, 645, 250, 50);
        profiles.add(pl7);
        pl7.setBounds(90, 650, 40, 40);
        profiles.add(pl6);
        pl6.setBounds(0, 640, 500, 60);

        javax.swing.GroupLayout profiles12Layout = new javax.swing.GroupLayout(profiles12);
        profiles12.setLayout(profiles12Layout);
        profiles12Layout.setHorizontalGroup(
            profiles12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profiles12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(profiles, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        profiles12Layout.setVerticalGroup(
            profiles12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profiles, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.add(profiles12);
        profiles12.setBounds(650, -590, 500, 700);

        jPanel5.setOpaque(false);

        jLayeredPane1.setAutoscrolls(true);
        jLayeredPane1.setInheritsPopupMenu(true);
        jLayeredPane1.setLayout(new java.awt.CardLayout());

        HOME.setBackground(new java.awt.Color(0, 0, 0));
        HOME.setLayout(null);

        jPanel14.setLayout(null);
        jPanel14.add(jLabel53);
        jLabel53.setBounds(0, 0, 300, 300);

        jLabel54.setBackground(new java.awt.Color(0, 0, 0));
        jLabel54.setFont(new java.awt.Font("Arial", 1, 150)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(204, 51, 255));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("      I I A S");
        jLabel54.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 0, 4, new java.awt.Color(0, 255, 51)));
        jLabel54.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel54.setOpaque(true);
        jPanel14.add(jLabel54);
        jLabel54.setBounds(0, 0, 740, 150);

        jLabel55.setBackground(new java.awt.Color(51, 51, 51));
        jLabel55.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 4, 4, 4, new java.awt.Color(204, 51, 255)));
        jPanel14.add(jLabel55);
        jLabel55.setBounds(0, 0, 740, 740);

        HOME.add(jPanel14);
        jPanel14.setBounds(47, 50, 740, 740);

        jPanel15.setLayout(new java.awt.BorderLayout());
        HOME.add(jPanel15);
        jPanel15.setBounds(840, 50, 800, 345);

        jPanel16.setBackground(new java.awt.Color(51, 51, 51));
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
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

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        HOME.add(jPanel16);
        jPanel16.setBounds(1270, 440, 370, 150);

        jPanel17.setBackground(new java.awt.Color(51, 51, 51));
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel17MouseClicked(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 51, 255));
        jButton1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jButton1.setText("PRODUCT LIST");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        HOME.add(jPanel17);
        jPanel17.setBounds(840, 440, 370, 150);

        jPanel18.setBackground(new java.awt.Color(51, 51, 51));

        jButton8.setBackground(new java.awt.Color(0, 255, 51));
        jButton8.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jButton8.setText("  BACKUP");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        HOME.add(jPanel18);
        jPanel18.setBounds(1270, 640, 370, 150);

        jPanel19.setBackground(new java.awt.Color(51, 51, 51));

        jButton9.setBackground(new java.awt.Color(204, 51, 255));
        jButton9.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jButton9.setText("REGISTRATION");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        HOME.add(jPanel19);
        jPanel19.setBounds(840, 640, 370, 150);

        jLayeredPane1.add(HOME, "card8");
        jLayeredPane1.add(graph1, "card4");

        javax.swing.GroupLayout bill_information1Layout = new javax.swing.GroupLayout(bill_information1);
        bill_information1.setLayout(bill_information1Layout);
        bill_information1Layout.setHorizontalGroup(
            bill_information1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1715, Short.MAX_VALUE)
        );
        bill_information1Layout.setVerticalGroup(
            bill_information1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 853, Short.MAX_VALUE)
        );

        jLayeredPane1.add(bill_information1, "card5");

        javax.swing.GroupLayout bill1Layout = new javax.swing.GroupLayout(bill1);
        bill1.setLayout(bill1Layout);
        bill1Layout.setHorizontalGroup(
            bill1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1715, Short.MAX_VALUE)
        );
        bill1Layout.setVerticalGroup(
            bill1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 853, Short.MAX_VALUE)
        );

        jLayeredPane1.add(bill1, "card3");

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setPreferredSize(new java.awt.Dimension(1690, 840));
        jPanel6.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("YOUR PROFILE INFORMATION:");
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel6.add(jLabel6);
        jLabel6.setBounds(0, 20, 1750, 50);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 255, 51));
        jLabel7.setText("NAME:");
        jPanel6.add(jLabel7);
        jLabel7.setBounds(40, 90, 950, 40);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 255, 51));
        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 51, 255)));
        jPanel6.add(jLabel8);
        jLabel8.setBounds(40, 140, 950, 40);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 255, 51));
        jLabel9.setText("USER ID:");
        jPanel6.add(jLabel9);
        jLabel9.setBounds(40, 190, 450, 40);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 255, 51));
        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 51, 255)));
        jPanel6.add(jLabel10);
        jLabel10.setBounds(40, 240, 450, 40);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 255, 51));
        jLabel11.setText("ADHAR_CARD NO.:");
        jPanel6.add(jLabel11);
        jLabel11.setBounds(40, 290, 450, 40);

        jLabel12.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 255, 51));
        jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 51, 255)));
        jPanel6.add(jLabel12);
        jLabel12.setBounds(40, 340, 450, 40);

        jLabel13.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 255, 51));
        jLabel13.setText("ADDRESS:");
        jPanel6.add(jLabel13);
        jLabel13.setBounds(40, 390, 950, 40);

        jLabel14.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 255, 51));
        jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 51, 255)));
        jPanel6.add(jLabel14);
        jLabel14.setBounds(40, 440, 950, 40);

        jLabel15.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 255, 51));
        jLabel15.setText("CONTACT NO.:");
        jPanel6.add(jLabel15);
        jLabel15.setBounds(40, 490, 450, 40);

        jLabel16.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 255, 51));
        jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 51, 255)));
        jPanel6.add(jLabel16);
        jLabel16.setBounds(40, 540, 450, 40);

        jLabel17.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 255, 51));
        jLabel17.setText("DATE OF BIRTH:");
        jPanel6.add(jLabel17);
        jLabel17.setBounds(40, 590, 450, 40);

        jLabel18.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 255, 51));
        jLabel18.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 51, 255)));
        jPanel6.add(jLabel18);
        jLabel18.setBounds(40, 640, 450, 40);

        jLabel19.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 255, 51));
        jLabel19.setText("EDUCATION:");
        jPanel6.add(jLabel19);
        jLabel19.setBounds(40, 690, 950, 40);

        jLabel20.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 255, 51));
        jLabel20.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 51, 255)));
        jPanel6.add(jLabel20);
        jLabel20.setBounds(40, 740, 950, 40);

        jLabel21.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 255, 51));
        jLabel21.setText("POSITION:");
        jPanel6.add(jLabel21);
        jLabel21.setBounds(540, 190, 450, 40);

        jLabel31.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 255, 51));
        jLabel31.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 51, 255)));
        jPanel6.add(jLabel31);
        jLabel31.setBounds(540, 240, 450, 40);

        jLabel36.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 255, 51));
        jLabel36.setText("JOINING DATE:");
        jPanel6.add(jLabel36);
        jLabel36.setBounds(540, 290, 450, 40);

        jLabel37.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 255, 51));
        jLabel37.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 51, 255)));
        jPanel6.add(jLabel37);
        jLabel37.setBounds(540, 340, 450, 40);

        jLabel38.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 255, 51));
        jLabel38.setText("GENDER:");
        jPanel6.add(jLabel38);
        jLabel38.setBounds(540, 490, 450, 40);

        jLabel39.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 255, 51));
        jLabel39.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 51, 255)));
        jPanel6.add(jLabel39);
        jLabel39.setBounds(540, 540, 450, 40);

        jLabel40.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 255, 51));
        jLabel40.setText("SALARY:");
        jPanel6.add(jLabel40);
        jLabel40.setBounds(540, 590, 450, 40);

        jLabel41.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 255, 51));
        jLabel41.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 51, 255)));
        jPanel6.add(jLabel41);
        jLabel41.setBounds(540, 640, 450, 40);

        jLabel48.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 255, 51));
        jLabel48.setText("PROFILE PHOTO:");
        jPanel6.add(jLabel48);
        jLabel48.setBounds(1040, 90, 650, 40);

        jLabel49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 255), 3));
        jPanel6.add(jLabel49);
        jLabel49.setBounds(1040, 140, 650, 650);

        jLayeredPane1.add(jPanel6, "card8");
        jLayeredPane1.add(record2, "card7");

        jPanel20.setBackground(new java.awt.Color(0, 0, 0));
        jPanel20.setPreferredSize(new java.awt.Dimension(1690, 840));
        jPanel20.setLayout(null);

        jButton10.setBackground(new java.awt.Color(0, 255, 51));
        jButton10.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton10.setText("OPEN CAMERA");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel20.add(jButton10);
        jButton10.setBounds(1250, 90, 210, 40);

        jButton11.setBackground(new java.awt.Color(0, 255, 51));
        jButton11.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton11.setText("SUBMIT");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel20.add(jButton11);
        jButton11.setBounds(1470, 90, 210, 40);

        jLabel56.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 255, 51));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("STREET / SHOP VANDOR REGISTRATION FORM");
        jLabel56.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 0, 3, 0, new java.awt.Color(0, 255, 51)));
        jPanel20.add(jLabel56);
        jLabel56.setBounds(0, 20, 1750, 50);

        jLabel57.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 255, 51));
        jLabel57.setText("VENDOR NAME:");
        jPanel20.add(jLabel57);
        jLabel57.setBounds(40, 90, 950, 40);

        jLabel58.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 255, 51));
        jLabel58.setText("VENDOR ID:");
        jPanel20.add(jLabel58);
        jLabel58.setBounds(40, 190, 450, 40);

        jLabel59.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 255, 51));
        jLabel59.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 51, 255)));
        jPanel20.add(jLabel59);
        jLabel59.setBounds(40, 240, 450, 40);

        jLabel60.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 255, 51));
        jLabel60.setText("ADHAR_CARD NO.:");
        jPanel20.add(jLabel60);
        jLabel60.setBounds(40, 290, 450, 40);

        jLabel61.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 255, 51));
        jLabel61.setText("ADDRESS:");
        jPanel20.add(jLabel61);
        jLabel61.setBounds(40, 390, 950, 40);

        jLabel62.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 255, 51));
        jLabel62.setText("CONTACT NO.:");
        jPanel20.add(jLabel62);
        jLabel62.setBounds(40, 490, 450, 40);

        jLabel63.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 255, 51));
        jLabel63.setText("DATE OF BIRTH:");
        jPanel20.add(jLabel63);
        jLabel63.setBounds(40, 590, 450, 40);

        jLabel64.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(0, 255, 51));
        jLabel64.setText("EDUCATION:");
        jPanel20.add(jLabel64);
        jLabel64.setBounds(40, 690, 950, 40);

        jLabel65.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 255, 51));
        jLabel65.setText("TYPE OF VENDOR?");
        jPanel20.add(jLabel65);
        jLabel65.setBounds(540, 190, 450, 40);

        jLabel66.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 255, 51));
        jLabel66.setText("JOINING DATE:");
        jPanel20.add(jLabel66);
        jLabel66.setBounds(540, 290, 450, 40);

        jLabel67.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(0, 255, 51));
        jLabel67.setText("GENDER:");
        jPanel20.add(jLabel67);
        jLabel67.setBounds(540, 490, 450, 40);

        jLabel68.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(0, 255, 51));
        jLabel68.setText("VENDOR PHOTO:");
        jPanel20.add(jLabel68);
        jLabel68.setBounds(1040, 90, 650, 40);

        jPanel21.setBackground(new java.awt.Color(0, 0, 0));
        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 255), 3));
        jPanel20.add(jPanel21);
        jPanel21.setBounds(1040, 140, 650, 650);

        jTextField2.setBackground(new java.awt.Color(0, 0, 0));
        jTextField2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 51, 255)));
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });
        jPanel20.add(jTextField2);
        jTextField2.setBounds(40, 140, 950, 40);

        jTextField3.setBackground(new java.awt.Color(0, 0, 0));
        jTextField3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 51, 255)));
        jPanel20.add(jTextField3);
        jTextField3.setBounds(40, 340, 450, 40);

        jTextField4.setBackground(new java.awt.Color(0, 0, 0));
        jTextField4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 51, 255)));
        jPanel20.add(jTextField4);
        jTextField4.setBounds(40, 440, 950, 40);

        jTextField5.setBackground(new java.awt.Color(0, 0, 0));
        jTextField5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 51, 255)));
        jPanel20.add(jTextField5);
        jTextField5.setBounds(40, 540, 450, 40);

        jTextField6.setBackground(new java.awt.Color(0, 0, 0));
        jTextField6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 51, 255)));
        jPanel20.add(jTextField6);
        jTextField6.setBounds(40, 740, 950, 40);

        jDateChooser1.setBackground(new java.awt.Color(0, 0, 0));
        jDateChooser1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 255), 3));
        jDateChooser1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel20.add(jDateChooser1);
        jDateChooser1.setBounds(540, 340, 450, 40);

        jDateChooser2.setBackground(new java.awt.Color(0, 0, 0));
        jDateChooser2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 255), 3));
        jDateChooser2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel20.add(jDateChooser2);
        jDateChooser2.setBounds(40, 640, 450, 40);

        jLabel69.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(0, 255, 51));
        jLabel69.setText("SHOP NAME:");
        jPanel20.add(jLabel69);
        jLabel69.setBounds(540, 590, 450, 40);

        jTextField7.setBackground(new java.awt.Color(0, 0, 0));
        jTextField7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(204, 51, 255)));
        jPanel20.add(jTextField7);
        jTextField7.setBounds(540, 640, 450, 40);

        jPanel22.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        jPanel20.add(jPanel22);
        jPanel22.setBounds(1050, 150, 630, 630);

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        jRadioButton5.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jRadioButton5.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton5.setText("MALE");

        jRadioButton6.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup1.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jRadioButton6.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton6.setText("FEMALE");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jRadioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jRadioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel20.add(jPanel7);
        jPanel7.setBounds(540, 490, 450, 90);

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));

        jRadioButton1.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("STREET VENDOR");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("SHOP VENDOR");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel20.add(jPanel8);
        jPanel8.setBounds(530, 190, 480, 100);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1715, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 1715, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 901, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jLayeredPane1.add(jPanel13, "card9");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1740, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1715, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 25, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 853, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(60, 110, 1740, 830);

        jLabel23.setBackground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("jLabel23");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(0, 0, 1800, 950);
        jPanel1.add(jLabel30);
        jLabel30.setBounds(60, 50, 1700, 900);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1800, 950);

        setSize(new java.awt.Dimension(1800, 950));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        reset1();

        int pos = menu.getX();
        if (pos > -190) {
            Animacion.Animacion.mover_izquierda(0, -190, 2, 2, menu);

            jPanel5.setVisible(true);
        } else {
            Animacion.Animacion.mover_derecha(-190, 0, 2, 2, menu);
            jPanel5.setVisible(false);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        labellB(jLabel1,jLabel4);
reset();
jPanel5.setVisible(true);
swithPanel(HOME);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        labellB(jLabel3, jLabel5);
        reset();
        jPanel5.setVisible(true);
        swithPanel(record2);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
      closecamera();
        System.exit(0);
      
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel46MouseClicked

    private void pl9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pl9MouseClicked
        reset2();
        int pos = profiles12.getY();
        if (pos > -589) {
            Animacion.Animacion.subir(40, -590, 15, 15, profiles12);
            resize(pl9, "icons8-pull-down-96 (1).png");
            jPanel5.setVisible(true);
        } else {
            Animacion.Animacion.bajar(-590, 40, 15, 15, profiles12);
            resize(pl9, "icons8-pull-up-96 (1).png");
            jPanel5.setVisible(false);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_pl9MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
          labellB(jLabel1,jLabel4);
reset();
jPanel5.setVisible(true);
swithPanel(HOME);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked

 
        labellB(jLabel27, jLabel42);
        reset();
jPanel5.setVisible(true);

swithPanel(jPanel6);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
       
        try{
            pst=con.prepareStatement("SELECT * FROM `employee` where user_id='"+pl8.getText()+"';");
            rs=pst.executeQuery();
            if(rs.next()){
                
               jLabel8.setText(rs.getString("name"));
               jLabel10.setText(rs.getString("user_id"));
                jLabel14.setText(rs.getString("Address"));
              jLabel12.setText(rs.getString("adhar_card_no"));
           jLabel16.setText(rs.getString("Contact_no"));
             jLabel18.setText(rs.getString("dob"));
               jLabel39.setText(rs.getString("gender"));
               jLabel31.setText(rs.getString("position"));
            jLabel37.setText(rs.getString("join_date"));
         jLabel20.setText(rs.getString("education"));
           jLabel41.setText(rs.getString("salary"));
                BufferedImage im= ImageIO.read(rs.getBinaryStream("image"));
                resize1(jLabel49,im);
            }
        }
        catch (Exception ex) {
            System.out.print(ex);
        }      
        labellB(jLabel27, jLabel42);
        reset();
jPanel5.setVisible(true);

swithPanel(jPanel6);
  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel42MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
             labellB(jLabel3, jLabel5);
        reset();
        jPanel5.setVisible(true);
        swithPanel(record2);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
          labellB(jLabel25, jLabel29);
        reset();
       
         
        jPanel5.setVisible(true);
         swithPanel(jPanel13);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        labellB(jLabel25, jLabel29);
        reset();
        jPanel5.setVisible(true);
          swithPanel(jPanel13);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        labellB(jLabel24, jLabel43);
        
        reset();
        jPanel5.setVisible(true);
        swithPanel(bill1);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseClicked
        labellB(jLabel24, jLabel43);
        
        reset();
        jPanel5.setVisible(true);
        swithPanel(bill1);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel43MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        labellB(jLabel26, jLabel47);
        swithPanel(bill_information1);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseClicked
        labellB(jLabel26, jLabel47);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel47MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        this.dispose();
        login2 l = new login2();
        /* Create and display the form */
        l.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        ResultSet rs1=null;
        Connection  con1=null;
        PreparedStatement pst1=null;
        if(jTextField1.getText().equals("")&&jTextField9.getText().equals("")&&jTextField10.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"FILL ALL FIELDS.");
        }

        else
        {

            try{
                connection();
                pst=con.prepareStatement("SELECT * FROM `login` WHERE user_id='"+pl8.getText()+"'");
                rs=pst.executeQuery();
                rs.next();
                if(rs.getString("password").equals(jTextField1.getText()))
                {
                    if(jTextField9.getText().equals(jTextField10.getText())){
                        pst1=con.prepareStatement("UPDATE `login` SET `password`='"+jTextField9.getText()+"' WHERE user_id='"+pl8.getText()+"'");
                        pst1.execute();

                        JOptionPane.showMessageDialog(this,"PASSWORD CHANGED SUCCESSFULLY.");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"NEW PASSWORD & CONFORM PASSWORD MUST BE SAME.");

                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"OLD PASSWORD DOESN'T MATCH.");

                }

            }catch(Exception e){
                System.out.print(e);
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jPanel12.setVisible(false);
        pl1.setVisible(true);
        jButton5.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jPanel12.setVisible(true);
        pl1.setVisible(false);
        jButton5.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
setState(ICONIFIED);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel50MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked
     
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseClicked

    private void jPanel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
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
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (evt.getActionCommand() == "OPEN CAMERA") {
            jButton10.setText("Pause");
            webSource = new VideoCapture(0); // video capture from default cam
            myThread = new empoyeedas.DaemonThread(); //create object of threat class
            Thread t = new Thread(myThread);
            t.setDaemon(true);
            myThread.runnable = true;
            t.start();          //start thrad

        }
        if (evt.getActionCommand() == "Pause") {
            // deactivate start button
            closecamera();
            eimg = "C:\\Users\\chaitany\\Desktop\\Forzon3\\src\\forzon3\\emimage\\" + jLabel10.getText() + ".jpg";
            Imgcodecs.imwrite(eimg, frame);

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
Color myWhite5 = new Color(0,255,51);   
        
jLabel63.setForeground(myWhite5);
  jDateChooser2.setBorder(new MatteBorder(3, 3, 3, 3, myWhite5)); 
                
        jTextField6.setEditable(true);
        jTextField7.setEditable(false); 
        jDateChooser2.setEnabled(true);
disale(jLabel69,jTextField7,jLabel64,jTextField6);
// TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
Color myWhite5 = new Color(102,102,102);   
           jLabel63.setForeground(myWhite5);
          jDateChooser2.setBorder(new MatteBorder(3, 3, 3, 3, myWhite5)); 
        jTextField7.setEditable(true);   
jTextField6.setEditable(false);
  jDateChooser2.setEnabled(false);       
disale(jLabel64,jTextField6,jLabel69,jTextField7);
// TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2MouseClicked
public void auto_venndor_Id(){
    int ord=0;
         
        try{
        connection();
          pst=con.prepareStatement("SELECT * FROM `vendor_information`");
     rs=pst.executeQuery();
     
     while(rs.next()){
         ord=rs.getInt("sr_no");
     }
     ord=ord+1;
    jLabel59.setText("vendor_"+ord);
     }catch(Exception e){
         System.out.print(e);
     }
  
}
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        
try{
             connection();
                pst=con.prepareStatement("INSERT INTO `vendor_information`(`vendor_name`, 'type`, `adhcard`, `ADDRESS`, `joindate_date`,`contact_no`, `gender`, `dob`, `education`, `SHOP_NAME`, `Image`)values(?,?,?,?,?,?,?,?,?,?,?)");        
            pst.setString(1,jTextField2.getText());
            String typev="STREET VENDOR";
            if(jRadioButton2.isSelected()){
              typev="SHOP VENDOR";  
            }
            pst.setString(2,typev);
            pst.setString(3, jTextField3.getText());
            pst.setString(4, jTextField4.getText());
            java.util.Date date=new java.util.Date();
			date=jDateChooser1.getDate();
			java.sql.Date sqlDate=new java.sql.Date(date.getTime());

             pst.setDate(5,sqlDate);
                         pst.setString(6,jTextField5.getText());
              String gendar="Male";
            if(jRadioButton2.isSelected()){
             gendar="Female";  
            }
            pst.setString(7,gendar);
            java.util.Date date1=new java.util.Date();
			date1=jDateChooser2.getDate();
			java.sql.Date sqlDate1=new java.sql.Date(date1.getTime());
pst.setDate(8,sqlDate1);
            pst.setString(9,jTextField6.getText());
            if(jTextField7.getText().equals("")){
            pst.setString(10,"none");
                
            }else{
            pst.setString(10,jTextField7.getText());
            } String s1="C:\\Users\\chaitany\\Desktop\\Forzon3\\src\\forzon3\\emimage\\" + jLabel10.getText() + ".jpg";
            File fimg = new File(s1); 
              InputStream in = new FileInputStream(fimg);

          pst.setBlob(11,in);
           
            pst.executeUpdate();
                 JOptionPane.showMessageDialog(this,"Add"); 
 
}
catch(SQLException ex){
  System.out.print(ex);   
}    catch (FileNotFoundException ex) {
         Logger.getLogger(addproduct.class.getName()).log(Level.SEVERE, null, ex);
     }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
auto_venndor_Id();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyPressed

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
            java.util.logging.Logger.getLogger(empoyeedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(empoyeedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(empoyeedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(empoyeedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            empoyeedas das = new empoyeedas();
            das.setVisible(true);

        } catch (Exception ex) {
        }
        /* Create and display the form */

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HOME;
    private forzon3.Bill bill1;
    private forzon3.Bill_information bill_information1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private forzon3.graph graph1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    public static javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    public static javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    public static javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    public static javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    public static javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    public javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    public static javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    public static javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    public static javax.swing.JLabel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel pl1;
    private javax.swing.JLabel pl2;
    private javax.swing.JLabel pl3;
    public static javax.swing.JLabel pl4;
    public static javax.swing.JLabel pl5;
    private javax.swing.JLabel pl6;
    private javax.swing.JLabel pl7;
    public javax.swing.JLabel pl8;
    public javax.swing.JLabel pl9;
    private javax.swing.JPanel profiles;
    private javax.swing.JPanel profiles12;
    private forzon3.Record record2;
    // End of variables declaration//GEN-END:variables
}
