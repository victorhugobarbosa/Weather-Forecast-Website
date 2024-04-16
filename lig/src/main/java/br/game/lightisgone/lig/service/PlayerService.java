package br.game.lightisgone.lig.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import br.game.lightisgone.lig.api.model.Player;
import br.game.lightisgone.lig.api.controller.PlayerController;
import org.springframework.web.bind.annotation.RestController;

@Service
public class PlayerService {

    private List<Player> playerList;

    public PlayerService(){
        playerList = new ArrayList<>();

        Player player = new Player(1,"Sumaré, Pq das Nações", "22:22");
        Player player2 = new Player(2,"Monte Mor, Nova Alvorada", "04:20");
        playerList.addAll(Arrays.asList(player, player2));
    }

    public Optional<Player> getPlayer(int id){
        Optional optional = Optional.empty();
        for(Player player: playerList){
            if(id == player.getId()){
                optional = Optional.of(player);
                return optional;
            }
        }
        return optional;
    }
}
