package main.java.com.capgemini.entity;

public class Player {
    private int playerId;
    private String playerName;
    private String playerCountry;

    public Player(String playerName, String playerCountry){
        this.playerName = playerName;
        this.playerCountry = playerCountry;
    }
    public Player(){}

    public Player(int playerId, String playerName, String playerCountry) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerCountry = playerCountry;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerCountry() {
        return playerCountry;
    }

    public void setPlayerCountry(String playerCountry) {
        this.playerCountry = playerCountry;
    }
}
