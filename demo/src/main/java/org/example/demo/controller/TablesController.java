package org.example.demo.controller;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.demo.models.Match;
import org.example.demo.models.Ranking;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
public class TablesController implements Initializable{
    @FXML
    private ScrollPane ranking;

    private final RankingService rankingService = new RankingService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        VBox tableContent = createTableContent();
        ranking.setContent(tableContent);
        ranking.setFitToWidth(true);
    }

    private VBox createTableContent() {
        VBox content = new VBox();
        content.setSpacing(0);
        content.setPadding(new Insets(0));

        // Thêm header cho bảng
        HBox header = createTableHeader();
        content.getChildren().add(header);

        // Lấy dữ liệu đội bóng từ service
        List<Ranking> teamData = rankingService.getStandingsData();

        // Tạo các dòng dữ liệu
        for (int i = 0; i < teamData.size(); i++) {
            HBox row = createTeamRow(teamData.get(i), i);
            content.getChildren().add(row);
        }

        return content;
    }

    private HBox createTableHeader() {
        HBox header = new HBox();
        header.setPadding(new Insets(10, 15, 10, 10));
        header.setSpacing(5);
        header.setStyle("-fx-background-color: #f8f8f8; -fx-border-color: #f8f8f8; -fx-border-width: 0 0 1 4;");

        String[] columns = {"Rank", "Club", "Played", "Won", "Drawn", "Lost", "Points", "Form", "Next", "More"};
        int[] widths = {40, 165, 50, 35, 45, 35, 50, 115, 35, 40};

        for (int i = 0; i < columns.length; i++) {
            Label label = new Label(columns[i]);
            label.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            label.setPrefWidth(widths[i]);
            label.setAlignment(Pos.CENTER);
            header.getChildren().add(label);
//            label.setStyle("-fx-border-color:red");
        }

        return header;
    }

    private HBox createTeamRow(Ranking rank_items, int index) {
        HBox row = new HBox();
        row.setAlignment(Pos.CENTER_LEFT);
        row.setPadding(new Insets(8, 15, 8, 10));
        row.setSpacing(5);

        // Thiết lập màu nền xen kẽ cho các dòng
        String rowStyle = index % 2 == 0 ?
                "-fx-background-color: white;" :
                "-fx-background-color: #f9f9f9;";

        // Thêm viền màu bên trái cho các đội đứng đầu (vị trí 1-6)
        if (index < 4) {
            rowStyle += "-fx-border-color: blue; -fx-border-width: 0 0 0 4;";
        } else if (index < 6) {
            rowStyle += "-fx-border-color: orange; -fx-border-width: 0 0 0 4;";
        }else{
            rowStyle +="-fx-border-color: #f8f8f8;-fx-border-width: 0 0 0 4;";
        }

        row.setStyle(rowStyle);

        // Cột vị trí
        Label posLabel = new Label(rank_items.getPosition());
        posLabel.setPrefWidth(45);
        posLabel.setAlignment(Pos.CENTER);
//        posLabel.setStyle("-fx-background-color: yellow");

        // Cột thông tin đội bóng (logo và tên)
        HBox clubColumn = new HBox();
        clubColumn.setAlignment(Pos.CENTER_LEFT);
        clubColumn.setSpacing(10);
        clubColumn.setPrefWidth(170);
//        clubColumn.setStyle("-fx-background-color: green");

        // Lấy đường dẫn logo từ service
//        String logoPath = rank_items.getHomeLogo();

        // Tạo ImageView cho logo đội bóng
        ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("/images/Logo/" +rank_items.getHomeLogo())));
//        try {
//            logo.setImage(new Image(getClass().getResourceAsStream("/images/Logo/" +logoPath)));
//        } catch (Exception e) {
//            // Sử dụng placeholder nếu không tìm thấy logo
//            System.err.println("Không tìm thấy logo cho đội: " + rank_items.getName());
//        }
        if (rank_items.getHomeLogo().equals("LIV.png")) {
            logo.setStyle(" -fx-effect: innershadow(gaussian, #d90429, 100, 0.8, 0, 0);");
        }
        logo.setFitHeight(30);
        logo.setFitWidth(30);

        // Tên đội bóng
        Label clubName = new Label(rank_items.getName());
        clubName.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        clubColumn.getChildren().addAll(logo, clubName);

        // Các cột thống kê
        Label played = new Label(rank_items.getPlayed());
        played.setPrefWidth(45);
//        played.setStyle("-fx-background-color: blue");
        played.setAlignment(Pos.CENTER);

        Label won = new Label(rank_items.getWon());
        won.setPrefWidth(40);
//        won.setStyle("-fx-background-color: orange");
        won.setAlignment(Pos.CENTER);

        Label drawn = new Label(rank_items.getDrawn());
        drawn.setPrefWidth(50);
//        drawn.setStyle("-fx-background-color: brown");
        drawn.setAlignment(Pos.CENTER);

        Label lost = new Label(rank_items.getLost());
        lost.setPrefWidth(35);
//        lost.setStyle("-fx-background-color: pink");
        lost.setAlignment(Pos.CENTER);

//        Label gf = new Label(rank_items.getGf());
//        gf.setPrefWidth(40);
//        gf.setStyle("-fx-background-color: #fb8500");

//        Label ga = new Label(rank_items.getGa());
//        ga.setPrefWidth(40);
//        ga.setStyle("-fx-background-color: #2a9d8f");
//
//        Label gd = new Label(rank_items.getGd());
//        gd.setPrefWidth(40);
//        gd.setStyle("-fx-background-color: #e9c46a");

        Label points = new Label(rank_items.getPoints());
        points.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        points.setPrefWidth(60);
//        points.setStyle("-fx-background-color: #e9c46a");
        points.setAlignment(Pos.CENTER);

        // Cột form với các hình tròn thể hiện kết quả gần đây (win/draw/loss)
        HBox formColumn = new HBox();
        formColumn.setSpacing(2);
        formColumn.setPrefWidth(100);
//        formColumn.setStyle("-fx-background-color: #d62828");

        // Tạo các indicator cho form (kết quả 5 trận gần nhất)
        for (char result : rank_items.getForm().toCharArray()) {
            Circle circle = new Circle(10);
            if (result == 'W') {
                circle.setFill(Color.rgb(0, 204, 102)); // Màu xanh lá cho chiến thắng
            } else if (result == 'D') {
                circle.setFill(Color.rgb(192, 192, 192)); // Màu xám cho hòa
            } else if (result == 'L') {
                circle.setFill(Color.rgb(231, 30, 91)); // Màu đỏ cho thua
            }

            Label resultLabel = new Label(String.valueOf(result));
            resultLabel.setTextFill(Color.WHITE);
            resultLabel.setStyle("-fx-font-size: 10px; -fx-font-weight: bold;");

            StackPane formIndicator = new StackPane();
            formIndicator.getChildren().addAll(circle, resultLabel);
            formColumn.getChildren().add(formIndicator);
        }

        // Biểu tượng đối thủ kế tiếp
        ImageView nextMatchIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/Logo/" +rank_items.getNextOpponentLogo())));
//        try {
//            nextMatchIcon.setImage(new Image(getClass().getResourceAsStream(rank_items.getNextOpponentLogo())));
//        } catch (Exception e) {
//            System.err.println("Không tìm thấy logo đối thủ kế tiếp cho đội: " + rank_items.getName());
//        }
        if (rank_items.getNextOpponentLogo().equals("LIV.png")) {
            nextMatchIcon.setStyle(" -fx-effect: innershadow(gaussian, #d90429, 100, 0.8, 0, 0);");
        }
        nextMatchIcon.setFitHeight(20);
        nextMatchIcon.setFitWidth(20);
        HBox nextMatch = new HBox(nextMatchIcon);
        nextMatch.setPrefWidth(40);
        nextMatch.setStyle("-fx-border-color: #e0e0e0; -fx-border-radius: 20px" );
        nextMatch.setAlignment(Pos.CENTER);

        // Nút "more options"
        Button moreOptions = new Button("▼");
        moreOptions.setPrefWidth(40);
        moreOptions.getStyleClass().add("more-options");
        String style = index % 2 == 0 ?
                "-fx-background-color: white;" :
                "-fx-background-color: #f9f9f9;";
        moreOptions.setStyle(style + "-fx-cursor: hand;");
        // Thêm tất cả các phần tử vào dòng
        row.getChildren().addAll(
                posLabel, clubColumn, played, won, drawn, lost,
                points, formColumn, nextMatch, moreOptions
        );

        return row;
    }
}
