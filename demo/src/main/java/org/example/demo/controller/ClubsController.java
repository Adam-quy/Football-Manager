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
import org.example.demo.utils.RankingService;
import org.example.demo.utils.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
public class ClubsController implements Initializable {
    @FXML
    private GridPane team_container;

    private final TeamService teamService = new TeamService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTeams();
    }

    private VBox teamCardView(Team team){
        VBox teamCard = new VBox(5);
        teamCard.setAlignment(Pos.CENTER);
        teamCard.setPadding(new Insets(5,10,0, 10));

        ImageView logoView = new ImageView(new Image(getClass().getResourceAsStream("/images/Logo/"+ team.getLogoPath())));
        if (team.getLogoPath().equals("LIV.png")) {
//            logoView.setStyle(" -fx-effect: innershadow(gaussian, #d90429, 100, 0.8, 0, 0);");
//            InnerShadow redGlow = new InnerShadow();
//            redGlow.setColor(Color.web("#d90429"));
//            redGlow.setRadius(20);
//            logoView.setEffect(redGlow);
//
//            logoView.setOnMouseEntered(e -> {
//                logoView.setEffect(new InnerShadow(20, Color.WHITE));
//            });
//
//            logoView.setOnMouseExited(e -> {
//                logoView.setEffect(redGlow);
//            });

              InnerShadow redGlow = new InnerShadow();
              redGlow.setColor(Color.web("#d90429"));
              redGlow.setRadius(20);
              logoView.setEffect(redGlow);

              logoView.setOnMouseEntered(e -> {
                  logoView.setEffect(new InnerShadow(20, Color.WHITE));
              });

              logoView.setOnMouseExited(e -> {
                  logoView.setEffect(redGlow);
              });
        }
        logoView.setFitHeight(80);
        logoView.setFitWidth(80);
        logoView.getStyleClass().add("team-logo");
        logoView.setPreserveRatio(true);

        // Create team name label
        Label nameLabel = new Label(team.getName());
        nameLabel.getStyleClass().add("team-name");
        nameLabel.setWrapText(true); // Cho phép xuống dòng khi không đủ chiều rộng
        nameLabel.setMaxWidth(150); // Đảm bảo không chiếm vô hạn chiều ngang
        nameLabel.setPrefWidth(100); // Chọn chiều rộng phù hợp với layout

        // Create arrow icon for navigation
        Label arrowLabel = new Label("→");
        arrowLabel.getStyleClass().add("arrow-icon");

        Region spacer = new Region();
        spacer.setPrefWidth(20);
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox content = new HBox(5);
        content.getChildren().addAll( nameLabel,spacer, arrowLabel);

        HBox colorBar = new HBox();
        colorBar.setPrefHeight(3);
        colorBar.getStyleClass().addAll("color-bar", team.getName().toLowerCase().replace(" ", "-").replace("&", "and") + "-color");

        teamCard.getChildren().addAll(logoView, content,colorBar);
        teamCard.setAlignment(Pos.CENTER_LEFT);
//        teamCard.setPrefHeight(25);
        teamCard.setPrefWidth(180);
        teamCard.getStyleClass().addAll("team-card", team.getName().toLowerCase().replace(" ", "-").replace("&", "and") + "-card");

        Region leftSpacer = new Region();
        Region rightSpacer = new Region();
        HBox.setHgrow(leftSpacer, Priority.ALWAYS);
        HBox.setHgrow(rightSpacer, Priority.ALWAYS);

        HBox hBox = new HBox(leftSpacer, teamCard, rightSpacer);


        Region topSpacer = new Region();
        Region bottomSpacer = new Region();
        VBox.setVgrow(topSpacer, Priority.ALWAYS);
        VBox.setVgrow(bottomSpacer, Priority.ALWAYS);

        VBox wrapper = new VBox(topSpacer, hBox, bottomSpacer);

        return wrapper;
    }

    private void loadTeams() {
        // Lấy danh sách các đội bóng
        List<Team> teams = teamService.getStandingsData();

        // Số cột cố định trong GridPane
        int numCols = 3;

        // Tính toán số hàng cần thiết dựa trên số lượng đội bóng
        int numRows = (int) Math.ceil((double) teams.size() / numCols);

        // Xóa tất cả các ràng buộc hàng hiện có
        team_container.getRowConstraints().clear();

        // Tạo động các RowConstraints dựa trên số hàng cần thiết
        for (int i = 0; i < numRows; i++) {
            RowConstraints row = new RowConstraints();
            row.setMinHeight(150);  // Chiều cao tối thiểu cho mỗi hàng
            row.setPrefHeight(150); // Chiều cao ưu tiên
            row.setVgrow(Priority.SOMETIMES);
            team_container.getRowConstraints().add(row);
        }

        // Thêm card cho từng đội bóng vào GridPane
        for (int i = 0; i < teams.size(); i++) {
            Team team = teams.get(i);
            VBox teamCard =  teamCardView(team);

            // Tính toán vị trí hàng và cột dựa trên index
            int row = i / numCols;
            int col = i % numCols;

            // Thêm vào GridPane tại vị trí (col, row)
            team_container.add(teamCard, col, row);
        }

    }

}
