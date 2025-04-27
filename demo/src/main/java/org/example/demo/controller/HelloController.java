package org.example.demo.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private HBox container;
    @FXML
    private AnchorPane sidebar_dash;

    @FXML
    private Pane inner_pane;

    @FXML
    private Pane pane_content;

    @FXML
    private HBox news_slider;
    private int currentIndex = 0;
    private final int CARD_WIDTH = 170; //
    private ArrayList<VBox> list = new ArrayList<>();

    @FXML
    private GridPane articlesGrid;
    private int currentRow = 0;

    @FXML
    private VBox schedule_box;
    private VBox createNewsCard(String title, String desc, String imageUrl) {
        VBox card = new VBox();
        card.getStyleClass().add("news-card");
        card.setSpacing(8);

        // Hình ảnh tin tức
        ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/images/newspaper/" + imageUrl)));
        image.setFitWidth(285);
        image.setFitHeight(160);
        image.setPreserveRatio(false);

        Rectangle clip = new Rectangle(285, 160); // phải cùng size với image
        clip.setArcWidth(20);  // độ cong ngang
        clip.setArcHeight(20); // độ cong dọc

        image.setClip(clip);

        Label overlay = new Label(title+ ": " + desc);
        overlay.setStyle("-fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: white; -fx-background-color: rgba(0,0,0,0.3);" +
                "-fx-padding: 3px 10px; -fx-background-raidus: 10px;");


        StackPane pane = new StackPane(image, overlay);
        pane.setPrefHeight(100);
        pane.setAlignment(Pos.BOTTOM_CENTER);


        card.getChildren().add(pane);
        return card;
    }


    private void showCard(int index) {
       news_slider.getChildren().removeIf(node -> node instanceof VBox);
       news_slider.getChildren().add(list.get(index));
    }

    private VBox createArticleBox(String title, String desc, String imageUrl) {
        VBox box = new VBox(10); // Khoảng cách giữa các phần tử
        box.getStyleClass().add("article-box");
        box.setPadding(new Insets(10));
        box.setMaxWidth(230);
        box.setMinHeight(130);

        // Hình ảnh bài báo
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("/images/newspaper/" + imageUrl)));
        imageView.setFitWidth(178);
        imageView.setFitHeight(100);
        imageView.setPreserveRatio(false);
        Rectangle clip = new Rectangle(178, 100);
        clip.setArcWidth(10);
        clip.setArcHeight(10);
        imageView.setClip(clip);

        // Tiêu đề bài báo
        Label titleLabel = new Label(title);
        titleLabel.setWrapText(true);
        titleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-font-family: Arial; -fx-text-fill: #3a0ca3;");
        titleLabel.setMaxWidth(178);

        // Mô tả ngắn
        Label descLabel = new Label(desc);
        descLabel.setWrapText(true);
        descLabel.setStyle("-fx-font-size: 10px; -fx-font-color: #b8b8ff; -fx-text-fill: #3a0ca3; ");

        // Thêm sự kiện khi click vào bài báo
//        box.setOnMouseClicked(e -> {
//            // Xử lý khi click vào bài báo, ví dụ: mở bài báo đầy đủ
//            openArticle(article);
//        });

        box.getChildren().addAll(imageView, titleLabel, descLabel);
        return box;
    }

    private void loadArticles() {
        // Danh sách mẫu các bài báo (trong thực tế, bạn có thể lấy từ cơ sở dữ liệu)
        String[] titles = {"Tin thể thao", "Tin kinh tế", "Tin giáo dục", "Tin công nghệ",
                "Tin thời tiết"};
        String[] descs = {"Mô tả về tin thể thao", "Mô tả về tin kinh tế", "Mô tả về tin giáo dục",
                "Mô tả về tin công nghệ", "Mô tả về tin thời tiết"};
        String[] images = {"article1.jpg", "article2.jpg", "article3.jpg", "article4.jpg",
                "article5.jpg"};

        // Thêm các bài báo vào lưới
        for (int i = 0; i < titles.length; i++) {
            VBox articleBox = createArticleBox(titles[i], descs[i], images[i]);

            // Tính vị trí trong lưới (2 cột)
            int col = i % 2;
            int row = i / 2;

            GridPane.setMargin(articleBox, new Insets(5));
//            GridPane.setHalignment(articleBox, HPos.CENTER); // Căn giữa theo chiều ngang
//            GridPane.setValignment(articleBox, VPos.CENTER); // Căn giữa theo chiều dọc
            // Thêm bài báo vào lưới
            articlesGrid.add(articleBox, col, row);

            // Cập nhật currentRow nếu cần
            if (row > currentRow) {
                currentRow = row;
            }
        }

        // Đảm bảo GridPane có đủ chiều cao để cuộn
        articlesGrid.setPrefHeight((currentRow + 1) * 150); // 150 là chiều cao ước tính cho mỗi hàng
    }

    private HBox createMatchResult(String homeTeam,String homeImage,  String score ,String awayTeam, String awayImage) {
        HBox matchRow = new HBox();
        matchRow.setAlignment(Pos.CENTER);
        matchRow.setPrefWidth(170);
        matchRow.setSpacing(5);

        // Home team
        Label home = new Label(homeTeam);
        home.setStyle("-fx-text-fill: #3a0ca3; -fx-font-weight: bold;");
        home.setPrefWidth(40);
        home.setAlignment(Pos.CENTER_RIGHT);

        // Team logos (placeholders)
        ImageView homeLogo = new ImageView(new Image(getClass().getResourceAsStream("/images/logo/" + homeImage)));
        homeLogo.setFitHeight(20);
        homeLogo.setFitWidth(20);


        ImageView awayLogo = new ImageView(new Image(getClass().getResourceAsStream("/images/logo/" + awayImage)));
        awayLogo.setFitHeight(20);
        awayLogo.setFitWidth(20);

        // Score
        Label scoreLabel = new Label(score);
        scoreLabel.setStyle("-fx-background-color: #560bad; -fx-background-radius: 20px; -fx-text-fill: white; " +
                "-fx-padding: 5 5; -fx-font-weight: bold; -fx-border-width: none");
        scoreLabel.setMinWidth(50);
        scoreLabel.setAlignment(Pos.CENTER);

        // Away team
        Label away = new Label(awayTeam);
        away.setStyle("-fx-text-fill: #3a0ca3; -fx-font-weight: bold;");
        away.setPrefWidth(40);
        away.setAlignment(Pos.CENTER_LEFT);

        matchRow.getChildren().addAll(home, homeLogo, scoreLabel, awayLogo, away);
        return matchRow;
    }

    @FXML
    public void initialize() {
        // Tạo 5 card tin tức mẫu
        for (int i = 1; i <= 5; i++) {
            VBox card = createNewsCard(
                    "Tin nóng " + i,
                    "Mô tả ngắn về tin tức số " + i,
                    "news" + i + ".jpg"
            );
            list.add(card);
        }
        showCard(currentIndex);
        news_slider.setAlignment(Pos.CENTER);
        articlesGrid.setHgap(20);
        articlesGrid.setVgap(20);
        articlesGrid.setPadding(new Insets(10, 10, 10, 10));
        loadArticles();

        schedule_box.setPadding(new Insets(10, 10, 10, 10));
        schedule_box.getChildren().addAll(
                createMatchResult("CHE", "CHE.png", "1-1", "OLD", "OLD.png"),
                createMatchResult("ARS", "ARS.png", "2-4", "NOR", "NOR.png"),
                createMatchResult("EVE", "EVE.png", "0-2", "MCI", "MCI.png"),
                createMatchResult("BOU", "BOU.png", "1-1", "CRY", "CRY.png")
        );
        schedule_box.setSpacing(30);
    }

    @FXML
    private void prevNews() {
        if (currentIndex > 0) {
            currentIndex--;
            showCard(currentIndex);
        }
    }

    @FXML
    private void nextNews() {
        if (currentIndex < list.size() - 1) {
            currentIndex++;
            showCard(currentIndex);
        }
    }
}