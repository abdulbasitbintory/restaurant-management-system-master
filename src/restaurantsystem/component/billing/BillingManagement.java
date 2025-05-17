package restaurantsystem.component.billing;

import javax.swing.*;
// import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import restaurantsystem.component.order.OrderManagement;
import restaurantsystem.MainMenu;

public class BillingManagement extends javax.swing.JFrame {
    private BillingHelper billingHelper;
    private static final String ORDER_FILE = "storage/order.txt";
    private static final String TEMP_FILE = "temp.txt";
    private static final String BILL_FILE = "totalBill.txt";

    public BillingManagement() {
        initComponents();
        displayBill();
        setLocationRelativeTo(null);
    }

    private void displayBill() {
        billingHelper = new BillingHelper();
        text.setText(billingHelper.getFullNames().toString());
        totalPriceArea.setText(billingHelper.getTotal());
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        OrderManagement orderManagement = new OrderManagement();
        orderManagement.setVisible(true);
        this.dispose();
    }

    private void paymentButtonActionPerformed(java.awt.event.ActionEvent evt) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
        this.dispose();

        try (PrintWriter billWriter = new PrintWriter(new FileOutputStream(BILL_FILE, true))) {
            billWriter.println(billingHelper.getFullNames());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error processing payment: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void printReceiptButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            boolean complete = text.print();
            String message = complete ? "Done printing" : "Printing cancelled";
            JOptionPane.showMessageDialog(this, message, "Printer", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Printing error: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Auto-generated GUI components
    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        JScrollPane jScrollPane1 = new JScrollPane();
        text = new javax.swing.JTextArea();
        totalPriceArea = new javax.swing.JTextField();
        // Variables declaration
        JButton backButton = new JButton();
        JButton paymentButton = new JButton();
        JButton printReceiptButton = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 255));

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        text.setEditable(false);
        text.setBackground(new java.awt.Color(204, 204, 255));
        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        totalPriceArea.setEditable(false);
        totalPriceArea.setBackground(new java.awt.Color(255, 102, 102));

        backButton.setText("Back");
        backButton.addActionListener(this::backButtonActionPerformed);

        paymentButton.setText("Payment");
        paymentButton.addActionListener(this::paymentButtonActionPerformed);

        printReceiptButton.setText("Print Receipt");
        printReceiptButton.addActionListener(this::printReceiptButtonActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(142, 142, 142)
                                                                .addComponent(paymentButton)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(printReceiptButton))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(totalPriceArea, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(totalPriceArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(paymentButton)
                                        .addComponent(printReceiptButton)
                                        .addComponent(backButton))
                                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            System.err.println("Error setting look and feel: " + ex.getMessage());
        }

        SwingUtilities.invokeLater(() -> new BillingManagement().setVisible(true));
    }

    public javax.swing.JTextArea text;
    private javax.swing.JTextField totalPriceArea;
}