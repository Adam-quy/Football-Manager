package org.example.demo.utils;


import org.example.demo.DAO.DAO_CLB;
import org.example.demo.models.Team;
import org.example.demo.config.DatabaseConnection;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamService {
    private DAO_CLB daoCLB = new DAO_CLB();
    public List<Team> getStandingsData(){
        List<Team> teams = new ArrayList<Team>();
        teams =  daoCLB.getAllClubs();
        return teams;
    }

}
