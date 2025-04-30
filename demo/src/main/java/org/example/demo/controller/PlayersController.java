package org.example.demo.controller;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.demo.models.Match;
import org.example.demo.models.Player;
import org.example.demo.models.Ranking;
import org.example.demo.models.Team;
import org.example.demo.utils.MatchService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.demo.utils.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PlayersController implements Initializable {
    @FXML
    private VBox Player_table;

    private final PlayerService playerService = new PlayerService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize the player data

        List<Player> playersList = playerService.getStandingsData();

        // Create the header row
        Player_table.getChildren().add(createHeaderRow());

        // Create player rows dynamically from the data
        for (Player player : playersList) {
            Player_table.getChildren().add(createPlayerRow(player));
        }
    }

    private HBox createHeaderRow() {
        HBox headerRow = new HBox();
        headerRow.setPadding(new Insets(5, 10, 10, 10));
        headerRow.setStyle(
                "-fx-border-color: transparent transparent #b8b8ff transparent;" +
                        "-fx-border-width: 0 0 1px 0;" +
                        "-fx-border-style: solid;"
        );

        Label playerLabel = new Label("Player");
        Label positionLabel = new Label("Position");
        Label nationalityLabel = new Label("Nationality");

        // Set style for header labels
        String headerStyle = "-fx-text-fill: #560bad;";
        playerLabel.setStyle(headerStyle);
        positionLabel.setStyle(headerStyle);
        nationalityLabel.setStyle(headerStyle);

        playerLabel.setFont(Font.font("System", FontWeight.BOLD, 14));
        positionLabel.setFont(Font.font("System", FontWeight.BOLD, 14));
        nationalityLabel.setFont(Font.font("System", FontWeight.BOLD, 14));

        // Add labels to header row with proper spacing and alignment
        Region spacer1 = new Region();
        HBox.setHgrow(spacer1, Priority.ALWAYS);
        Region spacer2 = new Region();
        HBox.setHgrow(spacer2, Priority.ALWAYS);

        headerRow.getChildren().addAll(
                playerLabel,
                spacer1,
                positionLabel,
                spacer2,
                nationalityLabel
        );

        // Set appropriate widths
        playerLabel.setPrefWidth(250);
        positionLabel.setPrefWidth(200);
        nationalityLabel.setPrefWidth(190);

        return headerRow;
    }

    private HBox createPlayerRow(Player player) {
        HBox playerRow = new HBox();
        playerRow.setPadding(new Insets(10));
        playerRow.setStyle("-fx-border-color: transparent transparent #e0e0e0 transparent; -fx-border-width: 0 0 1 0;");
        playerRow.setAlignment(Pos.CENTER_LEFT);

        // Player image
        ImageView playerImage = new ImageView();
        try {
            Image image = new Image(getClass().getResourceAsStream("/images/Player/" + player.getImagePath()));
            playerImage.setImage(image);
        } catch (Exception e) {
            // Use a placeholder if image not found
            playerImage.setStyle("-fx-background-color: #dddddd; -fx-background-radius: 25;");
        }
        playerImage.setFitHeight(50);
        playerImage.setFitWidth(50);
        playerImage.setPreserveRatio(true);

        // Player name with image
        HBox playerNameBox = new HBox(10);
        Label nameLabel = new Label(player.getName());
        nameLabel.setFont(Font.font("System", FontWeight.BOLD, 12));
        nameLabel.setStyle("-fx-text-fill: #3a0ca3;");
        playerNameBox.getChildren().addAll(playerImage, nameLabel);
        playerNameBox.setAlignment(Pos.CENTER_LEFT);

        // Position label
        Label positionLabel = new Label(player.getPosition());
        positionLabel.setStyle("-fx-text-fill: #3a0ca3;");
        positionLabel.setFont(Font.font("System", FontWeight.BOLD, 12));

        // Nationality with flag
        ImageView flagImage = new ImageView();
        try {
            Image flag = new Image(getClass().getResourceAsStream("/images/SVG/" + player.getNation_flag()));
            flagImage.setImage(flag);
        } catch (Exception e) {
            // Create a placeholder for missing flag
            flagImage.setStyle("-fx-background-color: #dddddd;");
        }
        flagImage.setFitHeight(20);
        flagImage.setFitWidth(30);
        flagImage.setPreserveRatio(true);

        HBox nationalityBox = new HBox(10);
        Label nationalityLabel = new Label(player.getNationality());
        nationalityLabel.setStyle("-fx-text-fill: #3a0ca3;");
        nationalityLabel.setFont(Font.font("System", FontWeight.BOLD, 12));
        nationalityBox.getChildren().addAll(flagImage, nationalityLabel);
        nationalityBox.setAlignment(Pos.CENTER_LEFT);

        // Add items to player row with proper spacing and alignment
        Region spacer1 = new Region();
        HBox.setHgrow(spacer1, Priority.ALWAYS);
        Region spacer2 = new Region();
        HBox.setHgrow(spacer2, Priority.ALWAYS);

        playerRow.getChildren().addAll(
                playerNameBox,
                spacer1,
                positionLabel,
                spacer2,
                nationalityBox
        );

        // Set appropriate widths
        playerNameBox.setPrefWidth(250);
        positionLabel.setPrefWidth(200);
        nationalityBox.setPrefWidth(190);

        return playerRow;
    }
}

