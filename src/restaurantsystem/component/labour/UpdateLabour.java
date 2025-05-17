package restaurantsystem.component.labour;

import javax.swing.*;
import restaurantsystem.model.Labour;
import restaurantsystem.service.LabourService;

public class UpdateLabour extends javax.swing.JFrame {
    private final LabourService labourService;

    public UpdateLabour() {
        initComponents();
        this.labourService = new LabourService();
        loadLabourList();
        setLocationRelativeTo(null);
    }

    private void loadLabourList() {
        StringBuilder sb = new StringBuilder();
        labourService.getAll().forEach(labour ->
                sb.append(labour.getId()).append("\t")
                        .append(labour.getName()).append("\t")
                        .append(labour.getSalary()).append("\n")
        );
        text.setText(sb.toString());
    }

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String sourceId = oldLabourIdField.getText().trim();
        String newId = newLabourIDField.getText().trim();
        String newName = newLabourNameField.getText().trim();
        String salaryText = newLabourSalaryField.getText().trim();

        if (sourceId.isEmpty() || newId.isEmpty() || newName.isEmpty() || salaryText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Field(s) cannot be left empty", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double salary;
        try {
            salary = Double.parseDouble(salaryText);
            if (salary <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid salary (numbers only, greater than 0)", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Labour updatedLabour = new Labour(newId, newName, salary);
        boolean isUpdated = labourService.update(sourceId, updatedLabour);

        if (!isUpdated) {
            JOptionPane.showMessageDialog(this, "No labour found to update", "Update Failed", JOptionPane.WARNING_MESSAGE);
            return;
        }

        oldLabourIdField.setText("");
        newLabourIDField.setText("");
        newLabourNameField.setText("");
        newLabourSalaryField.setText("");

        JOptionPane.showMessageDialog(this, "Labour info has been updated");
        loadLabourList();
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new LabourManagement().setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        newLabourNameField = new javax.swing.JTextField();
        JLabel jLabel3 = new JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        text = new javax.swing.JTextArea();
        JLabel jLabel4 = new JLabel();
        newLabourSalaryField = new javax.swing.JTextField();
        JLabel jLabel1 = new JLabel();
        oldLabourIdField = new javax.swing.JTextField();
        JButton updateButton = new JButton();
        JButton backButton = new JButton();
        JLabel jLabel2 = new JLabel();
        newLabourIDField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 255));

        jLabel3.setText("Enter New Name");

        text.setEditable(false);
        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        jLabel4.setText("Enter New Salary");
        jLabel1.setText("Which labour id want to modify");
        jLabel2.setText("Enter New ID");

        updateButton.setText("Update");
        updateButton.addActionListener(this::updateButtonActionPerformed);

        backButton.setText("Back");
        backButton.addActionListener(this::backButtonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(61, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                                                                .addComponent(updateButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(backButton))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGap(40, 40, 40)
                                                                        .addComponent(newLabourIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addGap(28, 28, 28)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(oldLabourIdField)
                                                                                .addComponent(newLabourNameField)
                                                                                .addComponent(newLabourSalaryField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(51, 51, 51))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(oldLabourIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(newLabourIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(newLabourNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(newLabourSalaryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(updateButton)
                                        .addComponent(backButton))
                                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.err.println("Error setting look and feel: " + e.getMessage());
            }
            new UpdateLabour().setVisible(true);
        });
    }

    private javax.swing.JTextField newLabourIDField;
    private javax.swing.JTextField newLabourNameField;
    private javax.swing.JTextField newLabourSalaryField;
    private javax.swing.JTextField oldLabourIdField;
    private javax.swing.JTextArea text;
}
