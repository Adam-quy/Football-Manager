package org.example.demo.utils;

import org.example.demo.models.Ranking;

import java.util.ArrayList;
import java.util.List;

public class RankingService {
    public List<Ranking> getStandingsData() {
        List<Ranking> data = new ArrayList<>();

        // Dữ liệu này sau này có thể lấy từ API hoặc database
        data.add(new Ranking("1", "LIV.png","Liverpool", "33", "24", "7", "2", "75", "31", "44", "79", "WWLWW", "SPU.png"));
        data.add(new Ranking("2", "ARS.png","Arsenal", "34", "18", "13", "3", "63", "29", "34", "67", "WDDWD", "BOU.png"));
        data.add(new Ranking("3","NEW.png", "Newcastle United", "34", "19", "5", "10", "65", "44", "21", "62", "WWWLW", "BRI.png"));
        data.add(new Ranking("4","MCI.png", "Manchester City", "34", "18", "7", "9", "66", "43", "23", "61", "WDWWW", "WOL.png"));
        data.add(new Ranking("5","CHE.png", "Chelsea", "34", "17", "9", "8", "59", "40", "19", "60", "WDDWW", "LIV.png"));
        data.add(new Ranking("6", "NOT.png","Nottingham Forest", "33", "18", "6", "9", "53", "39", "14", "60", "WWLLW", "BRE.png"));
        data.add(new Ranking("7","AST.png", "Aston Villa", "34", "16", "9", "9", "54", "49", "5", "57", "WWWWL", "FUL.png"));
        data.add(new Ranking("8","FUL.png", "Fulham", "34", "14", "9", "11", "50", "46", "4", "51", "LWLLW", "AST.png"));

        return data;
    }

}
