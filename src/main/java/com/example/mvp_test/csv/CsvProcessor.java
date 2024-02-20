package com.example.mvp_test.csv;

import com.example.mvp_test.domain.Game;
import com.example.mvp_test.ex.ParsingException;
import com.opencsv.CSVReader;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CsvProcessor {

    public static List<Game> parse(List<MultipartFile> files) {
        return files.stream()
            .map(file -> {
                try {
                    File transferFile = getFile(file);
                    CSVReader reader = new CSVReader(new FileReader(transferFile));
                    List<String[]> data = reader.readAll();
                    return new Game(data);
                } catch (Exception e) {
                    throw ParsingException.unableToReadException();
                }
            })
            .toList();
    }

    private static File getFile(MultipartFile file) throws IOException {
        File transferFile = File.createTempFile("transfer", null);
        file.transferTo(transferFile);
        return transferFile;
    }
}
