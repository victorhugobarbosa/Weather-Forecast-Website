package br.game.lightisgone.lig.service;

import java.util.ArrayList;
import java.util.List;

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

        Player player = new Player("Buenos Aires, 187", "22:22");
        playerList.addAll(ArrayList)
    }

    public Player getPlayer(String location){

    }
}
