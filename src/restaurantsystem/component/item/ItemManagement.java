package restaurantsystem.component.item;

import javax.swing.*;
import restaurantsystem.MainMenu;

public class ItemManagement extends javax.swing.JFrame {

    public ItemManagement() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new UpdateItem().setVisible(true);
        this.dispose();
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new AddItem().setVisible(true);
        this.dispose();
    }

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new ViewItem().setVisible(true);
        this.dispose();
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new DeleteItem().setVisible(true);
        this.dispose();
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new MainMenu().setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        JLabel jLabel3 = new JLabel();
        JButton jButton1 = new JButton();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel1 = new JPanel();
        // Variables declaration
        JButton addButton = new JButton();
        JButton viewButton = new JButton();
        JButton deleteButton = new JButton();
        JButton modifyButton = new JButton();
        JButton backButton = new JButton();

        jLabel3.setText("jLabel3");
        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        addButton.setText("Add Item");
        addButton.addActionListener(this::addButtonActionPerformed);

        viewButton.setText("View Item");
        viewButton.addActionListener(this::viewButtonActionPerformed);

        deleteButton.setText("Delete Item");
        deleteButton.addActionListener(this::deleteButtonActionPerformed);

        modifyButton.setText("Modify Item");
        modifyButton.addActionListener(this::modifyButtonActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(viewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(modifyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(addButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(viewButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modifyButton)
                                .addContainerGap(19, Short.MAX_VALUE))
        );

        backButton.setText("Back");
        backButton.addActionListener(this::backButtonActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(110, 110, 110)
                                                .addComponent(backButton)))
                                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(backButton)
                                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(59, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78))
        );

        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                new ItemManagement().setVisible(true);
            } catch (Exception e) {
                System.err.println("Error setting look and feel: " + e.getMessage());
            }
        });
    }

}