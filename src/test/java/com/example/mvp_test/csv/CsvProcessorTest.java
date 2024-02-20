package com.example.mvp_test.csv;

import com.example.mvp_test.CsvFactory;
import com.example.mvp_test.domain.Game;
import com.example.mvp_test.domain.enums.GameType;
import com.example.mvp_test.domain.player.BasketballPlayer;
import com.example.mvp_test.ex.ParsingException;
import org.junit.jupiter.api.Test;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvProcessorTest {

    @Test
    void testParsingOfOneFile() {
        MultipartFile results1 = CsvFactory.createBasketball1();

        List<Game> actual = CsvProcessor.parse(List.of(results1));

        assertNotNull(actual);
        assertEquals(1, actual.size());
        assertEquals(GameType.BASKETBALL, actual.get(0).getType());
    }

    @Test
    void testParsingOfTwoFiles() {
        MultipartFile results1 = CsvFactory.createBasketball1();
        MultipartFile results2 = CsvFactory.createHandball1();

        List<Game> actual = CsvProcessor.parse(List.of(results1, results2));

        assertNotNull(actual);
        assertEquals(2, actual.size());
        assertEquals(GameType.BASKETBALL, actual.get(0).getType());
        assertEquals(GameType.HANDBALL, actual.get(1).getType());
    }

    @Test
    void testParsingOfPlayer() {
        MultipartFile results1 = CsvFactory.createBasketballWithOnePlayer();

        List<Game> actual = CsvProcessor.parse(List.of(results1));

        assertNotNull(actual.get(0).getPlayers());
        assertEquals(1, actual.get(0).getPlayers().size());

        BasketballPlayer player = (BasketballPlayer) actual.get(0).getPlayers().get(0);
        assertNotNull(player);
        assertEquals("player 1", player.getPlayerName());
        assertEquals("nick1", player.getNickname());
        assertEquals(4, player.getNumber());
        assertEquals("Team A", player.getTeamName());
        assertEquals(10, player.getScoredPoints());
        assertEquals(2, player.getRebounds());
        assertEquals(7, player.getAssists());
    }

    @Test
    void testParsingFileWithBug() {
        MultipartFile results1 = CsvFactory.createHandballWithBug();
        List<MultipartFile> resultsList = List.of(results1);

        assertThrows(ParsingException.class, () -> {
            CsvProcessor.parse(resultsList);
        });
    }

}