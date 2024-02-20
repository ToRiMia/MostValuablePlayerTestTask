package com.example.mvp_test.service;

import com.example.mvp_test.io.PlayerDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TucanTournamentService {

    PlayerDto defineMVP(List<MultipartFile> results);
}
