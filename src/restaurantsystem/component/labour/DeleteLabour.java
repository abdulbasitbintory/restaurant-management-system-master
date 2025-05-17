package restaurantsystem.component.labour;

import javax.swing.*;
import restaurantsystem.service.LabourService;

public class DeleteLabour extends javax.swing.JFrame {
    private final LabourService labourService;

    public DeleteLabour() {
        initComponents();
        this.labourService = new LabourService();
        loadLabourList();
        setLocationRelativeTo(null);
    }

    private void loadLabourList() {
        StringBuilder sb = new StringBuilder();
        labourService.getAll().forEach(labour ->
                sb.append(labour.getId())
                        .append("\t")
                        .append(labour.getName())
                        .append("\t")
                        .append(labour.getSalary())
                        .append("\n")
        );
        text.setText(sb.toString());
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String deleteLabourID = labourIDField.getText().trim();

        if (deleteLabourID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid ID to delete", "Input Error", JOptionPane.ERROR_MESSAGE);
            labourIDField.setText("");
            return;
        }

        boolean deleted = labourService.delete(deleteLabourID);

        if (deleted) {
            JOptionPane.showMessageDialog(this, "Labour has been deleted");
        } else {
            JOptionPane.showMessageDialog(this, "No labour found with that ID", "Delete Failed", JOptionPane.WARNING_MESSAGE);
        }

        labourIDField.setText("");
        loadLabourList();
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new LabourManagement().setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        JButton deleteButton = new JButton();
        JButton backButton = new JButton();
        JScrollPane jScrollPane1 = new JScrollPane();
        text = new javax.swing.JTextArea();
        JLabel jLabel1 = new JLabel();
        labourIDField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 255));

        deleteButton.setText("Delete");
        deleteButton.addActionListener(this::deleteButtonActionPerformed);

        backButton.setText("Back");
        backButton.addActionListener(this::backButtonActionPerformed);

        text.setEditable(false);
        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        jLabel1.setText("Which Labour ID want to Delete");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteButton)
                                .addGap(18, 18, 18)
                                .addComponent(backButton)
                                .addGap(57, 57, 57))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(labourIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(labourIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(deleteButton)
                                        .addComponent(backButton))
                                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                new DeleteLabour().setVisible(true);
            } catch (Exception e) {
                System.err.println("Error setting look and feel: " + e.getMessage());
            }
        });
    }

    private javax.swing.JTextField labourIDField;
    private javax.swing.JTextArea text;
}
