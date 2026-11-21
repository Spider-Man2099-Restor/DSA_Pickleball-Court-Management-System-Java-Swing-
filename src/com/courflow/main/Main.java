package com.courflow.main;

import com.courtflow.io.FileUtil;
import com.courtflow.view.Dashboard;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) throws Exception {
        
        FileUtil.createStartupFile("Courts.txt");
        FileUtil.createStartupFile("Players.txt");
        
        FlatMacLightLaf.setup();
        UIManager.put("Button.arc", 15);
        UIManager.put("Component.arc", 15);
        UIManager.put("TextComponent.arc", 15);

        UIManager.put("TableHeader.background", new Color(235, 241, 248));
        UIManager.put("TableHeader.foreground", new Color(30, 41, 59));
        UIManager.put("TableHeader.bottomSeparatorColor", new Color(203, 213, 225));

        EventQueue.invokeLater(() -> {
            new Dashboard().setVisible(true);
        });
    }

}
