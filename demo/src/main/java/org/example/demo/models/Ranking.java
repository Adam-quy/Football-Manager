package org.example.demo.models;

public class Ranking {
    private String position;
    private String homeLogo;
    private String name;
    private String played;
    private String won;
    private String drawn;
    private String lost;
    private String gf;
    private String ga;
    private String gd;
    private String points;
    private String form;
    private String nextOpponentLogo;


    public Ranking(String position, String homeLogo,String name, String played, String won, String drawn,
                    String lost, String gf, String ga, String gd, String points, String form, String nextOpponentLogo) {
        this.position = position;
        this.homeLogo = homeLogo;
        this.name = name;
        this.played = played;
        this.won = won;
        this.drawn = drawn;
        this.lost = lost;
        this.gf = gf;
        this.ga = ga;
        this.gd = gd;
        this.points = points;
        this.form = form;
        this.nextOpponentLogo = nextOpponentLogo;
    }

    // Getters
    public String getPosition() { return position; }
    public String getName() { return name; }
    public String getPlayed() { return played; }
    public String getWon() { return won; }
    public String getDrawn() { return drawn; }
    public String getLost() { return lost; }
    public String getGf() { return gf; }
    public String getGa() { return ga; }
    public String getGd() { return gd; }
    public String getPoints() { return points; }
    public String getForm() { return form; }
    public String getNextOpponentLogo() { return nextOpponentLogo; }
    public String getHomeLogo() { return homeLogo; }
}
