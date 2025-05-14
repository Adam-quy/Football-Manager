package org.example.demo.models;

public class TeamPlayer {
    private String teamName;
    private String role;
    private String playerName;
    private String playerImage;
    private String playerNationality;
    private String nation_flag;
    private String position;
    public TeamPlayer(String teamName, String role, String playerName, String playerImage, String playerNationality, String nation_flag, String position ) {
        this.teamName = teamName;
        this.role = role;
        this.playerName = playerName;
        this.playerImage = playerImage;
        this.playerNationality = playerNationality;
        this.nation_flag = nation_flag;
        this.position = position;
    }

    public String getTeamName() {
        return teamName;
    }
    public String getRole() {
        return role;
    }
    public String getPlayerName() {
        return playerName;
    }
    public String getPlayerImage() {
        return playerImage;
    }
    public String getPlayerNationality() {
        return playerNationality;
    }
    public String getNation_flag() {
        return nation_flag;
    }
    public String getPosition() {
        return position;
    }
}
