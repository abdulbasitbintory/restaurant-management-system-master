package restaurantsystem.component.item;

import javax.swing.*;
import restaurantsystem.model.Item;
import restaurantsystem.service.ItemService;

public class UpdateItem extends javax.swing.JFrame {
    private final ItemService itemService;
    private static final String EMPTY_FIELD_ERROR = "All fields must be filled";
    private static final String INVALID_PRICE_ERROR = "Please enter a valid price (numbers only, greater than 0)";
    private static final String INVALID_QUANTITY_ERROR = "Please enter a valid quantity (whole numbers only, greater than 0)";
    private static final String NOT_FOUND_ERROR = "Item not found";
    private static final String SUCCESS_MESSAGE = "Item updated successfully";
    private static final String CONFIRM_UPDATE = "Are you sure you want to update this item?";

    public UpdateItem() {
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

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String srcName = modText.getText().trim();
            String modName = mName.getText().trim();
            String modPrice = mPrice.getText().trim();
            String modQuantity = mQuantity.getText().trim();

            validateInputs(srcName, modName, modPrice, modQuantity);

            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    CONFIRM_UPDATE,
                    "Confirm Update",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                Item updatedItem = createUpdatedItem(modName, modPrice, modQuantity);
                boolean isUpdated = itemService.update(srcName, updatedItem);

                if (isUpdated) {
                    clearForm();
                    loadItems();
                    JOptionPane.showMessageDialog(this, SUCCESS_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, NOT_FOUND_ERROR, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void validateInputs(String srcName, String modName, String modPrice, String modQuantity) {
        if (srcName.isEmpty() || modName.isEmpty() || modPrice.isEmpty() || modQuantity.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_FIELD_ERROR);
        }
        if (!isValidDecimal(modPrice)) {
            throw new IllegalArgumentException(INVALID_PRICE_ERROR);
        }
        if (!isValidInteger(modQuantity)) {
            throw new IllegalArgumentException(INVALID_QUANTITY_ERROR);
        }
    }

    private boolean isValidDecimal(String input) {
        try {
            double value = Double.parseDouble(input);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidInteger(String input) {
        try {
            int value = Integer.parseInt(input);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private Item createUpdatedItem(String name, String price, String quantity) {
        return new Item(
                name,
                Double.parseDouble(price),
                Integer.parseInt(quantity)
        );
    }

    private void clearForm() {
        modText.setText("");
        mName.setText("");
        mPrice.setText("");
        mQuantity.setText("");
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new ItemManagement().setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        JScrollPane jScrollPane1 = new JScrollPane();
        text = new javax.swing.JTextArea();
        JLabel jLabel1 = new JLabel();
        modText = new javax.swing.JTextField();
        JButton updateButton = new JButton();
        // Variables declaration
        JButton backButton = new JButton();
        JLabel jLabel2 = new JLabel();
        mName = new javax.swing.JTextField();
        mPrice = new javax.swing.JTextField();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        mQuantity = new javax.swing.JTextField();
        JLabel jLabel5 = new JLabel();
        JLabel jLabel6 = new JLabel();
        JLabel jLabel7 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 255));

        text.setEditable(false);
        text.setBackground(new java.awt.Color(204, 255, 204));
        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        jLabel1.setText("Enter item name to update information");

        updateButton.setText("Update");
        updateButton.addActionListener(this::updateButtonActionPerformed);

        backButton.setText("Back");
        backButton.addActionListener(this::backButtonActionPerformed);

        jLabel2.setText("Enter New Name");

        jLabel3.setText("Enter New Price");

        jLabel4.setText("Enter New Quantity");

        jLabel5.setText("Name");

        jLabel6.setText("Quantity");

        jLabel7.setText("Price");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel7)
                                                .addGap(66, 66, 66)
                                                .addComponent(jLabel6)
                                                .addGap(48, 48, 48))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(backButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(updateButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                                                .addGap(40, 40, 40)
                                                .addComponent(mName, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(28, 28, 28)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(modText)
                                                        .addComponent(mPrice)
                                                        .addComponent(mQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(43, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6))
                                .addGap(3, 3, 3)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(modText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(mName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(mPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(mQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(backButton)
                                        .addComponent(updateButton))
                                .addGap(47, 47, 47))
        );

        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                new UpdateItem().setVisible(true);
            } catch (Exception e) {
                System.err.println("Error setting look and feel: " + e.getMessage());
            }
        });
    }

    private javax.swing.JTextField mName;
    private javax.swing.JTextField mPrice;
    private javax.swing.JTextField mQuantity;
    private javax.swing.JTextField modText;
    private javax.swing.JTextArea text;
}