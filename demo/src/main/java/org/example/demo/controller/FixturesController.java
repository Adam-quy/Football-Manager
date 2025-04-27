package org.example.demo.controller;

import org.example.demo.models.Match;
import org.example.demo.utils.MatchService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

@Controller
public class FixturesController implements Initializable{
    @FXML
    private ScrollPane Calendar;
    @Autowired
    private MatchService matchService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        VBox mainContent = new VBox(20);
        mainContent.setPadding(new Insets(15));

        Map<LocalDate, List<Match>> matchesByDate = matchService.getUpcomingMatches();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy");

        // Sort dates to ensure chronological order
        matchesByDate.keySet().stream().sorted().forEach(date -> {
            // Date header with Premier League logo
            HBox dateHeader = createDateHeader(date, dateFormatter);
            mainContent.getChildren().add(dateHeader);

            // Add match rows for this date
            List<Match> matches = matchesByDate.get(date);
            for (Match match : matches) {
                HBox matchRow = createMatchRow(match);
                mainContent.getChildren().add(matchRow);
            }
        });

        Calendar.setContent(mainContent);
        Calendar.setFitToWidth(true);
    }

    private HBox createDateHeader(LocalDate date, DateTimeFormatter formatter) {
        HBox header = new HBox(10);
        header.setAlignment(Pos.CENTER_LEFT);

        Label dateLabel = new Label(date.format(formatter));
        dateLabel.getStyleClass().add("date-header");
        dateLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #3a0ca3;");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Label leagueLabel = new Label("Football Manager ");
        leagueLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #3a0ca3;");

        ImageView leagueLogo = new ImageView(new Image(getClass().getResourceAsStream("/images/icons/logo.jpg")));
        leagueLogo.setFitHeight(30);
        leagueLogo.setFitWidth(30);

        header.getChildren().addAll(dateLabel, spacer, leagueLabel, leagueLogo);
        return header;
    }

    private HBox createMatchRow(Match match) {
        HBox row = new HBox(0);
        row.getStyleClass().add("match-row");
        row.setAlignment(Pos.CENTER_LEFT);
        row.setPadding(new Insets(10, 0, 10, 0));
        row.setStyle("-fx-border-color: #f0f0f0; -fx-border-width: 0 0 1 0;");

        // Home team with logo
        ImageView homeTeamLogo = new ImageView(new Image(getClass().getResourceAsStream("/images/Logo/" + match.getHomeTeamLogo())));
        if (match.getHomeTeamLogo().equals("LIV.png")) {
            homeTeamLogo.setStyle(" -fx-effect: innershadow(gaussian, #d90429, 100, 0.8, 0, 0);");
        }
        homeTeamLogo.setFitHeight(30);
        homeTeamLogo.setFitWidth(30);

        Label homeTeamLabel = new Label(match.getHomeTeam());
        homeTeamLabel.setPrefWidth(80);
        homeTeamLabel.setMaxWidth(100);
        homeTeamLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #3a0ca3;");
        homeTeamLabel.setAlignment(Pos.CENTER_RIGHT);

        HBox homeGroup = new HBox(5, homeTeamLabel, homeTeamLogo);
        homeGroup.setAlignment(Pos.CENTER_LEFT);
//        homeGroup.setPrefWidth(120);
        homeGroup.setMaxWidth(150);
//        homeGroup.setStyle("-fx-background-color: yellow;");

        // Kick-off time
        Label timeLabel = new Label(match.getFormattedKickOffTime());
        timeLabel.setStyle("-fx-font-weight: bold; -fx-border-width: 0.2px; -fx-border-color:#f0f0f0; -fx-border-radius: 5px;");
        timeLabel.setPrefWidth(40);
        timeLabel.setMaxWidth(80);
        timeLabel.setPrefHeight(30);
        timeLabel.setAlignment(Pos.CENTER);

        // Away team with logo
        ImageView awayTeamLogo = new ImageView(new Image(getClass().getResourceAsStream("/images/Logo/" +match.getAwayTeamLogo())));
        if (match.getAwayTeamLogo().equals("LIV.png")) {
            awayTeamLogo.setStyle(" -fx-effect: innershadow(gaussian, #d90429, 100, 0.8, 0, 0);");
        }
        awayTeamLogo.setFitHeight(30);
        awayTeamLogo.setFitWidth(30);

        Label awayTeamLabel = new Label(match.getAwayTeam());
        awayTeamLabel.setPrefWidth(80);
        awayTeamLabel.setMaxWidth(100);
        awayTeamLabel.setStyle("-fx-font-weight: bold;-fx-text-fill: #3a0ca3;");
        awayTeamLabel.setAlignment(Pos.CENTER_LEFT);

        HBox awayGroup = new HBox(5, awayTeamLogo, awayTeamLabel);
        awayGroup.setAlignment(Pos.CENTER_LEFT);
        awayGroup.setPrefWidth(120);
        awayGroup.setMaxWidth(150);
//        awayGroup.setStyle("-fx-background-color: pink;");

        // Stadium info
        ImageView stadiumIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/icons/stadium.png")));
        stadiumIcon.setFitHeight(16);
        stadiumIcon.setFitWidth(16);
        stadiumIcon.setStyle("-fx-effect: innershadow(gaussian, #3a0ca3, 100, 0.8, 0, 0);");

        Label venueLabel = new Label(match.getFullVenue());
        venueLabel.setStyle("-fx-text-fill: #3a0ca3;");

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // Quick view button
        Label quickViewLabel = new Label("Quick View");
        quickViewLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #3a0ca3; -fx-background-color: #fff; -fx-border-width: 0.2px; -fx-border-color: #f0f0f0;-fx-background-radius: 5px; -fx-border-radius: 5px;");
        quickViewLabel.setPrefHeight(30);

        ImageView arrowIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/icons/right-arrow-line.png")));
        arrowIcon.setFitHeight(16);
        arrowIcon.setFitWidth(16);
        arrowIcon.setStyle("-fx-effect: innershadow(gaussian, #3a0ca3, 100, 0.8, 0, 0);");

        HBox info = new HBox(5);
        info.setAlignment(Pos.CENTER_LEFT);
//        info.setStyle("-fx-background-color: #4cc9f0");
        info.getChildren().addAll(homeGroup, timeLabel, awayGroup);

        HBox venueBox = new HBox(5);
        venueBox.setAlignment(Pos.CENTER_LEFT);
        venueBox.getChildren().addAll(stadiumIcon, venueLabel);
//        venueBox.setStyle("-fx-background-color: yellow;");

        HBox quickViewBox = new HBox(5);
        quickViewBox.setAlignment(Pos.CENTER_RIGHT);
        quickViewBox.getChildren().addAll(quickViewLabel, arrowIcon);
//        quickViewBox.setStyle("-fx-background-color: green;");

        row.getChildren().addAll(
               info, venueBox, spacer, quickViewBox
        );

        return row;
    }
}
