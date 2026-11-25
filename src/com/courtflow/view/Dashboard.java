package com.courtflow.view;

import com.courtflow.io.FileUtil;
import com.courtflow.model.Court;
import com.courtflow.model.Player;
import com.courtflow.validations.courtValidation;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

public class Dashboard extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Dashboard.class.getName());
    private courtValidation duplicate = new courtValidation();

    private ArrayList<Court> courtList = new ArrayList<>();
    private ArrayList<Player> playerQueue = new ArrayList<>();
    private static final int MAX_PLAYERS = 20;   // waiting + playing
    private static final int MAX_GAMES = 2;      // consecutive games before Cooldown
    private static final int MATCH_SIZE = 4;     // doubles
    private static final DateTimeFormatter LOG_TIME = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final Map<String, List<Player>> activeMatches = new LinkedHashMap<>();
    private int gamesPlayed = 0;   // session stat (resets when the app restarts)

    public Dashboard() {
        initComponents();
        FileUtil.createStartupFile("Courts.txt");
        FileUtil.createStartupFile("Players.txt");
        FileUtil.createStartupFile("Matches.txt");
        loadCourtsToTable();
        loadPlayersToTable();
        loadMatches();

        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        waitingQueueTable.setDefaultEditor(Object.class, null);   // queue cells are read-only
        jProgressBar1.setMaximum(MAX_PLAYERS);

        updateAllStats();
        log("Courtflow started: " + courtList.size() + " court(s), " + playerQueue.size()
                + " waiting, " + playersInMatch() + " playing.");

        //new Color(235, 241, 248)
        //EBF1F8
        this.getContentPane().setBackground(Color.WHITE);
        MainPanel.setBackground(Color.WHITE);

        LeftPanel.putClientProperty(FlatClientProperties.STYLE,
                "arc: 20; background: #FFFFFF; border: 1,1,1,1, #E2E8F0, 1, 20");
        MiddlePanel.putClientProperty(FlatClientProperties.STYLE,
                "arc: 20; background: #FFFFFF; border: 1,1,1,1, #E2E8F0, 1, 20");
        RightPanel.putClientProperty(FlatClientProperties.STYLE,
                "arc: 20; background: #FFFFFF; border: 1,1,1,1, #E2E8F0, 1, 20");
        HeaderPanel.putClientProperty(FlatClientProperties.STYLE,
                "arc: 20; background: #EBF1F8; border: 1,1,1,1, #E2E8F0, 1, 20");
        eventLogPanel.putClientProperty(FlatClientProperties.STYLE,
                "arc: 15; background: #FFFFFF; border: 1,1,1,1, #E2E8F0, 1, 15");

// 2. Remove the sharp square border from the JScrollPane
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane2.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane3.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jScrollPane2.getViewport().setBackground(Color.WHITE);
        jScrollPane3.getViewport().setBackground(Color.WHITE);

//        JTableHeader header = courtTable.getTableHeader();
//        header.setFont(header.getFont().deriveFont(Font.BOLD));
//HEADER PANEL
        Stats1.putClientProperty(FlatClientProperties.STYLE,
                "arc: 15; background: #FFFFFF; border: 1,1,1,1, #E2E8F0, 1, 15");
        Stats2.putClientProperty(FlatClientProperties.STYLE,
                "arc: 15; background: #FFFFFF; border: 1,1,1,1, #E2E8F0, 1, 15");
        Stats3.putClientProperty(FlatClientProperties.STYLE,
                "arc: 15; background: #FFFFFF; border: 1,1,1,1, #E2E8F0, 1, 15");
        Stats4.putClientProperty(FlatClientProperties.STYLE,
                "arc: 15; background: #FFFFFF; border: 1,1,1,1, #E2E8F0, 1, 15");
        jPanel5.putClientProperty(FlatClientProperties.STYLE,
                "arc: 15; background: #FFFFFF; border: 1,1,1,1, #E2E8F0, 1, 15");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        HeaderPanel = new javax.swing.JPanel();
        Stats1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        availableCourtsCounter = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        totalCourtsCounter = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        Stats2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        playerCounter = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        slotsCounter = new javax.swing.JLabel();
        Stats3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        eligibleCounter = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cooldownCounter = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        totalPlayers = new javax.swing.JLabel();
        Stats4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        gamesPlayedCounter = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        startMatchBtn = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        finishGameBtn = new javax.swing.JButton();
        LeftPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        addCourtBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        courtTable = new javax.swing.JTable();
        deleteCourtBtn = new javax.swing.JButton();
        MiddlePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        leavePlayerBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        waitingQueueTable = new javax.swing.JTable();
        RightPanel = new javax.swing.JPanel();
        eventLogPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfPlayerId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfPlayerName = new javax.swing.JTextField();
        addPlayerBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Courtflow");
        setForeground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        MainPanel.setBackground(java.awt.SystemColor.menu);

        HeaderPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("COURTS");

        availableCourtsCounter.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        availableCourtsCounter.setForeground(new java.awt.Color(51, 51, 51));
        availableCourtsCounter.setText("0");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("/");

        totalCourtsCounter.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        totalCourtsCounter.setForeground(new java.awt.Color(51, 51, 51));
        totalCourtsCounter.setText("0");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 51));
        jLabel12.setText("Available");

        javax.swing.GroupLayout Stats1Layout = new javax.swing.GroupLayout(Stats1);
        Stats1.setLayout(Stats1Layout);
        Stats1Layout.setHorizontalGroup(
            Stats1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Stats1Layout.createSequentialGroup()
                .addGroup(Stats1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Stats1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(Stats1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(Stats1Layout.createSequentialGroup()
                                .addComponent(availableCourtsCounter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalCourtsCounter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Stats1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator3)))
                .addContainerGap())
        );
        Stats1Layout.setVerticalGroup(
            Stats1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Stats1Layout.createSequentialGroup()
                .addGroup(Stats1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Stats1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(availableCourtsCounter))
                    .addGroup(Stats1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel17))
                    .addGroup(Stats1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(Stats1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalCourtsCounter)
                            .addComponent(jLabel12))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("QUEUE CAPACITY");

        playerCounter.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        playerCounter.setForeground(new java.awt.Color(51, 51, 51));
        playerCounter.setText("0");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("/");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText("20 Max");

        slotsCounter.setForeground(new java.awt.Color(51, 51, 51));
        slotsCounter.setText("0 slots open");

        javax.swing.GroupLayout Stats2Layout = new javax.swing.GroupLayout(Stats2);
        Stats2.setLayout(Stats2Layout);
        Stats2Layout.setHorizontalGroup(
            Stats2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Stats2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(Stats2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addGroup(Stats2Layout.createSequentialGroup()
                        .addComponent(playerCounter, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(slotsCounter)))
                .addContainerGap())
        );
        Stats2Layout.setVerticalGroup(
            Stats2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Stats2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(playerCounter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(Stats2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(Stats2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(slotsCounter))
                .addGap(30, 30, 30))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("PLAYER STATUS");

        eligibleCounter.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        eligibleCounter.setForeground(new java.awt.Color(0, 153, 51));
        eligibleCounter.setText("0");

        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Eligible");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("|");

        cooldownCounter.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        cooldownCounter.setForeground(new java.awt.Color(204, 153, 0));
        cooldownCounter.setText("0");

        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Cooldown");

        totalPlayers.setForeground(new java.awt.Color(51, 51, 51));
        totalPlayers.setText("0 Players in total");

        javax.swing.GroupLayout Stats3Layout = new javax.swing.GroupLayout(Stats3);
        Stats3.setLayout(Stats3Layout);
        Stats3Layout.setHorizontalGroup(
            Stats3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Stats3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(Stats3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Stats3Layout.createSequentialGroup()
                        .addComponent(eligibleCounter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(cooldownCounter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addComponent(totalPlayers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        Stats3Layout.setVerticalGroup(
            Stats3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Stats3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Stats3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Stats3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cooldownCounter)
                        .addComponent(jLabel16)
                        .addComponent(jLabel18))
                    .addGroup(Stats3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(eligibleCounter)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalPlayers)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("SESSION STATS");

        gamesPlayedCounter.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        gamesPlayedCounter.setText("0");

        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Games Played");

        javax.swing.GroupLayout Stats4Layout = new javax.swing.GroupLayout(Stats4);
        Stats4.setLayout(Stats4Layout);
        Stats4Layout.setHorizontalGroup(
            Stats4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Stats4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(Stats4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addGroup(Stats4Layout.createSequentialGroup()
                        .addComponent(gamesPlayedCounter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        Stats4Layout.setVerticalGroup(
            Stats4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Stats4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Stats4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gamesPlayedCounter)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("QUICK MATCH");

        startMatchBtn.setBackground(new java.awt.Color(37, 99, 235));
        startMatchBtn.setForeground(new java.awt.Color(255, 255, 255));
        startMatchBtn.setText("Start Match");
        startMatchBtn.addActionListener(this::startMatchBtnActionPerformed);

        jLabel22.setForeground(new java.awt.Color(153, 153, 153));
        jLabel22.setText("Ready Up, Quick Play");

        finishGameBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/courtflow/images/stop.png"))); // NOI18N
        finishGameBtn.addActionListener(this::finishGameBtnActionPerformed);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 20, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(startMatchBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(finishGameBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(startMatchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(finishGameBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout HeaderPanelLayout = new javax.swing.GroupLayout(HeaderPanel);
        HeaderPanel.setLayout(HeaderPanelLayout);
        HeaderPanelLayout.setHorizontalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Stats1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(Stats2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Stats3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Stats4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        HeaderPanelLayout.setVerticalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPanelLayout.createSequentialGroup()
                .addGroup(HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Stats1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HeaderPanelLayout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(Stats4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(Stats3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Stats2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        LeftPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("COURTS");

        addCourtBtn.setBackground(new java.awt.Color(37, 99, 235));
        addCourtBtn.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        addCourtBtn.setForeground(new java.awt.Color(255, 255, 255));
        addCourtBtn.setText("Add Court");
        addCourtBtn.addActionListener(this::addCourtBtnActionPerformed);

        courtTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Court Number", "Status", "Note"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        courtTable.setFocusable(false);
        courtTable.setShowGrid(true);
        courtTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(courtTable);

        deleteCourtBtn.setBackground(new java.awt.Color(225, 29, 72));
        deleteCourtBtn.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        deleteCourtBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteCourtBtn.setText("Delete");
        deleteCourtBtn.addActionListener(this::deleteCourtBtnActionPerformed);

        javax.swing.GroupLayout LeftPanelLayout = new javax.swing.GroupLayout(LeftPanel);
        LeftPanel.setLayout(LeftPanelLayout);
        LeftPanelLayout.setHorizontalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(LeftPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(deleteCourtBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addCourtBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        LeftPanelLayout.setVerticalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCourtBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteCourtBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        MiddlePanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("WAITING QUEUE");

        leavePlayerBtn.setBackground(new java.awt.Color(225, 29, 72));
        leavePlayerBtn.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        leavePlayerBtn.setForeground(new java.awt.Color(255, 255, 255));
        leavePlayerBtn.setText("Leave");
        leavePlayerBtn.addActionListener(this::leavePlayerBtnActionPerformed);

        waitingQueueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Player ID", "Name", "Games", "Status"
            }
        ));
        waitingQueueTable.setFocusable(false);
        waitingQueueTable.setShowGrid(true);
        waitingQueueTable.setShowVerticalLines(false);
        jScrollPane2.setViewportView(waitingQueueTable);

        javax.swing.GroupLayout MiddlePanelLayout = new javax.swing.GroupLayout(MiddlePanel);
        MiddlePanel.setLayout(MiddlePanelLayout);
        MiddlePanelLayout.setHorizontalGroup(
            MiddlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MiddlePanelLayout.createSequentialGroup()
                .addGroup(MiddlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(MiddlePanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MiddlePanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(leavePlayerBtn)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        MiddlePanelLayout.setVerticalGroup(
            MiddlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MiddlePanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(MiddlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(leavePlayerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        RightPanel.setBackground(new java.awt.Color(255, 255, 255));

        eventLogPanel.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout eventLogPanelLayout = new javax.swing.GroupLayout(eventLogPanel);
        eventLogPanel.setLayout(eventLogPanelLayout);
        eventLogPanelLayout.setHorizontalGroup(
            eventLogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eventLogPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        eventLogPanelLayout.setVerticalGroup(
            eventLogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eventLogPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("ADD PLAYER");

        jLabel4.setText("Player ID (Unique)");

        jLabel5.setText("Player Name");

        tfPlayerName.addActionListener(this::tfPlayerNameActionPerformed);

        addPlayerBtn.setBackground(new java.awt.Color(22, 163, 74));
        addPlayerBtn.setForeground(new java.awt.Color(255, 255, 255));
        addPlayerBtn.setText("+ Add Player");
        addPlayerBtn.addActionListener(this::addPlayerBtnActionPerformed);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("EVENT LOG");

        javax.swing.GroupLayout RightPanelLayout = new javax.swing.GroupLayout(RightPanel);
        RightPanel.setLayout(RightPanelLayout);
        RightPanelLayout.setHorizontalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfPlayerId)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPlayerName)
                    .addComponent(addPlayerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eventLogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        RightPanelLayout.setVerticalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPlayerId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addPlayerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventLogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(LeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MiddlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(HeaderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HeaderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MiddlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addCourtBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourtBtnActionPerformed
        addCourtFrame form = new addCourtFrame(this);
        form.setVisible(true);
    }//GEN-LAST:event_addCourtBtnActionPerformed

    private void leavePlayerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leavePlayerBtnActionPerformed
        int selectedRow = waitingQueueTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a player from the table first.",
                    "No Player Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Player selectedPlayer = playerQueue.get(selectedRow);
        int confirm = JOptionPane.showConfirmDialog(this,
                "Remove '" + selectedPlayer.getPlayerName() + "' from the queue?",
                "Confirm Leave", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        playerQueue.remove(selectedRow);
        log(selectedPlayer.getPlayerName() + " (" + selectedPlayer.getPlayerID() + ") left the queue.");
        saveAll();
        refreshAll();

    }//GEN-LAST:event_leavePlayerBtnActionPerformed

    private void tfPlayerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPlayerNameActionPerformed
        
    }//GEN-LAST:event_tfPlayerNameActionPerformed

    private void deleteCourtBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCourtBtnActionPerformed
        int selectedRow = courtTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please select a court from the table first.",
                    "No Court Selected",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        Court selectedCourt = courtList.get(selectedRow);

        if (courtList.get(selectedRow).isCourtStatus().equalsIgnoreCase("In Match")) {
            JOptionPane.showMessageDialog(
                    this,
                    "The selected court is currently in a match. Please choose an available court.",
                    "Court Occupied",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete '" + selectedCourt.getCourtNumber() + "'?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return; // User clicked No or closed the dialog
        }

        try {
            // 3. Remove from ArrayList in memory
            courtList.remove(selectedRow);

            // 4. Rebuild lines and overwrite Products.txt
            List<String> lines = new ArrayList<>();
            for (Court p : courtList) {
                lines.add(p.getCourtNumber() + "|" + p.isCourtStatus() + "|"
                        + p.getCourtNote());
            }
            FileUtil.writeAllLines("Courts.txt", lines);

            // 5. Refresh productsTable 
            loadCourtsToTable();

            log("Court deleted: " + selectedCourt.getCourtNumber());
            updateAllStats();
            JOptionPane.showMessageDialog(
                    this,
                    "Court deleted successfully!",
                    "Deleted",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error deleting court: " + ex.getMessage(),
                    "File Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_deleteCourtBtnActionPerformed

    private void addPlayerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlayerBtnActionPerformed

        String id = tfPlayerId.getText().trim();
        String name = tfPlayerName.getText().trim();

        if (playerQueue.size() + playersInMatch() >= MAX_PLAYERS) {
            JOptionPane.showMessageDialog(this,
                    "Player limit reached. Maximum of " + MAX_PLAYERS + " players (waiting + playing).",
                    "Queue Full", JOptionPane.WARNING_MESSAGE);
            log("Add player blocked: " + MAX_PLAYERS + " player limit reached.");
            return;
        }

        try {
            if (id.isBlank() || name.isBlank() || isPlayerIdTaken(id) || duplicate.duplicateId(id)) {
                JOptionPane.showMessageDialog(this,
                        "Invalid player details. Please check all fields (Player ID must be unique).",
                        "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Player newPlayer = new Player(id, name, 0, "Eligible");
            playerQueue.add(newPlayer);            // always joins at the rear (FIFO)

            saveAll();
            refreshAll();
            log("Player joined the rear of the queue: " + name + " (" + id + ") - position " + playerQueue.size() + ".");

            tfPlayerId.setText("");
            tfPlayerName.setText("");
            JOptionPane.showMessageDialog(this, "Player added successfully!", "Success",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "File error: " + ex.getMessage(),
                    "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addPlayerBtnActionPerformed

    private void startMatchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startMatchBtnActionPerformed
        
        int selectedRow = courtTable.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a court from the table first.",
                    "No Court Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Court selectedCourt = courtList.get(selectedRow);
        String courtNo = selectedCourt.getCourtNumber();

        if (!selectedCourt.isCourtStatus().equalsIgnoreCase("Ready")) {
            JOptionPane.showMessageDialog(this,
                    "The selected court is currently in a match. Please choose an available court.",
                    "Court Occupied", JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<Player> picked = pickNextPlayers();
        
        if (picked == null) {
            String msg = "Need " + MATCH_SIZE + " players to start a match, but only "
                    + playerQueue.size() + " are waiting.";
            JOptionPane.showMessageDialog(this, msg, "Not Enough Players", JOptionPane.WARNING_MESSAGE);
            log("Cannot start " + courtNo + ": " + msg);
            return;
        }

        StringBuilder who = new StringBuilder();
        
        for (int i = 0; i < picked.size(); i++) {
            
            Player p = picked.get(i);
            who.append("  ").append(i + 1).append(". ").append(p.getPlayerName())
                    .append(" (").append(p.getPlayerID()).append(")\n");
        }
        
        int confirm = JOptionPane.showConfirmDialog(this,
                "Start a match on '" + courtNo + "' with the next players in the queue?\n\n" + who,
                "Confirm Start Match", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        // 1. take the 4 players out of the waiting queue
        List<Player> onCourt = new ArrayList<>();
        for (Player p : picked) {
            playerQueue.remove(p);
            if (isEligible(p)) {
                onCourt.add(p);
            } else {
                // not enough eligible players, so a Cooldown player was called up early
                onCourt.add(withGames(p, 0, "Eligible"));
                log(p.getPlayerName() + " was called up early from Cooldown to fill the match.");
            }
        }

        // 2. everyone still in Cooldown has now sat out one match start -> Eligible again
        for (int i = 0; i < playerQueue.size(); i++) {
            Player p = playerQueue.get(i);
            if (isCooldown(p)) {
                playerQueue.set(i, withGames(p, 0, "Eligible"));
                log(p.getPlayerName() + " finished Cooldown and is Eligible again (0/" + MAX_GAMES + ").");
            }
        }

        // 3. court becomes In Match and remembers who is playing
        setCourtStatus(selectedRow, "In Match");
        activeMatches.put(courtNo, onCourt);

        log("MATCH STARTED on " + courtNo + " (Doubles): " + namesOf(onCourt));
        saveAll();
        refreshAll();
    }//GEN-LAST:event_startMatchBtnActionPerformed

    private void finishGameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishGameBtnActionPerformed

        int selectedRow = courtTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a court from the table first.",
                    "No Court Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Court selectedCourt = courtList.get(selectedRow);
        String courtNo = selectedCourt.getCourtNumber();

        if (!selectedCourt.isCourtStatus().equalsIgnoreCase("In Match")) {
            JOptionPane.showMessageDialog(this,
                    "The selected court does not have an active match to stop.",
                    "No Active Match", JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<Player> players = activeMatches.get(courtNo);
        if (players == null || players.isEmpty()) {
            // safety net: court says In Match
            setCourtStatus(selectedRow, "Ready");
            log("WARNING: no player data for " + courtNo + " - court reset to Ready.");
            saveAll();
            refreshAll();
            JOptionPane.showMessageDialog(this,
                    "No player data was found for " + courtNo + ". The court was reset to Ready.",
                    "Court Reset", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // ask every player: Continue or Leave
        confimationDialog dialog = new confimationDialog(this, true);
        dialog.setPlayers(courtNo, players);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);   // waits here until the dialog is closed

        if (!dialog.isConfirmed()) {
            log("Finish cancelled on " + courtNo + " - match is still in progress.");
            return;
        }
        log(dialog.getWinnerLog() + "\n");
        gamesPlayed++;
        List<Player> backEligible = new ArrayList<>();
        List<Player> backCooldown = new ArrayList<>();
        
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            int games = p.getPlayerLimit() + 1;
            String label = p.getPlayerName() + " (" + p.getPlayerID() + ")";

            if (!dialog.isContinuing(i)) {
                log(label + " finished on " + courtNo + " and left the session.");
            } else if (games >= MAX_GAMES) {
                backCooldown.add(withGames(p, MAX_GAMES, "Cooldown"));
                log(label + " reached " + MAX_GAMES + "/" + MAX_GAMES + " games -> Cooldown, placed at the very rear.");
            } else {
                backEligible.add(withGames(p, games, "Eligible"));
                log(label + " continues -> back of the queue (" + games + "/" + MAX_GAMES + ").");
            }
        }

        // continuing players go to the rear; Cooldown players go behind everyone
        playerQueue.addAll(backEligible);
        playerQueue.addAll(backCooldown);
        activeMatches.remove(courtNo);
        setCourtStatus(selectedRow, "Ready");

        log("MATCH FINISHED on " + courtNo + ". Court is Ready. Games played this session: " + gamesPlayed);
        
        saveAll();
        refreshAll();
    }//GEN-LAST:event_finishGameBtnActionPerformed

    public static void main(String args[]) {

        FlatMacLightLaf.setup();
        //UIManager.put("Panel.background", Color.WHITE);

        UIManager.put("Button.arc", 15);
        UIManager.put("Component.arc", 15);
        UIManager.put("TextComponent.arc", 15);

        UIManager.put("TableHeader.background", new Color(235, 241, 248));
        UIManager.put("TableHeader.foreground", new Color(30, 41, 59));
        UIManager.put("TableHeader.bottomSeparatorColor", new Color(203, 213, 225));

        //UIManager.put("TableHeader.height", 35);
        java.awt.EventQueue.invokeLater(() -> new Dashboard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel MiddlePanel;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JPanel Stats1;
    private javax.swing.JPanel Stats2;
    private javax.swing.JPanel Stats3;
    private javax.swing.JPanel Stats4;
    private javax.swing.JButton addCourtBtn;
    private javax.swing.JButton addPlayerBtn;
    private javax.swing.JLabel availableCourtsCounter;
    private javax.swing.JLabel cooldownCounter;
    private javax.swing.JTable courtTable;
    private javax.swing.JButton deleteCourtBtn;
    private javax.swing.JLabel eligibleCounter;
    private javax.swing.JPanel eventLogPanel;
    private javax.swing.JButton finishGameBtn;
    private javax.swing.JLabel gamesPlayedCounter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton leavePlayerBtn;
    private javax.swing.JLabel playerCounter;
    private javax.swing.JLabel slotsCounter;
    private javax.swing.JButton startMatchBtn;
    private javax.swing.JTextField tfPlayerId;
    private javax.swing.JTextField tfPlayerName;
    private javax.swing.JLabel totalCourtsCounter;
    private javax.swing.JLabel totalPlayers;
    private javax.swing.JTable waitingQueueTable;
    // End of variables declaration//GEN-END:variables

    public void addNewCourt(Court court) throws IOException {
        // 1. Add to ArrayList
        courtList.add(court);

        // 2. Add directly to productsTable
        DefaultTableModel model = (DefaultTableModel) courtTable.getModel();
        model.addRow(new Object[]{
            court.getCourtNumber(), court.isCourtStatus(),
            court.getCourtNote()
        });

        // 3. Write to Products.txt
        String line = court.getCourtNumber() + "|" + court.isCourtStatus() + "|"
                + court.getCourtNote();

        FileUtil.appendLine("Courts.txt", line);
        log("Court added: " + court.getCourtNumber() + " (" + court.getCourtNote() + ")");
        updateAllStats();

    }

    public void loadCourtsToTable() {

        courtList.clear(); // Keeps productList synced with the table
        DefaultTableModel model = (DefaultTableModel) courtTable.getModel();
        model.setRowCount(0);

        try {
            List<String> lines = FileUtil.readLines("Courts.txt");

            for (String line : lines) {
                if (line.isBlank()) {
                    continue;
                }

                String[] p = line.split("\\|");

                if (p.length >= 3) {
                    // 1. Add Court object into courtList so Edit/Delete works
                    // 1. Add Court object into courtList so Edit/Delete works
                    Court court = new Court(
                            p[0].trim(), p[1].trim(), p[2].trim()
                    );
                    courtList.add(court);

// 2. Add row into courtsTable
                    model.addRow(new Object[]{
                        court.getCourtNumber(), court.isCourtStatus(),
                        court.getCourtNote()
                    });

                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Failed to load products: " + ex.getMessage(),
                    "File Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

//    public void addTotalCourtCounter() {
//        totalCourtsCounter.setText("" + (courtList.size()));
//    }

//    public void countAvailableCourts() {
//        int c = 0;
//        for (Court court : courtList) {
//            if (court.isCourtStatus().contains("Ready")) {
//                c++;
//            }
//        }
//        availableCourtsCounter.setText("" + c);
//    }

    public void loadPlayersToTable() {

        playerQueue.clear(); // Keeps productList synced with the table
        DefaultTableModel model = (DefaultTableModel) waitingQueueTable.getModel();
        model.setRowCount(0);

        try {
            List<String> lines = FileUtil.readLines("Players.txt");

            for (String line : lines) {
                if (line.isBlank()) {
                    continue;
                }

                String[] p = line.split("\\|");

                if (p.length >= 4) {
                    // 1. Add Product object into productList so Edit/Delete works
                    // 1. Add Product object into productList so Edit/Delete works
                    Player player = new Player(
                            p[0].trim(), p[1].trim(), Integer.parseInt(p[2]), p[3].trim()
                    );
                    playerQueue.add(player);

// 2. Add row into productsTable
                    model.addRow(new Object[]{
                        player.getPlayerID(), player.getPlayerName(),
                        player.getPlayerLimit() + "/2", player.isPlayerStatus()
                    });

                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Failed to load products: " + ex.getMessage(),
                    "File Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

//    public void countEligibleAndCdPlayers() {
//        int c = 0;
//        int d = 0;
//        for (Player p : playerQueue) {
//            if (p.isPlayerStatus().contains("Eligible")) {
//                c++;
//            } else if (p.isPlayerStatus().contains("Cooldown")) {
//                d++;
//            }
//        }
//        slotsCounter.setText((20 - playerQueue.size()) + " slots open");
//        eligibleCounter.setText("" + c);
//        cooldownCounter.setText("" + d);
//    }
    public void addTotalCourtCounter() {
        updateAllStats();
    }

    public void countAvailableCourts() {
        updateAllStats();
    }

    public void countEligibleAndCdPlayers() {
        updateAllStats();
    }

    public void updateAllStats() {
        // Stats1 - courts
        int ready = 0;
        for (Court c : courtList) {
            if (c.isCourtStatus().equalsIgnoreCase("Ready")) {
                ready++;
            }
        }
        availableCourtsCounter.setText(String.valueOf(ready));
        totalCourtsCounter.setText(String.valueOf(courtList.size()));

        // Stats2 - capacity (waiting + playing)
        int waiting = playerQueue.size();
        int playing = playersInMatch();
        int registered = waiting + playing;
        playerCounter.setText(String.valueOf(registered));
        slotsCounter.setText(Math.max(0, MAX_PLAYERS - registered) + " slots open");
        jProgressBar1.setMaximum(MAX_PLAYERS);
        jProgressBar1.setValue(registered);

        // Stats3 - player status
        int eligible = 0;
        int cooldown = 0;
        for (Player p : playerQueue) {
            if (isEligible(p)) {
                eligible++;
            } else if (isCooldown(p)) {
                cooldown++;
            }
        }
        eligibleCounter.setText(String.valueOf(eligible));
        cooldownCounter.setText(String.valueOf(cooldown));
        totalPlayers.setText(waiting + " waiting, " + playing + " playing");

        // Stats4 - session
        gamesPlayedCounter.setText(String.valueOf(gamesPlayed));
    }

    // event log
    private void log(String message) {
        jTextArea1.append("[" + LocalTime.now().format(LOG_TIME) + "] " + message + "\n");
        jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
    }

    // queue / court rules
    private boolean isEligible(Player p) {
        return p.isPlayerStatus().equalsIgnoreCase("Eligible");
    }

    private boolean isCooldown(Player p) {
        return p.isPlayerStatus().toLowerCase().contains("cooldown");
    }

    // next 4 in strict FIFO order; Cooldown players are skipped unless there is no other way to fill the match
    private List<Player> pickNextPlayers() {
        
        List<Player> picked = new ArrayList<>();
        
        for (Player p : playerQueue) {
            if (picked.size() < MATCH_SIZE && isEligible(p)) {
                picked.add(p);
            }
        }
        for (Player p : playerQueue) {
            if (picked.size() < MATCH_SIZE && !isEligible(p)) {
                picked.add(p);
            }
        }
        return picked.size() == MATCH_SIZE ? picked : null;
    }

    private Player withGames(Player p, int games, String status) {
        return new Player(p.getPlayerID(), p.getPlayerName(), Math.min(games, MAX_GAMES), status);
    }

    private void setCourtStatus(int index, String status) {
        Court c = courtList.get(index);
        courtList.set(index, new Court(c.getCourtNumber(), status, c.getCourtNote()));
    }

    private int playersInMatch() {
        int n = 0;
        for (List<Player> list : activeMatches.values()) {
            n += list.size();
        }
        return n;
    }

    private boolean isPlayerIdTaken(String id) {
        for (Player p : playerQueue) {
            if (p.getPlayerID().equalsIgnoreCase(id)) {
                return true;
            }
        }
        for (List<Player> list : activeMatches.values()) {
            for (Player p : list) {
                if (p.getPlayerID().equalsIgnoreCase(id)) {
                    return true;
                }
            }
        }
        return false;
    }

    private String namesOf(List<Player> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(list.get(i).getPlayerName());
        }
        return sb.toString();
    }

    // ===== tables =====
    private void refreshAll() {
        refreshCourtTable();
        refreshQueueTable();
        updateAllStats();
    }

    private void refreshCourtTable() {
        int selected = courtTable.getSelectedRow();   // keep the selected court highlighted
        DefaultTableModel model = (DefaultTableModel) courtTable.getModel();
        model.setRowCount(0);
        for (Court c : courtList) {
            model.addRow(new Object[]{c.getCourtNumber(), c.isCourtStatus(), c.getCourtNote()});
        }
        if (selected >= 0 && selected < courtList.size()) {
            courtTable.setRowSelectionInterval(selected, selected);
        }
    }

    private void refreshQueueTable() {
        DefaultTableModel model = (DefaultTableModel) waitingQueueTable.getModel();
        model.setRowCount(0);
        for (Player p : playerQueue) {
            model.addRow(new Object[]{p.getPlayerID(), p.getPlayerName(),
                p.getPlayerLimit() + "/" + MAX_GAMES, p.isPlayerStatus()});
        }
    }

    // ===== files =====
    private void saveAll() {
        try {
            List<String> courts = new ArrayList<>();
            for (Court c : courtList) {
                courts.add(c.getCourtNumber() + "|" + c.isCourtStatus() + "|" + c.getCourtNote());
            }
            FileUtil.writeAllLines("Courts.txt", courts);

            List<String> players = new ArrayList<>();
            for (Player p : playerQueue) {
                players.add(p.getPlayerID() + "|" + p.getPlayerName() + "|"
                        + p.getPlayerLimit() + "|" + p.isPlayerStatus());
            }
            FileUtil.writeAllLines("Players.txt", players);

            // who is playing where: courtNumber|id|name|games|status
            List<String> matches = new ArrayList<>();
            for (Map.Entry<String, List<Player>> e : activeMatches.entrySet()) {
                for (Player p : e.getValue()) {
                    matches.add(e.getKey() + "|" + p.getPlayerID() + "|" + p.getPlayerName() + "|"
                            + p.getPlayerLimit() + "|" + p.isPlayerStatus());
                }
            }
            FileUtil.writeAllLines("Matches.txt", matches);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Failed to save data: " + ex.getMessage(),
                    "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // restores running matches after a restart and fixes courts that disagree with Matches.txt
    private void loadMatches() {
        activeMatches.clear();
        try {
            for (String line : FileUtil.readLines("Matches.txt")) {
                if (line.isBlank()) {
                    continue;
                }
                String[] p = line.split("\\|");
                if (p.length >= 5) {
                    activeMatches.computeIfAbsent(p[0].trim(), k -> new ArrayList<>())
                            .add(new Player(p[1].trim(), p[2].trim(), Integer.parseInt(p[3].trim()), p[4].trim()));
                }
            }
        } catch (IOException | NumberFormatException ex) {
            log("Could not read Matches.txt: " + ex.getMessage());
        }

        boolean changed = false;
        for (int i = 0; i < courtList.size(); i++) {
            Court c = courtList.get(i);
            boolean marked = c.isCourtStatus().equalsIgnoreCase("In Match");
            boolean hasMatch = activeMatches.containsKey(c.getCourtNumber());
            if (marked && !hasMatch) {
                setCourtStatus(i, "Ready");
                log(c.getCourtNumber() + " was In Match but had no players saved - reset to Ready.");
                changed = true;
            } else if (!marked && hasMatch) {
                setCourtStatus(i, "In Match");
                changed = true;
            }
        }
        if (changed) {
            saveAll();
            refreshCourtTable();
        }
    }
}
