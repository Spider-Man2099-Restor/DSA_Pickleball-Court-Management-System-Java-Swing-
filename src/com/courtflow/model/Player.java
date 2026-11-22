
package com.courtflow.model;

public class Player {
    
    private String playerID;
    private String playerName;
    private int playerLimit = 0;
    private boolean playerStatus;
    
    public boolean isPlayerStatus() {
        return playerStatus;
    }
    
    public void setPlayerStatus(boolean playerStatus) {
        this.playerStatus = playerStatus;
    }
   
    public int getPlayerLimit() {
        return playerLimit;
    }

  
    public void setPlayerLimit(int playerLimit) {
        this.playerLimit = playerLimit;
    }

  
    public String getPlayerName() {
        return playerName;
    }

   
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

   
    public String getPlayerID() {
        return playerID;
    }

    
    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public Player(String playerID, String playerName, int playerLimit, boolean playerStatus) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.playerLimit = playerLimit;
        this.playerStatus = playerStatus;
    }

    
    
}
