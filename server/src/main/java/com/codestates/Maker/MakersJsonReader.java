package com.codestates.Maker;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MakersJsonReader {
    public static Makers[] readJsonFile() throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get("src/main/resources/guro.json"));
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonData, Makers[].class);
    }
}
