package restaurantsystem.component.labour;

import restaurantsystem.service.LabourService;

public class ViewLabour extends javax.swing.JFrame {

    private final LabourService labourService;

    public ViewLabour() {
        initComponents();
        this.labourService = new LabourService();
        loadAndDisplayLabourData();
    }

    private void initComponents() {
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        labourTextArea = new javax.swing.JTextArea();
        javax.swing.JButton backButton = new javax.swing.JButton();
        javax.swing.JLabel idLabel = new javax.swing.JLabel();
        javax.swing.JLabel nameLabel = new javax.swing.JLabel();
        javax.swing.JLabel salaryLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 204));

        labourTextArea.setEditable(false);
        labourTextArea.setColumns(20);
        labourTextArea.setRows(5);
        jScrollPane1.setViewportView(labourTextArea);

        backButton.setText("Back");
        backButton.addActionListener(this::backButtonActionPerformed);

        idLabel.setText("ID");
        nameLabel.setText("Name");
        salaryLabel.setText("Salary");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(315, 315, 315)
                                                .addComponent(backButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addComponent(idLabel)
                                                .addGap(64, 64, 64)
                                                .addComponent(nameLabel)
                                                .addGap(49, 49, 49)
                                                .addComponent(salaryLabel)))
                                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(idLabel)
                                        .addComponent(nameLabel)
                                        .addComponent(salaryLabel))
                                .addGap(5, 5, 5)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(backButton)
                                .addGap(50, 50, 50))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void loadAndDisplayLabourData() {
        StringBuilder stringBuilder = new StringBuilder();

        labourService.getAll().forEach((labour) -> stringBuilder.append(labour.getId())
                .append("\t")
                .append(labour.getName())
                .append("\t")
                .append(labour.getSalary())
                .append("\n"));

        labourTextArea.setText(stringBuilder.toString());
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        LabourManagement lm = new LabourManagement();
        lm.setVisible(true);
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(ViewLabour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new ViewLabour().setVisible(true));
    }

    private javax.swing.JTextArea labourTextArea;
}