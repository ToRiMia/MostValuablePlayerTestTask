package com.example.mvp_test.service.impl;

import com.example.mvp_test.CsvFactory;
import com.example.mvp_test.io.PlayerDto;
import org.junit.jupiter.api.Test;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TucanTournamentServiceImplTest {

    private final TucanTournamentServiceImpl tournamentService = new TucanTournamentServiceImpl();

    @Test
    void testTwoFiles() {
        MultipartFile results1 = CsvFactory.createBasketball1();
        MultipartFile results2 = CsvFactory.createHandball1();
        PlayerDto expected = new PlayerDto("player 3", "nick3", 15, "Team A", 54);

        PlayerDto playerDto = tournamentService.defineMVP(List.of(results1, results2));

        assertEquals(expected, playerDto);
    }

    @Test
    void testFourFiles() {
        MultipartFile results1 = CsvFactory.createBasketball1();
        MultipartFile results2 = CsvFactory.createBasketball2();
        MultipartFile results3 = CsvFactory.createHandball1();
        MultipartFile results4 = CsvFactory.createHandball2();
        PlayerDto expected = new PlayerDto("player 3", "nick3", 15, "Team A", 125);

        PlayerDto playerDto = tournamentService.defineMVP(List.of(results1, results2, results3, results4));

        assertEquals(expected, playerDto);
    }
}