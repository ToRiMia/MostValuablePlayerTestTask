package com.example.mvp_test.domain.player;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class HandballPlayer extends Player {

    private int goalsMade;

    private int goalsReceived;

    public HandballPlayer(String[] data) {
        super(data);
        this.goalsMade = Integer.parseInt(data[4]);
        this.goalsReceived = Integer.parseInt(data[5]);
    }

    public HandballPlayer(String playerName, String nickname, int number, String teamName, int goalsMade, int goalsReceived) {
        super(playerName, nickname, number, teamName);
        this.goalsMade = goalsMade;
        this.goalsReceived = goalsReceived;
    }

    @Override
    public Player calculateRatingPoints() {
        setRatingPoints((goalsMade * 2) - goalsReceived);
        return this;
    }

    @Override
    public int getRatingPointsForTeam() {
        return getGoalsMade();
    }
}
