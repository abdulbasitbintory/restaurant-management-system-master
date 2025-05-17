package restaurantsystem.component.labour;

import javax.swing.*;
import restaurantsystem.MainMenu;

public class LabourManagement extends javax.swing.JFrame {

    public LabourManagement() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        JButton addButton = new JButton("Add Labour");
        JButton viewButton = new JButton("View Labour");
        JButton updateButton = new JButton("Update Labour");
        JButton deleteButton = new JButton("Delete Labour");
        JButton backButton = new JButton("Back");

        mainPanel.setBackground(new java.awt.Color(204, 255, 255));

        addButton.addActionListener(_ -> {
            new AddLabour().setVisible(true);
            this.dispose();
        });

        viewButton.addActionListener(_ -> {
            new ViewLabour().setVisible(true);
            this.dispose();
        });

        updateButton.addActionListener(_ -> {
            new UpdateLabour().setVisible(true);
            this.dispose();
        });

        deleteButton.addActionListener(_ -> {
            new DeleteLabour().setVisible(true);
            this.dispose();
        });

        backButton.addActionListener(_ -> {
            new MainMenu().setVisible(true);
            this.dispose();
        });

        GroupLayout layout = new GroupLayout(mainPanel);
        mainPanel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addComponent(viewButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGap(30)
                        .addComponent(addButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(viewButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(backButton)
                        .addGap(30)
        );

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Labour Management");
        setContentPane(mainPanel);
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.err.println("Error setting look and feel: " + e.getMessage());
            }
            new LabourManagement().setVisible(true);
        });
    }
}
