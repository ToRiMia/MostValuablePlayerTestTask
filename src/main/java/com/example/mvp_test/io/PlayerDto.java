package com.example.mvp_test.io;

import com.example.mvp_test.domain.player.Player;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerDto {

    private String playerName;

    private String nickname;

    private int number;

    private String teamName;

    private int ratingPoints;

    public PlayerDto(Player player, int ratingPoints) {
        this.playerName = player.getPlayerName();
        this.nickname = player.getNickname();
        this.number = player.getNumber();
        this.teamName = player.getTeamName();
        this.ratingPoints = ratingPoints;
    }
}
