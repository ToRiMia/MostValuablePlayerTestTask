package com.example.mvp_test.domain.player;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Player {

    private String playerName;

    private String nickname;

    private int number;

    private String teamName;

    private int ratingPoints;

    Player(String[] data) {
        playerName = data[0];
        nickname = data[1];
        number = Integer.parseInt(data[2]);
        teamName = data[3];
    }

    Player(String playerName, String nickname, int number, String teamName) {
        this.playerName = playerName;
        this.nickname = nickname;
        this.number = number;
        this.teamName = teamName;
    }

    public abstract int getRatingPointsForTeam();

    public abstract Player calculateRatingPoints();

    public void addTenExtraPoints() {
        ratingPoints += 10;
    }
}

