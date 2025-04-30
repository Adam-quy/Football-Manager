package org.example.demo.utils;

import org.example.demo.models.Player;


import java.util.ArrayList;
import java.util.List;

public class PlayerService {
    public List<Player> getStandingsData() {
        List<Player> data = new ArrayList<>();

        // Dữ liệu này sau này có thể lấy từ API hoặc database
        data.add(new Player("Adam_A.png", "Adam Armstrong","Forward","England.png","England"));
        data.add(new Player("Adrian.png", "Adiran","Goalkeeper","Spain.png","Spain"));
        data.add(new Player("Brandon_A.png", "Brandon Aguilera","Midfielder","Costa_Rica.png","Costa Rica"));
        data.add(new Player("Emmanuel_A.png", "Emmanuel Agbadou","Defender","Cote_D'lvoire.png","Costa D'lvoire"));
        data.add(new Player("Gassan_A.png", "Gassan Ahadme","Forward","Morocco.png","Morocco"));
        data.add(new Player("Josh_A.png", "Josh Acheampong","Defender","England.png","England"));
        data.add(new Player("Kristoffer_A.png", "Kristoffer Ajer","Defender","Norway.png","Norway"));
        data.add(new Player("Manuel_A.png", "Manuel Akanji","Defender","Switzerland.png","Switzerland"));
        data.add(new Player("Max_A.png", "Max Aarons","Defender","England.png","England"));
        data.add(new Player("Naouirou_A.png", "Naouirou Ahamada","Midfielder","France.png","France"));
        data.add(new Player("Nathan_A.png", "Nathan Ake","Defender","Netherlands.png","Netherlands"));
        data.add(new Player("Nayef_A.png", "Nayer Agured","Defender","Morocco.png","Morocco"));
        data.add(new Player("Ola_A.png", "Ola Aina","Defender","Nigeria.png","Nigeria"));
        data.add(new Player("Rayan_A.png", "Rayan Ait-Nouri","Defender","Algeria.png","Algeria"));
        data.add(new Player("Simon_A.png", "Simon Adingra","Forward","Cote_D'lvoire.png","Cote D'lvoire"));
        data.add(new Player("Tosin_A.png", "Tosin Adarabioyo","Defender","England.png","England"));
        data.add(new Player("Tyler_A.png", "Tyler Adams","Midfielder","United_States.png","United States"));
        data.add(new Player("Zach_Abbott.png", "Zach Abbott","Defender","England.png","England"));

        return data;
    }
}
