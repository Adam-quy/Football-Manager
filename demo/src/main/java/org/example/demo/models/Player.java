package org.example.demo.models;

public class Player {
    private String imagePath;
    private String name;
    private String position;
    private String nation_flag;
    private String nationality;

    public Player(String imagePath, String name, String position, String nation_flag,String nationality) {
        this.imagePath = imagePath;
        this.name = name;
        this.position = position;
        this.nation_flag = nation_flag;
        this.nationality = nationality;
    }

    public String getImagePath() {
        return this.imagePath;
    }
    public String getName() {
        return this.name;
    }
    public String getPosition() {
        return this.position;
    }
    public String getNationality() {
        return this.nationality;
    }

    public String getNation_flag() {
        return this.nation_flag;
    }
}
