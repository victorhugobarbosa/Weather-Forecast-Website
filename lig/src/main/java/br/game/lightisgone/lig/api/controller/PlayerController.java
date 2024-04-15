package br.game.lightisgone.lig.api.controller;

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

    @GetMapping
    public Player getPlayer(@RequestParam String location){
        return playerService.getPlayer();
    }
}
