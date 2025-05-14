package org.example.demo.models;

public class Team {
    private String name;
    private String logoPath;
    public Team(String name, String logoPath) {
        this.name = name;
        this.logoPath = logoPath;
    }
    public String getName() {
        return this.name;
    }

    public String getLogoPath() {
        return this.logoPath;
    }

}
