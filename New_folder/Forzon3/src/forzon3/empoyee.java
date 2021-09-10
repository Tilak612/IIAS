
/*
 * To chang``e this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forzon3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
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
public class empoyee extends javax.swing.JFrame {

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
    //End of reset funnction
    //start of camera code funnction
    public DaemonThread myThread = null;
    int count = 0;

    VideoCapture webSource = null;
    Mat frame = new Mat();
    MatOfByte mem = new MatOfByte();
    CascadeClassifier faceDetector = new CascadeClassifier(empoyee.class.getResource("haarcascade_frontalface_alt.xml").getPath().substring(1));
    MatOfRect faceDetections = new MatOfRect();
///    

    public void closecamera() {
        if (jButton3.getText().equals("Pause")) {

            myThread.runnable = false;            // stop thread
            // activate start button
            jButton3.setEnabled(true);     // deactivate stop button
            jButton3.setText("Start");
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
                            Graphics g = jPanel8.getGraphics();
                            faceDetector.detectMultiScale(frame, faceDetections);
                            for (Rect rect : faceDetections.toArray()) {
                                // System.out.println("ttt");
                                Imgproc.rectangle(frame, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                                        new Scalar(0, 255, 0));
                            }
                            Imgcodecs.imencode(".bmp", frame, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));
                            BufferedImage buff = (BufferedImage) im;
                            if (g.drawImage(buff, 0, 0, 260, 260, 0, 0, buff.getWidth(), buff.getHeight(), null)) {
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
        ImageIcon myimage1 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(d)));
        Image img3 = myimage1.getImage();
        Image img4 = img3.getScaledInstance(a.getWidth(), a.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i11 = new ImageIcon(img4);
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

    public empoyee() {
        initComponents();
        jPanel7.setVisible(false);
        jLabel30.setVisible(false);
        resize(pl9, "icons8-pull-down-96 (1).png");
        resize(pl1, "ashoka1.png");
        resize(pl6, "tra1.png");
        resize(jLabel23, "black-stylish-.jpg");
        resize(jLabel30, "unnamed.png");
        resize(pl7, "profiles.png");

        profiles.setOpaque(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        l3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
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
        graph1 = new forzon3.graph();
        bill_information1 = new forzon3.Bill_information();
        record1 = new forzon3.Record();
        bill1 = new forzon3.Bill();
        jLabel23 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 51), 5));
        jPanel1.setLayout(null);

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 255), 5));
        jPanel7.setLayout(null);

        jPanel8.setBackground(new java.awt.Color(0, 255, 51));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel8);
        jPanel8.setBounds(30, 75, 260, 260);

        jButton3.setBackground(new java.awt.Color(204, 51, 255));
        jButton3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 204, 204));
        jButton3.setText("Start");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton3);
        jButton3.setBounds(30, 370, 260, 50);

        jPanel9.setBackground(new java.awt.Color(102, 255, 102));
        jPanel9.setLayout(null);
        jPanel9.add(l3);
        l3.setBounds(0, 0, 260, 260);

        jPanel7.add(jPanel9);
        jPanel9.setBounds(310, 75, 260, 260);

        jButton4.setBackground(new java.awt.Color(204, 51, 255));
        jButton4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(204, 204, 204));
        jButton4.setText("Register");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton4);
        jButton4.setBounds(310, 370, 260, 50);

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 51), 5));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forzon3/image/colsed.png"))); // NOI18N
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 8));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 550, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.add(jPanel10);
        jPanel10.setBounds(0, 0, 600, 50);

        jPanel1.add(jPanel7);
        jPanel7.setBounds(620, 190, 600, 450);

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
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forzon3/image/data2.png"))); // NOI18N
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
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forzon3/image/accounting.png"))); // NOI18N
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
        jLabel29.setText("Data ");
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
        jLabel47.setText("Account");
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

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forzon3/image/colsed.png"))); // NOI18N
        jLabel46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 8));
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel46MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 1750, Short.MAX_VALUE)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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
        jLayeredPane1.add(graph1, "card4");

        javax.swing.GroupLayout bill_information1Layout = new javax.swing.GroupLayout(bill_information1);
        bill_information1.setLayout(bill_information1Layout);
        bill_information1Layout.setHorizontalGroup(
            bill_information1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1690, Short.MAX_VALUE)
        );
        bill_information1Layout.setVerticalGroup(
            bill_information1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );

        jLayeredPane1.add(bill_information1, "card5");
        jLayeredPane1.add(record1, "card2");

        javax.swing.GroupLayout bill1Layout = new javax.swing.GroupLayout(bill1);
        bill1.setLayout(bill1Layout);
        bill1Layout.setHorizontalGroup(
            bill1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1690, Short.MAX_VALUE)
        );
        bill1Layout.setVerticalGroup(
            bill1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );

        jLayeredPane1.add(bill1, "card3");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1740, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1690, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(60, 110, 1740, 840);

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
        labellB(jLabel1, jLabel4);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        labellB(jLabel3, jLabel5);
        reset();
        jPanel5.setVisible(true);
        swithPanel(record1);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
        System.exit(0);
        closecamera();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel46MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (evt.getActionCommand() == "Start") {
            jButton3.setText("Pause");
            webSource = new VideoCapture(0); // video capture from default cam
            myThread = new DaemonThread(); //create object of threat class
            Thread t = new Thread(myThread);
            t.setDaemon(true);
            myThread.runnable = true;
            t.start();          //start thrad

        }
        if (evt.getActionCommand() == "Pause") {
            // deactivate start button
            closecamera();
            eimg = "C:\\Users\\chaitany\\Desktop\\Forzon3\\src\\forzon3\\emimage\\" + eui + ".jpg";
            Imgcodecs.imwrite(eimg, frame);

            ImageIcon icon = new ImageIcon(eimg);
            Image img = icon.getImage();
            Image newImg = img.getScaledInstance(l3.getWidth(), l3.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newImc = new ImageIcon(newImg);
            l3.setIcon(newImc);

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        closecamera();
        jPanel5.setVisible(true);
        l3.setIcon(null);
        System.out.println(en + "\t" + eui + "\t" + ep + "\t" + eadc + "\t" + eadd + "\t" + econ + "\t" + egender + "\t" + epos + "\t" + eed + "\t" + esa + "\t" + edob + "\t" + ejb);

        File fimg = new File(eimg);
        if (fimg.exists()) {
            try {

                connection();
                pst = con.prepareStatement("insert into employee(name,user_id,adhar_card_no,salary,Address,Contact_no,image,dob,gender,position,join_date,education) values(?,?,?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1, en);
                pst.setString(2, eui);
                pst.setString(3, eadc);
                pst.setString(4, esa);
                pst.setString(5, eadd);
                pst.setString(6, econ);
                InputStream in = new FileInputStream(fimg);

                pst.setBlob(7, in);
                pst.setString(8, edob);
                pst.setString(9, egender);
                pst.setString(10, epos);
                pst.setString(11, ejb);
                pst.setString(12, eed);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record Saved");

            } catch (Exception e) {
                jPanel5.setVisible(false);
                JOptionPane.showMessageDialog(null, "Check Server connect or not ");

            }

        } else {
            jPanel5.setVisible(false);
            JOptionPane.showMessageDialog(null, "please insert picture of empolyee");

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        jPanel7.setVisible(false);
        closecamera();
        jPanel5.setVisible(true);
        l3.setIcon(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        labellB(jLabel1, jLabel4);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        labellB(jLabel27, jLabel42);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
        labellB(jLabel27, jLabel42);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel42MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        labellB(jLabel3, jLabel5);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        labellB(jLabel25, jLabel29);
        swithPanel(graph1);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        labellB(jLabel25, jLabel29);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        labellB(jLabel24, jLabel43);
        swithPanel(bill1);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseClicked
        labellB(jLabel24, jLabel43);
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
            java.util.logging.Logger.getLogger(empoyee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(empoyee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(empoyee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(empoyee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            empoyee das = new empoyee();
            das.setVisible(true);

        } catch (Exception ex) {
        }
        /* Create and display the form */

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private forzon3.Bill bill1;
    private forzon3.Bill_information bill_information1;
    private javax.swing.ButtonGroup buttonGroup1;
    private forzon3.graph graph1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel l3;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel pl1;
    private javax.swing.JLabel pl2;
    private javax.swing.JLabel pl3;
    private javax.swing.JLabel pl4;
    private javax.swing.JLabel pl5;
    private javax.swing.JLabel pl6;
    private javax.swing.JLabel pl7;
    public javax.swing.JLabel pl8;
    public javax.swing.JLabel pl9;
    private javax.swing.JPanel profiles;
    private javax.swing.JPanel profiles12;
    private forzon3.Record record1;
    // End of variables declaration//GEN-END:variables
}
