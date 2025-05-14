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
    private String homePosession;
    private String awayPosession;
    private String homeShotsOnTarget;
    private String awayShotsOnTarget;
    private String homeShots;
    private String awayShots;
    private String homeTouches;
    private String awayTouches;
    private String homePasses;
    private String awayPasses;
    private String homeTackles;
    private String awayTackles;
    private String homeClearances;
    private String awayClearances;
    private String homeCorners;
    private String awayCorners;
    private String homeOffsides;
    private String awayOffsides;
    private String homeYellowCards;
    private String awayYellowCards;
    private String homeFouls;
    private String awayFouls;

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

    public String getHomePosession(){
        return homePosession;
    }
    public void setHomePosession(String homePosession){
        this.homePosession = homePosession;
    }
    public String getAwayPosession(){
        return awayPosession;
    }
    public void setAwayPosession(String awayPosession){
        this.awayPosession = awayPosession;
    }
    public String getHomeShotsOnTarget(){
        return homeShotsOnTarget;
    }
    public void setHomeShotsOnTarget(String homeShotsOnTarget){
        this.homeShotsOnTarget = homeShotsOnTarget;
    }
    public String getAwayShotsOnTarget(){
        return awayShotsOnTarget;
    }
    public void setAwayShotsOnTarget(String awayShotsOnTarget){
        this.awayShotsOnTarget = awayShotsOnTarget;
    }
    public String getHomeShots(){
        return homeShots;
    }
    public void setHomeShots(String homeShots){
        this.homeShots = homeShots;
    }
    public String getAwayShots(){
        return awayShots;
    }
    public void setAwayShots(String awayShots){
        this.awayShots = awayShots;
    }
    public String getHomeTouches(){
        return homeTouches;
    }
    public void setHomeTouches(String homeTouches){
        this.homeTouches = homeTouches;
    }
    public String getAwayTouches(){
        return awayTouches;
    }
    public void setAwayTouches(String awayTouches){
        this.awayTouches = awayTouches;
    }
    public String getHomePasses(){
        return homePasses;
    }
    public void setHomePasses(String homePasses){
        this.homePasses = homePasses;
    }
    public String getAwayPasses(){
        return awayPasses;
    }
    public void setAwayPasses(String awayPasses){
        this.awayPasses = awayPasses;
    }
    public String getHomeTackles(){
        return homeTackles;
    }
    public void setHomeTackles(String homeTackles){
        this.homeTackles = homeTackles;
    }
    public String getAwayTackles(){
        return awayTackles;
    }
    public void setAwayTackles(String awayTackles){
        this.awayTackles = awayTackles;
    }
    public String getHomeClearances(){
        return homeClearances;
    }
    public void setHomeClearances(String homeClearances){
        this.homeClearances = homeClearances;
    }
    public String getAwayClearances(){
        return awayClearances;
    }
    public void setAwayClearances(String awayClearances){
        this.awayClearances = awayClearances;
    }
    public String getHomeCorners(){
        return homeCorners;
    }
    public void setHomeCorners(String homeCorners){
        this.homeCorners = homeCorners;
    }
    public String getAwayCorners(){
        return awayCorners;
    }
    public void setAwayCorners(String awayCorners){
        this.awayCorners = awayCorners;
    }
    public String getHomeOffsides(){
        return homeOffsides;
    }
    public void setHomeOffsides(String homeOffsides){
        this.homeOffsides = homeOffsides;
    }
    public String getAwayOffsides(){
        return awayOffsides;
    }
    public void setAwayOffsides(String awayOffsides){
        this.awayOffsides = awayOffsides;
    }
    public String getHomeYellowCards(){
        return homeYellowCards;
    }
    public void setHomeYellowCards(String homeYellowCards){
        this.homeYellowCards = homeYellowCards;
    }
    public String getAwayYellowCards(){
        return awayYellowCards;
    }
    public void setAwayYellowCards(String awayYellowCards){
        this.awayYellowCards = awayYellowCards;
    }
    public String getHomeFouls(){
        return homeFouls;
    }
    public void setHomeFouls(String homeFouls){
        this.homeFouls = homeFouls;
    }
    public String getAwayFouls(){
        return awayFouls;
    }
    public void setAwayFouls(String awayFouls){
        this.awayFouls = awayFouls;
    }
}
