package com.courtflow.view;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.UIManager;

public class confimationDialog extends javax.swing.JDialog {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(confimationDialog.class.getName());

    public confimationDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        headerPanel.putClientProperty(FlatClientProperties.STYLE,
                "arc: 20; background: #FFFFFF; border: 1,1,1,1, #E2E8F0, 1, 20");
        bodyPanel.putClientProperty(FlatClientProperties.STYLE,
                "arc: 20; background: #FFFFFF; border: 1,1,1,1, #FFFFFF, 1, 20");
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane1.getViewport().setBackground(Color.WHITE);

        //players panel
        p1Panel.putClientProperty(FlatClientProperties.STYLE,
                "arc: 20; background: #EBF1F8; border: 1,1,1,1, #E2E8F0, 1, 20");
        p2Panel.putClientProperty(FlatClientProperties.STYLE,
                "arc: 20; background: #EBF1F8; border: 1,1,1,1, #E2E8F0, 1, 20");
        p3Panel.putClientProperty(FlatClientProperties.STYLE,
                "arc: 20; background: #EBF1F8; border: 1,1,1,1, #E2E8F0, 1, 20");
        p4Panel.putClientProperty(FlatClientProperties.STYLE,
                "arc: 20; background: #EBF1F8; border: 1,1,1,1, #E2E8F0, 1, 20");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        headerPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        bodyPanel = new javax.swing.JPanel();
        p1Panel = new javax.swing.JPanel();
        p1Name = new javax.swing.JLabel();
        gameLimitCooldown1 = new javax.swing.JLabel();
        P1continueCheckBox1 = new javax.swing.JCheckBox();
        P1leaveCheckBox1 = new javax.swing.JCheckBox();
        p2Panel = new javax.swing.JPanel();
        p2Name = new javax.swing.JLabel();
        gameLimitCooldown2 = new javax.swing.JLabel();
        P2continueCheckBox2 = new javax.swing.JCheckBox();
        P2leaveCheckBox2 = new javax.swing.JCheckBox();
        p3Panel = new javax.swing.JPanel();
        p3Name = new javax.swing.JLabel();
        gameLimitCooldown3 = new javax.swing.JLabel();
        P3continueCheckBox2 = new javax.swing.JCheckBox();
        P3leaveCheckBox3 = new javax.swing.JCheckBox();
        p4Panel = new javax.swing.JPanel();
        p4Name = new javax.swing.JLabel();
        gameLimitCooldown4 = new javax.swing.JLabel();
        P4continueCheckBox4 = new javax.swing.JCheckBox();
        P4leaveCheckBox4 = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        confirmBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Post-Game Continuation");

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        headerPanel.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Ask each player whether they want to continue. \nSelecting Continue returns the player to the rear of the queue. \nAny player reaching 2 consecutive games is placed at the very rear with \nstatus Cooldown (Rear).");
        jTextArea1.setFocusable(false);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bodyPanel.setBackground(new java.awt.Color(255, 255, 255));

        p1Name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        p1Name.setText("P1 Name");

        gameLimitCooldown1.setText("Games : 2/2");

        P1continueCheckBox1.setText("Continue");
        P1continueCheckBox1.addActionListener(this::P1continueCheckBox1ActionPerformed);

        P1leaveCheckBox1.setText("Leave");
        P1leaveCheckBox1.addActionListener(this::P1leaveCheckBox1ActionPerformed);

        javax.swing.GroupLayout p1PanelLayout = new javax.swing.GroupLayout(p1Panel);
        p1Panel.setLayout(p1PanelLayout);
        p1PanelLayout.setHorizontalGroup(
            p1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1PanelLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(p1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p1Name, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(p1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(gameLimitCooldown1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(p1PanelLayout.createSequentialGroup()
                            .addComponent(P1continueCheckBox1)
                            .addGap(18, 18, 18)
                            .addComponent(P1leaveCheckBox1))))
                .addGap(223, 223, 223))
        );
        p1PanelLayout.setVerticalGroup(
            p1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p1PanelLayout.createSequentialGroup()
                .addGroup(p1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p1PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(p1Name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gameLimitCooldown1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(P1continueCheckBox1))
                    .addGroup(p1PanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(P1leaveCheckBox1)))
                .addContainerGap())
        );

        p2Name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        p2Name.setText("P2 Name");

        gameLimitCooldown2.setText("Games : 0/0");

        P2continueCheckBox2.setText("Continue");

        P2leaveCheckBox2.setText("Leave");

        javax.swing.GroupLayout p2PanelLayout = new javax.swing.GroupLayout(p2Panel);
        p2Panel.setLayout(p2PanelLayout);
        p2PanelLayout.setHorizontalGroup(
            p2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p2PanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(p2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p2PanelLayout.createSequentialGroup()
                        .addComponent(P2continueCheckBox2)
                        .addGap(18, 18, 18)
                        .addComponent(P2leaveCheckBox2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(p2Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gameLimitCooldown2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        p2PanelLayout.setVerticalGroup(
            p2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p2Name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gameLimitCooldown2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(p2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P2continueCheckBox2)
                    .addComponent(P2leaveCheckBox2))
                .addContainerGap())
        );

        p3Name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        p3Name.setText("P3 Name");

        gameLimitCooldown3.setText("Games : 0/0");

        P3continueCheckBox2.setText("Continue");

        P3leaveCheckBox3.setText("Leave");

        javax.swing.GroupLayout p3PanelLayout = new javax.swing.GroupLayout(p3Panel);
        p3Panel.setLayout(p3PanelLayout);
        p3PanelLayout.setHorizontalGroup(
            p3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p3PanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(p3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p3PanelLayout.createSequentialGroup()
                        .addComponent(P3continueCheckBox2)
                        .addGap(18, 18, 18)
                        .addComponent(P3leaveCheckBox3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(p3Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gameLimitCooldown3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        p3PanelLayout.setVerticalGroup(
            p3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p3PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p3Name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gameLimitCooldown3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(p3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P3continueCheckBox2)
                    .addComponent(P3leaveCheckBox3))
                .addContainerGap())
        );

        p4Name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        p4Name.setText("P4 Name");

        gameLimitCooldown4.setText("Games : 0/0");

        P4continueCheckBox4.setText("Continue");

        P4leaveCheckBox4.setText("Leave");

        javax.swing.GroupLayout p4PanelLayout = new javax.swing.GroupLayout(p4Panel);
        p4Panel.setLayout(p4PanelLayout);
        p4PanelLayout.setHorizontalGroup(
            p4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p4PanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(p4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p4PanelLayout.createSequentialGroup()
                        .addComponent(P4continueCheckBox4)
                        .addGap(18, 18, 18)
                        .addComponent(P4leaveCheckBox4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(p4Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gameLimitCooldown4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        p4PanelLayout.setVerticalGroup(
            p4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p4PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p4Name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gameLimitCooldown4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(p4PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P4continueCheckBox4)
                    .addComponent(P4leaveCheckBox4))
                .addContainerGap())
        );

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p1Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(p2Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(p3Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(p4Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p4Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        confirmBtn.setBackground(new java.awt.Color(22, 163, 74));
        confirmBtn.setForeground(new java.awt.Color(255, 255, 255));
        confirmBtn.setText("Confirm and Update Queue");

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(this::cancelBtnActionPerformed);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmBtn)
                .addGap(14, 14, 14))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void P1continueCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P1continueCheckBox1ActionPerformed
        if (P1continueCheckBox1.isSelected()) {
            P1leaveCheckBox1.setSelected(false);
        } else {
            P1continueCheckBox1.setSelected(true); // Prevents both from being unchecked
        }
    }//GEN-LAST:event_P1continueCheckBox1ActionPerformed

    private void P1leaveCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P1leaveCheckBox1ActionPerformed
        if (P1leaveCheckBox1.isSelected()) {
            P1continueCheckBox1.setSelected(false);
        } else {
            P1leaveCheckBox1.setSelected(true); // Prevents both from being unchecked
        }
    }//GEN-LAST:event_P1leaveCheckBox1ActionPerformed

    public static void main(String args[]) {

        FlatMacLightLaf.setup();
        //UIManager.put("Panel.background", Color.WHITE);

        UIManager.put("Button.arc", 15);
        UIManager.put("Component.arc", 15);
        UIManager.put("TextComponent.arc", 15);
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                confimationDialog dialog = new confimationDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox P1continueCheckBox1;
    private javax.swing.JCheckBox P1leaveCheckBox1;
    private javax.swing.JCheckBox P2continueCheckBox2;
    private javax.swing.JCheckBox P2leaveCheckBox2;
    private javax.swing.JCheckBox P3continueCheckBox2;
    private javax.swing.JCheckBox P3leaveCheckBox3;
    private javax.swing.JCheckBox P4continueCheckBox4;
    private javax.swing.JCheckBox P4leaveCheckBox4;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JLabel gameLimitCooldown1;
    private javax.swing.JLabel gameLimitCooldown2;
    private javax.swing.JLabel gameLimitCooldown3;
    private javax.swing.JLabel gameLimitCooldown4;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel p1Name;
    private javax.swing.JPanel p1Panel;
    private javax.swing.JLabel p2Name;
    private javax.swing.JPanel p2Panel;
    private javax.swing.JLabel p3Name;
    private javax.swing.JPanel p3Panel;
    private javax.swing.JLabel p4Name;
    private javax.swing.JPanel p4Panel;
    // End of variables declaration//GEN-END:variables
}
