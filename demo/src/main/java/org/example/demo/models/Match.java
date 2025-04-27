package org.example.demo.models;

import java.time.LocalDate;
import java.time.LocalTime;
public class Match {
    private String homeTeam;
    private String awayTeam;
    private String homeTeamLogo;
    private String awayTeamLogo;
    private LocalTime kickOffTime;
    private String venue;
    private String location;
    private LocalDate matchDate;
    private String matchResult;

    public Match(String homeTeam, String awayTeam, String homeTeamLogo, String awayTeamLogo,
                 LocalTime kickOffTime, String venue, String location, LocalDate matchDate, String matchResult) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamLogo = homeTeamLogo;
        this.awayTeamLogo = awayTeamLogo;
        this.kickOffTime = kickOffTime;
        this.venue = venue;
        this.location = location;
        this.matchDate = matchDate;
        this.matchResult = matchResult;
    }

    // Getters and setters
    public String getHomeTeam() { return homeTeam; }
    public void setHomeTeam(String homeTeam) { this.homeTeam = homeTeam; }

    public String getAwayTeam() { return awayTeam; }
    public void setAwayTeam(String awayTeam) { this.awayTeam = awayTeam; }

    public String getHomeTeamLogo() { return homeTeamLogo; }
    public void setHomeTeamLogo(String homeTeamLogo) { this.homeTeamLogo = homeTeamLogo; }

    public String getAwayTeamLogo() { return awayTeamLogo; }
    public void setAwayTeamLogo(String awayTeamLogo) { this.awayTeamLogo = awayTeamLogo; }

    public LocalTime getKickOffTime() { return kickOffTime; }
    public void setKickOffTime(LocalTime kickOffTime) { this.kickOffTime = kickOffTime; }

    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDate getMatchDate() { return matchDate; }
    public void setMatchDate(LocalDate matchDate) { this.matchDate = matchDate; }

    public String getFormattedKickOffTime() {
        return String.format("%02d:%02d", kickOffTime.getHour(), kickOffTime.getMinute());
    }

    public String getFullVenue() {
        return venue + ", " + location;
    }

    public String getMatchResult() { return matchResult; }
    public void setMatchResult(String matchResult) { this.matchResult = matchResult; }
}
