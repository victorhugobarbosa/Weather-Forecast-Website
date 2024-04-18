package br.game.lightisgone.lig.api.model;

public class Player {
    public int id;

    public String location;
    public String time;

    public Player(int id, String location, String time) throws Exception{
        int horas1 = Integer.parseInt(time.split(":")[0]);
        int horas2 = Integer.parseInt(time.split(":")[1]);

        if(horas1 < 0 || horas1 > 24)
            throw new Exception("Digite um horário válido");
        if(horas2 < 0 || horas2 > 60)
            throw new Exception("Digite um horário válido");

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

    public void setLocation(String location){
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
