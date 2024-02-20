package com.example.mvp_test.domain;

import com.example.mvp_test.domain.enums.GameType;
import com.example.mvp_test.domain.player.BasketballPlayer;
import com.example.mvp_test.domain.player.HandballPlayer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    @Test
    void testDefinitionOfWinnerTeamA() {
        Game game = new Game(GameType.BASKETBALL, List.of(
            new BasketballPlayer("nik 1", "nik1", 4, "Team A", 12, 5, 5),
            new BasketballPlayer("nik 2", "nik2", 5, "Team A", 16, 0, 7),
            new BasketballPlayer("nik 3", "nik3", 6, "Team B", 10, 5, 1),
            new BasketballPlayer("nik 4", "nik4", 7, "Team B", 5, 6, 0)));

        game.defineWinnerTeam();

        assertEquals("Team A", game.getWinnerTeam());
    }

    @Test
    void testDefinitionOfWinnerTeamDrawB() {
        Game game = new Game(GameType.BASKETBALL, List.of(
            new BasketballPlayer("nik 1", "nik1", 4, "Team A", 12, 5, 5),
            new BasketballPlayer("nik 2", "nik2", 5, "Team A", 1, 0, 7),
            new BasketballPlayer("nik 3", "nik3", 6, "Team B", 10, 5, 1),
            new BasketballPlayer("nik 4", "nik4", 7, "Team B", 5, 6, 0)));

        game.defineWinnerTeam();

        assertEquals("Team B", game.getWinnerTeam());
    }

    @Test
    void testCalculationOfRatingPointsForBasketball() {
        Game game = new Game(GameType.BASKETBALL, List.of(
            new BasketballPlayer("nik 1", "nik1", 4, "Team A", 12, 5, 5),
            new BasketballPlayer("nik 2", "nik2", 5, "Team A", 1, 0, 7),
            new BasketballPlayer("nik 3", "nik3", 6, "Team B", 10, 5, 1),
            new BasketballPlayer("nik 4", "nik4", 7, "Team B", 5, 6, 0)));

        game.calculateRatingPointsForEachPlayer();

        assertEquals(34, game.getPlayers().get(0).getRatingPoints());
        assertEquals(9, game.getPlayers().get(1).getRatingPoints());
        assertEquals(26, game.getPlayers().get(2).getRatingPoints());
        assertEquals(16, game.getPlayers().get(3).getRatingPoints());
    }

    @Test
    void testCalculationOfRatingPointsForHandball() {
        Game game = new Game(GameType.HANDBALL, List.of(
            new HandballPlayer("nik 1", "nik1", 4, "Team A", 12, 5),
            new HandballPlayer("nik 2", "nik2", 5, "Team A", 1, 0),
            new HandballPlayer("nik 3", "nik3", 6, "Team B", 10, 5),
            new HandballPlayer("nik 4", "nik4", 7, "Team B", 5, 6)));

        game.calculateRatingPointsForEachPlayer();

        assertEquals(19, game.getPlayers().get(0).getRatingPoints());
        assertEquals(2, game.getPlayers().get(1).getRatingPoints());
        assertEquals(15, game.getPlayers().get(2).getRatingPoints());
        assertEquals(4, game.getPlayers().get(3).getRatingPoints());
    }

    @Test
    void testCalculationOfRatingPointsForHandballWithExtraTen() {
        Game game = new Game(GameType.HANDBALL, List.of(
            new HandballPlayer("nik 1", "nik1", 4, "Team A", 12, 5),
            new HandballPlayer("nik 2", "nik2", 5, "Team A", 1, 0),
            new HandballPlayer("nik 3", "nik3", 6, "Team B", 10, 5),
            new HandballPlayer("nik 4", "nik4", 7, "Team B", 5, 6)));

        game.defineWinnerTeam();
        game.calculateRatingPointsForEachPlayer();

        assertEquals(19, game.getPlayers().get(0).getRatingPoints());
        assertEquals(2, game.getPlayers().get(1).getRatingPoints());
        assertEquals(25, game.getPlayers().get(2).getRatingPoints());
        assertEquals(14, game.getPlayers().get(3).getRatingPoints());
    }

}