package org.example.demo.utils;


import org.example.demo.models.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamService {
    public List<Team> getStandingsData() {
        List<Team> data = new ArrayList<>();

        // Dữ liệu này sau này có thể lấy từ API hoặc database
        data.add(new Team("Arsenal", "ARS.png"));
        data.add(new Team("Aston Villa", "AST.png"));
        data.add(new Team("Bournemouth", "BOU.png"));
        data.add(new Team("Brentford", "BRE.png"));
        data.add(new Team("Brighton & Hove Albion", "BRI.png"));
        data.add(new Team("Chelsea", "CHE.png"));
        data.add(new Team("Crystal Palace", "CRY.png"));
        data.add(new Team("Everton", "EVE.png"));
        data.add(new Team("Fulham", "FUL.png"));
        data.add(new Team("Ipswich Town", "IPS.png"));
        data.add(new Team("Leicester City", "LEI.png"));
        data.add(new Team("Liverpool", "LIV.png"));
        data.add(new Team("Manchester City", "MCI.png"));
        data.add(new Team("Manchester United", "MAN.png"));
        data.add(new Team("Newcastle United", "NEW.png"));
        data.add(new Team("Nottingham Forest", "NOT.png"));
        data.add(new Team("Southampton", "SOU.png"));
        data.add(new Team("Tottenham Hotspur", "SPU.png"));
        data.add(new Team("West Ham United", "WES.png"));
        data.add(new Team("Wolverhampton Wanderer", "WOL.png"));

        return data;
    }
}
