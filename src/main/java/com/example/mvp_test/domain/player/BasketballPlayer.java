package com.example.mvp_test.domain.player;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BasketballPlayer extends Player {

    private int scoredPoints;

    private int rebounds;

    private int assists;

    public BasketballPlayer(String[] data) {
        super(data);
        this.scoredPoints = Integer.parseInt(data[4]);
        this.rebounds = Integer.parseInt(data[5]);
        this.assists = Integer.parseInt(data[6]);
    }

    public BasketballPlayer(String playerName, String nickname, int number, String teamName, int scoredPoints, int rebounds, int assists) {
        super(playerName, nickname, number, teamName);
        this.scoredPoints = scoredPoints;
        this.rebounds = rebounds;
        this.assists = assists;
    }

    @Override
    public int getRatingPointsForTeam() {
        return getScoredPoints();
    }

    @Override
    public Player calculateRatingPoints() {
        setRatingPoints((scoredPoints * 2) + rebounds + assists);
        return this;
    }
}
