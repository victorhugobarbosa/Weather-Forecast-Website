package br.game.lightisgone.lig.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.game.lightisgone.lig.api.model.Player;
import br.game.lightisgone.lig.service.PlayerService;

@RestController
public class PlayerController {
    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @GetMapping("/player")
    public Player getPlayer(@RequestParam Integer id){
        Optional player = playerService.getPlayer(id);
        if(player.isPresent()){
            return (Player) player.get();
        }
        return null;
    }
}
