package br.game.lightisgone.lig.api.model;

public class Player {
    public int id;

    public String location;
    public String time;

    public Player(int id, String location, String time){
        this.location = location;
        this.time = time;
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getLocation(){
        return location;
    }

    public void setLocaltion(){
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
