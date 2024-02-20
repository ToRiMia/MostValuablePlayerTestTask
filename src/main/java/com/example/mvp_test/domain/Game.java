package com.example.mvp_test.domain;

import com.example.mvp_test.domain.enums.GameType;
import com.example.mvp_test.domain.player.BasketballPlayer;
import com.example.mvp_test.domain.player.HandballPlayer;
import com.example.mvp_test.domain.player.Player;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Data
@NoArgsConstructor
public class Game {

    private GameType type;

    private List<Player> players;

    private String winnerTeam;

    public Game(List<String[]> data) {
        String[] firstString = data.get(0);
        type = GameType.valueOf(firstString[0]);
        players = getPlayers(data);
    }

    public Game(GameType type, List<Player> players) {
        this.type = type;
        this.players = players;
    }

    public void defineWinnerTeam() {
        winnerTeam = players.stream()
            .collect(groupingBy(Player::getTeamName))
            .entrySet().stream()
            .max(getComparator())
            .map(Map.Entry::getKey)
            .orElse("DRAW");
    }

    public void calculateRatingPointsForEachPlayer() {
        players.stream()
            .map(Player::calculateRatingPoints)
            .filter(player -> player.getTeamName().equals(winnerTeam))
            .forEach(Player::addTenExtraPoints);
    }

    private List<Player> getPlayers(List<String[]> data) {
        return data.stream()
            .skip(1)
            .map(playerData -> switch (type) {
                case BASKETBALL -> new BasketballPlayer(playerData[0].split(";"));
                case HANDBALL -> new HandballPlayer(playerData[0].split(";"));
            })
            .toList();
    }

    private static Comparator<Map.Entry<String, List<Player>>> getComparator() {
        return Comparator.comparingInt(entry -> entry.getValue().stream()
            .mapToInt(Player::getRatingPointsForTeam)
            .sum());
    }
}
