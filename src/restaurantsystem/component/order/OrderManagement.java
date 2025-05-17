package restaurantsystem.component.order;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import restaurantsystem.MainMenu;
import restaurantsystem.model.Cart;
import restaurantsystem.model.CartItem;
import restaurantsystem.model.Item;
import restaurantsystem.model.Order;
import restaurantsystem.model.OrderLine;
import restaurantsystem.service.ItemService;
import restaurantsystem.service.OrderService;

public class OrderManagement extends javax.swing.JFrame {

    private final ItemService itemService;
    private final OrderService orderService;

    public OrderManagement() {
        initComponents();
        this.itemService = new ItemService();
        this.orderService = new OrderService();
        this.performFileRelatedTask();
    }

    private void initComponents() {
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        itemsTextArea = new javax.swing.JTextArea();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JButton backButton = new javax.swing.JButton();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        javax.swing.JLabel itemIdLabel = new javax.swing.JLabel();
        itemOrderQuantityField = new javax.swing.JTextField();
        javax.swing.JLabel quantityLabel = new javax.swing.JLabel();
        javax.swing.JButton addToCartButton = new javax.swing.JButton();
        itemIDToOrderField = new javax.swing.JTextField();
        javax.swing.JButton orderButton = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        receiptTextArea = new javax.swing.JTextArea();
        javax.swing.JLabel nameLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel priceLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel quantityLabel1 = new javax.swing.JLabel();
        totalPriceField = new javax.swing.JTextField();
        javax.swing.JLabel idLabel = new javax.swing.JLabel();
        javax.swing.JLabel priceLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel quantityLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel nameLabel2 = new javax.swing.JLabel();
        javax.swing.JButton clearCartButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        itemsTextArea.setEditable(false);
        itemsTextArea.setBackground(new java.awt.Color(204, 204, 204));
        itemsTextArea.setColumns(20);
        itemsTextArea.setRows(5);
        jScrollPane1.setViewportView(itemsTextArea);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        backButton.setText("Back");
        backButton.addActionListener(this::backButtonActionPerformed);

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        itemIdLabel.setText("Which ID Item You want?");

        quantityLabel.setText("Enter Quantity");

        addToCartButton.setText("Add to cart");
        addToCartButton.addActionListener(this::addToCartButtonActionPerformed);

        orderButton.setText("Order");
        orderButton.addActionListener(this::orderButtonActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(addToCartButton))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(quantityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(itemOrderQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(itemIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(itemIDToOrderField, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(39, 39, 39)
                                .addComponent(orderButton)
                                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(52, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(itemIdLabel)
                                                        .addComponent(itemIDToOrderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(quantityLabel)
                                                        .addComponent(itemOrderQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(orderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(5, 5, 5)))
                                .addComponent(addToCartButton)
                                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(backButton)
                                                .addGap(201, 492, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(12, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(backButton)
                                .addGap(23, 23, 23))
        );

        receiptTextArea.setBackground(new java.awt.Color(255, 153, 102));
        receiptTextArea.setColumns(20);
        receiptTextArea.setRows(5);
        jScrollPane2.setViewportView(receiptTextArea);

        nameLabel1.setText("Name");

        priceLabel1.setText("Price");

        quantityLabel1.setText("Quantity");

        totalPriceField.setEditable(false);
        totalPriceField.setBackground(new java.awt.Color(255, 204, 51));

        idLabel.setText("ID");

        priceLabel2.setText("Price");

        quantityLabel2.setText("Quantity");

        nameLabel2.setText("Name");

        clearCartButton.setText("Cancel");
        clearCartButton.addActionListener(this::clearCartButtonActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGap(92, 92, 92)
                                                                .addComponent(nameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(39, 39, 39)
                                                                .addComponent(priceLabel1)
                                                                .addGap(48, 48, 48)
                                                                .addComponent(quantityLabel1))
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(idLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                                        .addGap(2, 2, 2)
                                                                        .addComponent(nameLabel2)
                                                                        .addGap(40, 40, 40)
                                                                        .addComponent(quantityLabel2)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(priceLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(28, 28, 28))
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(totalPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(clearCartButton)))
                                                .addGap(40, 40, 40)))
                                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(nameLabel1)
                                                        .addComponent(priceLabel1)
                                                        .addComponent(quantityLabel1)
                                                        .addComponent(idLabel)
                                                        .addComponent(nameLabel2))
                                                .addGap(6, 6, 6)
                                                .addComponent(jScrollPane1))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(priceLabel2)
                                                        .addComponent(quantityLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(totalPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(clearCartButton))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void performFileRelatedTask() {
        StringBuilder stringBuilder = new StringBuilder();
        int num = 1;
        for (Item item : itemService.getAll()) {
            stringBuilder.append(num)
                    .append("\t")
                    .append(item.getName())
                    .append(" \t")
                    .append(item.getPrice())
                    .append(" \t")
                    .append(item.getQuantity())
                    .append("\n");
            num++;
        }
        itemsTextArea.setText(stringBuilder.toString());
    }

    private void orderButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Cart cart = orderService.getCart();

        if (cart.getCartItems().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Opps, You haven't added any item to cart. Please add item to the cart");
            return;
        }

        int lastOrderNumber = 0;

        try (Scanner scanner = new Scanner(new FileInputStream("storage/orderLine.txt"))) {
            while (scanner.hasNextLine()) {
                String orderLine = scanner.nextLine();
                if (!orderLine.isEmpty()) {
                    String[] orderParts = orderLine.split(",");
                    OrderLine orderLineObj = new OrderLine(
                            Integer.parseInt(orderParts[0]),
                            orderParts[1],
                            Integer.parseInt(orderParts[2]),
                            Double.parseDouble(orderParts[3]));
                    lastOrderNumber = orderLineObj.getOrderID();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

        int orderNumber = ++lastOrderNumber;

        try (PrintWriter pw = new PrintWriter(new FileOutputStream("storage/orderLine.txt", true))) {
            for (CartItem cartItem : cart.getCartItems()) {
                OrderLine orderLine = new OrderLine(
                        orderNumber,
                        cartItem.getItem().getName(),
                        cartItem.getQuantity(),
                        cartItem.getPrice());
                pw.println(orderLine.getOrderID() + "," + orderLine.getName() + "," + orderLine.getQuantity() + "," + orderLine.getPrice());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (PrintWriter pw = new PrintWriter(new FileOutputStream("storage/order.txt", true))) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            Order order = new Order(orderNumber, cart.getTotalPrice(), sdf.format(date));
            pw.println((order.getOrderID() + ",") + order.getPrice() + "," + order.getDate());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

        cart.getCartItems().forEach((item) -> itemService.reduceItemQuantityByItemName(item.getItem().getName(), item.getQuantity()));

        this.clearCartButtonActionPerformed(evt);
        this.performFileRelatedTask();
        JOptionPane.showMessageDialog(this, "Order has been created successfully !");
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        MainMenu im = new MainMenu();
        im.setVisible(true);
        this.setVisible(false);
    }

    private void addToCartButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String newItemId = itemIDToOrderField.getText();
        String newItemQuantityAsString = itemOrderQuantityField.getText();

        if (newItemId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter item id to add to cart");
            return;
        }

        if (newItemQuantityAsString.isEmpty() || !newItemQuantityAsString.chars().allMatch(Character::isDigit)) {
            JOptionPane.showMessageDialog(this, "Please enter valid quantity to add to cart");
            return;
        }

        int newItemQuantity = Integer.parseInt(newItemQuantityAsString);
        Item newItem = itemService.getItemByIndex(Integer.parseInt(newItemId));

        if (newItem == null) {
            JOptionPane.showMessageDialog(this, "Sorry , Please enter a valid Item ID");
            return;
        }

        if (newItemQuantity > newItem.getQuantity()) {
            JOptionPane.showMessageDialog(this, "Sorry , This item is out of stock");
            itemOrderQuantityField.setText("");
            itemIDToOrderField.setText("");
        } else {
            CartItem cartItem = new CartItem(newItem, newItemQuantity, newItem.getPrice() * newItemQuantity);
            orderService.addToCart(cartItem);

            receiptTextArea.setText(getReceiptStringByCart());
            totalPriceField.setText(String.valueOf(orderService.getCart().getTotalPrice()));

            JOptionPane.showMessageDialog(this, "Item has been added to cart");

            itemIDToOrderField.setText("");
            itemOrderQuantityField.setText("");
        }
    }

    private void clearCartButtonActionPerformed(java.awt.event.ActionEvent evt) {
        orderService.clearCart();
        this.receiptTextArea.setText("");
        this.totalPriceField.setText("");
    }

    public String getReceiptStringByCart() {
        List<CartItem> cartItems = orderService.getCart().getCartItems();
        StringBuilder stringBuilder = new StringBuilder();

        cartItems.forEach((item) -> stringBuilder.append(item.getItem().getName())
                .append("\t")
                .append(item.getQuantity())
                .append("\t")
                .append(item.getPrice())
                .append("\n"));

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new OrderManagement().setVisible(true));
    }

    private javax.swing.JTextField itemIDToOrderField;
    private javax.swing.JTextField itemOrderQuantityField;
    private javax.swing.JTextArea itemsTextArea;
    private javax.swing.JTextArea receiptTextArea;
    private javax.swing.JTextField totalPriceField;
}