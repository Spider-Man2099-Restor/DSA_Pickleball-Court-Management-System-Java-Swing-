package com.courtflow.view;

import com.courtflow.model.Court;
import com.courtflow.validations.courtValidation;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class addCourtFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(addCourtFrame.class.getName());
    private Dashboard dashboard;
    private courtValidation duplicate = new courtValidation();
    public addCourtFrame(Dashboard dashboard) {
        this();
        this.dashboard = dashboard;
    }
    
   
    public addCourtFrame() {
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        MainPanel.setBackground(Color.WHITE);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        tfCourtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfSurface = new javax.swing.JTextField();
        cbStatus = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        createCourtBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add New Court - Facility Configuration");

        tfCourtName.addActionListener(this::tfCourtNameActionPerformed);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel1.setText("Initial Status");

        tfSurface.addActionListener(this::tfSurfaceActionPerformed);

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ready" }));
        cbStatus.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel2.setText("Surface/Note");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel3.setText("Court Name / Number");

        createCourtBtn.setBackground(new java.awt.Color(37, 99, 235));
        createCourtBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        createCourtBtn.setForeground(new java.awt.Color(255, 255, 255));
        createCourtBtn.setText("+ Create Court");
        createCourtBtn.addActionListener(this::createCourtBtnActionPerformed);

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(this::cancelBtnActionPerformed);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(tfSurface)))
                    .addComponent(tfCourtName)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(cancelBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createCourtBtn)))
                .addGap(15, 15, 15))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCourtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSurface, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(createCourtBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfCourtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCourtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCourtNameActionPerformed

    private void tfSurfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSurfaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSurfaceActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void createCourtBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCourtBtnActionPerformed
    
        String name = tfCourtName.getText();
        String status = cbStatus.getSelectedItem().toString();
        String surfaceNote = tfSurface.getText();
        
        try {
            if ( duplicate.duplicateName(name)|| name == null || name.isBlank() || surfaceNote == null || surfaceNote.isBlank() ) {
                JOptionPane.showMessageDialog(
                        this,
                        "Invalid court details. Please check all fields.",
                        "Validation Error",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            } else {
                Court newCourt = new Court(name,status, surfaceNote);
                if (dashboard != null) {
                    try {
                        dashboard.addNewCourt(newCourt);
                    } catch (IOException ex) {
                        System.getLogger(addCourtFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
                }
                dashboard.addTotalCourtCounter();
                JOptionPane.showMessageDialog(
                        this,
                        "Product added successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );
                
                tfCourtName.setText("");
                tfSurface.setText("");
            }
        } catch (IOException ex) {
            System.getLogger(addCourtFrame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_createCourtBtnActionPerformed

    public static void main(String args[]) {
         FlatMacLightLaf.setup();
        //UIManager.put("Panel.background", Color.WHITE);

        UIManager.put("Button.arc", 15);
        UIManager.put("Component.arc", 15);
        UIManager.put("TextComponent.arc", 15);
        java.awt.EventQueue.invokeLater(() -> new addCourtFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JButton createCourtBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField tfCourtName;
    private javax.swing.JTextField tfSurface;
    // End of variables declaration//GEN-END:variables
}
