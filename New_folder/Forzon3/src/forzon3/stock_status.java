/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forzon3;

/**
 *
 * @author Tushar
 */
public class stock_status extends javax.swing.JPanel {

    /**
     * Creates new form stock_status
     */
    public stock_status() {
        initComponents();
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
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        jPanel1.setLayout(null);

        jLabel1.setText("Date:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 23, 46, 14);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(66, 23, 130, 14);

        jLabel3.setText("Manufacturing Stock Cost");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(530, 30, 150, 37);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(690, 30, 170, 30);

        jTable2.setBackground(new java.awt.Color(51, 51, 51));
        jTable2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51), 3));
        jTable2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM CODE", "ITEM NAME", "PRICE", "MANUFACTURE  QUANTITY", "SELLING QUANTITY", "AVAILABLE QUANTITY"
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

        jLabel4.setText("Available Stock Cost");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(557, 80, 120, 37);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(690, 80, 170, 30);

        jLabel5.setText("Selling Stock Cost");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(557, 130, 120, 37);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(690, 130, 170, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1021, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField2;
    public static javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
