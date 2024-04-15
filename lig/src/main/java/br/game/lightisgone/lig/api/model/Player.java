package br.game.lightisgone.lig.api.model;

public class Player {
    public String location;
    public String time;


    public Player(String location, String time){
        this.location = location;
        this.time = time;
    }

    public String getLocation(){
        return location;
    }
}
