package com.example.mvp_test.service.impl;

import com.example.mvp_test.csv.CsvProcessor;
import com.example.mvp_test.domain.Game;
import com.example.mvp_test.domain.player.Player;
import com.example.mvp_test.ex.MVPException;
import com.example.mvp_test.io.PlayerDto;
import com.example.mvp_test.service.TucanTournamentService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;


@Service
public class TucanTournamentServiceImpl implements TucanTournamentService {

    public PlayerDto defineMVP(List<MultipartFile> results) {
        List<Game> games = CsvProcessor.parse(results);
        List<Player> players = getAllPlayers(games);
        return players.stream()
            .collect(groupingBy(Player::getNickname))
            .entrySet().stream()
            .max(Comparator.comparingInt(entry -> getSumOfRatingPoints(entry.getValue())))
            .map(TucanTournamentServiceImpl::getPlayerDto)
            .orElseThrow(MVPException::notFound);
    }

    private static List<Player> getAllPlayers(List<Game> games) {
        return games.stream()
            .map(TucanTournamentServiceImpl::defineGameResults)
            .flatMap(Collection::stream)
            .toList();
    }

    private static List<Player> defineGameResults(Game game) {
        game.defineWinnerTeam();
        game.calculateRatingPointsForEachPlayer();
        return game.getPlayers();
    }

    private static int getSumOfRatingPoints(List<Player> players) {
        return players.stream()
            .mapToInt(Player::getRatingPoints)
            .sum();
    }

    private static PlayerDto getPlayerDto(Map.Entry<String, List<Player>> entry) {
        int sum = getSumOfRatingPoints(entry.getValue());
        return new PlayerDto(entry.getValue().get(0), sum);
    }
}
