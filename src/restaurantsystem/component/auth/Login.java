package restaurantsystem.component.auth;

import restaurantsystem.MainMenu;

import javax.swing.*;
import java.awt.*;

public class Login extends javax.swing.JFrame {
    private static final String DEFAULT_USERNAME = "abdul";
    private static final String DEFAULT_PASSWORD = "abdul";

    public Login() {
        initComponents();
        setDefaultCredentials();
        setLocationRelativeTo(null);
    }

    private void setDefaultCredentials() {
        userNameField.setText(DEFAULT_USERNAME);
        passwordField.setText(DEFAULT_PASSWORD);
    }

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String enteredUsername = userNameField.getText().trim();
        String enteredPassword = new String(passwordField.getPassword()).trim();

        if (authenticate(enteredUsername, enteredPassword)) {
            JOptionPane.showMessageDialog(this, "Access granted");
            this.dispose();
            new MainMenu().setVisible(true);
        } else {
            clearFields();
            JOptionPane.showMessageDialog(this, "Access Denied");
        }
    }

    private boolean authenticate(String username, String password) {
        return DEFAULT_USERNAME.equalsIgnoreCase(username) &&
                DEFAULT_PASSWORD.equals(password);
    }

    private void clearFields() {
        userNameField.setText("");
        passwordField.setText("");
    }

    private void initComponents() {
        JPanel loginPanel = new JPanel();
        JLabel userNameLabel = new JLabel();
        userNameField = new javax.swing.JTextField();
        JLabel passwordLabel = new JLabel();
        JButton loginButton = new JButton();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginPanel.setBackground(new java.awt.Color(153, 153, 255));
        loginPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FSKTM Restaurant", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", Font.PLAIN, 13), new java.awt.Color(0, 0, 204)));
        loginPanel.setForeground(new java.awt.Color(153, 153, 255));
        loginPanel.setName("");

        userNameLabel.setBackground(new java.awt.Color(255, 153, 153));
        userNameLabel.setForeground(new java.awt.Color(0, 0, 255));
        userNameLabel.setText("User Name: ");

        passwordLabel.setForeground(new java.awt.Color(0, 0, 204));
        passwordLabel.setText("Password :");

        loginButton.setText("Log In");
        loginButton.addActionListener(this::loginButtonActionPerformed);

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(loginButton)
                                        .addGroup(loginPanelLayout.createSequentialGroup()
                                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passwordLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(userNameField)
                                                        .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))))
                                .addContainerGap(57, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
                loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(userNameLabel)
                                        .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel)
                                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(loginButton)
                                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap(67, Short.MAX_VALUE))
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
            System.err.println("Failed to set look and feel");
        }

        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }

    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField userNameField;
}