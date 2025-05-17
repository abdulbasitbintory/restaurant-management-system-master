package restaurantsystem.component.item;

import javax.swing.*;
import restaurantsystem.service.ItemService;

public class ViewItem extends javax.swing.JFrame {
    private final ItemService itemService;

    public ViewItem() {
        initComponents();
        this.itemService = new ItemService();
        loadItems();
        setLocationRelativeTo(null);
    }

    private void loadItems() {
        StringBuilder itemsList = new StringBuilder();
        itemService.getAll().forEach(item ->
                itemsList.append(item.getName())
                        .append("\t")
                        .append(item.getPrice())
                        .append("\t")
                        .append(item.getQuantity())
                        .append("\n")
        );
        text.setText(itemsList.toString());
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new ItemManagement().setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        JScrollPane jScrollPane1 = new JScrollPane();
        text = new javax.swing.JTextArea();
        JButton backButton = new JButton();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 255));

        text.setBackground(new java.awt.Color(204, 255, 204));
        text.setColumns(20);
        text.setRows(5);
        text.setEditable(false);
        jScrollPane1.setViewportView(text);

        backButton.setText("Back");
        backButton.addActionListener(this::backButtonActionPerformed);

        jLabel1.setText("Name");
        jLabel2.setText("Price");
        jLabel3.setText("Quantity");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(300, 300, 300)
                                                .addComponent(backButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(9, 9, 9)
                                                                .addComponent(jLabel1)
                                                                .addGap(54, 54, 54)
                                                                .addComponent(jLabel2)
                                                                .addGap(63, 63, 63)
                                                                .addComponent(jLabel3)))))
                                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(28, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(backButton)
                                .addGap(50, 50, 50))
        );

        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                new ViewItem().setVisible(true);
            } catch (Exception e) {
                System.err.println("Error setting look and feel: " + e.getMessage());
            }
        });
    }

    private javax.swing.JTextArea text;
}
