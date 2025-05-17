package restaurantsystem.component.item;

import javax.swing.*;
import restaurantsystem.service.ItemService;

public class DeleteItem extends javax.swing.JFrame {
    private final ItemService itemService;
    private static final String EMPTY_NAME_ERROR = "Please enter a valid name to delete";
    private static final String NOT_FOUND_ERROR = "No item found with that name";
    private static final String SUCCESS_MESSAGE = "Item has been removed";
    private static final String DELETE_PROMPT = "Are you sure you want to delete this item?";

    public DeleteItem() {
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

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String itemName = dlttext.getText().trim();

        if (itemName.isEmpty()) {
            showError(EMPTY_NAME_ERROR);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                DELETE_PROMPT,
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            boolean isDeleted = itemService.delete(itemName);

            if (isDeleted) {
                JOptionPane.showMessageDialog(this, SUCCESS_MESSAGE);
                dlttext.setText("");
                loadItems();
            } else {
                showError(NOT_FOUND_ERROR);
            }
        }
    }

    private void showError(String message) {
        dlttext.setText("");
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new ItemManagement().setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        JScrollPane jScrollPane2 = new JScrollPane();
        JTextArea jTextArea1 = new JTextArea();
        JPanel jPanel1 = new JPanel();
        JScrollPane jScrollPane1 = new JScrollPane();
        text = new javax.swing.JTextArea();
        dlttext = new javax.swing.JTextField();
        JLabel jLabel1 = new JLabel();
        JButton backButton = new JButton();
        JButton deleteButton = new JButton();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 255));

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        text.setEditable(false);
        text.setBackground(new java.awt.Color(204, 255, 204));
        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        jLabel1.setText("Enter item name to delete");

        backButton.setText("Back");
        backButton.addActionListener(this::backButtonActionPerformed);

        deleteButton.setText("Delete");
        deleteButton.addActionListener(this::deleteButtonActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(backButton)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(171, 171, 171)
                                                                .addComponent(dlttext, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(deleteButton))
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dlttext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(backButton)
                                .addGap(18, 18, 18))
        );

        jLabel2.setText("Name");

        jLabel3.setText("Price");

        jLabel4.setText("Quantity");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jLabel2)
                                .addGap(146, 146, 146)
                                .addComponent(jLabel3)
                                .addGap(79, 79, 79)
                                .addComponent(jLabel4)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                new DeleteItem().setVisible(true);
            } catch (Exception e) {
                System.err.println("Error setting look and feel: " + e.getMessage());
            }
        });
    }

    private javax.swing.JTextField dlttext;
    private javax.swing.JTextArea text;
}