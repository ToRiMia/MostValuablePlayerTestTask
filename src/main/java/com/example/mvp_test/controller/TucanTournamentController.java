package com.example.mvp_test.controller;

import com.example.mvp_test.io.PlayerDto;
import com.example.mvp_test.service.TucanTournamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/tucan-tournament")
@RequiredArgsConstructor
public class TucanTournamentController {

    private final TucanTournamentService service;

    @PostMapping
    public PlayerDto defineMVP(@RequestParam("results") List<MultipartFile> results) {
        return service.defineMVP(results);
    }
}
