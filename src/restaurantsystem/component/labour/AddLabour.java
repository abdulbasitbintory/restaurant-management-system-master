package restaurantsystem.component.labour;

import javax.swing.*;
import restaurantsystem.model.Labour;
import restaurantsystem.service.LabourService;

public class AddLabour extends javax.swing.JFrame {
    private final LabourService labourService;

    public AddLabour() {
        initComponents();
        this.labourService = new LabourService();
        setLocationRelativeTo(null);
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String id = labourIdField.getText().trim();
        String name = labourNameField.getText().trim();
        String salaryText = labourSalaryField.getText().trim();

        if (id.isEmpty() || name.isEmpty() || salaryText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Field(s) cannot be empty", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double salary;
        try {
            salary = Double.parseDouble(salaryText);
            if (salary <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid salary (numbers only, greater than 0)", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Labour labour = new Labour(id, name, salary);
        labourService.create(labour);

        JOptionPane.showMessageDialog(this, "Labour has been added");

        labourIdField.setText("");
        labourNameField.setText("");
        labourSalaryField.setText("");
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new LabourManagement().setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        JButton addButton = new JButton();
        JButton backButton = new JButton();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        labourNameField = new javax.swing.JTextField();
        labourIdField = new javax.swing.JTextField();
        labourSalaryField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 255));

        addButton.setText("Add");
        addButton.addActionListener(this::addButtonActionPerformed);

        backButton.setText("Back");
        backButton.addActionListener(this::backButtonActionPerformed);

        jLabel1.setText("Labour ID");
        jLabel2.setText("Labour Name");
        jLabel3.setText("Labour Salary");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(backButton)
                                                .addGap(104, 104, 104)
                                                .addComponent(addButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(64, 64, 64)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(56, 56, 56)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labourSalaryField)
                                                        .addComponent(labourNameField)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(labourIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addGap(172, 172, 172))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(4, 4, 4))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(labourIdField)
                                                .addGap(18, 18, 18)
                                                .addComponent(labourNameField)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(labourSalaryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addButton)
                                        .addComponent(backButton))
                                .addGap(141, 141, 141))
        );

        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                new AddLabour().setVisible(true);
            } catch (Exception e) {
                System.err.println("Error setting look and feel: " + e.getMessage());
            }
        });
    }

    private javax.swing.JTextField labourIdField;
    private javax.swing.JTextField labourNameField;
    private javax.swing.JTextField labourSalaryField;
}
