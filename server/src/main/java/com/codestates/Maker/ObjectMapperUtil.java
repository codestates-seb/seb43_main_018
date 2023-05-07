package com.codestates.Maker;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;


@Component
public class ObjectMapperUtil {
    @Autowired
    private ObjectMapper objectMapper;

    public List<Makers> readJsonFile() throws IOException {
        Resource resource = new ClassPathResource("guro.json");
        InputStream inputStream = resource.getInputStream();
        Makers[] makersArray = objectMapper.readValue(inputStream, Makers[].class);
        return Arrays.asList(makersArray);
    }
}
