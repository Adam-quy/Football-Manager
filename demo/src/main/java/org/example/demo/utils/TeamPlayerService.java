package org.example.demo.utils;

import org.example.demo.models.TeamPlayer;

import java.util.ArrayList;
import java.util.List;

public class TeamPlayerService {
    public List<TeamPlayer> getData(){
        List<TeamPlayer> teamPlayers = new ArrayList<TeamPlayer>();
        teamPlayers.add(new TeamPlayer("Nott'm Forest","Goalkeepers","Wayne Henessey","Wayne_Henessay.png","Wales","Wales.png","13"));
        teamPlayers.add(new TeamPlayer("Nott'm Forest","Defenders","Morato","Morato.png","Brazil","Brazil.png","4"));
        teamPlayers.add(new TeamPlayer("Nott'm Forest","Midfielders","Elliot Anderson","Elliot_Anderson.png","England","England.png","8"));
        teamPlayers.add(new TeamPlayer("Nott'm Forest","Forwards","Taiwo Awoniyi","Taiwo_Awoniyi.png","Nigeria","Nigeria.png","9"));
        teamPlayers.add(new TeamPlayer("Brentford","Goalkeepers","Morato","Morato.png","Brazil","Brazil.png","4"));
        teamPlayers.add(new TeamPlayer("Brentford","Defenders","Morato","Morato.png","Brazil","Brazil.png","4"));
        teamPlayers.add(new TeamPlayer("Brentford","Midfielders","Morato","Morato.png","Brazil","Brazil.png","4"));
        teamPlayers.add(new TeamPlayer("Brentford","Forwards","Morato","Morato.png","Brazil","Brazil.png","4"));

        return teamPlayers;
    }
}
