package br.game.lightisgone.lig.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import br.game.lightisgone.lig.api.model.Player;

@Service
public class PlayerService {

    private List<Player> playerList;

    public PlayerService() throws Exception{
        playerList = new ArrayList<>();

        Player player = new Player(1,"Sumaré, Pq das Nações", "22:22");
        Player player2 = new Player(2,"Monte Mor, Nova Alvorada", "04:20");
        playerList.addAll(Arrays.asList(player, player2));
    }

    public Optional<Player> getPlayer(int id){
        Optional<Player> optional = Optional.empty();
        for(Player player: playerList){
            if(id == player.getId()){
                optional = Optional.of(player);
                return optional;
            }
        }
        return optional;
    }

    public Player setPlayer(Player p) throws Exception{
        p.setId(playerList.size()+1);
        if (playerList.add(p))
            return p;
        else
            return null;
    }
}
