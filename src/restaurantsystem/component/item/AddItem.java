package restaurantsystem.component.item;

import javax.swing.*;
import restaurantsystem.model.Item;
import restaurantsystem.service.ItemService;

public class AddItem extends javax.swing.JFrame {
    private final ItemService itemService;
    private static final String NAME_ERROR = "Item name cannot be empty";
    private static final String PRICE_ERROR = "Please enter a valid price (numbers only, greater than 0)";
    private static final String QUANTITY_ERROR = "Please enter a valid quantity (whole numbers only, greater than 0)";
    private static final String SUCCESS_MESSAGE = "Item has been added successfully";

    public AddItem() {
        initComponents();
        this.itemService = new ItemService();
        setLocationRelativeTo(null);
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String name = itemNameField.getText().trim();
            String priceText = itemPriceField.getText().trim();
            String quantityText = itemQuantityField.getText().trim();

            validateInput(name, priceText, quantityText);

            Item item = createItem(name, priceText, quantityText);
            itemService.create(item);

            clearForm();
            JOptionPane.showMessageDialog(this, SUCCESS_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void validateInput(String name, String price, String quantity) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(NAME_ERROR);
        }
        if (!isValidDecimal(price)) {
            throw new IllegalArgumentException(PRICE_ERROR);
        }
        if (!isValidInteger(quantity)) {
            throw new IllegalArgumentException(QUANTITY_ERROR);
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

    private Item createItem(String name, String price, String quantity) {
        return new Item(
                name,
                Double.parseDouble(price),
                Integer.parseInt(quantity)
        );
    }

    private void clearForm() {
        itemNameField.setText("");
        itemPriceField.setText("");
        itemQuantityField.setText("");
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new ItemManagement().setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        itemPriceField = new javax.swing.JTextField();
        itemNameField = new javax.swing.JTextField();
        itemQuantityField = new javax.swing.JTextField();
        JButton addButton = new JButton();
        JButton backButton = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setText("Item Name");
        jLabel2.setText("Item Price");
        jLabel3.setText("Item Quantity");

        addButton.setBackground(new java.awt.Color(0, 255, 153));
        addButton.setText("Add");
        addButton.addActionListener(this::addButtonActionPerformed);

        backButton.setText("Back");
        backButton.addActionListener(this::backButtonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(backButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(addButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(56, 56, 56)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(itemQuantityField)
                                                        .addComponent(itemPriceField)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(itemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(4, 4, 4))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(itemNameField)
                                                .addGap(18, 18, 18)
                                                .addComponent(itemPriceField)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(itemQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(backButton)
                                        .addComponent(addButton))
                                .addGap(34, 34, 34))
        );

        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                new AddItem().setVisible(true);
            } catch (Exception e) {
                System.err.println("Error setting look and feel: " + e.getMessage());
            }
        });
    }

    private javax.swing.JTextField itemNameField;
    private javax.swing.JTextField itemPriceField;
    private javax.swing.JTextField itemQuantityField;
}