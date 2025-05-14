package org.example.demo.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.demo.models.Match;
import org.example.demo.models.TeamPlayer;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import org.example.demo.utils.TeamPlayerService;

import java.util.List;

public class MatchResultController {
    @FXML
    private VBox match_result;

    @FXML
    private Button back;

    @FXML
    private void initialize() {
        // Thiết lập sự kiện cho nút back
        back.setOnAction(this::handleBackButton);
    }
    private void handleBackButton(ActionEvent event) {
        // Đóng cửa sổ hiện tại
        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();
    }


    private final TeamPlayerService service = new TeamPlayerService();
    private static final String BOLD_BLUE_STYLE = "-fx-font-weight: bold; -fx-text-fill: #3a0ca3;";
    private static final String WHITE_BOLD_STYLE = "-fx-font-size: 20px; -fx-text-fill: white; -fx-font-weight: bold;";
    private static final String TEAM_BOX_STYLE = "-fx-background-color: #DD3333;";
    private static final String HEADER_STYLE = "-fx-background-color: white; -fx-background-radius: 10px; -fx-border-color: none;";

    /**
     * Loads match data into the UI when the MatchResult page is opened
     * @param match The match data to display
     */
    public void loadMatchData(Match match) {
        match_result.getChildren().clear(); // Clear any existing content

        VBox header = createHeader(match);

        HBox content = new HBox(0);
        content.setAlignment(Pos.TOP_CENTER);

        VBox homeTeam = createTeamDisplay(match.getHomeTeam(), match.getHomeTeamLogo(), true);
        VBox awayTeam = createTeamDisplay(match.getAwayTeam(), match.getAwayTeamLogo(), false);
        Region centerSpacer = new Region();
        HBox.setHgrow(centerSpacer, Priority.ALWAYS);

        content.getChildren().addAll(homeTeam,centerSpacer, awayTeam);

        match_result.getChildren().addAll(header, content);
        match_result.setSpacing(20);
    }

    /**
     * Creates team display with all players grouped by role
     */
    private VBox createTeamDisplay(String teamName, String teamLogo, boolean isHomeTeam) {
        VBox teamDisplay = new VBox(10);
        teamDisplay.setMinWidth(250);

        HBox teamLabel = new HBox(5);


        Label teamNameLabel = new Label(teamName);
        teamNameLabel.setStyle(BOLD_BLUE_STYLE + "-fx-font-size: 20px;");

        ImageView logo = createImageView("/images/Logo/" + teamLogo, 40, 40);

        // Arrange elements based on team side
        if (isHomeTeam) {
            teamLabel.getChildren().addAll(teamNameLabel, logo);
            teamLabel.setAlignment(Pos.CENTER_RIGHT);
        } else {
            teamLabel.getChildren().addAll(logo, teamNameLabel);
            teamLabel.setAlignment(Pos.CENTER_LEFT);
        }

        // Create role sections
        String[] roles = {"Goalkeepers", "Defenders", "Midfielders", "Forwards"};
        for (String role : roles) {
            VBox roleSection = createRoleDisplay(teamName, role, isHomeTeam);
            teamDisplay.getChildren().add(roleSection);
        }

        if (isHomeTeam) {
            teamDisplay.setPadding(new Insets(0, 0, 0, 20));
        } else {
            teamDisplay.setPadding(new Insets(0, 20, 0, 0));
        }
        teamDisplay.getChildren().add(0, teamLabel);


        return teamDisplay;
    }

    /**
     * Creates the match header with date, time, and venue information
     */
    private VBox createHeader(Match match) {
        // Match information row (date, kickoff, venue)
        HBox matchInfo = createMatchInfoRow(match);

        // Teams and score display
        HBox teamsDisplay = createTeamsDisplay(match);

        // Create the header container
        VBox heading = new VBox(10);
        heading.setAlignment(Pos.CENTER);
        heading.setPadding(new Insets(15, 20, 30, 20));
        heading.setStyle(HEADER_STYLE);
        heading.getChildren().addAll(matchInfo, teamsDisplay);

        return heading;
    }

    /**
     * Creates the match information row with date, time and venue
     */
    private HBox createMatchInfoRow(Match match) {
        HBox matchInfo = new HBox(10);
        matchInfo.setAlignment(Pos.CENTER);

        // Date display
        HBox dateBox = createInfoBox(
                createImageView("/images/icons/calendar_1.png", 15, 15),
                new Label(match.getMatchDate().toString())
        );

        // Kickoff time display
        HBox kickOffBox = createInfoBox(
                createImageView("/images/icons/clock.png", 14, 14),
                new Label(match.getKickOffTime().toString())
        );

        // Venue display
        HBox venueBox = createInfoBox(
                createImageView("/images/icons/stadium.png", 14, 14),
                new Label(match.getFullVenue())
        );

        // Add spacers for centering
        Region leftSpacer = new Region();
        HBox.setHgrow(leftSpacer, Priority.ALWAYS);
        Region rightSpacer = new Region();
        HBox.setHgrow(rightSpacer, Priority.ALWAYS);

        matchInfo.getChildren().addAll(leftSpacer, dateBox, kickOffBox, venueBox, rightSpacer);
        return matchInfo;
    }

    /**
     * Creates an info box with an icon and label
     */
    private HBox createInfoBox(ImageView icon, Label label) {
        HBox box = new HBox(5);
        box.setAlignment(Pos.CENTER);
//        box.setPrefWidth(width);

        icon.setStyle("-fx-effect: innershadow(gaussian, #3a0ca3, 100, 0.8, 0, 0);");
        label.setAlignment(Pos.CENTER_LEFT);
        label.setStyle("-fx-text-fill: #3a0ca3; -fx-font-size: 14px;");

        box.getChildren().addAll(icon, label);
        return box;
    }

    /**
     * Creates the teams and score display
     */
    private HBox createTeamsDisplay(Match match) {
        // Home team box
        VBox homeTeamBox = new VBox();
        homeTeamBox.setAlignment(Pos.CENTER);
        homeTeamBox.setPrefWidth(200);
        homeTeamBox.setStyle(TEAM_BOX_STYLE);

        ImageView homeLogo = createImageView("/images/Logo/" + match.getHomeTeamLogo(), 50, 50);

        Label homeNameLabel = new Label(match.getHomeTeam());
        homeNameLabel.setAlignment(Pos.CENTER);
        homeNameLabel.setPrefWidth(150);
        homeNameLabel.setStyle(WHITE_BOLD_STYLE);

        homeTeamBox.getChildren().addAll(homeLogo, homeNameLabel);

        // Time/score display
        Label timeLabel = new Label(match.getKickOffTime().toString());
        timeLabel.setStyle("-fx-font-size: 40px; -fx-font-weight: bold; -fx-text-fill: #3a0ca3;");

        // Away team box
        VBox awayTeamBox = new VBox();
        awayTeamBox.setAlignment(Pos.CENTER);
        awayTeamBox.setPrefWidth(200);
        awayTeamBox.setStyle(TEAM_BOX_STYLE);

        ImageView awayLogo = createImageView("/images/Logo/" + match.getAwayTeamLogo(), 50, 50);

        Label awayNameLabel = new Label(match.getAwayTeam());
        awayNameLabel.setAlignment(Pos.CENTER);
        awayNameLabel.setPrefWidth(150);
        awayNameLabel.setStyle(WHITE_BOLD_STYLE);

        awayTeamBox.getChildren().addAll(awayLogo, awayNameLabel);

        // Container for all elements
        HBox container = new HBox(10);
        container.setAlignment(Pos.CENTER);
        container.getChildren().addAll(homeTeamBox, timeLabel, awayTeamBox);

        return container;
    }

    /**
     * Creates a player display row
     */
    private HBox createPlayerDisplay(String name, String nationFlag, String nationality,
                                     String image, String position, boolean isHomeTeam) {
        HBox playerDisplay = new HBox(15);

        // Player info section
        VBox playerInfo = new VBox(5);

        Label nameLabel = new Label(name);
        nameLabel.setStyle(BOLD_BLUE_STYLE + "-fx-font-size: 14px;");

        // Nationality display
        HBox nationBox = new HBox(5);
        Label nationLabel = new Label(nationality);
        nationLabel.setStyle(BOLD_BLUE_STYLE + "-fx-font-size: 12px;");

        ImageView nationFlag1 = createImageView("/images/SVG/" + nationFlag, 12, 12);

        if (isHomeTeam) {
            nationBox.getChildren().addAll(nationLabel, nationFlag1);
            nationBox.setAlignment(Pos.CENTER_RIGHT);
        } else {
            nationBox.getChildren().addAll(nationFlag1, nationLabel);
            nationBox.setAlignment(Pos.CENTER_LEFT);
        }

        playerInfo.getChildren().addAll(nameLabel, nationBox);

        // Player image
        ImageView playerImage = createImageView("/images/Player/" + image, 40, 40);

        // Position label
        Label positionLabel = new Label(position);
        positionLabel.setStyle(BOLD_BLUE_STYLE + "-fx-font-size: 14px;");

        // Arrange elements based on team side
        if (isHomeTeam) {
            playerDisplay.getChildren().addAll(playerInfo, playerImage, positionLabel);
            playerDisplay.setAlignment(Pos.CENTER_RIGHT);
        } else {
            playerDisplay.getChildren().addAll(positionLabel, playerImage, playerInfo);
            playerDisplay.setAlignment(Pos.CENTER_LEFT);
        }

        return playerDisplay;
    }

    /**
     * Creates a role display section with all players of that role
     */
    private VBox createRoleDisplay(String teamName, String role, boolean isHomeTeam) {
        VBox roleDisplay = new VBox(5);
        if (isHomeTeam) {
            roleDisplay.setAlignment(Pos.CENTER_RIGHT);
        } else {
            roleDisplay.setAlignment(Pos.CENTER_LEFT);
        }

        // Role header
        Label roleLabel = new Label(role);
        roleLabel.setPadding(new Insets(5, 0, 5, 0));
        roleLabel.setStyle(BOLD_BLUE_STYLE + "-fx-font-size: 16px;");


        roleDisplay.getChildren().add(roleLabel);

        // Add players with the matching role
        List<TeamPlayer> players = service.getData();
        for (TeamPlayer player : players) {
            if (player.getTeamName().equalsIgnoreCase(teamName) &&
                    player.getRole().equalsIgnoreCase(role)) {

                HBox playerDisplay = createPlayerDisplay(
                        player.getPlayerName(),
                        player.getNation_flag(),
                        player.getPlayerNationality(),
                        player.getPlayerImage(),
                        player.getPosition(),
                        isHomeTeam
                );

                roleDisplay.getChildren().add(playerDisplay);
            }
        }

        return roleDisplay;
    }

    /**
     * Helper method to create ImageView with specified resource and dimensions
     */
    private ImageView createImageView(String resourcePath, double height, double width) {
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(resourcePath)));
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
        return imageView;
    }

    public void loadMatchResult(Match match) {
        match_result.getChildren().clear(); // Clear any existing content

        VBox header = createHeaderResult(match);

        HBox content = new HBox(0);
        content.setAlignment(Pos.TOP_CENTER);
        updateMatchWithStats(match);
        content.getChildren().add(createMatchStats(match));


        match_result.getChildren().addAll(header, content);
        match_result.setSpacing(20);
    }
    private VBox createHeaderResult(Match match) {
        // Match information row (date, kickoff, venue)
        HBox matchInfo = createMatchInfoRow(match);

        // Teams and score display
        HBox teamsDisplay = createTeamsResult(match);

        // Create the header container
        VBox heading = new VBox(10);
        heading.setAlignment(Pos.CENTER);
        heading.setPadding(new Insets(15, 20, 30, 20));
        heading.setStyle(HEADER_STYLE);
        heading.getChildren().addAll(matchInfo, teamsDisplay);

        return heading;
    }
    private HBox createTeamsResult(Match match) {
        // Home team box
        VBox homeDisplay = new VBox();
        HBox homeTeamBox = new HBox(5);
        homeTeamBox.setAlignment(Pos.CENTER_LEFT);
        homeTeamBox.setPrefWidth(225);
        homeTeamBox.setStyle(TEAM_BOX_STYLE);

        ImageView homeLogo = createImageView("/images/Logo/" + match.getHomeTeamLogo(), 50, 50);

        Label homeNameLabel = new Label(match.getHomeTeam());
        homeNameLabel.setAlignment(Pos.CENTER_LEFT);
        homeNameLabel.setPrefWidth(150);
        homeNameLabel.setStyle(WHITE_BOLD_STYLE);

        homeTeamBox.getChildren().addAll(homeLogo, homeNameLabel);
        Region bottomSpacer = new Region();
        bottomSpacer.setPrefHeight(25); // chiều cao khoảng trống
        homeDisplay.getChildren().addAll( homeTeamBox, bottomSpacer);

        // score display
        Label resultLabel = new Label(match.getMatchResult());
        resultLabel.setMinHeight(70);
        resultLabel.setStyle("-fx-font-size: 40px; -fx-font-weight: bold; -fx-text-fill: white;" +
                "-fx-background-color: #3a0ca3; -fx-border-color:none;" +
                "-fx-background-radius: 0 0 10px 10px;");

        // Away team box
        VBox awayDisplay = new VBox();
        HBox awayTeamBox = new HBox(5);
        awayTeamBox.setAlignment(Pos.CENTER_RIGHT);
        awayTeamBox.setPrefWidth(225);
        awayTeamBox.setStyle(TEAM_BOX_STYLE);

        ImageView awayLogo = createImageView("/images/Logo/" + match.getAwayTeamLogo(), 50, 50);

        Label awayNameLabel = new Label(match.getAwayTeam());
        awayNameLabel.setAlignment(Pos.CENTER_RIGHT);
        awayNameLabel.setPrefWidth(150);
        awayNameLabel.setStyle(WHITE_BOLD_STYLE);

        awayTeamBox.getChildren().addAll(awayNameLabel, awayLogo);
        awayDisplay.getChildren().addAll(awayTeamBox, bottomSpacer);

        // Container for all elements
        HBox container = new HBox(5);
        container.setAlignment(Pos.CENTER);
        container.getChildren().addAll(homeDisplay, resultLabel, awayDisplay);

        return container;
    }
    private VBox createMatchStats(Match match) {
        VBox statsContainer = new VBox(0);
        statsContainer.setAlignment(Pos.CENTER);
        statsContainer.setPrefWidth(800);
        statsContainer.setPadding(new Insets(0, 20, 20, 20));

        // Title for stats section
        Label statsTitle = new Label("Match Stats");
        statsTitle.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #4B0082;");
        statsTitle.setPadding(new Insets(0, 0, 15, 0));
        statsTitle.setAlignment(Pos.CENTER);
        statsTitle.setPrefWidth(Double.MAX_VALUE);

        //Team
        HBox matchTeam = new HBox(10);
        matchTeam.setAlignment(Pos.CENTER);
        matchTeam.setPadding(new Insets(0, 10, 0, 10));

        //HomeBox
        HBox homeTeamBox = new HBox(5);
        homeTeamBox.setAlignment(Pos.CENTER_LEFT);
        homeTeamBox.setPrefWidth(225);


        ImageView homeLogo = createImageView("/images/Logo/" + match.getHomeTeamLogo(), 30, 30);

        Label homeNameLabel = new Label(match.getHomeTeam());
        homeNameLabel.setAlignment(Pos.CENTER_RIGHT);
        homeNameLabel.setPrefWidth(150);
        homeNameLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: #3a0ca3; -fx-font-weight: bold;");

        homeTeamBox.getChildren().addAll(homeNameLabel, homeLogo);
        //Spacer
        Region centerSpacer = new Region();
        HBox.setHgrow(centerSpacer, Priority.ALWAYS);

        //AwayBox
        HBox awayTeamBox = new HBox(15);
        awayTeamBox.setAlignment(Pos.CENTER_RIGHT);
        awayTeamBox.setPrefWidth(225);


        ImageView awayLogo = createImageView("/images/Logo/" + match.getAwayTeamLogo(), 30, 30);

        Label awayNameLabel = new Label(match.getAwayTeam());
        awayNameLabel.setAlignment(Pos.CENTER_LEFT);
        awayNameLabel.setPrefWidth(150);
        awayNameLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #3a0ca3; -fx-font-weight: bold;");

        awayTeamBox.getChildren().addAll(awayLogo, awayNameLabel);

        matchTeam.getChildren().addAll(homeTeamBox,centerSpacer, awayTeamBox);
        // Add stats rows
        statsContainer.getChildren().addAll(
                statsTitle,
                matchTeam,
                createStatsRow("Possession %", match.getHomePosession(), match.getAwayPosession(),3),
                createStatsRow("Shots on target", match.getHomeShotsOnTarget(), match.getAwayShotsOnTarget(),4),
                createStatsRow("Shots", match.getHomeShots(), match.getAwayShots(),5),
                createStatsRow("Touches", match.getHomeTouches(), match.getAwayTouches(),6),
                createStatsRow("Passes", match.getHomePasses(), match.getAwayPasses(),7),
                createStatsRow("Tackles", match.getHomeTackles(), match.getAwayTackles(),8),
                createStatsRow("Clearances", match.getHomeClearances(), match.getAwayClearances(),9),
                createStatsRow("Corners", match.getHomeCorners(), match.getAwayCorners(),10),
                createStatsRow("Offsides", match.getHomeOffsides(), match.getAwayOffsides(),11),
                createStatsRow("Yellow cards", match.getHomeYellowCards(), match.getAwayYellowCards(),12),
                createStatsRow("Fouls conceded", match.getHomeFouls(), match.getAwayFouls(),13)
        );

        return statsContainer;
    }

    private HBox createStatsRow(String statName, String homeValue, String awayValue,int Position) {
        HBox row = new HBox(10);
        row.setAlignment(Pos.CENTER);
        row.setPrefWidth(800);
        row.setPrefHeight(40);
        row.setStyle(Position % 2 == 0 ? "-fx-background-color: #f5f5f5;" : "-fx-background-color: white;");

        // Home team value
        Label homeLabel = new Label(homeValue);
        homeLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #3a0ca3;");
        homeLabel.setAlignment(Pos.CENTER);
        homeLabel.setPrefWidth(100);

        // Stat name
        Label nameLabel = new Label(statName);
        nameLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #3a0ca3;");
        nameLabel.setAlignment(Pos.CENTER);
        nameLabel.setPrefWidth(200);

        // Away team value
        Label awayLabel = new Label(awayValue);
        awayLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #4B0082;");
        awayLabel.setAlignment(Pos.CENTER);
        awayLabel.setPrefWidth(100);

        row.getChildren().addAll(homeLabel, nameLabel, awayLabel);

        return row;
    }
    private void updateMatchWithStats(Match match) {
        // Match stats based on the image
        match.setHomePosession("49");
        match.setAwayPosession("51");
        match.setHomeShotsOnTarget("3");
        match.setAwayShotsOnTarget("4");
        match.setHomeShots("20");
        match.setAwayShots("12");
        match.setHomeTouches("611");
        match.setAwayTouches("626");
        match.setHomePasses("383");
        match.setAwayPasses("410");
        match.setHomeTackles("11");
        match.setAwayTackles("13");
        match.setHomeClearances("31");
        match.setAwayClearances("54");
        match.setHomeCorners("7");
        match.setAwayCorners("4");
        match.setHomeOffsides("1");
        match.setAwayOffsides("1");
        match.setHomeYellowCards("3");
        match.setAwayYellowCards("8");
        match.setHomeFouls("9");
        match.setAwayFouls("15");
    }
}