/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forzon3;


import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author chaitany
 */
public class profiles1 extends javax.swing.JPanel {

    private Window profiles12;

    /**
     * Creates new form profiles1
     */
         public void resize(JLabel a,String d){
      ImageIcon myimage1=new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(d)));
        Image img3=myimage1.getImage();
        Image img4=img3.getScaledInstance( a.getWidth(),a.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon i11=new ImageIcon(img4);   
       a.setIcon(i11);
}
    public profiles1() {
        initComponents();
         
        
      resize(pl9,"icons8-pull-down-96 (1).png");
        resize(pl1,"ashoka1.png");
    resize(pl6,"tra1.png");
    resize(pl7,"profiles.png");
    pl8.setText("chaitanya");
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

        profiles = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pl1 = new javax.swing.JLabel();
        pl2 = new javax.swing.JLabel();
        pl3 = new javax.swing.JLabel();
        pl4 = new javax.swing.JLabel();
        pl5 = new javax.swing.JLabel();
        pl9 = new javax.swing.JLabel();
        pl8 = new javax.swing.JLabel();
        pl7 = new javax.swing.JLabel();
        pl6 = new javax.swing.JLabel();

        setOpaque(false);

        profiles.setOpaque(false);
        profiles.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 102), 5));
        jPanel2.setLayout(null);

        pl1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 102), 5));
        jPanel2.add(pl1);
        pl1.setBounds(0, 10, 500, 490);

        pl2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        pl2.setForeground(new java.awt.Color(153, 51, 255));
        pl2.setText("HELLO");
        jPanel2.add(pl2);
        pl2.setBounds(50, 540, 60, 22);

        pl3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        pl3.setForeground(new java.awt.Color(153, 51, 255));
        pl3.setText("USER ID: ");
        jPanel2.add(pl3);
        pl3.setBounds(50, 580, 82, 22);

        pl4.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        pl4.setForeground(new java.awt.Color(153, 51, 255));
        pl4.setText("CHAITANYA");
        jPanel2.add(pl4);
        pl4.setBounds(120, 520, 300, 50);

        pl5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        pl5.setForeground(new java.awt.Color(0, 255, 102));
        pl5.setText("123456");
        jPanel2.add(pl5);
        pl5.setBounds(140, 577, 300, 22);

        profiles.add(jPanel2);
        jPanel2.setBounds(0, -10, 500, 650);

        pl9.setToolTipText("Your Profile");
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
        pl8.setBounds(110, 650, 270, 50);
        profiles.add(pl7);
        pl7.setBounds(70, 650, 40, 40);
        profiles.add(pl6);
        pl6.setBounds(0, 640, 500, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(profiles, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(profiles, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(707, 707, 707))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pl9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pl9MouseClicked
    

        // TODO add your handling code here:
    }//GEN-LAST:event_pl9MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel pl1;
    private javax.swing.JLabel pl2;
    private javax.swing.JLabel pl3;
    private javax.swing.JLabel pl4;
    private javax.swing.JLabel pl5;
    private javax.swing.JLabel pl6;
    private javax.swing.JLabel pl7;
    private javax.swing.JLabel pl8;
    private javax.swing.JLabel pl9;
    private javax.swing.JPanel profiles;
    // End of variables declaration//GEN-END:variables
}
